package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.TipoHabitacion;

public class TipoHabitacionDAO implements dao.ITipoHabitacionDAO{

    private static final String SELECT_TIPO_HABITACION_BY_ID = "SELECT nombre FROM tipo_habitacion WHERE id_tipohabitacion=?";
    private static final String SELECT_TIPO_HABITACION = "SELECT id_tipohabitacion, nombre FROM tipo_habitacion";

    @Override
    public String getTipoHabitacion(int idTipoHabitacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        String nombreH = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_TIPO_HABITACION_BY_ID);
            stmt.setInt(1, idTipoHabitacion);
            rs = stmt.executeQuery();
            rs.next();
            nombreH = rs.getString("nombre");

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return nombreH;
    }

    @Override
    public List<TipoHabitacion> getListaTipoHabitacion() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoHabitacion tipohabitaciones = null;
        List<TipoHabitacion> TipoHabitaciones = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_TIPO_HABITACION);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreH = rs.getString("nombre");
                int idTipoHabitacion = rs.getInt("id_tipohabitacion");

                tipohabitaciones = new TipoHabitacion(idTipoHabitacion, nombreH);
                TipoHabitaciones.add(tipohabitaciones);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return TipoHabitaciones;
    }

}
