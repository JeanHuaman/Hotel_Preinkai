package modelo;

import java.util.Date;

public class Servicio {

    private int id_servicio;
    private String nombreServicio;
    private double precio;
    private String horariInicio;
    private String horarioFinal;
    private String ambiente;
    private String estado;
    private int personasMaximas;

    public Servicio() {
    }

    public Servicio(int id_servicio, String nombreServicio, double precio, String horariInicio, String horarioFinal, String ambiente, String estado, int personasMaximas) {
        this.id_servicio = id_servicio;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.horariInicio = horariInicio;
        this.horarioFinal = horarioFinal;
        this.ambiente = ambiente;
        this.estado = estado;
        this.personasMaximas = personasMaximas;
    }

    public Servicio(String nombreServicio, double precio, String horariInicio, String horarioFinal, String ambiente, String estado, int personasMaximas, int id_servicio) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.horariInicio = horariInicio;
        this.horarioFinal = horarioFinal;
        this.ambiente = ambiente;
        this.estado = estado;
        this.personasMaximas = personasMaximas;
        this.id_servicio = id_servicio;
    }

    public Servicio(String nombreServicio, double precio, String horariInicio, String horarioFinal, String ambiente, String estado, int personasMaximas) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.horariInicio = horariInicio;
        this.horarioFinal = horarioFinal;
        this.ambiente = ambiente;
        this.estado = estado;
        this.personasMaximas = personasMaximas;
    }

    public Servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getHorariInicio() {
        return horariInicio;
    }

    public void setHorariInicio(String horariInicio) {
        this.horariInicio = horariInicio;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPersonasMaximas() {
        return personasMaximas;
    }

    public void setPersonasMaximas(int personasMaximas) {
        this.personasMaximas = personasMaximas;
    }

    @Override
    public String toString() {
        return "Servicio{" + "id_servicio=" + id_servicio + ", nombreServicio=" + nombreServicio + ", precio=" + precio + ", horariInicio=" + horariInicio + ", horarioFinal=" + horarioFinal + ", ambiente=" + ambiente + ", estado=" + estado + ", personasMaximas=" + personasMaximas + '}';
    }

}
