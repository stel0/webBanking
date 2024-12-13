/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
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
public class GUIPagoServicios extends JFrame  {
   
    public GUIPagoServicios(Cuenta cuentasesion){
    this.setTitle("Pago Servicios");
    this.setSize(500, 500);//tamaño de ventana
    this.setLocationRelativeTo(null);//centra la ventana en la pantalla
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Cuenta cuentasesion= new Cuenta("","", "",0,0, "",0,0);
        GUIPagoServicios Inicio=new GUIPagoServicios(cuentasesion);
        Inicio.setVisible(true);
    } 
}
