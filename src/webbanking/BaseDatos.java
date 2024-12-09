/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package webbanking;

/**
 *
 * @author cabal
 */
import java.util.ArrayList;

public class BaseDatos {
    ArrayList<Cuenta> cuentas = new ArrayList<>();
    
    public BaseDatos() {
        cuentas.add(new Cuenta("Alex", "Corriente", 6546548, 3000000, "Activa", 1324, 2222));
        cuentas.add(new Cuenta("Bruno", "Ahorro", 6546549, 2000000, "Activa", 4321, 1111));
        cuentas.add(new Cuenta("Carla", "Corriente", 6546550, 1500000, "Inactiva", 5678, 3333));
    }
    // retorna la cuenta del id correspondiente
    public Cuenta getCuenta(double id){
        for(Cuenta cuenta : cuentas){
            if (cuenta.getIDcuenta() == id){
                return cuenta; // Retorna la cuenta encontrada
            }
        }   
        return null; 
    }
    //realiza la opreacion depositocuenta que aumento el saldo de la cuenta destino en el monto introducido 
    public Boolean Depositar(double CDestino,double Deposito){
        if (Deposito <= 0) {
            throw new IllegalArgumentException("El depósito debe ser mayor a 0.");
        }
        Cuenta cuenta=getCuenta(CDestino);
        System.out.println("Antes del deposito: "+cuenta.getSaldo()+" Titular: "+cuenta.gettitular()+" Nro. Cuenta: "+ cuenta.getIDcuenta());
        cuenta.aumentarSaldo(Deposito);
        System.out.println("Despues del deposito: "+cuenta.getSaldo()+" Titular: "+cuenta.gettitular()+" Nro. Cuenta: "+ cuenta.getIDcuenta());
        return true;
    }
    
}
