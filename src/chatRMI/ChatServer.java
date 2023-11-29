package chatRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatServer extends UnicastRemoteObject implements ServerInterface {

    private boolean isRunning;

    public ChatServer() throws RemoteException {
        super();
    }

    public void startServer() {
        isRunning = true;
        System.out.println("Servidor iniciado");
    }

    public void stopServer() {
        isRunning = false;
        System.out.println("Servidor interrompido");
    }
    public static void main(String[] args) throws RemoteException {
    try{
        ChatServer stubServidor = new ChatServer();
        ServerInterface stubRemoto = (ServerInterface) UnicastRemoteObject.exportObject(stubServidor, 0);
        Registry registro = LocateRegistry.createRegistry(1099);
        registro.rebind("Brastemp", stubServidor);
        System.out.println("Servidor RMI está pronto...");
    
    } catch (Exception e){
        System.err.println("Exceção no Servidor:" + e.toString());
       e.printStackTrace();
    } 
   }
}
    

