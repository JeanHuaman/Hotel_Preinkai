/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.DetalleServicio;

/**
 *
 * @author JEAN
 */
public class DetalleServicioDAO implements IDetalleServicioDAO{

    @Override
    public int insertarDetalleServicio(DetalleServicio detalleServicio) {
        Connection conn=null;
         PreparedStatement stmt=null;
         int rows = 0;
         try{
             conn = Conexion.getConexion();
             stmt = conn.prepareStatement(IDetalleServicioDAO.INSERT_DETALLESERVICIO);
             stmt.setInt(1,detalleServicio.getIdReserva());
             stmt.setInt(2,detalleServicio.getIdServicio());
             stmt.setString(3,detalleServicio.getDniHuesped());
             stmt.setString(4,detalleServicio.getNombreHuesped());
             rows = stmt.executeUpdate();
         }catch(SQLException ex){
             ex.printStackTrace(System.out);
         }finally{
            
            Conexion.close(stmt);
            Conexion.close(conn);
        }
       return rows;
    }
    
}
