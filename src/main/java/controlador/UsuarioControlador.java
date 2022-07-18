/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.HabitacionFavoritaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.HabitacionFavorita;
import modelo.Usuario;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
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

        Usuario usuario = new UsuarioDAO().iniciarSesion(email);

        if (usuario.getPassword().equals(password)) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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

}
