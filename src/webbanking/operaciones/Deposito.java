/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;

import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.DepositoInterface;

/**
 *
 * @author sotelo
 */
public class Deposito extends Operacion implements DepositoInterface {

    @Override
    public Boolean depositar() {
        //DENTRO DE ESTE METODO VALIDAR EL PIN DE CUENTA 
        return true;
    }
      /*
    no es necesario, debido a que antes de depositar vos ya vas a estar dentro
    de tu cuenta, lo que si se debera validar es el numero de cuenta a la que 
    queres depositar para ver si existe dentro de la base de datos
    
    @Override
    public Boolean validarPinCuenta() {
        return true;
    }
    }*/
    
}
