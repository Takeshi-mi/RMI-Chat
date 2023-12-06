package server;

import interfaces.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServidorChat extends UnicastRemoteObject implements InterfaceChat {
    List<String> messageLog = new ArrayList<>();
    List<InterfaceCliente> clientes = new ArrayList<>();

    public ServidorChat() throws RemoteException {
        super(); //chama o construtor da classe mãe, no caso UnicastRemoteObject. 
        clientes = new ArrayList<>();
      
    }
    @Override
       public String getAllMsg() throws RemoteException {
           StringBuilder sb = new StringBuilder();
           for (String msg : messageLog) {
               sb.append(msg);
               sb.append("\n");
           }
           return sb.toString();
       }
    @Override
    public void registrarCliente(InterfaceCliente cliente, String nome) throws RemoteException {
        clientes.add(cliente);
        notifyAtualizarClientes();
        enviarMensagem("Aviso:", nome+" entrou no chat!");
    }

     private void notifyAtualizarClientes() throws RemoteException {
        for (var cl : clientes) {
            cl.atualizarClientes();
        }
    }
    @Override
    public void desconectarCliente(InterfaceCliente listener) throws RemoteException {
        clientes.remove(listener);
        notifyAtualizarClientes();
        enviarMensagem("Aviso:", listener+" saiu do chat!");
    }

    @Override
    public void enviarMensagem(String remetente, String mensagem) throws RemoteException {
        String displayMsg =  remetente + ": "+mensagem;
        messageLog.add(displayMsg);
        for (var cliente : clientes) {
            cliente.notificar(displayMsg);
        }
    }

    @Override
    public List<InterfaceCliente> getClientes() throws RemoteException {
        return clientes;
    }

}
