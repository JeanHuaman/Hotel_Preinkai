/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DetalleServicioDAO;
import dao.ReservaDAO;
import dao.ServicioDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DetalleServicio;
import modelo.Reserva;
import modelo.Servicio;
import modelo.Usuario;
import dao.IDetalleServicioDAO;
import dao.IReservaDAO;
import dao.IServicioDAO;

/**
 *
 * @author JEAN
 */
@WebServlet("/UsuarioControlador")
public class UsuarioControlador extends HttpServlet{
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
                case "pagarServicio":  
                    this.pagarServicio(request,response);
                    break;
                case "agregarServicio":
                    this.agregarServicio(request,response);
                    break;
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

    private void agregarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession sesion=request.getSession();
        IServicioDAO controladorServicio = new ServicioDAO();
        List<Servicio> carritoServicios = (List<Servicio>) sesion.getAttribute("carritoServicios");
        int cantidadPersonas = Integer.parseInt(request.getParameter("personas"));
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        Servicio servicio = controladorServicio.filtrarServicioId(idServicio);
        double total = 0;        
        
        if(carritoServicios==null)
        {
            carritoServicios = new ArrayList();
            sesion.setAttribute("carritoServicios", carritoServicios);
        }
        
        
        
        servicio.setPersonasMaximas(cantidadPersonas);
        carritoServicios.add(servicio);
        
        for(Servicio unidad : carritoServicios)
        {
            total = unidad.getPrecio()*unidad.getPersonasMaximas() + total;
        }
        
        sesion.setAttribute("totalServicio", total);
        
        request.getRequestDispatcher("vistas/servicios.jsp").forward(request, response);
    }

    private void pagarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        IReservaDAO controladorReserva = new ReservaDAO();
        IDetalleServicioDAO controladorDetalle = new DetalleServicioDAO();
        
        Usuario usuario= (Usuario) request.getAttribute("usuario");
        usuario = new Usuario(1,1,"74883021","jean","933610015","niño jesus","jean@gmail.com","123456","usuario");
        if(usuario != null)
        {
            List<Servicio> carritoServicios = (List<Servicio>) sesion.getAttribute("carritoServicios");
            double totalServicios = (double) sesion.getAttribute("totalServicio");
            
            String tipoPago = request.getParameter("tipoPago");
            String tipoTarjeta = request.getParameter("tipoTarjeta");
            String fecha = (String) sesion.getAttribute("fechaServicio");
            int cantidad=4;
            
            Reserva reserva = new Reserva(usuario.getIdUsuario(),totalServicios,tipoPago,tipoTarjeta,fecha,fecha,cantidad);
            controladorReserva.insertarReserva(reserva);
            int idReserva = controladorReserva.obtenerIdReserva();
            for(Servicio s : carritoServicios)
            {
               
               DetalleServicio detalle = new DetalleServicio(idReserva,s.getId_servicio(),usuario.getDni(),usuario.getNombre());
               controladorDetalle.insertarDetalleServicio(detalle);
            }
            
            sesion.setAttribute("carritoServicios", null);
            sesion.setAttribute("totalServicio",0);
            sesion.setAttribute("fechaServicio", "");
           request.getRequestDispatcher("index.jsp").forward(request, response); 
        }
        
    }
    
}
