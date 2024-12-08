/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;

import webbanking.Servicio;
import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.PagoServiciosInterface;

/**
 *
 * @author sotelo
 */
public class PagoServicios extends Operacion implements PagoServiciosInterface {
    private Servicio servicio;

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public Boolean pagarServicios() {
        return true;
    }

    @Override
    public Boolean validarPinTransaccion() {
        return true;
    }
      
}
