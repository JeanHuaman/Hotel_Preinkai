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

    private static final String SELECT_HABITACION_FAVORITA = "SELECT imagen, descripcion, precio FROM habitaciones_favoritas hf INNER JOIN habitacion h on h.id_habitacion=hf.id_habitacion";
    private static final String INSERT_HABITACION_FAVORITA = "INSERT INTO habitaciones_favoritas "
            + "(id_usuario, id_habitacion) VALUES (?,?)";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    HabitacionFavorita habitacionFavorita;
    private boolean estadoOperacion;

    @Override
    public boolean guardar(HabitacionFavorita habitacionFavorita) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        conn = Conexion.getConexion();

        try {
            conn.setAutoCommit(false);
            sql = INSERT_HABITACION_FAVORITA;
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, habitacionFavorita.getId_usuario());
            stmt.setInt(2, habitacionFavorita.getId_habitacion());

            estadoOperacion = stmt.executeUpdate() > 0;

            conn.commit();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        }

        return estadoOperacion;
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
        }
        return habitacionesFavoritas;
    }

}
