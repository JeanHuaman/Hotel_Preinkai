package dao;

import java.sql.SQLException;
import java.util.List;
import modelo.HabitacionFavorita;

public interface IHabitacionFavoritaDAO {
    public List<HabitacionFavorita> listar();
    public boolean guardar(HabitacionFavorita habitacionFavorita) throws SQLException;

}
