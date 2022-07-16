package modelo;

import java.sql.SQLException;
import java.util.List;

public interface IHabitacionFavorita {
    public List<HabitacionFavorita> listar();
    public boolean guardar(HabitacionFavorita habitacionFavorita) throws SQLException;

}
