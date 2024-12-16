/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pantallas;

/**
 *
 * @author cabal
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIPinTransaccion extends JDialog{
    private boolean validez= false;
    
    public GUIPinTransaccion(JFrame padre,String Titulo,Integer Pin){
    super(padre, Titulo, true); // Modal para bloquear interacción con el JFrame
    setSize(500,300);
    setLayout(null);
    
    JLabel Solicitud = new JLabel("Por favor, ingrese su pin de transaccion para continuar");
    Solicitud.setBounds(20, 10, 400, 25);
    Solicitud.setFont(new Font("arial",Font.BOLD,12));
    add(Solicitud);
    
    JLabel titulocaja = new JLabel("Contraseña:");
    titulocaja.setBounds(20, 50, 100, 25);
    titulocaja.setFont(new Font("arial",Font.PLAIN,12));
    add(titulocaja);
    
    //caja de texto para la contraseña
    JTextField campoContrasena = new JTextField();
    campoContrasena.setBounds(120, 50, 150, 30);
    add(campoContrasena);
    
    JButton botonAceptar = new JButton("Aceptar");
    botonAceptar.setBounds(160,160, 100, 30);
    add(botonAceptar);
    
    
    
    //Colocar panel
    JPanel panel=new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.LIGHT_GRAY);//establecer color del panel
    this.getContentPane().add(panel); //agregamos el panel
    
    
    
    //Boton de salida/atras 
    JButton BSalir= new JButton("Atras");
        BSalir.setBounds(180, 210, 70, 30);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(BSalir);
        //Evento: salir(vuelve a inicio de sesion)
        ActionListener Salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }  
        };
    BSalir.addActionListener(Salir);
        
    this.add(BSalir);
        
        
        botonAceptar.addActionListener(e -> {
           
            
            try {
                int contrasenaIngresada = Integer.parseInt(campoContrasena.getText());
                if (contrasenaIngresada == Pin) {
                    validez = true; // Indicar que la contraseña es válida
                    dispose(); // Cerrar el diálogo
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta. Inténtalo de nuevo.");
                    campoContrasena.setText(""); // Limpiar el campo
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa un número válido.");
                campoContrasena.setText(""); // Limpiar el campo
            }
        });
        
         setLocationRelativeTo(padre);
    
    }
    public boolean validarcontraseña() {
       return validez;
   }
    
}
