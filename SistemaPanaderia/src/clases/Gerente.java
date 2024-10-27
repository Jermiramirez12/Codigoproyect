package clases;

// Clase que representa a un gerente del sistema
public class Gerente extends Usuario {

    public Gerente(int idGerente, String nombre) {
        super(idGerente, nombre); // Llama al constructor de Usuario
    }

    @Override
    public void mostrarOpciones() {
        System.out.println("Opciones de Gerente:");
        System.out.println("1. Cargar Ventas");
        System.out.println("2. Gestionar Gastos");
        System.out.println("3. Ajustar Cálculos por Inflación");
        System.out.println("4. Ajustar Aumentos del CIPAC");
        System.out.println("5. Generar Reportes");
        System.out.println("6. Revisar Reportes");
        System.out.println("7. Imprimir Reportes");
    }

    @Override
    public String toString() {
        return "Gerente{id=" + id + ", nombre='" + nombre + "'}";
    }
}