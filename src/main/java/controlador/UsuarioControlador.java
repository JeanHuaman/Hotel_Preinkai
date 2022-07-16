/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.HabitacionFavoritaDAO;
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
import modelo.HabitacionFavorita;

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
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String accion = request.getParameter("accion");
        if (accion.equals("SaveFavoriteRoom")) {
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
        }
    }

}
