
package dao;

import java.util.Date;
import java.util.List;
import modelo.Servicio;



public class Prueba {
    public static void main(String[] args) {
        
        Date fecha;
        Date horariInicio;
        Date horarioFinal;
        
        fecha = new Date();
        
        InterfaceServicioDAO Servicio = new ServicioDAO();
//        Servicio servicio = new Servicio("bar",20,"10:30","11:30","bar Cielo","habilitado",5);
//        
//        System.out.println(Servicio.insertarServicios(servicio));
//        System.out.println(Servicio.nombreServicios());
//        System.out.println("hola");
        List<Servicio> servicios = Servicio.filtrarServicios("tenis"); 
        System.out.println(servicios.toString());
    }
 
}
