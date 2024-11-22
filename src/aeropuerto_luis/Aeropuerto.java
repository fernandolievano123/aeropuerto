package aeropuerto_luis;
import java.util.ArrayList;

public class Aeropuerto {

    private String nombre;
    private String ciudad;
    private String pais;
    private ArrayList<Compañia> companias;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.companias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void agregarCompania(Compañia compania) {
        companias.add(compania);
    }

    public ArrayList<Compañia> getCompanias() {
        return companias; // Este método devuelve la lista de compañías
    }

    public void mostrarDatos() {
        System.out.println("AEROPUERTO: " + nombre);
        System.out.println("Ciudad: " + ciudad + ", País: " + pais);
        for (Compañia compania : companias) {
            compania.mostrarDatos();
        }
    }
}

