package clases;

// Clase que representa a un encargado de gastos
public class EncargadoGastos extends Usuario {

    public EncargadoGastos(int idEncargado, String nombre) {
        super(idEncargado, nombre); // Llama al constructor de Usuario
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones de Encargado de Gastos:");
        System.out.println("1. Registrar Compras");
        System.out.println("2. Registrar Gastos");
    }

    @Override
    public String toString() {
        return "EncargadoGastos{id=" + id + ", nombre='" + nombre + "'}";
    }
}