/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import dao.HabitacionFavoritaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import dao.DetalleServicioDAO;
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
import dao.IReservaDAO;
import dao.IServicioDAO;
import servicios.Excel;
import servicios.Mail;

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
//                case "editar":  
//                    this.editarProducto(request, response);
//                    break;
//                case "eliminar":
//                    this.eliminarProducto(request,response);
//                    break;   
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
                case "pagarServicio":
                    this.pagarServicio(request, response);
                    break;
                case "agregarServicio":
                    this.agregarServicio(request, response);
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

    private void agregarHabitacionFavorita(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));

        HabitacionFavorita habitacion_favorita = new HabitacionFavorita(id_usuario, id_habitacion);
        System.out.println("Listaaa: " + habitacion_favorita);
        int registrado = new HabitacionFavoritaDAO().guardar(habitacion_favorita);

        request.setAttribute("idRegistrado", (Object) registrado);
        request.getRequestDispatcher("./vistas/habitaciones_favorita.jsp").forward(request, response);
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

    private void pagarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        IReservaDAO controladorReserva = new ReservaDAO();
        IDetalleServicioDAO controladorDetalle = new DetalleServicioDAO();

        Usuario usuario = (Usuario) request.getAttribute("usuario");
        usuario = new Usuario(1, 1, "74883021", "jean", "933610015", "niño jesus", "jean@gmail.com", "123456", "usuario");
        if (usuario != null) {
            List<Servicio> carritoServicios = (List<Servicio>) sesion.getAttribute("carritoServicios");
            double totalServicios = (double) sesion.getAttribute("totalServicio");

            String tipoPago = request.getParameter("tipoPago");
            String tipoTarjeta = request.getParameter("tipoTarjeta");
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
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

}
