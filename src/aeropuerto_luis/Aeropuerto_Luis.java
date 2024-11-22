package aeropuerto_luis;

import java.sql.*;

public class Aeropuerto_Luis {

    public static void main(String[] args) {
        cargarDatosIniciales(); // Llamada para cargar los datos iniciales si es necesario

        // Menú de gestión
        java.util.Scanner sc = new java.util.Scanner(System.in);
        
        while (true) {
            System.out.println("--- MENU DE GESTION AEROPORTUARIA ---");
            System.out.println("1. Mostrar Compañías.");
            System.out.println("2. Mostrar Pasajeros.");
            System.out.println("3. Agregar Compañía.");
            System.out.println("4. Agregar Pasajero.");
            System.out.println("0. Salir.");
            System.out.print("Elija una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    mostrarCompanias();
                    break;
                case 2:
                    mostrarPasajeros();
                    break;
                case 3:
                    // Agregar compañía
                    System.out.print("Ingrese el nombre de la nueva compañía: ");
                    String nombreCompania = sc.nextLine();
                    agregarCompania(nombreCompania);
                    break;
                case 4:
                    // Agregar pasajero
                    System.out.print("Ingrese el nombre del nuevo pasajero: ");
                    String nombrePasajero = sc.nextLine();
                    System.out.print("Ingrese el pasaporte del nuevo pasajero: ");
                    String pasaporte = sc.nextLine();
                    System.out.print("Ingrese la nacionalidad del nuevo pasajero: ");
                    String nacionalidad = sc.nextLine();
                    agregarPasajero(nombrePasajero, pasaporte, nacionalidad);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // Método para agregar una nueva compañía a la base de datos
    public static void agregarCompania(String nombre) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://82.197.82.62:3306/u984447967_op2024b", 
                "u984447967_unipaz", "estudiantesPoo2024B.*")) {
            
            // Sentencia SQL para insertar una nueva compañía
            String sql = "INSERT INTO companias (nombre) VALUES (?)";
            
            // Preparamos la sentencia
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre); // Asignamos el nombre de la compañía
            
            // Ejecutamos la sentencia
            int rowsAffected = stmt.executeUpdate();
            
            // Comprobamos si se insertaron filas
            if (rowsAffected > 0) {
                System.out.println("Compañía agregada correctamente.");
            } else {
                System.out.println("Error al agregar la compañía.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al agregar la compañía: " + e.getMessage());
        }
    }

    // Método para agregar un nuevo pasajero a la base de datos
    public static void agregarPasajero(String nombre, String pasaporte, String nacionalidad) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://82.197.82.62:3306/u984447967_op2024b", 
                "u984447967_unipaz", "estudiantesPoo2024B.*")) {
            
            // Sentencia SQL para insertar un nuevo pasajero
            String sql = "INSERT INTO pasajeros (nombre, pasaporte, nacionalidad) VALUES (?, ?, ?)";
            
            // Preparamos la sentencia
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre); // Asignamos el nombre
            stmt.setString(2, pasaporte); // Asignamos el pasaporte
            stmt.setString(3, nacionalidad); // Asignamos la nacionalidad
            
            // Ejecutamos la sentencia
            int rowsAffected = stmt.executeUpdate();
            
            // Comprobamos si se insertaron filas
            if (rowsAffected > 0) {
                System.out.println("Pasajero agregado correctamente.");
            } else {
                System.out.println("Error al agregar el pasajero.");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al agregar el pasajero: " + e.getMessage());
        }
    }

    // Mostrar las compañías
    public static void mostrarCompanias() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://82.197.82.62:3306/u984447967_op2024b", 
                "u984447967_unipaz", "estudiantesPoo2024B.*")) {
            
            String sql = "SELECT * FROM companias";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("Compañías registradas:");
            while (rs.next()) {
                int idCompania = rs.getInt("idCompania");
                String nombre = rs.getString("nombre");
                System.out.println("ID: " + idCompania + " | Nombre: " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar compañías: " + e.getMessage());
        }
    }

    // Mostrar los pasajeros
    public static void mostrarPasajeros() {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://82.197.82.62:3306/u984447967_op2024b", 
                "u984447967_unipaz", "estudiantesPoo2024B.*")) {
            
            String sql = "SELECT * FROM pasajeros";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("Pasajeros registrados:");
            while (rs.next()) {
                int idPasajero = rs.getInt("idPasajero");
                String nombre = rs.getString("nombre");
                String pasaporte = rs.getString("pasaporte");
                String nacionalidad = rs.getString("nacionalidad");
                System.out.println("ID: " + idPasajero + " | Nombre: " + nombre + " | Pasaporte: " + pasaporte + " | Nacionalidad: " + nacionalidad);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar pasajeros: " + e.getMessage());
        }
    }

    // Método para cargar los datos iniciales si es necesario
    public static void cargarDatosIniciales() {
        System.out.println("Datos iniciales cargados correctamente.");
    }
}
