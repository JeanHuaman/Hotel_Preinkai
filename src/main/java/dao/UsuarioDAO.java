/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JEAN
 */
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public int cantidadUsuario() {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int cantidadUsuarios=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IUsuarioDAO.CANTIDAD_USUARIO);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                cantidadUsuarios = rs.getInt(1);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cantidadUsuarios;
    }
    
}
