
package controlador;


import dao.HabitacionDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Habitacion;



public class Prueba {
    public static void main(String[] args) {
        List<Habitacion> habitaciones=new HabitacionDAO().listar();
        for (Habitacion habitacion:habitaciones) {
            System.out.println(habitacion.getDescripcion());
        }
        /*List<Habitacion> habitaciones=new HabitacionDAO().listarId(1);
        for (Habitacion habitacion:habitaciones) {
            System.out.println(habitacion.getDescripcion());
        }*/
        
        
        
        
//        String marca=new MarcaDaoJDBC().getNombreMarca(2);
//        System.out.println(marca);
//        
//        String categoria = new CategoriaDaoJDBC().getNombreCategoria(1);
//        System.out.println(categoria);
//        
//        List<Producto> productos= new ProductoDaoJDBC().listar();
//        System.out.println(productos);
//        List<Producto> listaFiltrada= new ArrayList();
//        
//        for(Producto producto:productos){
//            if(producto.getNombre().contains("ci"))
//            {
//                listaFiltrada.add(producto);
//            }
//        }
//        Producto producto = new Producto(10);
//     int cont =new ProductoDaoJDBC().eliminar(producto);
//        System.out.println(cont);

//        int cont =new ProductoDaoJDBC().actualizar(producto);
//        System.out.println(cont);
//        System.out.println(listaFiltrada);
//        
//        System.out.println("caracter".contains("rac"));
//        

//          Usuario usuario = new Usuario("juan@hotmail.com","juan","12345");
//          
//          int registrado = new UsuarioDaoJDBC().registrarse(usuario);

//            System.out.println(registrado);

//            Usuario usuario = new Usuario("jean","huaman","987654321","jean@hotmail.com","87451263","Niño jesus 2da etapa","jean","123456");
//            
//            int actualizado = new UsuarioDaoJDBC().actualizarUsuario(usuario);
//            
//            System.out.println(actualizado);
          
//          String logeado = new UsuarioDaoJDBC().iniciarSesion(usuario);
//          if(logeado.equals(usuario.getPassword())){
//              System.out.println("Inicio de Sesión correctamente");
//          }else{
//              System.out.println("NO inicio de sesión");
//          }
         
    }
 
}
