package aeropuerto_luis;

public class Pasajero {
    private int idPasajero;
    private String nombre;
    private String pasaporte;
    private String nacionalidad;

    // Constructor
    public Pasajero(int idPasajero, String nombre, String pasaporte, String nacionalidad) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.pasaporte = pasaporte;
        this.nacionalidad = nacionalidad;
    }

    // Getters
    public int getIdPasajero() {
        return idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return "ID: " + idPasajero + ", Nombre: " + nombre + ", Pasaporte: " + pasaporte + ", Nacionalidad: " + nacionalidad;
    }
}


