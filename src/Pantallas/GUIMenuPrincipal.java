package Pantallas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cabal
 */
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import variablesGlobales.MensajesExito;
import webbanking.BaseDatos;
import webbanking.Cuenta;
import webbanking.db.Consultas;
import webbanking.operaciones.PagoTarjeta;

public class GUIMenuPrincipal extends JFrame {
    Cuenta cuenta;
    private BaseDatos baseDatos;
    private JLabel Saldo;
    
    JPanel panel=new JPanel();//creacion de panel
    JTextField Pin= new JTextField();
    JTextField Correo= new JTextField();
    //private final JLabel lblSaldo; // Para mostrar y actualizar el saldo dinámicamente

    
    public GUIMenuPrincipal (Cuenta cuenta){ 
        this.cuenta=cuenta;
        this.baseDatos = new BaseDatos();
        this.setTitle("Menu");
        this.setSize(800, 700);//tamaño de ventana
        this.setLocationRelativeTo(null);//centra la ventana en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //lblSaldo = new JLabel("Saldo disponible: " + cuenta.getSaldo());
        
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
        //creamos las etiquetas
        JLabel Saludo = new JLabel("Bienvenido, "+cuenta.gettitular()+" !");
        JLabel Idcuenta = new JLabel("Nro.Cuenta: "+ cuenta.getIDcuenta());
        JLabel SaldoT    = new JLabel("Saldo disponible:  ");
        Saldo   = new JLabel(" "+cuenta.getSaldo());
        
        
        //seteamos sus posicion y tamaño
        //nombreetiqueta.bounds(x,y,ancho,alto)
        Saludo.setBounds(250,30, 400, 20);
        Idcuenta.setBounds(250,60, 400, 20);
        SaldoT.setBounds(30,80, 400, 40);
        Saldo.setBounds(250,100, 400, 80);
        
        //color de fuente  del texto
        
        Idcuenta.setForeground(Color.BLACK);
        
        //formato de la fuente
        Saludo.setFont(new Font("arial",Font.PLAIN,20));
        Idcuenta.setFont(new Font("arial",Font.BOLD,15));
        SaldoT.setFont(new Font("arial",Font.PLAIN,18));
        Saldo.setFont(new Font("arial",Font.BOLD,30));
        
        //agergamos las etiquetas a la pantalla
        panel.add(Saludo);
        panel.add(Idcuenta);
        panel.add(SaldoT);
        panel.add(Saldo);   
    }
    
    
    private void colocarBotones(){
        JButton BDeposito = new JButton("Depósito Cuenta");
        BDeposito.setBounds(100, 200, 200, 50);
        panel.add(BDeposito);

        // Evento: Abrir GUIDeposito y validar el Pin de cuenta
        ActionListener ValidarPin1;
        ValidarPin1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GUIDeposito GDeposito= new GUIDeposito(cuenta);
                GUIPinCuenta PantallaValidacion = new GUIPinCuenta(cuenta.getPinCuenta(),GDeposito,cuenta);
                PantallaValidacion.setVisible(true);
            }
        };
        BDeposito.addActionListener(ValidarPin1);

        
        JButton BTransferencia= new JButton("Transferencia entre cuentas");
        BTransferencia.setBounds(400, 200, 200, 50);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(BTransferencia);
        ///Evento: Abrir GUITransferencia y validar la Pin de cuenta
        ActionListener ValidarPin2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUITransferencia GTransferencia= new GUITransferencia(cuenta);//recibe la cuenta en la que inicio la sesion para revisar si la cuenta desde la que quiere tranferir es esa u otra del mismo titular
                GUIPinCuenta PantallaValidacion = new GUIPinCuenta(cuenta.getPinCuenta(),GTransferencia,cuenta);
                PantallaValidacion.setVisible(true);
                dispose();
            }    
        };
        BTransferencia.addActionListener(ValidarPin2);
        
        //
        
        
        JButton BPagoServicio= new JButton("Pagar Servicios");
        BPagoServicio.setBounds(100, 300, 200, 50);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(BPagoServicio);
        ///Evento: Abrir GUIPagoServicio y validar la Pin de cuenta
         ActionListener ValidarPin3= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GUIPagoServicios GPagoServicios= new GUIPagoServicios(cuenta);//recibe la cuenta en la que inicio la sesion para revisar si la cuenta desde la que quiere tranferir es esa u otra del mismo titular
                GUIPinCuenta PantallaValidacion = new GUIPinCuenta(cuenta.getPinCuenta(),GPagoServicios,cuenta);
                PantallaValidacion.setVisible(true);  
            }
        };
        BPagoServicio.addActionListener(ValidarPin3);
        
        
        
        //
        
        JButton BPagotarjeta= new JButton("Pagar Tarjeta de Credito");
        BPagotarjeta.setBounds(400, 300, 200, 50);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(BPagotarjeta);
        //Evento: Abrir GUIPagoTarjeta y validar pin cuenta
         ActionListener ValidarPin4= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PagoTarjeta pt = Consultas.deudaTarjeta(cuenta.getIDcuenta());
                if(pt != null){
                    if(pt.getDeuda() != 0){
                        GUIPagoTarjetas GPagoTarjeta= new GUIPagoTarjetas(cuenta,pt);
                        GUIPinCuenta PantallaValidacion = new GUIPinCuenta(cuenta.getPinCuenta(),GPagoTarjeta,cuenta);
                        PantallaValidacion.setVisible(true);  
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Por el momento no tienes deuda");
                    }
                }else{
                    JOptionPane.showMessageDialog(rootPane, "No posees una tarjeta");
                }
            }
                
        };
        BPagotarjeta.addActionListener(ValidarPin4);
        
        //
        
        
        JButton BSalir= new JButton("Salir");
        BSalir.setBounds(650, 600, 60, 30);
        /*InicioSesion.setEnabled(true);*///habilitar o deshabilitar la interaccion con el boton
        panel.add(BSalir);
        //Evento: salir(vuelve a inicio de sesion)
        ActionListener Salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                GUIInicioSesion inicio=new GUIInicioSesion();
                inicio.setVisible(true);
            }
                
        };
        BSalir.addActionListener(Salir);

        
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cuenta cuenta=new Cuenta("","", "",0,0, "",0,0);
        GUIMenuPrincipal Inicio=new GUIMenuPrincipal(cuenta);
        Inicio.setVisible(true);
        
    }
}
