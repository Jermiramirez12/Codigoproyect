package clases;

// Clase que representa a un dueño del sistema
public class Dueno extends Usuario {
    
    public Dueno(int idDueno, String nombre) {
        super(idDueno, nombre); // Llama al constructor de Usuario
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones de Dueño: 1. Revisar Reportes, 2. Imprimir Reportes");
    }

    @Override
    public String toString() {
        return "Dueno{id=" + id + ", nombre='" + nombre + "'}";
    }
}