/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;

import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.PagoTarjetaInterface;

/**
 *
 * @author sotelo
 */
public class PagoTarjeta extends Operacion implements PagoTarjetaInterface{

    @Override
    public Boolean pagoTarjeta() {
        return true;
    }

    @Override
    public Boolean validarPinCuenta() {
        return true;
    }
   
}
