package controlador;

import dao.DetalleReservaDAO;
import dao.HabitacionFavoritaDAO;
import dao.UsuarioDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

import dao.DetalleServicioDAO;
import dao.HabitacionDAO;
import dao.IDetalleReservaDAO;
import dao.ReservaDAO;
import dao.ServicioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.HabitacionFavorita;
import modelo.Usuario;
import modelo.DetalleServicio;
import modelo.Reserva;
import modelo.Servicio;
import dao.IDetalleServicioDAO;
import dao.IHabitacionDAO;
import dao.IReservaDAO;
import dao.IServicioDAO;
import servicios.Excel;
import servicios.Mail;
import modelo.DetalleReserva;
import modelo.Habitacion;

/**
 * @author JEAN
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
//                case "editar":  
//                    this.editarProducto(request, response);
//                    break;
//                case "eliminar":
//                    this.eliminarProducto(request,response);
//                    break;   
                case "seleccionarHabitacion": {
                    try {
                        this.seleccionarHabitacion(request, response);
                    } catch (SQLException ex) {
//                        Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "GoToLogin":
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("vistas/login.jsp");
                    requestDispatcher.forward(request, response);
                    break;
                case "cerrarSesion":
                    this.cerrarSession(request, response);
                    break;
                case "GenerarReporteExcel":
                    this.generarReporteExcel(request, response);
                    break;
                case "historial":
                    this.historial(request,response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "pagar":
                    this.pagarReserva(request, response);
                    break;
                case "agregarServicio":
                    this.agregarServicio(request, response);
                    break;
                case "agregarHabitacion": {
                    try {
                        this.agregarHabitacion(request, response);
                    } catch (SQLException ex) {
//                        Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "AddUser":
                    this.agregarUsuario(request, response);
                    break;
                case "Login":
                    this.iniciarSesion(request, response);
                    break;
                case "actualizarUsuario":
                    //this.actualizarUsuario(request, response);
                    break;
                case "SaveFavoriteRoom":
                    this.agregarHabitacionFavorita(request, response);
                    break;
                case "SendMail":
                    this.enviarCorreo(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }

    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        response.sendRedirect("index.jsp");
    }

    private void enviarCorreo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreSM = request.getParameter("txtNombre");
        String celularSM = request.getParameter("txtCelular");
        String direccionSM = request.getParameter("txtDireccion");
        String correoSM = request.getParameter("txtCorreo");
        String descripcionSM = request.getParameter("txtDescripcion");
        Mail mail = new Mail();

        mail.enviarMail(nombreSM, celularSM, direccionSM, correoSM, descripcionSM);
        request.getRequestDispatcher("vistas/verMail.jsp").forward(request, response);
    }

    private void generarReporteExcel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Excel ex = new Excel();
        try {
            ex.crearExcel();
            RequestDispatcher requestDispatcherExcel = request.getRequestDispatcher("vistas/verReporteEnExcel.jsp");
            requestDispatcherExcel.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("" + e);
        }
    }

    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String celular = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        Usuario usuario = new Usuario(dni, nombre, celular, direccion, email, password, rol);
        System.out.println("Listaaa: " + usuario);
        int registrado = new UsuarioDAO().registrarse(usuario);

        request.setAttribute("idRegistrado", (Object) registrado);
        request.getRequestDispatcher("./vistas/login.jsp").forward(request, response);

    }

    private void agregarHabitacionFavorita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        boolean encontrado = false;
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        List<HabitacionFavorita> habitacionesFavoritas = new HabitacionFavoritaDAO().listar(usuario.getIdUsuario());
        for (HabitacionFavorita hab : habitacionesFavoritas) {
            if (hab.getId_habitacion() == id_habitacion && !encontrado) {
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            HabitacionFavorita habitacion_favorita = new HabitacionFavorita(usuario.getIdUsuario(), id_habitacion);
            System.out.println("Listaaa: " + habitacion_favorita);
            int registrado = new HabitacionFavoritaDAO().guardar(habitacion_favorita);
        }


        response.sendRedirect("vistas/habitaciones_favorita.jsp");

    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("correo");
        String password = request.getParameter("password");
        String rol = "";
        int id_usuario;
        Usuario usuario = new UsuarioDAO().iniciarSesion(email);
        rol = usuario.getRol();
        id_usuario = usuario.getIdUsuario();
        System.out.println("Rol: " + rol);
        System.out.println("Id del Usuario: " + id_usuario);
        if (usuario.getPassword().equals(password)) {
            if (rol.equals("Usuario")) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else if (rol.equals("Administrador")) {
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("vistas/dashboard.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorLogin", "error");
            request.getRequestDispatcher("./vistas/login.jsp").forward(request, response);
        }

    }

    private void cerrarSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        response.sendRedirect("index.jsp");
    }

    private void agregarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        IServicioDAO controladorServicio = new ServicioDAO();
        List<Servicio> carritoServicios = (List<Servicio>) sesion.getAttribute("carritoServicios");
        int cantidadPersonas = Integer.parseInt(request.getParameter("personas"));
        int totalPersonasServicio;
        if (sesion.getAttribute("totalPersonasServicio") == null) {
            totalPersonasServicio = 0;
            sesion.setAttribute("totalPersonasServicio", totalPersonasServicio);
        }
        totalPersonasServicio = (int) sesion.getAttribute("totalPersonasServicio");
        totalPersonasServicio += cantidadPersonas;
        sesion.setAttribute("totalPersonasServicio", totalPersonasServicio);
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        Servicio servicio = controladorServicio.filtrarServicioId(idServicio);
        double total = 0;

        if (carritoServicios == null) {
            carritoServicios = new ArrayList();
            sesion.setAttribute("carritoServicios", carritoServicios);
        }

        servicio.setPersonasMaximas(cantidadPersonas);
        carritoServicios.add(servicio);

        for (Servicio unidad : carritoServicios) {
            total = unidad.getPrecio() * unidad.getPersonasMaximas() + total;
        }
        sesion.setAttribute("totalServicio", total);
        response.sendRedirect("vistas/servicios.jsp");

    }

    private void pagarReserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        IReservaDAO controladorReserva = new ReservaDAO();
        String tipoReserva = request.getParameter("tipo");
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        String tipoPago = request.getParameter("tipoPago");
        String tipoTarjeta = request.getParameter("tipoTarjeta");
        if (usuario != null) {
            if (tipoReserva.equalsIgnoreCase("servicio")) {
                IDetalleServicioDAO controladorDetalle = new DetalleServicioDAO();
                List<Servicio> carritoServicios = (List<Servicio>) sesion.getAttribute("carritoServicios");
                double totalServicios = (double) sesion.getAttribute("totalServicio");

                String fecha = (String) sesion.getAttribute("fechaServicio");
                int totalPersonasServicio = (int) sesion.getAttribute("totalPersonasServicio");
                ;

                Reserva reserva = new Reserva(usuario.getIdUsuario(), totalServicios, tipoPago, tipoTarjeta, fecha, fecha, totalPersonasServicio, tipoReserva);
                controladorReserva.insertarReserva(reserva);
                int idReserva = controladorReserva.obtenerIdReserva();
                for (Servicio s : carritoServicios) {

                    DetalleServicio detalle = new DetalleServicio(idReserva, s.getId_servicio(), usuario.getDni(), usuario.getNombre());
                    controladorDetalle.insertarDetalleServicio(detalle);
                }
                sesion.setAttribute("carritoServicios", null);
                sesion.setAttribute("totalServicio", 0);
                sesion.setAttribute("fechaServicio", "");
                sesion.setAttribute("totalPersonasServicio", 0);
            }

            if (tipoReserva.equalsIgnoreCase("habitacion")) {
                IDetalleReservaDAO IDetalleReserva = new DetalleReservaDAO();
                List<Habitacion> carritoHabitaciones = (List<Habitacion>) sesion.getAttribute("carritoHabitacion");
                double totalHabitaciones = (double) sesion.getAttribute("totalHabitacion");
                String fechaEntrada = (String) sesion.getAttribute("fechaEntrada");
                String fechaSalida = (String) sesion.getAttribute("fechaSalida");
                int totalHuespedes = (int) sesion.getAttribute("totalHuespedes");

                Reserva reserva = new Reserva(usuario.getIdUsuario(), totalHabitaciones, tipoPago, tipoTarjeta, fechaEntrada, fechaSalida, totalHuespedes, tipoReserva);
                controladorReserva.insertarReserva(reserva);
                int idReserva = controladorReserva.obtenerIdReserva();

                for (Habitacion s : carritoHabitaciones) {

                    DetalleReserva detalle = new DetalleReserva(idReserva, s.getId_habitacion(), usuario.getDni(), usuario.getNombre());
                    IDetalleReserva.insertarDetalleReserva(detalle);
                }
                sesion.setAttribute("carritoHabitacion", null);
                sesion.setAttribute("totalHabitacion", 0);
                sesion.setAttribute("fechaEntrada", "");
                sesion.setAttribute("fechaSalida", "");
            }

            response.sendRedirect("index.jsp");
        }

    }

    private void agregarHabitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession sesion = request.getSession();
        IHabitacionDAO Ihabitacion = new HabitacionDAO();
        List<Habitacion> carritoHabitacion = (List<Habitacion>) sesion.getAttribute("carritoHabitacion");
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
        Habitacion habitacion = Ihabitacion.obtenerHabitacion(idHabitacion);
        double totalHabitacion = 0;
        int totalHuespedes = 0;
        if (carritoHabitacion == null) {
            carritoHabitacion = new ArrayList();
            sesion.setAttribute("carritoHabitacion", carritoHabitacion);
        }

        carritoHabitacion.add(habitacion);

        for (Habitacion h : carritoHabitacion) {
            totalHabitacion = h.getPrecio() + totalHabitacion;
            totalHuespedes = h.getPersonas_maximas() + totalHuespedes;
        }
        sesion.setAttribute("totalHabitacion", totalHabitacion);
        sesion.setAttribute("totalHuespedes", totalHuespedes);

        response.sendRedirect("index.jsp");
    }

    private void seleccionarHabitacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        IHabitacionDAO Ihabitacion = new HabitacionDAO();
        int idHabitacion = Integer.parseInt(request.getParameter("idHabitacion"));
        Habitacion habitacion = Ihabitacion.obtenerHabitacion(idHabitacion);
        request.setAttribute("habitacion", habitacion);
        request.getRequestDispatcher("vistas/reservahabitacion.jsp").forward(request, response);
    }


    private void historial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        IReservaDAO ireserva = new ReservaDAO();
        List<Reserva> historial = ireserva.listarReservas(usuario.getIdUsuario());
        sesion.setAttribute("historial",historial);
        response.sendRedirect("vistas/historialServiciosHabitaciones.jsp");
    }
}
