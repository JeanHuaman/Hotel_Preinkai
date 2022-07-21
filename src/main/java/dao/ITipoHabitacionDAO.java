
package dao;

import java.util.List;
import modelo.TipoHabitacion;


public interface ITipoHabitacionDAO {
    public String getTipoHabitacion(int idTipoHabitacion);
     public List<TipoHabitacion> getListaTipoHabitacion();
}
