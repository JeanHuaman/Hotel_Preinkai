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
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import modelo.Servicio;

/**
 *
 * @author JEAN
 */
public class ReservaDAO implements IReservaDAO{

    @Override
    public int insertarReserva(Reserva reserva) {
        Connection conn=null;
         PreparedStatement stmt=null;
         int rows = 0;
         try{
             conn = Conexion.getConexion();
             stmt = conn.prepareStatement(IReservaDAO.INSERT_RESERVA);
             stmt.setInt(1,reserva.getIdUsuario());
             stmt.setDouble(2,reserva.getImporteTotal());
             stmt.setString(3,reserva.getTipoPago());
             stmt.setString(4,reserva.getTipoTarjeta());
             stmt.setString(5,reserva.getFechaEntrada());
             stmt.setString(6,reserva.getFechaSalida());
             stmt.setInt(7,reserva.getCantidadPersonas());
             rows = stmt.executeUpdate();
         }catch(SQLException ex){
             ex.printStackTrace(System.out);
         }finally{
            
            Conexion.close(stmt);
            Conexion.close(conn);
        }
       return rows;
    }

    @Override
    public int obtenerIdReserva() {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int id=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IReservaDAO.SELECT_ID_RESERVA);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return id;
    }
    
}
