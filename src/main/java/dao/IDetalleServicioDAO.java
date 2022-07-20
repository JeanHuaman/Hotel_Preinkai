/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.DetalleServicio;

/**
 *
 * @author JEAN
 */
public interface IDetalleServicioDAO {
    String INSERT_DETALLESERVICIO = "INSERT INTO detalle_servicio(id_reserva,id_servicio,dni_huesped,nombre_huesped) VALUES(?,?,?,?)";

int insertarDetalleServicio(DetalleServicio detalleServicio);
}
