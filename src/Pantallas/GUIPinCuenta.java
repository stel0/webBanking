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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import webbanking.BaseDatos;
import webbanking.Cuenta;

public class GUIPinCuenta extends JFrame {
    private Integer pin;
    JPanel panel=new JPanel();//creacion de panel
    JTextField CPin= new JTextField();//caja de texto
    JLabel error = new JLabel();
    
    JFrame Operacion;
    public GUIPinCuenta (Integer Pin,JFrame operacion){
        this.pin=Pin;
        this.Operacion=operacion;
        this.setTitle("Validacion de pin");
        this.setSize(500, 500);//tamaño de ventana
        this.setLocationRelativeTo(null);//centra la ventana en la pantalla
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        IniciarComponentes();
        
    }
    
    
    private void IniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        colocarCajaTexto();
        colocarBotones();
        
    }
    
    private void colocarPanel(){
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);//establecer color del panel
        this.getContentPane().add(panel); //agregamos el panel
    }
    
    private void colocarEtiquetas(){
        JLabel TITULO = new JLabel("VALIDACION DE PIN DE CUENTA");
        JLabel Solicitud = new JLabel("Por favor, ingrese su pin de cuenta para continuar...");
        JLabel Ncampo = new JLabel("Pin cuenta: ");
        
        TITULO.setBounds(130,30, 300, 20);
        Solicitud.setBounds(100,55, 400, 20);
        Ncampo.setBounds(60,100, 200, 40);
        
        TITULO.setFont(new Font("arial",Font.BOLD,15));
        Solicitud.setFont(new Font("arial",Font.PLAIN,12));
        
        panel.add(TITULO);
        panel.add(Solicitud);
        panel.add(Ncampo);
    }
    private void colocarBotones(){
        
        JButton Bverificar= new JButton("Continuar");
        Bverificar.setBounds(125, 200, 200, 50);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(Bverificar);
        
        error.setBounds(30, 300, 450, 30);
        error.setFont(new Font("arial", Font.PLAIN, 15));
        error.setForeground(Color.RED);
        error.setVisible(false); // Por defecto es invisible
        panel.add(error);
        ActionListener Validar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int cpin = Integer.parseInt(CPin.getText()); 
                    if(pin.equals(cpin)){
                        Operacion.setVisible(true);
                        dispose();
                    }else{
                        error.setText("La contraseña es incorrecta, por favor vuelva a intentar.");
                        error.setVisible(true); 

                    }
                }catch(NumberFormatException ex){//validar si el pin es un numero
                     error.setText("El PIN  debe ser caracteres numericos.");
                     error.setVisible(true);
                }
            }
        };
        Bverificar.addActionListener(Validar);
        
        
        JButton BSalir= new JButton("Atras");
        BSalir.setBounds(400, 400, 70, 30);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(BSalir);
        //Evento: salir(vuelve a inicio de sesion)
        ActionListener Salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion.dispose();
                dispose();
            }  
        };
        BSalir.addActionListener(Salir);
        
    }
    
    
    private void colocarCajaTexto(){
        CPin.setBounds(60, 140, 300, 20);
        panel.add(CPin);
        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int Pin=0;
        JFrame ventana=new JFrame();
        GUIPinCuenta pincuenta=new GUIPinCuenta(Pin,ventana);
        pincuenta.setVisible(true);
    }
}