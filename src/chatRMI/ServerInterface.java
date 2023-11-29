package chatRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

    void startServer() throws RemoteException;

    void stopServer() throws RemoteException;
}