
package modelo;


public class Piso {
    private int idPiso;
    private int numeroHabitaciones;

    public Piso() {
    }

    public Piso(int idPiso, int numeroHabitaciones) {
        this.idPiso = idPiso;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    public int getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }

    public void setNumeroHabitaciones(int numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
    
    
}
