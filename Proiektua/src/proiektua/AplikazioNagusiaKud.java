package proiektua;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.Observable;
import java.util.Vector;

//import erreserbaEgin.Aparkalekua; (Beste pakete bateko klasea)

//extends Observable???
public class AplikazioNagusiaKud extends UnicastRemoteObject implements AplikazioNagusiaKudInterfazea{
	//Erabiliko d(ir)en klaseak adierazi (LOTURAK):
	private static AplikazioDatuBase aplikazioDatuBase;//hau klase diagraman ez dago


	public AplikazioNagusiaKud() throws RemoteException{
		super();
		//AplikazioDatuBase klasearen instantzia egin, honekin DB-ra konektatuko da.
		aplikazioDatuBase = new AplikazioDatuBase();
		//Beste kudeatzaileen instantziak:
		//erreserbaEginKud = new erreserbaEgin.erreserbaEginKud();
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

}
