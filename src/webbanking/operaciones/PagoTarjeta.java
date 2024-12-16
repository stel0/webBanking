package webbanking.operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import variablesGlobales.MensajesError;
import variablesGlobales.MensajesExito;
import webbanking.db.ConexionBD;
import webbanking.operacion.Operacion;
import webbanking.operaciones.interfaces.PagoTarjetaInterface;

/**
 *
 * @author sotelo
 */
public class PagoTarjeta extends Operacion implements PagoTarjetaInterface {
    private String fechaVencimiento;
    private Integer limiteCredito;
    private Integer saldoDisponible;
    private String estado;
    private Integer deuda;
    private Integer idTarjeta;

    @Override
    public Boolean pagoTarjeta(int monto) {
        this.saldoDisponible += monto;
        
        // Crear un hilo para actualizar la deuda
        Thread actualizarDeudaThread = new Thread(new ActualizarDeudaRunnable());
        actualizarDeudaThread.start();
        
        try {
            actualizarDeudaThread.join(); // Esperar a que termine el hilo (opcional)
        } catch (InterruptedException e) {
            System.err.println("Error al esperar la actualización de la deuda: " + e.getMessage());
        }
        
        return true;
    }

    @Override
    public Boolean validarPinCuenta() {
        return true;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(Integer limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public Integer getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(Integer saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getDeuda() {
        return deuda;
    }

    public void setDeuda(Integer deuda) {
        this.deuda = deuda;
    }

    public Integer getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(Integer idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public boolean actualizarDeuda() {
        String sql = "UPDATE Tarjeta SET saldo_disponible = ? WHERE id_tarjeta = ?";
        try (Connection conexion = ConexionBD.conectar(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            // Configurar los parámetros de la consulta
            stmt.setInt(1, saldoDisponible);
            stmt.setInt(2, idTarjeta);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println(MensajesExito.EXITO_ACTUALIZACION);
                return true;
            } else {
                System.out.println(MensajesError.ERROR_CUENTA_NO_ENCONTRADA);
                return false;
            }
        } catch (SQLException e) {
            System.err.println(MensajesError.ERROR_AL_ACTUALIZAR + e.getMessage());
            return false;
        }
    }

    // Clase interna para manejar la actualización en un hilo
    private class ActualizarDeudaRunnable implements Runnable {
        @Override
        public void run() {
            boolean exito = actualizarDeuda();
            if (!exito) {
                System.err.println("Error al actualizar la deuda en el hilo.");
            }
        }
    }
}
