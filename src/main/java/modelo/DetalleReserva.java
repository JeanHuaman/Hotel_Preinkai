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
public class DetalleReserva {
    private int idDetalle;
    private int idReserva;
    private int idHabitacion;
    private String dniHuesped;
    private String nombreHuesped;

    public DetalleReserva(int idDetalle, int idReserva, int idHabitacion, String dniHuesped, String nombreHuesped) {
        this.idDetalle = idDetalle;
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.dniHuesped = dniHuesped;
        this.nombreHuesped = nombreHuesped;
    }

    public DetalleReserva(int idReserva, int idHabitacion, String dniHuesped, String nombreHuesped) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.dniHuesped = dniHuesped;
        this.nombreHuesped = nombreHuesped;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
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
