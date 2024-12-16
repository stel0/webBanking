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

public class Actualizar {
    public static void actualizarSaldo(int idCuenta, int nuevoSaldo) {
        String query = "UPDATE Cuenta SET saldo = ? WHERE id_cuenta = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, nuevoSaldo);
            stmt.setInt(2, idCuenta);

            //int filasActualizadas = stmt.executeUpdate();
            //System.out.println("Saldo actualizado con éxito. Filas afectadas: " + filasActualizadas);
        } catch (SQLException e) {
            System.err.println("Error al actualizar saldo: " + e.getMessage());
        }
    }
    
    // Método para actualizar la deuda de una tarjeta
    public boolean actualizarDeudaTarjeta(int idTarjeta, double nuevaDeuda) {
        String sql = "UPDATE Tarjeta SET deuda = ? WHERE id_tarjeta = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setDouble(1, nuevaDeuda);
            stmt.setInt(2, idTarjeta);

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizó correctamente
        } catch (SQLException e) {
            System.err.println("Error al actualizar la deuda de la tarjeta: " + e.getMessage());
        }
        return false; // Retorna false en caso de error
    }
    
     // Método para actualizar el saldo disponible de una tarjeta
    public boolean actualizarSaldoDisponibleTarjeta(int idTarjeta, double nuevoSaldoDisponible) {
        String sql = "UPDATE Tarjeta SET limite_credito = deuda + ? WHERE id_tarjeta = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setDouble(1, nuevoSaldoDisponible);
            stmt.setInt(2, idTarjeta);

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se actualizó correctamente
        } catch (SQLException e) {
            System.err.println("Error al actualizar el saldo disponible de la tarjeta: " + e.getMessage());
        }
        return false; // Retorna false en caso de error
    }
}

