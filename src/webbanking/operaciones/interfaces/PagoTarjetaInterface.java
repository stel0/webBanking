/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package webbanking.operaciones.interfaces;

/**
 *
 * @author sotelo
 */
public interface PagoTarjetaInterface {
    Boolean pagoTarjeta(int monto);
    Boolean validarPinCuenta();
}
