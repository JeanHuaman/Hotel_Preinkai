package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.CRUD;
import modelo.Conexion;
import modelo.Habitacion;

public class HabitacionDAO implements CRUD {

    private static final String SELECT_HABITACION = "SELECT id_habitacion,id_tipohabitacion,id_piso,"
            + "precio,imagen,descripcion,personas_maximas,disponibilidad,estrellas "
            + "FROM habitacion";
    private static final String SELECT_HABITACION_POR_ID = "SELECT id_habitacion,nombre,id_piso,precio,"
            + "imagen,descripcion,personas_maximas, disponibilidad,estrellas FROM habitacion h "
            + "INNER JOIN tipo_habitacion th on th.id_tipohabitacion=h.id_tipohabitacion "
            + "WHERE id_habitacion =?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Habitacion habitacion;
    private boolean estadoOperacion;

    @Override
    public List<Habitacion> listar() {
        List<Habitacion> habitaciones = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_HABITACION);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_habitacion = rs.getInt("id_habitacion");
                int id_tipohabitacion = rs.getInt("id_tipohabitacion");
                int id_piso = rs.getInt("id_piso");
                double precio = rs.getDouble("precio");
                String imagen = rs.getString("imagen");
                String descripcion = rs.getString("descripcion");
                int personas_maximas = rs.getInt("personas_maximas");
                String disponibilidad = rs.getString("disponibilidad");
                int estrellas = rs.getInt("estrellas");

                habitacion = new Habitacion(id_habitacion, id_tipohabitacion, id_piso, precio,
                        imagen, descripcion, personas_maximas, disponibilidad, estrellas);
                habitaciones.add(habitacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, ex);
        }
        return habitaciones;
    }

    //Listar la información de la habitación por id
    @Override
    public Habitacion listarId(int id) throws SQLException {

        Habitacion h = new Habitacion();

        String sql = null;
        estadoOperacion = false;
        conn = Conexion.getConexion();

        try {
            sql = SELECT_HABITACION_POR_ID;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                h.setId_habitacion(rs.getInt(1));
                h.setTipohabitacion(rs.getString(2));
                h.setId_piso(rs.getInt(3));
                h.setPrecio(rs.getDouble(4));
                h.setImagen(rs.getString(5));
                h.setDescripcion(rs.getString(6));
                h.setPersonas_maximas(rs.getInt(7));
                h.setDisponibilidad(rs.getString(8));
                h.setEstrellas(rs.getInt(9));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return h;
    }

}
