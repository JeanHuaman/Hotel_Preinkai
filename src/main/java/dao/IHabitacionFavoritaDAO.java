package dao;

import java.sql.SQLException;
import java.util.List;
import modelo.HabitacionFavorita;

public interface IHabitacionFavoritaDAO {
    public List<HabitacionFavorita> listar();
    public int guardar(HabitacionFavorita habitacionFavorita);

}
