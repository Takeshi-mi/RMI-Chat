import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClienteInterface extends Remote {

    void receberMensagem(String menssagem) throws RemoteException;

    void updateUserList(ArrayList<String> users) throws RemoteException;
}