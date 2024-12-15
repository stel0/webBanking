/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Pantallas;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;
import webbanking.BaseDatos;
import webbanking.Cliente;
import webbanking.Cuenta;
import webbanking.db.Consultas;

/**
 *
 * @author cabal
 */
public class GUIInicioSesion extends JFrame {
    JPanel panel=new JPanel();//creacion de panel
    JTextField Pin= new JTextField();
    JTextField Correo= new JTextField();
    JLabel error = new JLabel();
    BaseDatos basedatos = new BaseDatos();
    public GUIInicioSesion(){
        // TODO code application logic here
        
        this.setTitle("Inicio de Sesion");
        this.setSize(500, 500);//tamaño de ventana
        this.setLocationRelativeTo(null);//centra la ventana en la pantalla
        IniciarComponente();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void IniciarComponente(){
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        colocarCajaTexto();
        
    }
    private void colocarPanel(){
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);//establecer color del panel
        this.getContentPane().add(panel); //agregamos el panel
    }
    private void colocarEtiquetas(){
        //creamos las etiquetas
        JLabel Lcorreo = new JLabel("Correo electronico");
        JLabel LPin = new JLabel("Contraseña ");
        
        //seteamos sus posicion y tamaño
        Lcorreo.setBounds(30,30, 200, 20);
        LPin.setBounds(30,80, 200, 20);
        
        //color de fuente en del texto
        Lcorreo.setForeground(Color.BLACK);
        LPin.setForeground(Color.BLACK);
        
        //formato de la fuente
        Lcorreo.setFont(new Font("arial",Font.PLAIN,15));
        LPin.setFont(new Font("arial",Font.PLAIN,15));
        
        //agergamos las etiquetas a la pantalla
        panel.add(Lcorreo);
        panel.add(LPin);
        
    }
    
    private void colocarBotones(){
        JButton InicioSesion= new JButton("Iniciar Sesion");
        InicioSesion.setBounds(175, 175, 150, 50);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(InicioSesion);
        
        error.setBounds(30, 250, 450, 30);
        error.setFont(new Font("arial", Font.PLAIN, 15));
        error.setForeground(Color.RED);
        error.setVisible(false); // Por defecto,invisible
        panel.add(error);
        
        //Evento:Validar Entradas de cajas de texto
        ActionListener Validar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String password = Pin.getText(); 
                    String correo = Correo.getText();
                    int id_cliente = Consultas.verificarPinCuenta(correo,password);
                    if(id_cliente != -1){
                        error.setText("Iniciando sesion");
                        error.setVisible(true);
                        List<Cuenta> cuentas= Consultas.obtenerDatos(correo,id_cliente);
                        System.out.println("Cantidad de cuentas:"+cuentas.size());

                        if(!cuentas.isEmpty()){
                            GUISeleccionarCuenta seleccionarCuenta = new GUISeleccionarCuenta(cuentas);
                            seleccionarCuenta.setVisible(true);
                            dispose();
                        }
                        
                    }else{

                        error.setText("El correo o la contraseña son incorrectos,por favor, vuelva a intentar.");
                        error.setVisible(true);
                    }
                }catch(NumberFormatException ex){//validar si el pin es un numero
                     error.setText("El PIN  debe ser válidos.");
                     error.setVisible(true);
                }
            }
        };
        
        InicioSesion.addActionListener(Validar);
        
        
    }
    
    private void colocarCajaTexto(){

        Correo.setBounds(60, 50, 300, 20);
        panel.add(Correo);
       
        Pin.setBounds(60, 100, 300, 20);
        panel.add(Pin);
         
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GUIInicioSesion Inicio=new GUIInicioSesion();
        Inicio.setVisible(true);
    }
}
