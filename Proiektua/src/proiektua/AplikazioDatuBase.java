package proiektua;


import java.rmi.RemoteException;
import java.sql.*;
import java.util.*;

/**
 * Arkitekturaren hirugarren mailaren klase nagusia
 * Singleton diseinu-patroia erabiltzen da instantzia bakarra izateko.
 */

public class AplikazioDatuBase
{
    private static AplikazioDatuBase instantzia;
    public static java.sql.Connection konexioa;
    private int erreserbaZenb=0;

    /**
    * Datu basea hasieratzen
    */
    public AplikazioDatuBase()
    {
        try
            {
            Class.forName("com.mysql.jdbc.Driver");
    	    konexioa = DriverManager.getConnection("jdbc:mysql://localhost/software","root","123456");
    	    System.out.println("Datu-basera ondo konektatu da.");
        }
        catch (SQLException anException)
            {
            while (anException != null)
                {
                System.out.println("SQL Exception:  " + anException.getMessage());
                anException = anException.getNextException();
            }
        }
        catch (java.lang.Exception anException)
            {
            anException.printStackTrace();
        }
    }
    /**
    * Datu base itxi
    */
    public void finalize()
    {
        try
            {
            konexioa.close();
        }
        catch (SQLException anException)
            {
            while (anException != null)
                {
                System.out.println("SQL Exception:  " + anException.getMessage());
                anException = anException.getNextException();
            }
        }
        catch (Exception anException)
            {
            anException.printStackTrace();
        }
    }
    /**
    * Eskuratu azken erreserbaren zenbakia eragiketak egiteko.
    */

    public int getAzkenErreserbarenZenbakia()
    {
        // Erazagupenak
        int erreserbarenZenbakia = 0;
        PreparedStatement selectSententzia;
        ResultSet resultSet;
        // Sarrera
        try
            {
            // Select sententzia sortu
            selectSententzia = konexioa.prepareStatement("SELECT MAX (Erreserba_Zenbakia) FROM Erreserba");
            // Select sententzia exekutatu
            resultSet = selectSententzia.executeQuery();

            // ResulSet osagaia aztertzen
            if (resultSet.next())
                {
                erreserbarenZenbakia = resultSet.getInt(1);
            }
            System.out.println("Select MAX erreserbarenZenbakia = " + erreserbarenZenbakia);
            resultSet.close();
        }
        catch (SQLException anException)
            {
            while (anException != null)
                {
                System.out.println("SQL Exception:  " + anException.getMessage());
                anException = anException.getNextException();
            }
        }
        catch (java.lang.Exception anException)
            {
            System.out.println("Exception:  " + anException.getMessage());
        }
        // Irteera
        finally
            {
            return erreserbarenZenbakia;
        }
    }

