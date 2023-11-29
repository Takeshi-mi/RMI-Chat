package server;

import client.CRClient;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements CRServer {
	private ArrayList<User> users = new ArrayList<User>();
	
	public Server() throws RemoteException {super();} 

	public static void main(String args[]) {
		try {
                        Registry registry = LocateRegistry.createRegistry(1099);
			Naming.rebind("Server1", new Server());
			System.out.println("Servidor Iniciado");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void sendMessage(User user, String msg) throws RemoteException {
		for(User userX : users) {
			userX.getConn().receiveMessage(user.getLogin() + " diz: " + msg);
		}
	}
	
	@Override
	public void connect(User user) throws RemoteException {
		users.add(user);
		try {
			user.setConn((CRClient) Naming.lookup("//127.0.0.1/" + user.getLogin()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		System.out.println("Ususário conectou: " + user.getLogin());
	}

	@Override
	public void disconnect(User user) throws RemoteException {
		users.remove(user);
		System.out.println("Ususário desconectou: " + user.getLogin());
	}
}