package dao;

import java.sql.Date;
import java.util.List;
import modelo.Servicio;


public interface InterfaceServicioDAO {
    String SELECT_FILTRO_SERVICIOS="SELECT id_servicio,nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado,personas_maximas,fecha FROM servicio";
    String SELECT_NOMBRE_SERVICIOS="SELECT nombre_servicio FROM servicio group by nombre_servicio ";
    String INSERT_SERVICIO = "INSERT INTO servicio(nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado,personas_maximas,fecha) VALUES(?,?,?,?,?,?,?,?)";
//    String UPDATE_PRODUCTO = "UPDATE producto SET nombre_producto=?,id_marca=?,id_categoria=?,cantidad=?,precio=?,descripcion=?,imagen=? WHERE id_producto=?";
//    String DELETE_PRODUCTO = "DELETE FROM producto WHERE id_producto=?";
    
    List<Servicio> filtrarServicios(Date fecha, String nombreServicio);
    int insertarServicios(Servicio servicio);
    List<String> nombreServicios();
}
