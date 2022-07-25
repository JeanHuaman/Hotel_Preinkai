package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import dao.Conexion;
import modelo.Habitacion;

public class HabitacionDAO implements IHabitacionDAO {

    private static final String SELECT_HABITACION = "SELECT id_habitacion,nombre,id_piso,precio,"
            + "imagen,descripcion,personas_maximas, disponibilidad,estrellas FROM habitacion h "
            + "INNER JOIN tipo_habitacion th on th.id_tipohabitacion=h.id_tipohabitacion order by id_habitacion";
    private static final String SELECT_HABITACION_POR_ID = "SELECT id_habitacion,nombre,id_piso,precio,"
            + "imagen,descripcion,personas_maximas, disponibilidad,estrellas FROM habitacion h "
            + "INNER JOIN tipo_habitacion th on th.id_tipohabitacion=h.id_tipohabitacion "
            + "WHERE id_habitacion =?";
    private static final String EDIT_HABITACION_POR_ID = "SELECT id_habitacion,th.id_tipohabitacion,id_piso,precio,"
            + "imagen,descripcion,personas_maximas, disponibilidad,estrellas FROM habitacion h "
            + "INNER JOIN tipo_habitacion th on th.id_tipohabitacion=h.id_tipohabitacion "
            + "WHERE id_habitacion =";
    private static final String SELECT_HABITACION_POR_RECOMENDACION = "SELECT id_habitacion,nombre,id_piso,precio,"
            + "imagen,descripcion,personas_maximas, disponibilidad,estrellas FROM habitacion h "
            + "INNER JOIN tipo_habitacion th on th.id_tipohabitacion=h.id_tipohabitacion "
            + "WHERE personas_maximas=";
    private static final String INSERT_HABITACION = "INSERT INTO habitacion(id_tipohabitacion, id_piso, precio, imagen, descripcion, personas_maximas, disponibilidad, estrellas) VALUES (?,?,?,?,?,?,?,?)";
    private static final String UPDATE_HABITACION = "UPDATE habitacion SET id_tipohabitacion=?,id_piso=?,precio=?,descripcion=?,personas_maximas=?,disponibilidad=?, estrellas=? WHERE id_habitacion=?";
    private static final String DELETE_HABITACION = "DELETE FROM habitacion WHERE id_habitacion=?";
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
                String tipohabitacion = rs.getString("nombre");
                int id_piso = rs.getInt("id_piso");
                double precio = rs.getDouble("precio");
                String imagen = rs.getString("imagen");
                String descripcion = rs.getString("descripcion");
                int personas_maximas = rs.getInt("personas_maximas");
                String disponibilidad = rs.getString("disponibilidad");
                int estrellas = rs.getInt("estrellas");

                habitacion = new Habitacion(id_habitacion, tipohabitacion,
                        id_piso, precio, imagen, descripcion, personas_maximas, 
                        disponibilidad, estrellas);
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

    @Override
    public List<Habitacion> listarPorRecomendacion(int adultos, int ninos) throws SQLException {
        List<Habitacion> listarHabitacionesRecomendadas = new ArrayList<>();

        String sql = null;
        estadoOperacion = false;
        conn = Conexion.getConexion();
        int personas_maximas = adultos + ninos;
        try {
            sql = SELECT_HABITACION_POR_RECOMENDACION + personas_maximas;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            //stmt.setInt(1, personas_maximas);
            while (rs.next()) {
                Habitacion h = new Habitacion();
                h.setId_habitacion(rs.getInt(1));
                h.setTipohabitacion(rs.getString(2));
                h.setId_piso(rs.getInt(3));
                h.setPrecio(rs.getDouble(4));
                h.setImagen(rs.getString(5));
                h.setDescripcion(rs.getString(6));
                h.setPersonas_maximas(rs.getInt(7));
                h.setDisponibilidad(rs.getString(8));
                h.setEstrellas(rs.getInt(9));
                listarHabitacionesRecomendadas.add(h);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("" + e);
        }

        return listarHabitacionesRecomendadas;
    }

    @Override
    public int insertar(Habitacion habitacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(INSERT_HABITACION);
            stmt.setInt(1, habitacion.getId_tipohabitacion());
            stmt.setInt(2, habitacion.getId_piso());
            stmt.setDouble(3, habitacion.getPrecio());
            stmt.setString(4, habitacion.getImagen());
            stmt.setString(5, habitacion.getDescripcion());
            stmt.setInt(6, habitacion.getPersonas_maximas());
            stmt.setString(7, habitacion.getDisponibilidad());
            stmt.setInt(8, habitacion.getEstrellas());
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
    public int actualizar(Habitacion habitacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(UPDATE_HABITACION);
            stmt.setInt(1, habitacion.getId_tipohabitacion());
            stmt.setInt(2, habitacion.getId_piso());
            stmt.setDouble(3, habitacion.getPrecio());
            stmt.setString(4, habitacion.getDescripcion());
            stmt.setInt(5, habitacion.getPersonas_maximas());
            stmt.setString(6, habitacion.getDisponibilidad());
            stmt.setInt(7, habitacion.getEstrellas());
            stmt.setInt(8,habitacion.getId_habitacion());
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
    public int eliminar(Habitacion habitacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(DELETE_HABITACION);
            stmt.setInt(1, habitacion.getId_habitacion());
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
    public Habitacion obtenerHabitacion(int id) throws SQLException {
        Habitacion h = new Habitacion();

        String sql = null;
        estadoOperacion = false;
        conn = Conexion.getConexion();

        try {
            sql = EDIT_HABITACION_POR_ID + id;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                h.setId_habitacion(rs.getInt(1));
                h.setId_tipohabitacion(rs.getInt(2));
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
    
    @Override
    public int cantidadHabitaciones() {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int cantidadHabitaciones=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IHabitacionDAO.CANTIDAD_HABITACION);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                cantidadHabitaciones = rs.getInt(1);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cantidadHabitaciones;
    }

}