    private int lortuErreserbaZenb() {
    	int z = 0;
    	CallableStatement st;
    	ResultSet rs=null;
		try {
			st = konexioa.prepareCall("SELECT COUNT(*) FROM erreserbak");
			rs = st.executeQuery();
			while(rs.next()) {
				z=rs.getInt(1);
			}
			rs.close();
		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return z;
	}
	/**
    * Erreserbaren ezugarriak txertatzen datu-basean
    * @return count int
    * @param data java.util.Date
    * @param amount double
    */
    public int sartuErreserba(
        String baieztapenZenbakia,
        int turistaKop,
        String irteerarenKodea,
        String agenteKodea,
        String data)
    {
        // Erazagupenak
        PreparedStatement insertSententzia = null;
        // Sarrera
        try
            {
            // Insert sententzia sortu
        	erreserbaZenb=lortuErreserbaZenb()+1;
            insertSententzia = konexioa.prepareStatement("INSERT INTO Erreserbak VALUES (?, ?, ?, ?, ?)");
            // Insert sententzia hasieratu
            insertSententzia.setString(1, erreserbaZenb+"");
            insertSententzia.setString(4, baieztapenZenbakia);
            insertSententzia.setInt(5, turistaKop);
            insertSententzia.setString(2, irteerarenKodea);
            insertSententzia.setString(3, agenteKodea);
            //  Insert sententzia exekutatu
            insertSententzia.executeUpdate();
            //  Insert sententzia amaitu
            insertSententzia.close();

            // Aukeratutako bidairako plaza kopurua eguneratu
            PreparedStatement updateSententzia = konexioa.prepareStatement("UPDATE datak" +
            															" SET plazaKop=plazaKop-"+turistaKop+
            															" WHERE AgenteId="+agenteKodea+
            															" AND IrteeraId="+irteerarenKodea+
            															" AND Data='" + data + "'");
            updateSententzia.executeUpdate();
            updateSententzia.close();
        }
        catch (SQLException anException)
            {
            while (anException != null)
                {
                System.out.println(" SQL Exception : " + anException.getMessage());
                anException = anException.getNextException();
            }
        }
        return 1;
    }
    /**
    * Turistaren datuak txertatzen datu-basean
    * @return count int
    * @param data java.util.Date
    * @param amount double
    */
    public int sartuTurista(
        String izena,
        String helbidea,
        String telefonoa,
        String turistaZenbakia)
    {
        // Erazagupenak
        int count = 0;
        PreparedStatement insertSententzia = null;
        // Sarrera
        try
            {
            // Insert sententzia sortu
            insertSententzia = konexioa.prepareStatement("INSERT INTO Turistak VALUES (?, ?, ?, ?, ?)");
            // Hasieratu Insert statement
            insertSententzia.setString(3, izena);
            insertSententzia.setString(4, helbidea);
            insertSententzia.setString(5, telefonoa);
            insertSententzia.setString(2, erreserbaZenb+"");
            insertSententzia.setString(1, turistaZenbakia);
            // Insert sententzia exekutatu
            count = insertSententzia.executeUpdate();
            // Insert sententzia amaitu
            insertSententzia.close();
        }
        catch (SQLException anException)
            {
            while (anException != null){
                System.out.println(" SQL Exception : " + anException.getMessage());
                anException = anException.getNextException();
            }
        }
        catch (java.lang.Exception anException)
            {
            anException.printStackTrace();
        }
        // Irteera
        finally
            {
            return count;
        }
    }
    /**
    * Klasearen instantzia eskuratzeko metodoa
    * @return instance AplikazioDatuBase
    */
    public static AplikazioDatuBase instance()
    {
        if (instantzia == null)
            instantzia = new AplikazioDatuBase();
        return instantzia;
    }

    /**
     * Existitzen diren agenteak lortzen dituen metodoa
     *
     * @return Vector<Agentea>
     */
    public Vector<Agentea> getAgenteak(){
    	Vector<Agentea> agenteZer = new Vector();

    	CallableStatement st;
    	ResultSet rs=null;
		try {
			st = konexioa.prepareCall("SELECT AgenteId, AgenteIzena FROM Agenteak ORDER BY AgenteId");
			rs = st.executeQuery();
			while(rs.next()) {
				Agentea ag = new Agentea(rs.getString(1),rs.getString(2));
				agenteZer.add(ag);
			}
			rs.close();
			st.close();
		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return agenteZer;
    }

    /**
     * Datu basetik deskonektatzen duen metodoa
     *
     * @return void
     */
    public void deskonektatuDB(){
    	try{
    		konexioa.close();
    		System.out.println("Datu-basetik ondo deskonektatu da.");
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
    }

    /**
     * Aukeratutako agenteak eskaintzen dituen bidaien ezaugarriak lortzeko metodoa.
     *
     * @return Vector<Ezaugarria>
     */
    public Vector<Ezaugarria> getEzaugarriak(String id){
     	Vector<Ezaugarria> ezaugarriZer = new Vector<Ezaugarria>();

    	CallableStatement st;
    	ResultSet rs=null;
		try {
			st = konexioa.prepareCall("SELECT IrteeraDeskribapena, IrteeraId " +
									  "FROM Irteerak " +
									  "WHERE AgenteId=" + id +" ORDER BY IrteeraId");
			rs = st.executeQuery();
			while(rs.next()) {
				Ezaugarria e = new Ezaugarria(rs.getString(2),rs.getString(1));
				ezaugarriZer.add(e);
			}
			rs.close();
		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return ezaugarriZer;
    }

    /**
     * Agentea, irteera eta honen data zehaztuta, bidai horretarako dauden plaza libre kopurua itzultzen da.
     *
     * @return Vector<Ezaugarria>
     */
	public int getPlazaKop(String agenteId, String irteeraId, String data) throws RemoteException{
    	int plazaKop=0;
		CallableStatement st;
    	ResultSet rs=null;

		try {
			st = konexioa.prepareCall("SELECT PlazaKop " +
									  "FROM datak " +
									  "WHERE AgenteId=" + agenteId +
									  " AND IrteeraId=" + irteeraId +
									  " AND Data='" + data + "'");
			rs = st.executeQuery();
			while(rs.next()) {
				plazaKop = rs.getInt(1);
			}
		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return plazaKop;
	}

    //Aukeratutako "agenteId" eta "irteeraId"-rako irteera datak lortu.
    public Vector<Data> getDatak(String agenteId,String irteeraId){
     	Vector<Data> dataZer = new Vector<Data>();

    	CallableStatement st;
    	ResultSet rs=null;
		try {
			st = konexioa.prepareCall("SELECT Data, PlazaKop " +
									  "FROM datak " +
									  "WHERE AgenteId=" + agenteId +
									  " AND IrteeraId= " + irteeraId +
									  " ORDER BY Data");
			rs = st.executeQuery();
			while(rs.next()) {
				Data d = new Data(rs.getDate(1).toString(),agenteId,irteeraId,rs.getInt(2));
				dataZer.add(d);
			}
		}
    	catch (SQLException e) {
			e.printStackTrace();
		}
    	return dataZer;
    }
}
