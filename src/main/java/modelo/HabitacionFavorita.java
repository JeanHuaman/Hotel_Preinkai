
package modelo;


public class HabitacionFavorita {
    private int id_habitacion_favorita;
    private int id_usuario;
    private int id_habitacion;
    private String imagen;
    private String descripcion;
    private double precio;

    public HabitacionFavorita() {
    }

    public HabitacionFavorita(int id_habitacion_favorita, int id_usuario, int id_habitacion) {
        this.id_habitacion_favorita = id_habitacion_favorita;
        this.id_usuario = id_usuario;
        this.id_habitacion = id_habitacion;
    }

    public HabitacionFavorita(String imagen, String descripcion, double precio) {
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    
    
    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getId_habitacion_favorita() {
        return id_habitacion_favorita;
    }

    public void setId_habitacion_favorita(int id_habitacion_favorita) {
        this.id_habitacion_favorita = id_habitacion_favorita;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "HabitacionFavorita{" + "id_habitacion_favorita=" + id_habitacion_favorita + ", id_usuario=" + id_usuario + ", id_habitacion=" + id_habitacion + ", imagen=" + imagen + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }
    
    
}
