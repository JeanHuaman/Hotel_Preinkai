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
public class HabitacionDAO implements IHabitacionDAO {

    @Override
    public int cantidadHabitaciones() {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int cantidadHabitaciones=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IHabitacionDAO.CANTIDAD_HABITACION);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                cantidadHabitaciones = rs.getInt(1);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cantidadHabitaciones;
    }
    
}
