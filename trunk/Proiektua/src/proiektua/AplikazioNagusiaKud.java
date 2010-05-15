package proiektua;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.Observable;
import java.util.Vector;

//extends Observable???
public class AplikazioNagusiaKud extends UnicastRemoteObject implements AplikazioNagusiaKudInterfazea{
	//Erabiliko d(ir)en klaseak adierazi (LOTURAK):
	private static AplikazioDatuBase aplikazioDatuBase;//hau klase diagraman ez dago
	String zenb; //Baieztapen zenbakia gordetzeko aldagai globala

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

	public void deskonektatuDB() throws RemoteException {
		aplikazioDatuBase.deskonektatuDB();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws RemoteException {
		zerbitzariaJaurti();
	}

	/*************************************************************/
	//METODOEN INPLEMENTAZIOA:
	public Vector<Agentea> getAgenteak()  throws RemoteException{
		return aplikazioDatuBase.getAgenteak();
	}

	public Vector<Ezaugarria> getEzaugarriak(String id) throws RemoteException {
		return aplikazioDatuBase.getEzaugarriak(id);
	}

	//"null" itzultzen du plaza kopuru librea erreserbatu nahi den plaza kopurua baino txikiagoa denean.
	public String getErreserbaBaieztapenZenbakia(String agenteId, String irteeraId, String data, int bidaiariKop) throws RemoteException{
		int plazaKop = aplikazioDatuBase.getPlazaKop(agenteId, irteeraId, data);
		if((plazaKop - bidaiariKop) < 0) return null;
		else{
			//"1"-etik "99999"-erako ausazko zenbakia lortu:
			Integer z = (int)Math.floor(Math.random()*(1-99999+1)+99999);
			zenb = z.toString();
			return (zenb);
		}
	}

	public boolean baieztapenZenbakiaKonprobatu(String z){
		return (z.equals(zenb));
	}

	private int getPlazaKop(String agenteId, String irteeraId, String data) throws RemoteException {
		return aplikazioDatuBase.getPlazaKop(agenteId,irteeraId,data);
	}

	public Vector<Data> getDatak(String aId, String iId) throws RemoteException {
		return aplikazioDatuBase.getDatak(aId, iId);
	}

	public int sartuTurista(String izena, String helbidea, String telefonoa, String turistaZenbakia) throws RemoteException {
		return aplikazioDatuBase.sartuTurista(izena, helbidea, telefonoa, turistaZenbakia);
	}

	public int sartuErreserba(String baieztapenZenbakia, int turistaKop,
		String irteerarenKodea, String agenteKodea, String data) throws RemoteException {
		return aplikazioDatuBase.sartuErreserba(baieztapenZenbakia, turistaKop, irteerarenKodea, agenteKodea, data);
	}



}
