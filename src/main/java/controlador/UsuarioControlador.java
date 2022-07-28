/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DetalleReservaDAO;
import dao.HabitacionFavoritaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import modelo.Usuario;
import dao.IDetalleServicioDAO;
import dao.IHabitacionDAO;
import dao.IReservaDAO;
import dao.IServicioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.DetalleReserva;
import modelo.Habitacion;

/**
 *
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
                case "seleccionarHabitacion": {
                    try {
                        this.seleccionarHabitacion(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
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
                        Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
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
                    HabitacionFavoritaDAO habitacionFavoritaDAO = new HabitacionFavoritaDAO();
                    HabitacionFavorita habitacionFavorita = new HabitacionFavorita();
                    habitacionFavorita.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
                    habitacionFavorita.setId_habitacion(Integer.parseInt(request.getParameter("id_habitacion")));
                    try {
                        habitacionFavoritaDAO.guardar(habitacionFavorita);
                        System.out.println("Registro guardado satisfactoriamente...");
                        RequestDispatcher requestDispatcher = request.getRequestDispatcher("vistas/habitaciones_favorita.jsp");
                        requestDispatcher.forward(request, response);

                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
//                case "agregarProducto":
//                    this.agregarProducto(request,response);
//                    break;
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

    private void agregarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id_membresia = Integer.parseInt(request.getParameter("id_membresia"));
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String celular = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");

        Usuario usuario = new Usuario(id_membresia, dni, nombre, celular, direccion, email, password, rol);
        System.out.println("Listaaa: " + usuario);
        int registrado = new UsuarioDAO().registrarse(usuario);

        request.setAttribute("idRegistrado", (Object) registrado);
        request.getRequestDispatcher("./vistas/login.jsp").forward(request, response);

    }

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("correo");
        String password = request.getParameter("password");
        String rol = "";
        Usuario usuario = new UsuarioDAO().iniciarSesion(email);
        rol = usuario.getRol();
        System.out.println("Rol: " + rol);
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

        request.getRequestDispatcher("vistas/servicios.jsp").forward(request, response);
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
                int cantidad = 4;

                Reserva reserva = new Reserva(usuario.getIdUsuario(), totalServicios, tipoPago, tipoTarjeta, fecha, fecha, cantidad);
                controladorReserva.insertarReserva(reserva);
                int idReserva = controladorReserva.obtenerIdReserva();
                for (Servicio s : carritoServicios) {

                    DetalleServicio detalle = new DetalleServicio(idReserva, s.getId_servicio(), usuario.getDni(), usuario.getNombre());
                    controladorDetalle.insertarDetalleServicio(detalle);
                }
                sesion.setAttribute("carritoServicios", null);
                sesion.setAttribute("totalServicio", 0);
                sesion.setAttribute("fechaServicio", "");
            }

            if (tipoReserva.equalsIgnoreCase("habitacion")) {
                IDetalleReservaDAO IDetalleReserva = new DetalleReservaDAO();
                List<Habitacion> carritoHabitaciones = (List<Habitacion>) sesion.getAttribute("carritoHabitacion");
                double totalHabitaciones = (double) sesion.getAttribute("totalHabitacion");
                String fechaEntrada = (String) sesion.getAttribute("fechaEntrada");
                String fechaSalida = (String) sesion.getAttribute("fechaSalida");
                int totalHuespedes = (int) sesion.getAttribute("totalHuespedes");
                
                Reserva reserva = new Reserva(usuario.getIdUsuario(), totalHabitaciones, tipoPago, tipoTarjeta, fechaEntrada, fechaSalida, totalHuespedes);
                controladorReserva.insertarReserva(reserva);
                int idReserva = controladorReserva.obtenerIdReserva();
                
                for(Habitacion s : carritoHabitaciones) {

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
        int totalHuespedes =0;
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

}
