package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

    private static final String REGISTRAR_USUARIO = "INSERT INTO usuario(id_membresia,dni,nombre,celular,direccion,email,password,rol) "
            + "VALUES(?,?,?,?,?,?,?,?)";
    private static final String SESION_USUARIO = "SELECT id_membresia,dni,nombre,celular,"
            + "direccion,email,password,rol FROM usuario WHERE email=? limit 1";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public int registrarse(Usuario usuario) {

        int isRegistrado = 0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(REGISTRAR_USUARIO);
            stmt.setInt(1, usuario.getIdMembresia());
            stmt.setString(2, usuario.getDni());
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getCelular());
            stmt.setString(5, usuario.getDireccion());
            stmt.setString(6, usuario.getEmail());
            stmt.setString(7, usuario.getPassword());
            stmt.setString(8, usuario.getRol());
            isRegistrado = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return isRegistrado;
    }

    @Override
    public Usuario iniciarSesion(String correo) {
        Usuario usuario = null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SESION_USUARIO);
            stmt.setString(1, correo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int membresia = Integer.parseInt(rs.getString("id_membresia"));
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String celular = rs.getString("celular");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String rol = rs.getString("rol");

                usuario = new Usuario(membresia, dni, nombre, celular, direccion, email, password, rol);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    }

}
