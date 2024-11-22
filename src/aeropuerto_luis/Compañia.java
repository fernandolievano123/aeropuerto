package aeropuerto_luis;

public class Compañia {
    private int idCompania;
    private String nombre;

    // Constructor
    public Compañia(int idCompania, String nombre) {
        this.idCompania = idCompania;
        this.nombre = nombre;
    }

    // Getters
    public int getIdCompania() {
        return idCompania;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "ID: " + idCompania + ", Nombre: " + nombre;
    }
}
