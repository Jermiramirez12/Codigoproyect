package clases;

// Clase abstracta que representa un usuario del sistema
public abstract class Usuario {
    protected int id; // Identificador del usuario
    protected String nombre; // Nombre del usuario

    // Constructor de Usuario
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos getter
    public int getId() { return id; }
    public String getNombre() { return nombre; }

    // Método abstracto para mostrar opciones
    public abstract void mostrarOpciones();
}