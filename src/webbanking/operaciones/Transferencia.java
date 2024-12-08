/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;

import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.TransferenciaInterface;

/**
 *
 * @author sotelo
 */
public class Transferencia extends Operacion implements TransferenciaInterface {

    @Override
    public Boolean transferencia() {
        return true;
    }

    @Override
    public Boolean validarPinTransaccion() {
        return true;
    }
    
}
