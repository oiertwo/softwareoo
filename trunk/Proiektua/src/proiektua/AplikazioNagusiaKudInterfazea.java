package proiektua;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.swing.JComboBox;

public interface AplikazioNagusiaKudInterfazea extends Remote{
	//AplikazioNagusiaKud erabiltzen dituen metodo guztiak definitu behar dira:
	public void deskonektatuDB() throws RemoteException;
	public Vector<Agentea> getAgenteak() throws RemoteException;
	public Vector<Ezaugarria> getEzaugarriak(String agenteId) throws RemoteException;
	public int getPlazaKop(String agenteId, String irteeraId, String data) throws RemoteException;
	public String getErreserbaBaieztapenZenbakia(JComboBox cmbAgenteak, JComboBox cmbEzaugarriak, String data, int bidaiariKop) throws RemoteException;
	public Vector<String> getDatak(String aId,String iId) throws RemoteException;
	public boolean baieztapenZenbakiaKonprobatu(String z) throws RemoteException;
	public void sartuTuristak() throws RemoteException;
    public void sartuErreserba(String baieztapenZenbakia,String irteerarenKodea,String agenteKodea, String data) throws RemoteException;
    public Vector<String> kargatuAgenteak() throws RemoteException;
    public Vector<String> kargatuEzaugarriak(JComboBox cmbAgenteak) throws RemoteException;
    public Vector<String> kargatuDatak( JComboBox cmbEzaugarriak, JComboBox cmbAgenteak) throws RemoteException;
    public String lortuAukeratutakoAgenteId(JComboBox cmbAgenteak) throws RemoteException;
    public String lortuAukeratutakoEzaugarriId(JComboBox cmbEzaugarriak) throws RemoteException;
	public void gehituTurista(String izena, String helb, String telf, int pos) throws RemoteException;
	public Turista lortuTurista(int posizioa) throws RemoteException;
	public void ezabatuTuristak() throws RemoteException;
}
