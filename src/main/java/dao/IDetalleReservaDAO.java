/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.DetalleReserva;

/**
 *
 * @author JEAN
 */
public interface IDetalleReservaDAO {
    String INSERT_DETALLE_RESERVA = "INSERT INTO detalle_reservacion(id_reserva,id_habitacion,dni_huesped,nombre_huesped) VALUES(?,?,?,?)";
    int insertarDetalleReserva(DetalleReserva detalleReserva);
}
