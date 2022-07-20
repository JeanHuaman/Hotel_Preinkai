package modelo;

public interface IUsuario {
    public int registrarse(Usuario usuario);
    public Usuario iniciarSesion(String correo);
}
