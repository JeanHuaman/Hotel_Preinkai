package controlador;

import dao.IServicioDAO;
import dao.ServicioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import modelo.Servicio;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "administra peticiones para la tabla servicio", urlPatterns = {"/ServicioControlador"})
public class ServicioControlador extends HttpServlet {

    ServicioDAO sdao = new ServicioDAO();
    Servicio s = new Servicio();

    private static final long serialVersionUID = 1L;

    public ServicioControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String id = request.getParameter("id");
        switch (accion) {
            case "ServiceDetails":
               
                //System.out.println("Editar id: " + id);

                try {
                s = sdao.listarId(Integer.parseInt(id));
                //System.out.println(s);
                request.setAttribute("servicio", s);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/verdetalle.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            case "EditService":
                try {
                s = sdao.obtenerServicio(Integer.parseInt(id));
                System.out.println(s);
                request.setAttribute("servicio", s);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/editarServicio.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            case "eliminar":
                this.eliminarServicio(request, response);
                break;
            default:
                this.accionDefault(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String accion = request.getParameter("accion");
        switch (accion) {

            case "UpdateService":
                this.modificarServicio(request, response);
                break;
            case "AddService":
                this.agregarServicio(request, response);
                break;
            case "filtrarServicio":
                this.filtrarServicio(request, response);
                break;
            default:
                this.accionDefault(request, response);
                break;
        }

    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    private void eliminarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_servicio = Integer.parseInt(request.getParameter("id_servicio"));
        Servicio servicio = new Servicio(id_servicio);
        int registrosModificados = new ServicioDAO().eliminar(servicio);
        request.getRequestDispatcher("vistas/crudHabitaciones.jsp").forward(request, response);

    }

    private void editarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Editar id: " + id);
        ServicioDAO servicioDao = new ServicioDAO();
        Servicio s = new Servicio();
        try {
            s = servicioDao.obtenerServicio(id);
            //System.out.println(h);
            request.setAttribute("servicio", s);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/editarServicio.jsp");
            requestDispatcher.forward(request, response);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void modificarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_servicio = Integer.parseInt(request.getParameter("id_servicio"));
        String nombre_servicio = request.getParameter("nombre_servicio");
        double precio = Double.parseDouble(request.getParameter("precio"));
        String horario_inicio = request.getParameter("horario_inicio");
        String horario_fin = request.getParameter("horario_fin");
        String ambiente = request.getParameter("ambiente");
        String estado = request.getParameter("estado");
        int personas_maximas = Integer.parseInt(request.getParameter("personas_maximas"));

        Servicio servicio = new Servicio(nombre_servicio, precio, horario_inicio, horario_fin, ambiente, estado, personas_maximas, id_servicio);

        int registrosModificados = new ServicioDAO().actualizar(servicio);
        request.setAttribute("servicio", servicio);
        System.out.println("" + servicio);
        response.sendRedirect("vistas/crudHabitaciones.jsp");
    }

    private void agregarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre_servicio = request.getParameter("nombre_servicio");
        int precio = Integer.parseInt(request.getParameter("precio"));
        String horario_inicio = request.getParameter("horario_inicio");
        String horario_fin = request.getParameter("horario_fin");
        String ambiente = request.getParameter("ambiente");
        String estado = request.getParameter("estado");
        int personas_maximas = Integer.parseInt(request.getParameter("personas_maximas"));
        Servicio servicio = new Servicio(nombre_servicio, precio, horario_inicio, horario_fin, ambiente, estado, personas_maximas);

        System.out.println("" + servicio);
        int cantidadInserto = new ServicioDAO().insertar(servicio);
        response.sendRedirect("vistas/crudHabitaciones.jsp");
    }

    public static List<String> listarServicios() {
        IServicioDAO servicio = new ServicioDAO();
        List<String> listaServicios = servicio.nombreServicios();
        return listaServicios;
    }

    private void filtrarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        IServicioDAO controladorServicio = new ServicioDAO();
        String fecha = request.getParameter("fecha");
        String nombreServicio = request.getParameter("nombreServicio");
        List<Servicio> servicios = controladorServicio.filtrarServicios(nombreServicio);
        request.setAttribute("servicios", servicios);
        sesion.setAttribute("nombreServicioActual", nombreServicio);
        sesion.setAttribute("fechaServicio", fecha);

        request.getRequestDispatcher("vistas/servicios.jsp").forward(request, response);
    }

    public static List<Servicio> listarServicioDefecto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String nombreServicio = (String) sesion.getAttribute("nombreServicioActual");
        IServicioDAO controladorServicio = new ServicioDAO();
        if (nombreServicio == null) {
            nombreServicio = "tenis";
        }
        List<Servicio> servicios = controladorServicio.filtrarServicios(nombreServicio);

        return servicios;
    }

}
