
package modelo;


public class TipoHabitacion {
    private int idTipoHabitacion;
    private String nombreH;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int idTipoHabitacion, String nombreH) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.nombreH = nombreH;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }
    
    
}
