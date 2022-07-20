/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JEAN
 */
public class DetalleServicio {
    private int idDetalleServicio;
    private int idReserva;
    private int idServicio;
    private String dniHuesped;
    private String nombreHuesped;

    public DetalleServicio(int idDetalleServicio, int idReserva, int idServicio, String dniHuesped, String nombreHuesped) {
        this.idDetalleServicio = idDetalleServicio;
        this.idReserva = idReserva;
        this.idServicio = idServicio;
        this.dniHuesped = dniHuesped;
        this.nombreHuesped = nombreHuesped;
    }

    public DetalleServicio(int idReserva, int idServicio, String dniHuesped, String nombreHuesped) {
        this.idReserva = idReserva;
        this.idServicio = idServicio;
        this.dniHuesped = dniHuesped;
        this.nombreHuesped = nombreHuesped;
    }

    public int getIdDetalleServicio() {
        return idDetalleServicio;
    }

    public void setIdDetalleServicio(int idDetalleServicio) {
        this.idDetalleServicio = idDetalleServicio;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDniHuesped() {
        return dniHuesped;
    }

    public void setDniHuesped(String dniHuesped) {
        this.dniHuesped = dniHuesped;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }
    
    
}
