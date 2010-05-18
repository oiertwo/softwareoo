package proiektua;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import javax.swing.JComboBox;

public class AplikazioNagusiaKud extends UnicastRemoteObject implements AplikazioNagusiaKudInterfazea{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static AplikazioDatuBase aplikazioDatuBase;

	String zenb; //Baieztapen zenbakia gordetzeko aldagai globala
	private Vector<Agentea> agenteZer = new Vector<Agentea>();
	private Vector<Ezaugarria> ezaugarriZer = new Vector<Ezaugarria>();
	private Vector<String> dataZer = new Vector<String>();
	private Vector<Turista> turistaZer = new Vector<Turista>();  //  @jve:decl-index=0:

    /**
     * Eraikitzailea
     *
     * @return Vector<String>
     */
	public AplikazioNagusiaKud() throws RemoteException{
		super();
		//AplikazioDatuBase klasearen instantzia egin, honekin DB-ra konektatuko da.
		aplikazioDatuBase = AplikazioDatuBase.getInstance();
	}

	/**
	 * Zerbitzua jaurtitzen duen metodoa rmi erabiliz, 1099 portutik
	 *
	 * @return void
	 */
	public static void zerbitzariaJaurti() {
		try {
			AplikazioNagusiaKud urrunekoObj = new AplikazioNagusiaKud();
			try {
				java.rmi.registry.LocateRegistry.createRegistry(1099); // RMIREGISTRY jaurtitzearen baliokidea
			}
			catch (Exception e) {}
			// Urruneko zerbitzua erregistratu
			String zerbitzuIzena = "erreserba_sistema";
			Naming.rebind(zerbitzuIzena,urrunekoObj);
			System.out.println("Zerbitzaria ondo jaurti da.");
		}
		catch (Exception e) {
			System.out.println("Errorea zerbitzaria jaurtitzean: "+e.toString());
		}
	}

    /**
     * DB-tik deskonektatuko duen metodoa
     *
     * @return Vector<String>
     */
	public void deskonektatuDB() throws RemoteException {
		aplikazioDatuBase.deskonektatuDB();
	}

    /**
     * Nagusia, DB-ra konexioa egin eta urrutiko zerbitzua jaurtiko duena
     *
     * @return void
     */
	public static void main(String[] args)  throws RemoteException {
		zerbitzariaJaurti();
	}

	/*************************************************************/
    /**
     * Agenteen zerrenda lortuko duen metodoa
     *
     * @return Vector<Agentea>
     */
	public Vector<Agentea> getAgenteak()  throws RemoteException{
		return aplikazioDatuBase.getAgenteak();
	}

    /**
     * Ezaugarrien zerrenda lortuko duen metodoa
     *
     * @return Vector<Agentea>
     */
	public Vector<Ezaugarria> getEzaugarriak(String id) throws RemoteException {
		return aplikazioDatuBase.getEzaugarriak(id);
	}

    /**
     * Erreserba egiteko baieztapen zenbakia sortzen duen metodoa.
     * "null" itzuliko du plaza kopuru librea erreserbatu nahi den plaza kopurua baino txikiagoa denean.
     *
     * @return String
     */
	public String getErreserbaBaieztapenZenbakia(JComboBox cmbAgenteak, JComboBox cmbEzaugarriak, String data, int bidaiariKop) throws RemoteException{
		String agenteId = agenteZer.get(cmbAgenteak.getSelectedIndex()).getId();
		String irteeraId = ezaugarriZer.get(cmbEzaugarriak.getSelectedIndex()).getId();

		int plazaKop = aplikazioDatuBase.getPlazaKop(agenteId, irteeraId, data);
		if((plazaKop - bidaiariKop) < 0) return null;
		else{
			//"1"-etik "99999"-erako ausazko zenbakia lortu:
			Integer z = (int)Math.floor(Math.random()*(1-99999+1)+99999);
			zenb = z.toString();
			return zenb;
		}
	}

    /**
     * Parametroz pasatako zenbakia baieztapen zenbakiarenkin bat datorren konprobatzen duen metodoa.
     * @return String
     */
	public boolean baieztapenZenbakiaKonprobatu(String z){
		return z.equals(zenb);
	}

    /**
     * Plaza kopurua libre lortzen duen metodoa
     * @return int
     */
	public int getPlazaKop(String agenteId, String irteeraId, String data) throws RemoteException {
		return aplikazioDatuBase.getPlazaKop(agenteId,irteeraId,data);
	}

    /**
     * Aukeratutako bidairako aukeragai dauden daten zerrenda itzultzen duen metodoa.
     * @return String
     */
	public Vector<String> getDatak(String aId, String iId) throws RemoteException {
		return aplikazioDatuBase.getDatak(aId, iId);
	}

