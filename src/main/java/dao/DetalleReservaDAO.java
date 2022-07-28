/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.DetalleReserva;

/**
 *
 * @author JEAN
 */
public class DetalleReservaDAO implements IDetalleReservaDAO{

    @Override
    public int insertarDetalleReserva(DetalleReserva detalleReserva) {
        Connection conn=null;
         PreparedStatement stmt=null;
         int rows = 0;
         try{
             conn = Conexion.getConexion();
             stmt = conn.prepareStatement(IDetalleReservaDAO.INSERT_DETALLE_RESERVA);
             stmt.setInt(1,detalleReserva.getIdReserva());
             stmt.setInt(2,detalleReserva.getIdHabitacion());
             stmt.setString(3,detalleReserva.getDniHuesped());
             stmt.setString(4,detalleReserva.getNombreHuesped());
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
