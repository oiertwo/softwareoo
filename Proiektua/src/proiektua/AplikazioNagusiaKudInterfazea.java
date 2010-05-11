package proiektua;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface AplikazioNagusiaKudInterfazea extends Remote{
	//AplikazioNagusiaKud erabiltzen dituen metodo guztiak definitu behar dira:
	public void deskonektatuDB() throws RemoteException;
	public Vector<Agentea> getAgenteak() throws RemoteException;

}
