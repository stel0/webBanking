/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package webbanking.db;

/**
 *
 * @author HP
 */
import java.sql.*;
import webbanking.Cuenta;

public class Consultas {
    
    // Método para verificar el PIN de la cuenta
    static public boolean verificarPinCuenta(String correo, String pinIngresado)  {
        String sql = "SELECT COUNT(*) FROM Cliente c JOIN Cuenta cu ON c.id_cliente = cu.id_cliente WHERE c.email = ? AND cu.pin_cuenta = ?;";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setString(1, correo);
            stmt.setString(2, pinIngresado);

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                return true; // PIN correcto
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar el PIN de la cuenta: " + e.getMessage());
        }
        return false; // PIN incorrecto o cuenta no encontrada
    }

    // Método para verificar el PIN de transacción
    public boolean verificarPinTransaccion(int idCuenta, String pinIngresado) {
        String sql = "SELECT COUNT(*) FROM Cuenta WHERE id_cuenta = ? AND pin_transaccion = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setInt(1, idCuenta);
            stmt.setString(2, pinIngresado);

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                return true; // PIN correcto
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar el PIN de transacción: " + e.getMessage());
        }
        return false; // PIN incorrecto o cuenta no encontrada
    }
    
    // Método para obtener el saldo de una cuenta
    public double obtenerSaldoCuenta(int idCuenta) {
        String sql = "SELECT saldo FROM Cuenta WHERE id_cuenta = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setInt(1, idCuenta);

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return resultado.getDouble("saldo"); // Retorna el saldo de la cuenta
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el saldo de la cuenta: " + e.getMessage());
        }
        return -1; // Retorna -1 en caso de error o si no se encuentra la cuenta
    }
    
     // Método para obtener la deuda de una tarjeta
    public double obtenerDeudaTarjeta(int idTarjeta) {
        String sql = "SELECT deuda FROM Tarjeta WHERE id_tarjeta = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setInt(1, idTarjeta);

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return resultado.getDouble("deuda"); // Retorna la deuda de la tarjeta
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la deuda de la tarjeta: " + e.getMessage());
        }
        return -1; // Retorna -1 en caso de error o si no se encuentra la tarjeta
    }

    // Método para obtener el saldo disponible de una tarjeta
    public double obtenerSaldoDisponibleTarjeta(int idTarjeta) {
        String sql = "SELECT limite_credito - deuda AS saldo_disponible FROM Tarjeta WHERE id_tarjeta = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setInt(1, idTarjeta);

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return resultado.getDouble("saldo_disponible"); // Retorna el saldo disponible de la tarjeta
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el saldo disponible de la tarjeta: " + e.getMessage());
        }
        return -1; // Retorna -1 en caso de error o si no se encuentra la tarjeta
    }

    // Método para verificar si una cuenta pertenece a un cliente específico
    public boolean verificarCuentaDeCliente(int idCliente, int idCuenta) {
        String sql = "SELECT COUNT(*) FROM Cuenta WHERE id_cliente = ? AND id_cuenta = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idCuenta);

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next() && resultado.getInt(1) > 0) {
                return true; // La cuenta pertenece al cliente
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar la relación entre cliente y cuenta: " + e.getMessage());
        }
        return false; // La cuenta no pertenece al cliente o no se encontró
    }
    
    static public boolean verificarCuentaExiste(long idCuenta) {
    String sql = "SELECT COUNT(*) FROM Cuenta WHERE id_cuenta = ?";

    try (Connection conexion = ConexionBD.conectar();
         PreparedStatement stmt = conexion.prepareStatement(sql)) {

        // Configurar el parámetro de la consulta
        stmt.setInt(1, (int)idCuenta);

        // Ejecutar la consulta
        ResultSet resultado = stmt.executeQuery();
        if (resultado.next() && resultado.getInt(1) > 0) {
            return true; // La cuenta existe
        }
    } catch (SQLException e) {
        System.err.println("Error al verificar la existencia de la cuenta: " + e.getMessage());
    }
    return false; // La cuenta no existe o hubo un error
}
    
    static public Cuenta obtenerDatos(String correo,String pin_cuenta) {
        String sql = 
                "SELECT c.id_cliente, c.email,c.nombre, cu.id_cuenta, cu.saldo, cu.tipo_cuenta, cu.estado, cu.pin_transaccion\n" +
                "FROM Cliente c\n" +
                "JOIN Cuenta cu ON c.id_cliente = cu.id_cliente\n" +
                "WHERE c.email = ? AND cu.pin_cuenta = ?;";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setString(1, correo);
            stmt.setString(2, pin_cuenta);

            // Ejecutar la consulta
            ResultSet resultado = stmt.executeQuery();
            
            // Verificar si hay resultados
            if (resultado.next()) {
                // Crear un objeto Cuenta (o Cliente) con los datos obtenidos
                Cuenta cuenta = new Cuenta();
                cuenta.setCorreo(correo);
                cuenta.setTitular(resultado.getString("nombre"));
                cuenta.setTipoCuenta(resultado.getString("tipo_cuenta"));
                cuenta.setIDcuenta(resultado.getInt("id_cuenta"));
                cuenta.setSaldo(resultado.getDouble("saldo"));
                cuenta.setEstadoCuenta(resultado.getString("estado"));
                cuenta.setPinCuenta(Integer.parseInt(pin_cuenta));
                cuenta.setPinTransaccion(resultado.getInt("pin_transaccion"));
                
                return cuenta; // Retorna el objeto Cuenta con los datos
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos del cliente: " + e.getMessage());
        }
        return null; // Retorna null si no se encuentran datos o hay un error
    }

//      public static void main(String[] args) {
//        Consultas consultas = new Consultas();
//
//        // Verificar el PIN de la cuenta
//        if (consultas.verificarPinCuenta(1, "8765")) {
//            System.out.println("PIN de cuenta verificado correctamente.");
//        } else {
//            System.out.println("PIN de cuenta incorrecto o cuenta no encontrada.");
//        }
//
//        // Verificar el PIN de transacción
//        if (consultas.verificarPinTransaccion(1, "1234")) {
//            System.out.println("PIN de transacción verificado correctamente.");
//        } else {
//            System.out.println("PIN de transacción incorrecto o cuenta no encontrada.");
//        }
//
//        // Obtener el saldo de la cuenta
//        double saldo = consultas.obtenerSaldoCuenta(1);
//        if (saldo != -1) {
//            System.out.println("El saldo de la cuenta es: " + saldo);
//        } else {
//            System.out.println("No se pudo obtener el saldo de la cuenta o cuenta no encontrada.");
//        }
//    }
}   
