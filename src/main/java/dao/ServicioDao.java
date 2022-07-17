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
public class ServicioDAO implements IServicioDAO{

    @Override
    public List<Servicio> filtrarServicios(String nombreServicio) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Servicio servicio=null;
        List<Servicio> servicios=new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IServicioDAO.SELECT_FILTRO_SERVICIOS);
            stmt.setString(1, nombreServicio);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                int id_servicio = rs.getInt("id_servicio");
                double precio = rs.getDouble("precio");
                String horarioInicio = rs.getString("horario_inicio");
                String horarioFinal = rs.getString("horario_fin");
                String ambiente = rs.getString("ambiente");
                String estado = rs.getString("estado");
                int personasMaximas = rs.getInt("personas_maximas");
                servicio = new Servicio(id_servicio,nombreServicio,precio,horarioInicio,horarioFinal,ambiente,estado,personasMaximas);
                servicios.add(servicio);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return servicios;
    }

    @Override
    public int insertarServicios(Servicio servicio) {
        Connection conn=null;
         PreparedStatement stmt=null;
         int rows = 0;
         try{
             conn = Conexion.getConexion();
             stmt = conn.prepareStatement(IServicioDAO.INSERT_SERVICIO);
             stmt.setString(1,servicio.getNombreServicio());
             stmt.setDouble(2,servicio.getPrecio());
             stmt.setString(3,servicio.getHorariInicio());
             stmt.setString(4,servicio.getHorarioFinal());
             stmt.setString(5,servicio.getAmbiente());
             stmt.setString(6,servicio.getEstado());
             stmt.setInt(7,servicio.getPersonasMaximas());
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
            stmt = conn.prepareStatement(IServicioDAO.SELECT_NOMBRE_SERVICIOS);
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

    @Override
    public Servicio filtrarServicioId(int idServicio) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Servicio servicio=null;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IServicioDAO.SELECT_FILTRA_SERVICIO_ID);
            stmt.setInt(1, idServicio);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                String nombreServicio = rs.getString("nombre_servicio");
                double precio = rs.getDouble("precio");
                String horarioInicio = rs.getString("horario_inicio");
                String horarioFinal = rs.getString("horario_fin");
                String ambiente = rs.getString("ambiente");
                String estado = rs.getString("estado");
                int personasMaximas = rs.getInt("personas_maximas");
                servicio = new Servicio(idServicio,nombreServicio,precio,horarioInicio,horarioFinal,ambiente,estado,personasMaximas);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return servicio;
    }
    
}
