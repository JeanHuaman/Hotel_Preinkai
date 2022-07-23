
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Piso;


public class PisoDAO implements IPisoDAO{
    
    private static final String SELECT_PISO_BY_ID = "SELECT numero_habitaciones FROM piso WHERE id_piso=?";
    private static final String SELECT_PISO = "SELECT id_piso, numero_habitaciones FROM piso";
    
    @Override
    public int getNumeroPiso(int idPiso){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        int numeroHabitaciones=0;
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_PISO_BY_ID);
            stmt.setInt(1, idPiso);
            rs = stmt.executeQuery();
            rs.next();
            numeroHabitaciones = rs.getInt("numero_habitaciones");
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return numeroHabitaciones;
    }
    
        
      public List<Piso> getListaPiso(){
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Piso piso=null;
        List<Piso> pisos=new ArrayList();
        try {
            conn = Conexion.getConexion();
            stmt = conn.prepareStatement(SELECT_PISO);
            rs = stmt.executeQuery();
            while(rs.next())
            {
                int numeroHabitaciones = rs.getInt("numero_habitaciones");
                int idPiso= rs.getInt("id_piso");
                
                piso = new Piso(idPiso,numeroHabitaciones);
                pisos.add(piso);
            }
                                    
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return pisos;
    }   
}
