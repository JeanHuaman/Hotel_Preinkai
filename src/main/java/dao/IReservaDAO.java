/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Reserva;

/**
 *
 * @author JEAN
 */
public interface IReservaDAO {
    String INSERT_RESERVA = "INSERT INTO reserva(id_usuario,importe_total,tipo_pago,tipo_tarjeta,fecha_entrada,fecha_salida,cantidad_personas) VALUES(?,?,?,?,?,?,?)";
    String SELECT_ID_RESERVA = "SELECT max(id_reserva) FROM reserva";
int insertarReserva(Reserva reserva);
int obtenerIdReserva();
}
