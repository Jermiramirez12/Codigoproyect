package servicios;

import clases.*;

public class UsuarioServicio {
    private Dueno dueno;
    private Gerente gerente;
    private EncargadoGastos encargadoGastos;

    public void inicializarUsuarios() {
        dueno = new Dueno(1, "Claudio Moserrat");
        gerente = new Gerente(2, "Jermi Ramirez");
        encargadoGastos = new EncargadoGastos(3, "Mario zamora");
    }

    public Usuario obtenerUsuario(String tipo) {
        Usuario usuario;
        switch (tipo) {
            case "Dueno":
                usuario = dueno; // Cambiado de Dueno a dueno (instancia)
                break;
            case "Gerente":
                usuario = gerente; // Correcto
                break;
            case "EncargadoGastos":
                usuario = encargadoGastos; // Correcto
                break;
            default:
                usuario = null; // Correcto
                break;
        }
        return usuario;
    }
}