/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import webbanking.Cuenta;

import webbanking.Servicio;
import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.PagoServiciosInterface;

/**
 *
 * @author sotelo
 */
public class PagoServicios extends Operacion implements PagoServiciosInterface {
    private String servicio;

    public PagoServicios(String servicio,Cuenta cuenta,Double monto) {
        this.servicio = servicio;
        this.cuenta = cuenta;
        this.monto = monto;
    }

    public String getServicio(){
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

   

    @Override
    public Boolean validarPinTransaccion() {
        return true;
    }

    @Override
    public Boolean pagarServicios() {
        if (monto <= 0) {
            throw new IllegalArgumentException("El depósito debe ser mayor a 0.");
        }
        try {
            cuenta.disminuirSaldo(monto);
            return true;
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error:" + e.getMessage());
        }
        return false;
    }
}
