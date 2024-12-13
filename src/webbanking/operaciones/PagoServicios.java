/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import webbanking.Servicio;
import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.PagoServiciosInterface;

/**
 *
 * @author sotelo
 */
public class PagoServicios extends Operacion implements PagoServiciosInterface {
    private Servicio servicio;

    public PagoServicios(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio(){
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

   

    @Override
    public Boolean validarPinTransaccion() {
        return true;
    }

    @Override
    public String[] pagarServicios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagarServicios'");
    }

    // @Override
    // public void pagarServicios() {
    // try {
    // Servicio servicio = this.servicio;
    // Servicio response = this.baseDeDatos.get(servicio.getNombreServicio());
    // if (response.equals(null)) {
    // System.out.println("Servicio no encontrado");
    // } else {
    // String[] resultado;
    // }
    // } catch (Exception e) {
    // System.out.println("Error al obtener el servicio");
    // }
    // }
      
}
