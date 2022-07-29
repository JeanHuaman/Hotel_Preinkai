package dao;

import java.sql.SQLException;
import java.util.List;
import modelo.HabitacionFavorita;

public interface IHabitacionFavoritaDAO {
    public List<HabitacionFavorita> listar(int idUsuario);
    public int guardar(HabitacionFavorita habitacionFavorita);

}
