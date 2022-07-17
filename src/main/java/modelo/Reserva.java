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
public class Reserva {
    private int idReserva;
    private int idUsuario;
    private double importeTotal;
    private String tipoPago;
    private String tipoTarjeta;
    private String fechaEntrada;
    private String fechaSalida;
    private int CantidadPersonas;

    public Reserva(int idReserva, int idUsuario, double importeTotal, String tipoPago, String tipoTarjeta, String fechaEntrada, String fechaSalida, int CantidadPersonas) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.importeTotal = importeTotal;
        this.tipoPago = tipoPago;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.CantidadPersonas = CantidadPersonas;
    }

    public Reserva(int idUsuario, double importeTotal, String tipoPago, String tipoTarjeta, String fechaEntrada, String fechaSalida, int CantidadPersonas) {
        this.idUsuario = idUsuario;
        this.importeTotal = importeTotal;
        this.tipoPago = tipoPago;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.CantidadPersonas = CantidadPersonas;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCantidadPersonas() {
        return CantidadPersonas;
    }

    public void setCantidadPersonas(int CantidadPersonas) {
        this.CantidadPersonas = CantidadPersonas;
    }
    
    
}
