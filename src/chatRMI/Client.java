import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

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
				Player player = new Player();
				player.setLogin(login);
				conn.connect(player);
				conn.sendMessage(player, JOptionPane.showInputDialog(null, "Digite uma mensagem"));
				conn.disconnect(player);
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