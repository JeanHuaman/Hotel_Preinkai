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

import javax.servlet.http.HttpSession;

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
             stmt.setString(8,reserva.getTipoReserva());
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

    @Override
    public int cantidadReservas() {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int cantidadReservas=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IReservaDAO.CANTIDAD_RESERVAS);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                cantidadReservas = rs.getInt(1);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cantidadReservas;
    }

    @Override
    public double totalVentas() {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        double totalVentas=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IReservaDAO.TOTAL_VENTAS);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                totalVentas = rs.getDouble(1);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return totalVentas;
    }

    @Override
    public List<Reserva> listarReservas(int idUsuario) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Reserva> reservas = new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(IReservaDAO.SELECT_RESERVA);
            stmt.setInt(1,idUsuario);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                int idReserva = rs.getInt("id_reserva");
                double importe = rs.getDouble("importe_total");
                String tipoPago = rs.getString("tipo_pago");
                String tipoTarjeta = rs.getString("tipo_tarjeta");
                String fechaEntrada = rs.getString("fecha_entrada");
                String fechaSalida = rs.getString("fecha_salida");
                int personas = rs.getInt("cantidad_personas");
                String tipo = rs.getString("tipo");
                Reserva reserva = new Reserva(idReserva,idUsuario,importe,tipoPago,tipoTarjeta,fechaEntrada,fechaSalida,personas,tipo);
                reservas.add(reserva);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return reservas;
    }

}
