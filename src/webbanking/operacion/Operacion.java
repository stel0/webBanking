/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operacion;

import webbanking.Cuenta;

/**
 *
 * @author sotelo
 */
abstract public class Operacion {
    protected Cuenta cuenta;
    protected Integer idCuentaDestino;
    protected String tipoTransaccion;
    protected Double monto;
    protected String fecha;
    protected String estadoOperacion;
    protected String detalles;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Integer getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(Integer idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(String estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
    
}
