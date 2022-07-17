
package dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import modelo.DetalleServicio;
import modelo.Servicio;



public class Prueba {
    public static void main(String[] args) {
        
        Date fecha;
        Date horariInicio;
        Date horarioFinal;
        
        fecha = new Date();
        
//        InterfaceServicioDAO Servicio = new ServicioDAO();
//        InterfaceDetalleServicioDAO controladorDetalle = new DetalleServicioDAO();
//        DetalleServicio detalle = new DetalleServicio(1,1,"78977773","jean2");
//        System.out.println(controladorDetalle.insertarDetalleServicio(detalle));

            IReservaDAO reserva = new ReservaDAO();
            System.out.println(reserva.obtenerIdReserva());
//        Servicio servicio = new Servicio("bar",20,"10:30","11:30","bar Cielo","habilitado",5);
//        
//        System.out.println(Servicio.insertarServicios(servicio));
//        System.out.println(Servicio.nombreServicios());
//        System.out.println("hola");
//        List<Servicio> servicios = Servicio.filtrarServicios("tenis"); 
//        Servicio servicio = Servicio.filtrarServicioId(3);
//        System.out.println(servicio.toString());
    }
 
}
