/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author JEAN
 */
public class Servicio {
    private int id_servicio;
    private String nombreServicio;
    private double precio;
    private String horariInicio;
    private String horarioFinal;
    private String ambiente;
    private String estado;
    private int personasMaximas;
    private Date fecha;

    public Servicio(int id_servicio, String nombreServicio, double precio, String horariInicio, String horarioFinal, String ambiente, String estado, int personasMaximas, Date fecha) {
        this.id_servicio = id_servicio;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.horariInicio = horariInicio;
        this.horarioFinal = horarioFinal;
        this.ambiente = ambiente;
        this.estado = estado;
        this.personasMaximas = personasMaximas;
        this.fecha = fecha;
    }

    public Servicio(String nombreServicio, double precio, String horariInicio, String horarioFinal, String ambiente, String estado, int personasMaximas, Date fecha) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.horariInicio = horariInicio;
        this.horarioFinal = horarioFinal;
        this.ambiente = ambiente;
        this.estado = estado;
        this.personasMaximas = personasMaximas;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    
}
