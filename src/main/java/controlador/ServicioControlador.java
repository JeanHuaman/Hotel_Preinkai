/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ServicioDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Servicio;
import dao.IServicioDAO;

/**
 *
 * @author JEAN
 */
@WebServlet("/ServicioControlador")
public class ServicioControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if(accion!=null)
        {
            switch(accion){
//                case "editar":  
//                    this.editarProducto(request, response);
//                    break;
//                case "eliminar":
//                    this.eliminarProducto(request,response);
//                    break;                
                default:
                    this.accionDefault(request, response);
                    break;
            }
        }else{
            this.accionDefault(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("accion");
        if(accion!=null)
        {
            switch(accion){
                case "filtrarServicio":  
                    this.filtrarServicio(request,response);
                    break;
//                case "detalleServicio":
//                    this.detalleServicio(request,response);
//                    break;
//                case "agregarProducto":
//                    this.agregarProducto(request,response);
//                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        }else{
            this.accionDefault(request, response);
        }
    }
    
    private void accionDefault(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        
        
                
        response.sendRedirect("index.jsp");
    }

   public static List<String> listarServicios(){
       IServicioDAO servicio = new ServicioDAO();
       List<String> listaServicios = servicio.nombreServicios();
       return listaServicios;
   }
   
   private void filtrarServicio(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
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

    public static List<Servicio> listarServicioDefecto(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        String nombreServicio = (String) sesion.getAttribute("nombreServicioActual");
        IServicioDAO controladorServicio = new ServicioDAO();
        if(nombreServicio==null){
            nombreServicio="tenis";
        }
        List<Servicio> servicios = controladorServicio.filtrarServicios(nombreServicio);
        
        return servicios;
    }
    
}
