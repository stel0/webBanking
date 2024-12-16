/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;
import webbanking.BaseDatos;
import webbanking.Cuenta;
import webbanking.db.Consultas;
import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.DepositoInterface;

/**
 *
 * @author sotelo
 */
public class Deposito extends Operacion implements DepositoInterface {
    private final double deposito;
    
    public Deposito(double deposito){
        this.deposito=deposito;
    }
    
    private void setTransaccion(){
        this.tipoTransaccion="deposito";
    }
    
    
    @Override
    //realiza la operacion de deposito en cuenta
    public Boolean depositar() {
        if (deposito <= 0) {
            throw new IllegalArgumentException("El depósito debe ser mayor a 0.");
        }
        try {
            cuentaDestino.aumentarSaldo(deposito);
            return true;
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error:"+e.getMessage());
        }
        return false;
    }
}
