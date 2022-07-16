package controlador;

import dao.HabitacionDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Habitacion;

@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = {"/HabitacionControlador"})
public class HabitacionControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HabitacionControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("RoomDetails")) {
            String id = request.getParameter("id");
            //System.out.println("Editar id: " + id);
            HabitacionDAO hdao = new HabitacionDAO();
            Habitacion h = new Habitacion();
            try {
                h = hdao.listarId(Integer.parseInt(id));
                //System.out.println(h);
                request.setAttribute("habitacion", h);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/verdetalle.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String accion = request.getParameter("accion");
        if (accion.equals("RoomsRecommendation")) {
            int cantAdultos = Integer.parseInt(request.getParameter("cantAdultos"));
            int cantNinos = Integer.parseInt(request.getParameter("cantNinos"));
            System.out.println("Adultos: " + cantAdultos);
            System.out.println("Niños: " + cantNinos);
            HabitacionDAO hdao = new HabitacionDAO();
            List<Habitacion> lista = new ArrayList<>();

            try {
                lista = hdao.listarPorRecomendacion(cantAdultos, cantNinos);
                for (Habitacion habitacion : lista) {
                    System.out.println(habitacion);
                }
                System.out.println(lista);
                request.setAttribute("habitaciones_recomendadas", lista);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/verrecomendacion.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
