package webbanking;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sotelo
 */
public class Cuenta {
    private String tipoCuenta;
    private Double saldo;
    private String estadoCuenta;
    private Integer pinCuenta;
    private Integer pinTransaccion;

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

   
    public Integer getPinTransaccion() {
        return pinTransaccion;
    }

    
}
