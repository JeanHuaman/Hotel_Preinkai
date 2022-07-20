package dao;

import modelo.Usuario;

public interface IUsuarioDAO {
    public int registrarse(Usuario usuario);
    public Usuario iniciarSesion(String correo);
}
