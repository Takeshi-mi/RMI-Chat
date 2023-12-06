/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chatrmi;

import server.FrmServidor;

/**
 *
 * @author Takeshi
 */
public class ChatRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            FrmServidor server = new FrmServidor();
            server.setVisible(true);
    }
    
}
