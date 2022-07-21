package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Habitacion;
import modelo.Servicio;

public class ServicioDAO implements IServicioDAO {

    private static final String SELECT_SERVICIO = "SELECT id_servicio,nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado,personas_maximas FROM servicio";
    private static final String SELECT_SERVICIO_POR_ID = "SELECT id_servicio,nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado,personas_maximas FROM servicio WHERE id_servicio=?";
    private static final String EDIT_SERVICIO_POR_ID = "SELECT id_servicio,nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado, personas_maximas FROM servicio WHERE id_servicio =";
    private static final String INSERT_SERVICIO = "INSERT INTO servicio(nombre_servicio, precio, horario_inicio, horario_fin, ambiente, estado, personas_maximas) VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE_SERVICIO = "UPDATE servicio SET nombre_servicio=?,precio=?,horario_inicio=?,horario_fin=?,ambiente=?, estado=?,personas_maximas=? WHERE id_servicio=?";
    private static final String DELETE_SERVICIO = "DELETE FROM servicio WHERE id_servicio=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Servicio servicio;
    private boolean estadoOperacion;

    @Override
    public List<Servicio> listar() {
        List<Servicio> servicios = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_SERVICIO);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_servicio = rs.getInt("id_servicio");
                String nombre_servicio = rs.getString("nombre_servicio");
                double precio = rs.getDouble("precio");
                String horario_inicio = rs.getString("horario_inicio");
                String horario_fin = rs.getString("horario_fin");
                String ambiente = rs.getString("ambiente");
                String estado = rs.getString("estado");
                int personas_maximas = rs.getInt("personas_maximas");

                servicio = new Servicio(id_servicio, nombre_servicio,
                        precio, horario_inicio, horario_fin, ambiente, estado,
                        personas_maximas);
                servicios.add(servicio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            JOptionPane.showMessageDialog(null, ex);
        }
        return servicios;
    }

    @Override
    public Servicio listarId(int id) throws SQLException {

        Servicio s = new Servicio();

        String sql = null;
        estadoOperacion = false;
        conn = Conexion.getConexion();

        try {
            sql = SELECT_SERVICIO_POR_ID;
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                s.setId_servicio(rs.getInt(1));
                s.setNombreServicio(rs.getString(2));
                s.setPrecio(rs.getDouble(4));
                s.setHorariInicio(rs.getString(5));
                s.setHorarioFinal(rs.getString(6));
                s.setAmbiente(rs.getString(7));
                s.setEstado(rs.getString(8));
                s.setPersonasMaximas(rs.getInt(9));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public int insertar(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(INSERT_SERVICIO);
            stmt.setString(1, servicio.getNombreServicio());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setString(3, servicio.getHorariInicio());
            stmt.setString(4, servicio.getHorarioFinal());
            stmt.setString(5, servicio.getAmbiente());
            stmt.setString(6, servicio.getEstado());
            stmt.setInt(7, servicio.getPersonasMaximas());
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
    public int actualizar(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(UPDATE_SERVICIO);

            stmt.setString(1, servicio.getNombreServicio());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setString(3, servicio.getHorariInicio());
            stmt.setString(4, servicio.getHorarioFinal());
            stmt.setString(5, servicio.getAmbiente());
            stmt.setString(6, servicio.getEstado());
            stmt.setInt(7, servicio.getPersonasMaximas());
            stmt.setInt(8, servicio.getId_servicio());
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
    public int eliminar(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(DELETE_SERVICIO);
            stmt.setInt(1, servicio.getId_servicio());
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
    public Servicio obtenerServicio(int id) throws SQLException {
        Servicio s = new Servicio();

        String sql = null;
        estadoOperacion = false;
        conn = Conexion.getConexion();

        try {
            sql = EDIT_SERVICIO_POR_ID + id;
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                s.setId_servicio(rs.getInt(1));
                s.setNombreServicio(rs.getString(2));
                s.setPrecio(rs.getDouble(3));
                s.setHorariInicio(rs.getString(4));
                s.setHorarioFinal(rs.getString(5));
                s.setAmbiente(rs.getString(6));
                s.setEstado(rs.getString(7));
                s.setPersonasMaximas(rs.getInt(8));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public List<Servicio> filtrarServicios(String nombreServicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio servicio = null;
        List<Servicio> servicios = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IServicioDAO.SELECT_FILTRO_SERVICIOS);
            stmt.setString(1, nombreServicio);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_servicio = rs.getInt("id_servicio");
                double precio = rs.getDouble("precio");
                String horarioInicio = rs.getString("horario_inicio");
                String horarioFinal = rs.getString("horario_fin");
                String ambiente = rs.getString("ambiente");
                String estado = rs.getString("estado");
                int personasMaximas = rs.getInt("personas_maximas");
                servicio = new Servicio(id_servicio, nombreServicio, precio, horarioInicio, horarioFinal, ambiente, estado, personasMaximas);
                servicios.add(servicio);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return servicios;
    }

    @Override
    public int insertarServicios(Servicio servicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IServicioDAO.INSERT_SERVICIO);
            stmt.setString(1, servicio.getNombreServicio());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setString(3, servicio.getHorariInicio());
            stmt.setString(4, servicio.getHorarioFinal());
            stmt.setString(5, servicio.getAmbiente());
            stmt.setString(6, servicio.getEstado());
            stmt.setInt(7, servicio.getPersonasMaximas());
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
    public List<String> nombreServicios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String nombreServicio;
        List<String> nombreServiciosDisponibles = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IServicioDAO.SELECT_NOMBRE_SERVICIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                nombreServicio = rs.getString("nombre_servicio");
                nombreServiciosDisponibles.add(nombreServicio);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return nombreServiciosDisponibles;
    }

    @Override
    public Servicio filtrarServicioId(int idServicio) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio servicio = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IServicioDAO.SELECT_FILTRA_SERVICIO_ID);
            stmt.setInt(1, idServicio);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreServicio = rs.getString("nombre_servicio");
                double precio = rs.getDouble("precio");
                String horarioInicio = rs.getString("horario_inicio");
                String horarioFinal = rs.getString("horario_fin");
                String ambiente = rs.getString("ambiente");
                String estado = rs.getString("estado");
                int personasMaximas = rs.getInt("personas_maximas");
                servicio = new Servicio(idServicio, nombreServicio, precio, horarioInicio, horarioFinal, ambiente, estado, personasMaximas);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return servicio;
    }

    @Override

    public int cantidadServicios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int cantidadServicios = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IServicioDAO.CANTIDAD_SERVICIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                cantidadServicios = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cantidadServicios;
    }

}
