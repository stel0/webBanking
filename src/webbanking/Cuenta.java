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
    private final String correo;
    private final String Titular;
    private String tipoCuenta;
    private final long  IDcuenta;// le agrege porque tiene que ser uno d elos atributos de la cuenta
    private double saldo;// modifique a double para que pueda usar el constructor porque si esta en Double no se puede modificar
    private String estadoCuenta;
    private final Integer pinCuenta;
    private Integer pinTransaccion;
    
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
    public String gettitular(){
        return this.Titular;
    }
    
    public double getIDcuenta(){
        return this.IDcuenta;
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
    public void aumentarSaldo(double dep){
        this.saldo=this.saldo + dep;
    }
    public void disminuirSaldo(double dep){
        this.saldo=this.saldo - dep;
    }
}
