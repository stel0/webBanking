/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import java.awt.Panel;
import javax.swing.JOptionPane;
import variablesGlobales.MensajesExito;
import webbanking.Cuenta;
import webbanking.db.Consultas;
import webbanking.operaciones.PagoTarjeta;

/**
 *
 * @author sotelo
 */
public class GUIPagoTarjetas extends javax.swing.JFrame {

    private Cuenta cuenta;
    private PagoTarjeta pt;
    /**
     * Creates new form GUIPagoTarjetas
     */
    public GUIPagoTarjetas(Cuenta cuenta,PagoTarjeta pt) {
        this.setLocationRelativeTo(null);//centra la ventana en la pantalla
        this.cuenta = cuenta;
        this.pt = pt;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        deudaTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidadAbonar = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();
        Abonar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Deuda total:");

        deudaTotal.setEditable(false);
        deudaTotal.setText(Integer.toString(pt.getDeuda()));

        jLabel2.setText("Cantidad a abonar:");

        cantidadAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadAbonarActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Abonar.setText("Abonar");
        Abonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbonarActionPerformed(evt);
            }
        });

        jLabel3.setText("Saldo cta:");

        jTextField1.setEditable(false);
        jTextField1.setText(Double.toString(cuenta.getSaldo()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(Abonar))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(deudaTotal)
                    .addComponent(cantidadAbonar)
                    .addComponent(jTextField1))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deudaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cantidadAbonar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(Abonar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        dispose();
        GUIMenuPrincipal menuPrincipal = new GUIMenuPrincipal(cuenta);
        menuPrincipal.setVisible(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private void AbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbonarActionPerformed
        // TODO add your handling code here:
        try {
            int abonar = Integer.parseInt(cantidadAbonar.getText());
            int diferencia = pt.getDeuda() - abonar;
        
            if(diferencia < 0){
                JOptionPane.showMessageDialog(this, "El monto a abonar debe ser menor o igual a la deuda");
            }else if((double)abonar > cuenta.getSaldo()){
                JOptionPane.showMessageDialog(this, "El monto a abonar sobrepasa el saldo de la cuenta");
            }else if((double)abonar <= 0){
                JOptionPane.showMessageDialog(this, "El monto a abonar debe ser mayor a cero");
            }else{
                if(pt.pagoTarjeta(abonar)){
                    JOptionPane.showMessageDialog(this, "El pago ha sido exitoso!");
                    cuenta.disminuirSaldo(abonar);
                    dispose();
                    GUIMenuPrincipal menuPrincipal = new GUIMenuPrincipal(cuenta);
                    menuPrincipal.setVisible(true);
                }
            }
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error:"+e.getMessage());
        }
        
    }//GEN-LAST:event_AbonarActionPerformed

    private void cantidadAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadAbonarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadAbonarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPagoTarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPagoTarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPagoTarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPagoTarjetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Cuenta cuenta=new Cuenta("","", "",0,0, "",0,0);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIPagoTarjetas(cuenta,new PagoTarjeta()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abonar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JTextField cantidadAbonar;
    private javax.swing.JTextField deudaTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
