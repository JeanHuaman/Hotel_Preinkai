package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.HabitacionFavorita;

public class HabitacionFavoritaDAO implements IHabitacionFavoritaDAO {

    private static final String SELECT_HABITACION_FAVORITA = "SELECT imagen, descripcion, precio "
            + "FROM habitaciones_favoritas hf "
            + "INNER JOIN habitacion h on h.id_habitacion=hf.id_habitacion "
            + "WHERE hf.id_usuario=10";
    private static final String INSERT_HABITACION_FAVORITA = "INSERT INTO habitaciones_favoritas "
            + "(id_usuario, id_habitacion) VALUES (?,?)";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    HabitacionFavorita habitacionFavorita;
    private boolean estadoOperacion;

    @Override
    public int guardar(HabitacionFavorita habitacionFavorita){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(INSERT_HABITACION_FAVORITA);
            stmt.setInt(1, habitacionFavorita.getId_usuario());
            stmt.setInt(2, habitacionFavorita.getId_habitacion());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public List<HabitacionFavorita> listar() {
        List<HabitacionFavorita> habitacionesFavoritas = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_HABITACION_FAVORITA);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String imagen = rs.getString("imagen");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");

                habitacionFavorita = new HabitacionFavorita(imagen, descripcion, precio);
                habitacionesFavoritas.add(habitacionFavorita);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return habitacionesFavoritas;
    }

}
