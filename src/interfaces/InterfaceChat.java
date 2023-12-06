/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/**
 *
 * @author Takeshi
 */
public interface InterfaceChat extends Remote {//Define a interface extendendo a classe Remote. 
    // É um padrão quando se trata de Remote Methods Invocation(RMI)
    void registrarCliente(InterfaceCliente listener, String nome) throws RemoteException;
    void desconectarCliente(InterfaceCliente listener) throws RemoteException;
    void enviarMensagem(String remetente, String mensagem) throws RemoteException;
    List<InterfaceCliente> getClientes() throws RemoteException;

}