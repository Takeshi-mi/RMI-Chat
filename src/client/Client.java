package client;

import server.User;
import client.CRClient;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import server.CRServer;
import view.FrmLogin;

@SuppressWarnings("serial")
public class Client extends UnicastRemoteObject implements CRClient {
	public Client() throws RemoteException {super();} 
	
	public static void main(String[] args) {
		CRServer conn;
		try {
                        Registry registry = LocateRegistry.getRegistry("localhost",1099);
			conn = (CRServer) Naming.lookup("Server1");
			try {
				String login = JOptionPane.showInputDialog(null, "Poe seu nick ai");
				registry.rebind("login", new Client());
				User user = new User();
                                user.setLogin(login);
				conn.connect(user);
				conn.sendMessage(user, JOptionPane.showInputDialog(null, "Digite uma mensagem"));
				conn.disconnect(user);
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Client exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void receiveMessage(String msg) throws RemoteException {
		System.out.println(msg);
	}
}