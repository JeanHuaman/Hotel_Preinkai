package dao;

import modelo.Usuario;

public interface IUsuarioDAO {
    public int registrarse(Usuario usuario);
    public Usuario iniciarSesion(String correo);
    
    String CANTIDAD_USUARIO = "SELECT count(id_usuario) FROM preinkai.usuario where rol='usuario'";
    
    int cantidadUsuario();
}
