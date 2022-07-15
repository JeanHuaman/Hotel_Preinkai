package modelo;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface CRUD {

    public List<Habitacion> listar();

    public Habitacion listarId(int id) throws SQLException;

}
