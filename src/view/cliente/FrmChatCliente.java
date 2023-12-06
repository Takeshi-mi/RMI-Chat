/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.cliente;

import interfaces.InterfaceChat;
import interfaces.InterfaceCliente;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Takeshi
 */
public class FrmChatCliente extends javax.swing.JFrame {
class ClientListener extends UnicastRemoteObject implements InterfaceCliente{
      
        
        ClientListener() throws RemoteException {
        }
        
        @Override
        public void notificar(String msg) throws RemoteException {
            String textoAntigo = txtBatePapo.getText();
            txtBatePapo.setText(textoAntigo+"\n"+msg);
            System.out.println("entrou no notificar");
        }

        @Override
        public void atualizarClientes() throws RemoteException {
            atualizarLista();
        }

        @Override
        public String getNome() throws RemoteException {
            return nomeCliente;
        }
    }
    private String nomeCliente;
    private InterfaceChat chat;
    private static Registry registro;
    private InterfaceCliente userIF;
//    ClientListener user;;;
    
    public FrmChatCliente(String nomeCliente, InterfaceChat chat) {
        initComponents();
        this.nomeCliente = nomeCliente;
        this.chat = chat;
        try {
            userIF = (InterfaceCliente) new ClientListener(); //castando para interface
            chat.registrarCliente(userIF, this.nomeCliente);
        } catch (RemoteException ex) {
            Logger.getLogger(FrmChatCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Configurar a interface com o nome do cliente
        lblNomeUser.setText(nomeCliente);
    }  

    private void atualizarLista() {
        try {
            // JList é um componente gráfico. 
            List<InterfaceCliente> clientes = chat.getClientes();
            DefaultListModel<String> model = new DefaultListModel<>(); //cria uma lista em branco. Eu poderia usar removeAllElemnts
            //model.removeAllElements();
            List<String> nomesClientes = new ArrayList<>();

            for (InterfaceCliente cliente : clientes) {
                nomesClientes.add(cliente.getNome());
            }

            model.addAll(nomesClientes);
            listOnlineUsers.setModel(model);
        } catch (RemoteException e) {
            e.printStackTrace();
            // Tratamento de erro ao atualizar lista de clientes
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBatePapo = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNomeUser = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMensagem = new javax.swing.JTextArea();
        btnEnvia = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnDesconectar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOnlineUsers = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(114, 137, 218));
        jPanel1.setToolTipText("");

        txtBatePapo.setEditable(false);
        txtBatePapo.setColumns(20);
        txtBatePapo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBatePapo.setRows(5);
        jScrollPane1.setViewportView(txtBatePapo);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile-user 64px.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        lblNomeUser.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNomeUser.setText("Usuário");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeUser))
                .addGap(16, 16, 16))
        );

        txtMensagem.setColumns(20);
        txtMensagem.setRows(5);
        jScrollPane3.setViewportView(txtMensagem);

        btnEnvia.setBackground(new java.awt.Color(114, 137, 218));
        btnEnvia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        btnEnvia.setToolTipText("");
        btnEnvia.setBorder(null);
        btnEnvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviaActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(33, 92, 84)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Grupo Família IFG");

        btnDesconectar.setBackground(new java.awt.Color(255, 0, 51));
        btnDesconectar.setForeground(new java.awt.Color(255, 255, 255));
        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesconectar)
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDesconectar)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(listOnlineUsers);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText(" • Online");
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnvia)
                        .addGap(221, 221, 221))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnvia))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviaActionPerformed
        try {
            String mensagem = txtMensagem.getText().trim();
            if (!mensagem.isEmpty()) {
                chat.enviarMensagem(nomeCliente, mensagem);
                txtMensagem.setText(""); // Limpar campo de mensagem após o envio
                // user.notificar(mensagem);
                System.out.println("teste"+ nomeCliente+ mensagem);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            // Tratamento de erro ao enviar mensagem
        }        
    }//GEN-LAST:event_btnEnviaActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
         desconectarCliente();
         
    }//GEN-LAST:event_btnDesconectarActionPerformed
    private void desconectarCliente() {
        try {
            chat.desconectarCliente(userIF);
            this.dispose();
            System.out.println("O cliente "+userIF.getNome()+" se desconectou.");

        } catch (RemoteException e) {
            e.printStackTrace();
            
        }
    }
    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmChatCliente("", null).setVisible(true);
 
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnEnvia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNomeUser;
    private javax.swing.JList<String> listOnlineUsers;
    private javax.swing.JTextArea txtBatePapo;
    private javax.swing.JTextArea txtMensagem;
    // End of variables declaration//GEN-END:variables
}
