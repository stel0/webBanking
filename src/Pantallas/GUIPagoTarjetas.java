/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pantallas;

import javax.swing.JFrame;
import webbanking.Cuenta;

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
public class GUIPagoTarjetas extends JFrame  {
    Cuenta cuenta;
    BaseDatos baseDatos;
    public  GUIPagoTarjetas(Cuenta cuenta, BaseDatos baseDatos) {
        
        this.setTitle("Pago de Tarjetas de credito");
        this.setSize(500, 500);//tamaño de ventana
        this.setLocationRelativeTo(null);//centra la ventana en la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public static void main(String[] args) {
            // TODO code application logic here
            BaseDatos baseDatos = new BaseDatos();
            Cuenta cuenta= new Cuenta("","", "",0,0, "",0,0);
            GUIPagoTarjetas Inicio = new GUIPagoTarjetas(cuenta, baseDatos);
            Inicio.setVisible(true);
        } 
}
