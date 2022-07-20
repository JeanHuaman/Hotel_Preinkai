package dao;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Habitacion;

public interface IHabitacionDAO {

    public List<Habitacion> listar();

    public Habitacion listarId(int id) throws SQLException;

    public List<Habitacion> listarPorRecomendacion(int adultos, int ninos) throws SQLException;

    public int insertar(Habitacion habitacion);

    public int actualizar(Habitacion habitacion);
    
    public int eliminar(Habitacion habitacion);

    }
