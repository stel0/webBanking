/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sotelo
 */
public class Cliente {
    
    private List<Cuenta> cuentas;
    
    public Cliente(){
        this.cuentas = new ArrayList<>();
    }
    
    public void addCuenta(Cuenta cuenta){
        cuentas.add(cuenta);
    }
}
