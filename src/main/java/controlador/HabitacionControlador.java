package controlador;

import dao.HabitacionDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Habitacion;

@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = {"/HabitacionControlador"})
public class HabitacionControlador extends HttpServlet {

    HabitacionDAO hdao = new HabitacionDAO();
    Habitacion h = new Habitacion();

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
        String id = request.getParameter("id");
        switch (accion) {
            case "RoomDetails":
               
                //System.out.println("Editar id: " + id);

                try {
                h = hdao.listarId(Integer.parseInt(id));
                //System.out.println(h);
                request.setAttribute("habitacion", h);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/verdetalle.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;
            case "EditRoom":
            {
                try {
                    h = hdao.obtenerHabitacion(Integer.parseInt(id));
                } catch (SQLException ex) {
                    Logger.getLogger(HabitacionControlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                System.out.println(h);
                request.setAttribute("habitacion", h);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/editarHabitacion.jsp");
                requestDispatcher.forward(request, response);
            break;

            case "eliminar":
                this.eliminarHabitacion(request, response);
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

            case "RoomsRecommendation":
                HttpSession sesion=request.getSession();
                int cantAdultos = Integer.parseInt(request.getParameter("cantAdultos"));
                int cantNinos = Integer.parseInt(request.getParameter("cantNinos"));
                String fechaEntrada = request.getParameter("fechaEntrada");
                String fechaSalida = request.getParameter("fechaSalida");
                
                String fechaEntradaActual = (String) sesion.getAttribute("fechaEntradaActual");
                if(fechaEntradaActual==null){
                    fechaEntradaActual = fechaEntrada;
                    sesion.setAttribute("fechaEntradaActual", fechaEntradaActual);
                }
                
                String fechaSalidaActual = (String) sesion.getAttribute("fechaSalidaActual");
                if(fechaSalidaActual==null){
                    fechaSalidaActual= fechaSalida;
                    sesion.setAttribute("fechaSalidaActual", fechaSalidaActual);
                }
                
                if(!fechaEntrada.equals(fechaEntradaActual) || !fechaSalida.equals(fechaSalidaActual))
                {
                    sesion.setAttribute("carritoHabitacion", null);
                }
                
                
                sesion.setAttribute("cantidadAdulto", cantAdultos);
                sesion.setAttribute("fechaEntrada", fechaEntrada);
                sesion.setAttribute("cantidadNinos", cantNinos);
                sesion.setAttribute("fechaSalida", fechaSalida);
                
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
                break;
            case "buscar":
                this.habitacionesFiltradas(request, response);
                break;
            case "UpdateRoom":
                this.modificarHabitacion(request, response);
                break;
            case "AddRoom":
                this.agregarHabitacion(request, response);
                break;
            default:
                this.accionDefault(request, response);
                break;
        }

    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    private void habitacionesFiltradas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Habitacion> habitaciones = new HabitacionDAO().listar();
        List<Habitacion> listaFiltrada = new ArrayList();

        String habitacionFiltrado = request.getParameter("buscarHabitacion");
        if (habitacionFiltrado != null && !habitacionFiltrado.equals("")) {
            /*for(Habitacion habitacion:habitaciones){
                if(habitacion.getId_tipohabitacion().toLowerCase().contains(habitacionFiltrado.toLowerCase()))
                {
                    listaFiltrada.add(habitacion);
                }
            } */

        }
        request.setAttribute("habitaciones", listaFiltrada);

        request.getRequestDispatcher("vistas/crudHabitaciones.jsp").forward(request, response);

    }

    private void eliminarHabitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        Habitacion habitacion = new Habitacion(id_habitacion);
        int registrosModificados = new HabitacionDAO().eliminar(habitacion);
        request.getRequestDispatcher("vistas/crudHabitaciones.jsp").forward(request, response);

    }

    private void editarHabitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Editar id: " + id);
        HabitacionDAO habitacionDAO = new HabitacionDAO();
        Habitacion h = new Habitacion();
        h = habitacionDAO.obtenerHabitacion(id); // TODO Auto-generated catch block
        //System.out.println(h);
        request.setAttribute("habitacion", h);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/vistas/editarHabitacion.jsp");
        requestDispatcher.forward(request, response);

    }
    private void modificarHabitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        int id_tipohabitacion = Integer.parseInt(request.getParameter("id_tipohabitacion"));
        int id_piso = Integer.parseInt(request.getParameter("id_piso"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        String descripcion = request.getParameter("descripcion");
        int personas_maximas = Integer.parseInt(request.getParameter("personas_maximas"));
        String disponibilidad = request.getParameter("disponibilidad");
        int estrellas = Integer.parseInt(request.getParameter("estrellas"));
        
        Habitacion habitacion = new Habitacion(id_tipohabitacion, id_piso, precio, 
                descripcion,personas_maximas, disponibilidad, estrellas,id_habitacion);

        int registrosModificados = new HabitacionDAO().actualizar(habitacion);
        request.setAttribute("habitacion",habitacion);
        System.out.println("" + habitacion);
         response.sendRedirect("vistas/crudHabitaciones.jsp");
    }

    private void agregarHabitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_tipohabitacion = Integer.parseInt(request.getParameter("id_tipohabitacion"));
        int id_piso = Integer.parseInt(request.getParameter("id_piso"));//listo
        double precio = Double.parseDouble(request.getParameter("precio"));//listo
        String imagen = request.getParameter("imagen");//listo
        String descripcion = request.getParameter("descripcion");//listo
        int personas_maximas = Integer.parseInt(request.getParameter("personas_maximas"));//listo
        String disponibilidad = request.getParameter("disponibilidad");//listo
        int estrellas = Integer.parseInt(request.getParameter("estrellas"));//listo

        Habitacion habitacion = new Habitacion(id_tipohabitacion, id_piso, precio, imagen,
                descripcion, personas_maximas, disponibilidad, estrellas);
        System.out.println("" + habitacion);
        int cantidadInserto = new HabitacionDAO().insertar(habitacion);
        response.sendRedirect("vistas/crudHabitaciones.jsp");
    }
}
