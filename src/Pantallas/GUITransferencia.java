/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pantallas;

/**
 *
 * @author cabal
 */
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import webbanking.Cuenta;
public class GUITransferencia extends JFrame  {
   JPanel panel=new JPanel();
   Cuenta cuenta;
    public GUITransferencia(Cuenta cuentasesion){
    cuenta = cuentasesion;  
    this.setTitle("Transferencia entre cuentas");
    this.setSize(500, 500);//tamaño de ventana
    this.setLocationRelativeTo(null);//centra la ventana en la pantalla
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    IniciarComponentes();
    }
    
    private void IniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
    }
    
    private void colocarPanel(){
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);//establecer color del panel
        this.getContentPane().add(panel); //agregamos el panel
    }
    private void colocarEtiquetas(){
        
    }
    
    private void colocarBotones(){
        JButton BTransferir= new JButton("Transferir");
        BTransferir.setBounds(100, 200, 200, 50);
        panel.add(BTransferir);
        
        BTransferir.addActionListener(e -> {
            // Mostrar el diálogo de contraseña
            int Pin= cuenta.getPinTransaccion(); // Contraseña numérica correcta
            //EL dialogo se va a aencargar de comparar y de devolver si introdujo correctamente
            GUIPinTransaccion Dialogo = new GUIPinTransaccion(this, "Introduzca su pin de transaccion", Pin);
            Dialogo.setVisible(true);

            // Validar si la contraseña fue correcta
            if (Dialogo.validarcontraseña()) {
                //ACA TIENEN QUE PONER LA LOGICA DE LA ACCION QUE QUIEREN QUE REALICE SOBRE LA BASE DE DATOS
                //COMO LAS QUE DEFINIMOS,DEPOSIITO,TRANSFERENCIA,ETC,ETC.
                GUITransaccionFormulario tForm = new GUITransaccionFormulario(cuenta);
                tForm.setVisible(true);
                dispose();
            } 
        });
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cuenta cuenta=new Cuenta("","", "",0,0, "",0,0);
        GUITransferencia Inicio=new GUITransferencia(cuentasesion);
        Inicio.setVisible(true);
    } 
}
