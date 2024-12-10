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
     /*la conexion de la base de datos se realizara atraves una clase mediadora, podria ser esta u otra
    aca estara la logica que yo use para la clase "BaseDatos" de ejemplo y que realizara los cambios en el array
    cada operacion, y como se creara una conexion para cada vez que se haga una operacion seria 
     interesante que tambien apliquen un metodo que elimine esa conexion una vez se haya realizado una operacion
    para no saturar las conexiones nada, pero eso ya es decision de ustedes*/
    
    ArrayList<Cuenta> cuentas = new ArrayList<>();
    
    public BaseDatos() {
        cuentas.add(new Cuenta("Alex", "Corriente", 6546548, 3000000, "Activa", 1324, 2222));
        cuentas.add(new Cuenta("Bruno", "Ahorro", 6546549, 2000000, "Activa", 4321, 1111));
        cuentas.add(new Cuenta("Carla", "Corriente", 6546550, 1500000, "Inactiva", 5678, 3333));
    }
    
    
    // retorna la cuenta del id correspondiente
    public Cuenta getCuenta(long id){
        for(Cuenta cuenta : cuentas){
            if (cuenta.getIDcuenta() == id){
                return cuenta; // Retorna la cuenta encontrada
            }
        }   
        return null; 
    }
    
    //DEPOSITO CUENTA//
    
    //realiza la opreacion depositocuenta que aumento el saldo de la cuenta destino en el monto introducido 
    public Boolean Depositar(long CDestino,double Deposito){
        if (Deposito <= 0) {
            throw new IllegalArgumentException("El depósito debe ser mayor a 0.");
        }
        Cuenta cuenta=getCuenta(CDestino);
        System.out.println("Antes del deposito: "+cuenta.getSaldo()+" Titular: "+cuenta.gettitular()+" Nro. Cuenta: "+ cuenta.getIDcuenta());
        cuenta.aumentarSaldo(Deposito);
        System.out.println("Despues del deposito: "+cuenta.getSaldo()+" Titular: "+cuenta.gettitular()+" Nro. Cuenta: "+ cuenta.getIDcuenta());
        return true;
    }
    
    //TRANSFERENCIA DE UNA CUENTA A OTRA//
    
    //valida los datos dados por el cliente para la transferencia, verificando si cumple
    //con los requerimientos
    public boolean verifTRS(long Destino,Cuenta Remitente,double Monto,Cuenta Sesion){
        Cuenta destino=getCuenta(Destino);//busca la cuenta destino segun el numero de cuenta
        if(Remitente.gettitular().equalsIgnoreCase(Sesion.gettitular())){//verifica si la cuenta de la sesion es del mismo titular que el del remitente de la transferencia
            if(destino != null && Remitente!=null){//verifica si existe la cuenta y si la cuenta remitente no es un campo vacio
                if(!Sesion.equals(destino)){/* se verifica si la cuenta en la que se inicio sesion es distinta de la cuenta a la que se piensa transferir*/
                    if(Monto <= Remitente.getSaldo()){
                        return true;
                    }
                   return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }
    public void Transferir(long Destino,Cuenta Remitente,double Monto){
        Cuenta CDestino=getCuenta(Destino);
        CDestino.aumentarSaldo(Monto);
        Remitente.desminuirSaldo(Monto);
    }
    
}
