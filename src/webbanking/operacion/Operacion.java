/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import variablesGlobales.MensajesError;
import variablesGlobales.MensajesExito;
import webbanking.Cuenta;
import webbanking.db.ConexionBD;

/**
 *
 * @author sotelo
 */
abstract public class Operacion {
    protected Cuenta cuenta;
    protected Cuenta cuentaDestino;
    protected Long idCuentaDestino;
    protected String tipoTransaccion;
    protected Double monto;
    protected String fecha;
    protected String estadoOperacion;
    protected String detalles;
    
    //variables especial
    protected String mensaje;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Long getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(Long idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
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
