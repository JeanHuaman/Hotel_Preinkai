package dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import modelo.DetalleReserva;
import modelo.Habitacion;
import modelo.DetalleServicio;
import modelo.Reserva;
import modelo.Servicio;
import modelo.Usuario;

public class Prueba {

    public static void main(String[] args) throws SQLException {

//        Date fecha;
//        Date horariInicio;
//        Date horarioFinal;
//        
//        fecha = new Date();
//        
//        InterfaceServicioDAO Servicio = new ServicioDAO();
//        
//        IHabitacionDAO controladorHabitacion = new HabitacionDAO();
//        List<Habitacion> habitaciones = controladorHabitacion.listar();
//        IUsuarioDAO controladorUsuario = new UsuarioDAO();
//        Usuario usuario = new Usuario(1,"78945612","usuarioPrueba","12456788","casa","user@gmail","123","usuario");
//        int idUsuario = controladorUsuario.registrarse(usuario);
//        System.out.println(idUsuario);
//        Servicio servicio = new Servicio("bar",20,"10:30","11:30","bar Cielo","habilitado",5,new Date());
//        InterfaceServicioDAO Servicio = new ServicioDAO();
//        InterfaceDetalleServicioDAO controladorDetalle = new DetalleServicioDAO();
//        DetalleServicio detalle = new DetalleServicio(1,1,"78977773","jean2");
//        System.out.println(controladorDetalle.insertarDetalleServicio(detalle));
//
//            IReservaDAO reserva = new ReservaDAO();
//            System.out.println(reserva.obtenerIdReserva());
        System.out.println(new HabitacionDAO().obtenerHabitacion(4));
//        Servicio servicio = new Servicio("bar",20,"10:30","11:30","bar Cielo","habilitado",5);
//        
//        System.out.println(Servicio.insertarServicios(servicio));
//        System.out.println(Servicio.nombreServicios());
//        System.out.println("hola");

//        for(Habitacion h:habitaciones){
//            System.out.println(h.toString());
//        }
//        List<Servicio> servicios = Servicio.filtrarServicios("tenis"); 
//        Servicio servicio = Servicio.filtrarServicioId(3);
//        System.out.println(servicio.toString());

    }

}