    /**
     * Turista zerrenda gordetzen duen metodoa.
     * @return void
     */
	public void sartuTuristak() throws RemoteException {
		for(int i=0;i<turistaZer.size();i++){
			String izena=turistaZer.get(i).getIzena();
			String helb=turistaZer.get(i).getHelbidea();
			String telf=turistaZer.get(i).getTelefonoa();
			aplikazioDatuBase.sartuTurista(izena, helb, telf, i+1+"");
		}
	}

    /**
     * Erreserba gordetzen duen metodoa
     * @return void
     */
	public void sartuErreserba(String baieztapenZenbakia, String irteerarenKodea,
							  String agenteKodea, String data) throws RemoteException {
		int turistaKop = turistaZer.size();
		aplikazioDatuBase.sartuErreserba(baieztapenZenbakia, turistaKop, irteerarenKodea, agenteKodea, data);
	}

    /**
     * Agenteen zerrenda itzultzen duen metodoa
     * @return Vector<Atring>
     */
	public Vector<String> kargatuAgenteak() throws RemoteException{
		Vector<String> agenteak= new Vector<String>();
		try {
			agenteZer = getAgenteak();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for(int i=0; (i<agenteZer.size());i++){
			agenteak.add(agenteZer.get(i).getIzena());
		}
		return agenteak;
	}

    /**
     * Ezaugarrien zerrenda itzultzen duen metodoa
     * @return Vector<String>
     */
	public Vector<String> kargatuEzaugarriak(JComboBox cmbAgenteak) throws RemoteException{
		ezaugarriZer.removeAllElements();
		Vector<String> ezaugarriak=new Vector<String>();
		String agenteId = agenteZer.get((cmbAgenteak.getSelectedIndex())).getId();
		try {
			ezaugarriZer =  getEzaugarriak(agenteId);
			for(int i=0; (ezaugarriZer.size() > i);i++){
				ezaugarriak.add(ezaugarriZer.get(i).getEzaugarri());
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return ezaugarriak;
	}

    /**
     * Daten zerrenda itzultzen duen metodoa
     * @return Vector<String>
     */
	public Vector<String> kargatuDatak(JComboBox cmbEzaugarriak, JComboBox cmbAgenteak) throws RemoteException{
		dataZer.removeAllElements();
		Vector<String> datak=new Vector<String>();
		try {
			String agenteId=agenteZer.get(cmbAgenteak.getSelectedIndex()).getId();
			String ezaugarriId=ezaugarriZer.get(cmbEzaugarriak.getSelectedIndex()).getId();
			dataZer= getDatak(agenteId,ezaugarriId);
			for(int i=0; (dataZer.size() > i);i++){
				datak.add(dataZer.get(i).toString());
		}
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return datak;
	}

    /**
     * Aukeratutako agentearen identifikatzailea itzultzen duen metodoa
     * @return String
     */
    public String lortuAukeratutakoAgenteId(JComboBox cmbAgenteak) throws RemoteException{
    	return (agenteZer.get(cmbAgenteak.getSelectedIndex()).getId());
    }

    /**
     * Aukeratutako ezaugarriaren identifikatzailea itzultzen duen metodoa
     * @return String
     */
    public String lortuAukeratutakoEzaugarriId(JComboBox cmbEzaugarriak) throws RemoteException{
    	return (ezaugarriZer.get(cmbEzaugarriak.getSelectedIndex()).getId());
    }

    /**
     * Turista berria turisten zerrendan gordetzen duen metodoa
     * @return void
     */
	public void gehituTurista(String izena, String helbidea, String telf, int pos){
		Turista t= new Turista(izena,helbidea,telf);
		if(turistaZer.size() > pos) turistaZer.setElementAt(t, pos);
		else turistaZer.add(pos,t);
	}

    /**
     * Posizio jakin batean gordetako turista itzultzen duen metodoa
     * @return Turista
     */
	public Turista lortuTurista(int pos){
		if(turistaZer.size() > pos){
			String izena=turistaZer.get(pos).getIzena();
			String helbidea=turistaZer.get(pos).getHelbidea();
			String telefonoa=turistaZer.get(pos).getTelefonoa();
			return new Turista(izena,helbidea,telefonoa);
		}
		return new Turista("","","");
	}

    /**
     * Aukeratutako agentearen identifikatzailea itzultzen duen metodoa
     * @return void
     */
	public void ezabatuTuristak() throws RemoteException{
		turistaZer.removeAllElements();
	}
}
