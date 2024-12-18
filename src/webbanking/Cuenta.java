package webbanking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import variablesGlobales.MensajesError;
import variablesGlobales.MensajesExito;
import webbanking.db.ConexionBD;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sotelo
 */
public class Cuenta {
    private String correo;
    private String Titular;
    private String tipoCuenta;
    private long  IDcuenta;// le agrege porque tiene que ser uno d elos atributos de la cuenta
    private double saldo;// modifique a double para que pueda usar el constructor porque si esta en Double no se puede modificar
    private String estadoCuenta;
    private Integer pinCuenta;
    private Integer pinTransaccion;
    
    public Cuenta(){}
    
    public Cuenta(String correo,String titular, String tipoCuenta, long Id, double saldo, String Estado, Integer pincuenta, Integer pintransaccion) {
        this.correo=correo;
        this.Titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.IDcuenta = Id;
        this.saldo = saldo;
        this.estadoCuenta = Estado;
        this.pinCuenta = pincuenta;
        this.pinTransaccion = pintransaccion;
    }
    public String getcorreo(){
        return this.correo;
    }
    
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String gettitular(){
        return this.Titular;
    }
    
    public void setTitular(String nombre){
        this.Titular = nombre;
    }
    
    public long getIDcuenta(){
        return this.IDcuenta;
    }
    
    public void setIDcuenta(long idCuenta){
        this.IDcuenta = idCuenta;
    }
    
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
        actualizarSaldo();
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public Integer getPinCuenta() {
        return pinCuenta;
    }
    
    public void setPinCuenta(int pinCuenta){
        this.pinCuenta = pinCuenta;
    }

    public Integer getPinTransaccion() {
        return pinTransaccion;
    }
    
    public void setPinTransaccion(int pinTransaccion){
        this.pinTransaccion = pinTransaccion;
    }
    
    public void aumentarSaldo(double dep){
        this.saldo=this.saldo + dep;
        actualizarSaldo();
    }
    public void disminuirSaldo(double dep){
        this.saldo=this.saldo - dep;
        actualizarSaldo();
    }
    
    private boolean actualizarSaldo() {
        // primero actualizamos el saldo de la cuenta origen
        String sql = "UPDATE Cuenta SET saldo = ?  WHERE id_cuenta = ?";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            // Configurar los parámetros de la consulta
            stmt.setDouble(1, saldo);
            stmt.setInt(2, (int)IDcuenta);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println(MensajesExito.EXITO_ACTUALIZACION);
                return true;
            } else {
                System.out.println(MensajesError.ERROR_CUENTA_NO_ENCONTRADA);
                return false;
            }
        } catch (SQLException e) {
            System.err.println(MensajesError.ERROR_AL_ACTUALIZAR + e.getMessage());
            return false;
        }
                
    }
    
    
}
