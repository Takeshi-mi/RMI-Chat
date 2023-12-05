/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

/**
 *
 * @author Takeshi
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCliente extends Remote { //Define a interface extendendo a classe Remote. 
    // É um padrão quando se trata de Remote Methods Invocation(RMI)
    void notificar(String msg) throws RemoteException; 
    void atualizarClientes() throws RemoteException;
    String getNome() throws RemoteException;
}
