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
public interface IMembresiaDAO {
    String CANTIDAD_MEMBRESIA = "select count(id_membresia) from membresia";
    
    int cantidadMembresia();
}
