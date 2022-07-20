package modelo;

public class Usuario {

    private int idUsuario;
    private int idMembresia;
    private String dni = "";
    private String nombre = "";
    private String celular = "";
    private String direccion = "";
    private String email = "";
    private String password = "";
    private String rol = "";

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(int idMembresia, String dni,String nombre,String celular,String direccion,
            String email,String password,String rol) {
        this.idMembresia=idMembresia;
        this.dni=dni;
        this.nombre=nombre;
        this.celular=celular;
        this.direccion=direccion;
        this.email=email;
        this.password=password;
        this.rol=rol;
        
    }

    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", idMembresia=" + idMembresia + ", dni=" + dni + ", nombre=" + nombre + ", celular=" + celular + ", direccion=" + direccion + ", email=" + email + ", password=" + password + ", rol=" + rol + '}';
    }

    
    
    
}
