package aeropuerto_luis;
import java.util.ArrayList;

public class Vuelo {

    private String id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precio;
    private int totalAsientos;
    private int asientosReservados;
    private ArrayList<Pasajero> pasajeros;

    public Vuelo(String id, String ciudadOrigen, String ciudadDestino, double precio, int totalAsientos) {
        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.totalAsientos = totalAsientos;
        this.asientosReservados = 0;
        this.pasajeros = new ArrayList<>();
    }

    // Métodos Getter
    public String getId() {
        return id;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;  // Este método devuelve la ciudad de origen
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTotalAsientos() {
        return totalAsientos;
    }

    public int getAsientosReservados() {
        return asientosReservados;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    // Método para agregar un pasajero
    public boolean hayAsientosDisponibles() {
        return asientosReservados < totalAsientos;
    }

    public void agregarPasajero(Pasajero pasajero) {
        if (hayAsientosDisponibles()) {
            pasajeros.add(pasajero);
            asientosReservados++;
            System.out.println("Pasajero " + pasajero.getNombre() + " agregado exitosamente.");
        } else {
            System.out.println("No hay asientos disponibles en este vuelo.");
        }
    }

    // Método para mostrar la información del vuelo
    public void mostrarInfo() {
        System.out.println("Vuelo " + id + ": " + ciudadOrigen + " -> " + ciudadDestino + " ($" + precio + ")");
        System.out.println("Asientos Reservados: " + asientosReservados + "/" + totalAsientos);
    }
}

