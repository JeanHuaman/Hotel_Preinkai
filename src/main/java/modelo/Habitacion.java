package modelo;

public class Habitacion {

    private int id_habitacion;
    private int id_tipohabitacion;
    private String tipohabitacion;
    private int id_piso;
    private double precio;
    private String imagen;
    private String descripcion;
    private int personas_maximas;
    private String disponibilidad;
    private int estrellas;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, int id_tipohabitacion, int id_piso, double precio, String imagen, String descripcion, int personas_maximas, String disponibilidad, int estrellas) {
        this.id_habitacion = id_habitacion;
        this.id_tipohabitacion = id_tipohabitacion;
        this.id_piso = id_piso;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.personas_maximas = personas_maximas;
        this.disponibilidad = disponibilidad;
        this.estrellas = estrellas;
    }

    public Habitacion(int id_habitacion, int id_tipohabitacion, String tipohabitacion, int id_piso, double precio, String imagen, String descripcion, int personas_maximas, String disponibilidad, int estrellas) {
        this.id_habitacion = id_habitacion;
        this.id_tipohabitacion = id_tipohabitacion;
        this.tipohabitacion = tipohabitacion;
        this.id_piso = id_piso;
        this.precio = precio;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.personas_maximas = personas_maximas;
        this.disponibilidad = disponibilidad;
        this.estrellas = estrellas;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public int getId_tipohabitacion() {
        return id_tipohabitacion;
    }

    public void setId_tipohabitacion(int id_tipohabitacion) {
        this.id_tipohabitacion = id_tipohabitacion;
    }

    public String getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(String tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public int getId_piso() {
        return id_piso;
    }

    public void setId_piso(int id_piso) {
        this.id_piso = id_piso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public int getPersonas_maximas() {
        return personas_maximas;
    }

    public void setPersonas_maximas(int personas_maximas) {
        this.personas_maximas = personas_maximas;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "id_habitacion=" + id_habitacion + ", id_tipohabitacion=" + id_tipohabitacion + ", tipohabitacion=" + tipohabitacion + ", id_piso=" + id_piso + ", precio=" + precio + ", imagen=" + imagen + ", descripcion=" + descripcion + ", personas_maximas=" + personas_maximas + ", disponibilidad=" + disponibilidad + ", estrellas=" + estrellas + '}';
    }

}
