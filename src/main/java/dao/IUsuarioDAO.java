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
public interface IUsuarioDAO {
    
    String CANTIDAD_USUARIO = "SELECT count(id_usuario) FROM preinkai.usuario where rol='usuario'";
    
    int cantidadUsuario();
}
