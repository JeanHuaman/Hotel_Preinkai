/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author JEAN
 */
public interface IHabitacionDAO {
    String CANTIDAD_HABITACION = "select count(id_habitacion) from habitacion";
    
    int cantidadHabitaciones();
}
