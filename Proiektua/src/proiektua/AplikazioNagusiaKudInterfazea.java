package proiektua;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface AplikazioNagusiaKudInterfazea extends Remote{
	//AplikazioNagusiaKud erabiltzen dituen metodo guztiak definitu behar dira:
	public void deskonektatuDB() throws RemoteException;
	public Vector<Agentea> getAgenteak() throws RemoteException;
	public Vector<Ezaugarria> getEzaugarriak(String agenteId) throws RemoteException;
	public String getErreserbaBaieztapenZenbakia(String agenteId, String irteeraId, String data, int bidaiariKop) throws RemoteException;
	public Vector<Data> getDatak(String aId,String iId) throws RemoteException;
	public boolean baieztapenZenbakiaKonprobatu(String z) throws RemoteException;
	public int sartuTurista(String izena,String helbidea,String telefonoa,String turistaZenbakia) throws RemoteException;
    public int sartutErreserba(String baieztapenZenbakia,int turistaKop,String irteerarenKodea,String agenteKodea) throws RemoteException;

}
