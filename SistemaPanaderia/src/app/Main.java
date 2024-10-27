package app;

import clases.*;
import funcionesUtiles.*;
import servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        usuarioServicio.inicializarUsuarios();

        List<Venta> ventas = new ArrayList<>();
        List<Gasto> gastos = new ArrayList<>();
        List<Reporte> reportes = new ArrayList<>();
        List<Compra> compras = new ArrayList<>();
        List<Inflacion> inflaciones = new ArrayList<>();
        List<Cipac> cipacAumentos = new ArrayList<>();

        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Dueño");
            System.out.println("2. Gerente");
            System.out.println("3. Encargado");
            int tipoUsuario = FuncionesDeEntradas.leerInt();

            String tipo = switch (tipoUsuario) {
                case 1 -> "Dueno";
                case 2 -> "Gerente";
                case 3 -> "EncargadoGastos";
                default -> null;
            };

            if (tipo == null) {
                System.out.println("Tipo de usuario no válido.");
                continue;
            }

            Usuario usuario = usuarioServicio.obtenerUsuario(tipo);
            if (usuario != null) {
                boolean regresarAMenuPrincipal = MenuUsuario.mostrarMenu(usuario, ventas, gastos, reportes, compras, inflaciones, cipacAumentos);
                if (!regresarAMenuPrincipal) {
                    ejecutar = false; // Termina el programa si el usuario elige salir
                }
            } else {
                System.out.println("No se pudo obtener el usuario.");
            }
        }

        System.out.println("Saliendo del sistema...");
    }
}