/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Reserva;

/**
 *
 * @author JEAN
 */
public interface IReservaDAO {
    String INSERT_RESERVA = "INSERT INTO reserva(id_usuario,importe_total,tipo_pago,tipo_tarjeta,fecha_entrada,fecha_salida,cantidad_personas,tipo) VALUES(?,?,?,?,?,?,?,?)";
    String SELECT_ID_RESERVA = "SELECT max(id_reserva) FROM reserva";
    String CANTIDAD_RESERVAS = "SELECT count(id_reserva) FROM reserva";
    String TOTAL_VENTAS = "select sum(importe_total) from reserva";
    String SELECT_RESERVA = "SELECT id_reserva,id_usuario,importe_total,tipo_pago,tipo_tarjeta,fecha_entrada,fecha_salida,cantidad_personas,tipo FROM reserva WHERE id_usuario=?";
int insertarReserva(Reserva reserva);
int obtenerIdReserva();
int cantidadReservas();
double totalVentas();
List<Reserva> listarReservas(int idUsuario);
}
