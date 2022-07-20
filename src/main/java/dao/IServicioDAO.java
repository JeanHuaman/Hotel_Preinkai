package dao;

import java.sql.Date;
import java.util.List;
import modelo.Servicio;


public interface IServicioDAO {
    String SELECT_FILTRO_SERVICIOS="SELECT id_servicio,nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado,personas_maximas FROM servicio where nombre_servicio=? ";
    String SELECT_NOMBRE_SERVICIOS="SELECT nombre_servicio FROM servicio group by nombre_servicio ";
    String INSERT_SERVICIO = "INSERT INTO servicio(nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado,personas_maximas) VALUES(?,?,?,?,?,?,?,?)";
    String SELECT_FILTRA_SERVICIO_ID = "SELECT nombre_servicio,precio,horario_inicio,horario_fin,ambiente,estado,personas_maximas FROM servicio where id_servicio=?";
    String CANTIDAD_SERVICIOS = "select count(id_servicio) from servicio";
    
    List<Servicio> filtrarServicios(String nombreServicio);
    int insertarServicios(Servicio servicio);
    List<String> nombreServicios();
    Servicio filtrarServicioId(int idServicio);
    int cantidadServicios();
}
