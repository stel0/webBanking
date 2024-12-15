/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webbanking.operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import webbanking.Cuenta;
import webbanking.db.ConexionBD;
import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.TransferenciaInterface;
import webbanking.db.Consultas;

/**
 *
 * @author sotelo
 */
public class Transferencia extends Operacion implements TransferenciaInterface {
    
    public Transferencia(long CD,double monto,Cuenta CS){
        this.cuenta = CS;
        this.idCuentaDestino=CD;
        this.monto=monto;
    }
    
    public Transferencia Transferir(){
        //Verificamos si la cuenta destino existe
        if(Consultas.verificarCuentaExiste(idCuentaDestino)){
            this.cuentaDestino = obtenerDatos(idCuentaDestino);
            realizarTransferencia();
        }else{
            this.mensaje = "No existe una cuenta con ese numero";
        }
        return this;
    }        
    @Override
    public Boolean transferencia() {
        return true;
    }

    @Override
    public Boolean validarPinTransaccion() {
        return true;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    
    public void realizarTransferencia(){
        if(cuenta.getSaldo() - monto > 0){
            // actualizamos cuenta destino
            cuentaDestino.aumentarSaldo(monto);
            actualizarSaldo((int)cuentaDestino.getIDcuenta(), cuentaDestino.getSaldo()); 
            // actualizamos cuenta origen
            cuenta.desminuirSaldo(monto); 
            actualizarSaldo((int)this.cuenta.getIDcuenta(),cuenta.getSaldo()); 
            return;
        }
        this.mensaje = "El monto es muy alto";
    }
    
    public Cuenta obtenerDatos(long idCuenta) {
        String sql = 
                "SELECT c.id_cliente, c.nombre,c.apellido, c.email, cu.id_cuenta, cu.saldo, cu.tipo_cuenta, cu.estado, cu.pin_transaccion\n" +
                "FROM Cliente c\n" +
                "JOIN Cuenta cu ON c.id_cliente = cu.id_cliente\n" +
                "WHERE cu.id_cuenta = ?;";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setString(1, Long.toString(idCuenta));


            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            
            // Verificar si hay resultados
            if (resultado.next()) {
                // Crear un objeto Cuenta (o Cliente) con los datos obtenidos
                Cuenta cuenta = new Cuenta();
                cuenta.setCorreo(resultado.getString("email"));
                cuenta.setTitular(resultado.getString("nombre") + " " + resultado.getString("apellido"));
                cuenta.setTipoCuenta(resultado.getString("tipo_cuenta"));
                cuenta.setIDcuenta(resultado.getInt("id_cuenta"));
                cuenta.setSaldo(resultado.getDouble("saldo"));
                
                return cuenta; // Retorna el objeto Cuenta con los datos
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos del cliente: " + e.getMessage());
        }
        return null; // Retorna null si no se encuentran datos o hay un error
    }
}
