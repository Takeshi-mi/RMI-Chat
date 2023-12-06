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
        enviarMensagem("Aviso:", listener.getNome()+" saiu do chat!");
    }

    @Override
    public void enviarMensagem(String remetente, String mensagem) throws RemoteException {
        String displayMsg =  remetente + ": "+mensagem;
        messageLog.add(displayMsg);
        for (var cliente : clientes) {
            cliente.notificar(displayMsg);  //Notifica cada cliente individualmente para saberem que chegou mensagem e 
            //é hora de atualizar a tela
            
        }
    }

    @Override
    public List<InterfaceCliente> getClientes() throws RemoteException {
        return clientes;
    }

}
