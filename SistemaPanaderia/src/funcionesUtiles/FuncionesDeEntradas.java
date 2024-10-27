package funcionesUtiles;

import java.util.Scanner;

// Clase que proporciona métodos para la entrada de datos del usuario
public class FuncionesDeEntradas {
    private static Scanner scanner = new Scanner(System.in); // Scanner para leer entradas

    // Método para leer un entero
    public static int leerInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número entero: ");
            }
        }
    }

    // Método para leer un número decimal
    public static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, ingrese un número decimal: ");
            }
        }
    }

    // Método para leer una cadena
    public static String leerString() {
        return scanner.nextLine();
    }
}