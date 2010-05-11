package proiektua;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AplikazioNagusiaKudInterfazea extends Remote{
	//AplikazioNagusiaKud erabiltzen dituen metodo guztiak definitu behar dira:
	public void deskonektatuDB() throws RemoteException;
	//public Vector<Agentea> lortuAgenteak() throws RemoteException;

}
