/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;
import webbanking.BaseDatos;
import webbanking.Cuenta;
import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.TransferenciaInterface;

/**
 *
 * @author sotelo
 */
public class Transferencia extends Operacion implements TransferenciaInterface {
    private long CDestin;
    private Cuenta CRemitente;
    private double Monto;
    private Cuenta CuentaSesion;
    private BaseDatos Basedatos=new BaseDatos();
    public Transferencia(Cuenta CR,long CD,double monto,Cuenta CS){
        this.CDestin=CD;
        this.CRemitente=CR;
        this.Monto=monto;
        this.CuentaSesion=CS;
    }
    public void Transferir(){
        Basedatos.Transferir(CDestin, CRemitente, Monto);
    }
    public boolean ValidarDatos() {
        if (Basedatos.verifTRS(CDestin, CRemitente, Monto, CuentaSesion)) {
            return true;
        }
       return false;
    }
    
    
            
    @Override
    public Boolean transferencia() {
        return true;
    }

    @Override
    public Boolean validarPinTransaccion() {
        return true;
    }
    
}
