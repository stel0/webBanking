/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package webbanking.operaciones.interfaces;

import webbanking.Servicio;

/**
 *
 * @author sotelo
 */
public interface PagoServiciosInterface {
    String[] pagarServicios();
    Boolean validarPinTransaccion();
}
