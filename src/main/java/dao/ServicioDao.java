/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Servicio;

/**
 *
 * @author JEAN
 */
public class ServicioDAO implements InterfaceServicioDAO{

    @Override
    public List<Servicio> filtrarServicios(Date fecha, String nombreServicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertarServicios(Servicio servicio) {
        Connection conn=null;
         PreparedStatement stmt=null;
         Date fechaSql = new java.sql.Date(servicio.getFecha().getTime());
         int rows = 0;
         try{
             conn = Conexion.getConexion();
             stmt = conn.prepareStatement(InterfaceServicioDAO.INSERT_SERVICIO);
             stmt.setString(1,servicio.getNombreServicio());
             stmt.setDouble(2,servicio.getPrecio());
             stmt.setString(3,servicio.getHorariInicio());
             stmt.setString(4,servicio.getHorarioFinal());
             stmt.setString(5,servicio.getAmbiente());
             stmt.setString(6,servicio.getEstado());
             stmt.setInt(7,servicio.getPersonasMaximas());
             stmt.setDate(8,fechaSql);
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
    public List<String> nombreServicios() {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        String nombreServicio;
        List<String> nombreServiciosDisponibles = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(InterfaceServicioDAO.SELECT_NOMBRE_SERVICIOS);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                nombreServicio = rs.getString("nombre_servicio");
                nombreServiciosDisponibles.add(nombreServicio);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return nombreServiciosDisponibles;
    }
    
}
