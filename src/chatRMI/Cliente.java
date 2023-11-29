import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Cliente extends UnicastRemoteObject implements ClienteInterface {

    public Cliente() throws RemoteException {
        super();
    }

    @Override
    public void receberMensagem(String menssagem) throws RemoteException {
        // 
    }
 
    @Override
    public void updateUserList(ArrayList<String> users) throws RemoteException {
        // 
    }
}