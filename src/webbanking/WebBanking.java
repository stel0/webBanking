/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webbanking;

import webbanking.operaciones.Deposito;

/**
 *
 * @author sotelo
 */
public class WebBanking {

    /**
     * @param args the command line arguments
     */
    /*NOTA
    La logica hasta donde esta implementada funciona, creo que deje lo suficientemente moldeable como para que
    se pueda conectar la base de datos de SQL y que de ahi modifique directamente los datos de las cuentas
    La clase basedatos es solamente para usar un array como idea de lo que tendria que hacer en la base de datos*/
    /*AUN ASI DEJARE EXPLICACIONES BREVES DE QUE CUAL ES EL FLUJO DE ACCION DEL PROGRAMA!*/ 
     public static void main(String[] args) {
         
         
         //Instanciamos una nueva clase deposito para realizar el deposito del monto a la cuenta
         
//        Deposito Deposito1=new Deposito(6546548,500000);
//        if (Deposito1.depositar()) {
//            System.out.println("Depósito realizado con éxito.");
//        } else {
//            System.out.println("Depósito fallido.");
//        }
        
        
        //Instancie otro deposito para que vean que la instanciacion dentro de la clase
        //deposito de la clase BaseDatos es propia de cada depostio por tanto los cambios no se mantendran, pero
        // si pasamos como parametro de instanciamiento de la propia class los cambios si son permanentes puesta esta trabajando sobre
        //el mismo objeto BaseDatos
        //no la paso como parametro por el hecho de que vamos a trabajar con una base de datos en SQL y por lo que vi el metodo 
        //  modificara directamente la base de datos 
        
//       Deposito Deposito2=new Deposito(6546548,500000);
//        if (Deposito2.depositar()) {
//            System.out.println("Depósito realizado con éxito.");
//        } else {
//            System.out.println("Depósito fallido.");
//        }
//        
        
        
        
        
    }
    
}
