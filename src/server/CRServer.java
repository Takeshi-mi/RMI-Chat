package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CRServer extends Remote {
	void connect(User usuario) throws RemoteException;
	void sendMessage(User usuario, String msg) throws RemoteException;
	void disconnect(User usuario) throws RemoteException;
}