package funcionesUtiles;

import clases.*;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Comparator;

public class MenuUsuario {
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean mostrarMenu(Usuario usuario, List<Venta> ventas, List<Gasto> gastos, List<Reporte> reportes, List<Compra> compras, List<Inflacion> inflaciones, List<Cipac> cipacAumentos) {
        boolean regresarASeleccionUsuario = false;

        while (!regresarASeleccionUsuario) {
            System.out.println("\n=========================");
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("=========================");
            System.out.println("Bienvenido, " + usuario.getNombre());
            System.out.println("=========================");

            if (usuario instanceof Dueno) {
                mostrarMenuDueno(reportes);
            } else if (usuario instanceof EncargadoGastos) {
                mostrarMenuEncargado(gastos, compras);
            } else if (usuario instanceof Gerente) {
                mostrarMenuGerente(ventas, gastos, reportes, compras, inflaciones, cipacAumentos);
            }

            System.out.print("¿Desea regresar a la selección de usuario? (s/n): ");
            String respuesta = FuncionesDeEntradas.leerString();
            regresarASeleccionUsuario = respuesta.equalsIgnoreCase("s");
        }
        return regresarASeleccionUsuario;
    }

    private static void mostrarMenuDueno(List<Reporte> reportes) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú Dueño ---");
            System.out.println("1. Ver Reportes");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = FuncionesDeEntradas.leerInt();

            switch (opcion) {
                case 1 -> verReportes(reportes);
                case 0 -> continuar = false;
                default -> System.out.println("\u001B[31mOpción no válida. Por favor, intente de nuevo.\u001B[0m");
            }
        }
    }

    private static Object verReportes(List<Reporte> reportes) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void mostrarMenuEncargado(List<Gasto> gastos, List<Compra> compras) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú Encargado de Gastos ---");
            System.out.println("1. Gestionar Gastos");
            System.out.println("2. Gestionar Compras");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = FuncionesDeEntradas.leerInt();

            switch (opcion) {
                case 1 -> menuGastos(gastos);
                case 2 -> menuCompras(compras);
                case 0 -> continuar = false;
                default -> System.out.println("\u001B[31mOpción no válida. Por favor, intente de nuevo.\u001B[0m");
            }
        }
    }

    private static void mostrarMenuGerente(List<Venta> ventas, List<Gasto> gastos, List<Reporte> reportes, List<Compra> compras, List<Inflacion> inflaciones, List<Cipac> cipacAumentos) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú Gerente ---");
            System.out.println("1. Gestionar Ventas");
            System.out.println("2. Gestionar Gastos");
            System.out.println("3. Gestionar Compras");
            System.out.println("4. Ver Reportes");
            System.out.println("5. Registrar Índice de Inflación");
            System.out.println("6. Registrar Aumento CIPAC");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");

            int opcion = FuncionesDeEntradas.leerInt();

            switch (opcion) {
                case 1 -> menuVentas(ventas);
                case 2 -> menuGastos(gastos);
                case 3 -> menuCompras(compras);
                case 4 -> verReportes(reportes);
                case 5 -> registrarInflacion(inflaciones);
                case 6 -> registrarCipac(cipacAumentos);
                case 0 -> continuar = false;
                default -> System.out.println("\u001B[31mOpción no válida. Por favor, intente de nuevo.\u001B[0m");
            }
        }
    }

    private static Object registrarCipac(List<Cipac> cipacAumentos) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Object registrarInflacion(List<Inflacion> inflaciones) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void menuVentas(List<Venta> ventas) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Gestión de Ventas ---");
            System.out.println("1. Añadir Venta");
            System.out.println("2. Ver Ventas");
            System.out.println("3. Editar Venta");
            System.out.println("4. Eliminar Venta");
            System.out.println("5. Ordenar Ventas por Fecha");
            System.out.println("6. Buscar Venta por ID");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = FuncionesDeEntradas.leerInt();

            switch (opcion) {
                case 1 -> agregarVenta(ventas);
                case 2 -> verVentas(ventas);
                case 3 -> editarVenta(ventas);
                case 4 -> eliminarVenta(ventas);
                case 5 -> ordenarVentas(ventas);
                case 6 -> {
                    System.out.print("Ingrese el ID de la venta a buscar: ");
                    int idVenta = FuncionesDeEntradas.leerInt();
                    Venta venta = buscarVentaPorId(ventas, idVenta);
                    if (venta != null) {
                        System.out.println("Venta encontrada: " + venta);
                    } else {
                        System.out.println("Venta no encontrada.");
                    }
                }
                case 0 -> continuar = false;
                default -> System.out.println("\u001B[31mOpción no válida. Por favor, intente de nuevo.\u001B[0m");
            }
        }
    }

    private static void agregarVenta(List<Venta> ventas) {
        System.out.print("Ingrese el ID de la venta: ");
        int idVenta = FuncionesDeEntradas.leerInt();
        System.out.print("Ingrese la fecha (dd/MM/yyyy): ");
        String fechaStr = FuncionesDeEntradas.leerString();
        Date fecha = convertirStringADate(fechaStr);
        System.out.print("Ingrese el monto total: ");
        double montoTotal = FuncionesDeEntradas.leerDouble();
        System.out.print("Ingrese el detalle: ");
        String detalle = FuncionesDeEntradas.leerString();
        System.out.print("Ingrese el tipo de venta (Efectivo, Débito, Transferencia): ");
        String tipoVenta = FuncionesDeEntradas.leerString();
        System.out.print("Ingrese el ID del gerente: ");
        int gerenteId = FuncionesDeEntradas.leerInt();

        Venta nuevaVenta = new Venta(idVenta, fecha, montoTotal, detalle, tipoVenta, gerenteId);
        ventas.add(nuevaVenta);
        System.out.println("Venta añadida exitosamente.");
    }

    private static void verVentas(List<Venta> ventas) {
        System.out.println("\n--- Ventas Registradas ---");
        for (Venta venta : ventas) {
            System.out.println(venta);
        }
    }

    private static void editarVenta(List<Venta> ventas) {
        System.out.print("Ingrese el ID de la venta a editar: ");
        int idVenta = FuncionesDeEntradas.leerInt();
        Venta venta = buscarVentaPorId(ventas, idVenta);

        if (venta != null) {
            System.out.print("Ingrese la nueva fecha (dd/MM/yyyy): ");
            String fechaStr = FuncionesDeEntradas.leerString();
            Date fecha = convertirStringADate(fechaStr);
            System.out.print("Ingrese el nuevo monto total: ");
            double montoTotal = FuncionesDeEntradas.leerDouble();
            System.out.print("Ingrese el nuevo detalle: ");
            String detalle = FuncionesDeEntradas.leerString();
            System.out.print("Ingrese el nuevo tipo de venta (Efectivo, Débito, Transferencia): ");
            String tipoVenta = FuncionesDeEntradas.leerString();

            venta.setFecha(fecha);
            venta.setMontoTotal(montoTotal);
            venta.setDetalle(detalle);
            venta.setTipoVenta(tipoVenta);
            System.out.println("Venta editada exitosamente.");
        } else {
            System.out.println("\u001B[31mVenta no encontrada.\u001B[0m");
        }
    }

    private static void eliminarVenta(List<Venta> ventas) {
        System.out.print("Ingrese el ID de la venta a eliminar: ");
        int idVenta = FuncionesDeEntradas.leerInt();
        Venta venta = buscarVentaPorId(ventas, idVenta);

        if (venta != null) {
            ventas.remove(venta);
            System.out.println("Venta eliminada exitosamente.");
        } else {
            System.out.println("\u001B[31mVenta no encontrada.\u001B[0m");
        }
    }

    private static Venta buscarVentaPorId(List<Venta> ventas, int idVenta) {
        for (Venta venta : ventas) {
            if (venta.getId() == idVenta) {
                return venta;
            }
        }
        return null;
    }

    private static void ordenarVentas(List<Venta> ventas) {
        ventas.sort(Comparator.comparing(Venta::getFecha));
        System.out.println("Ventas ordenadas por fecha.");
    }

    private static Date convertirStringADate(String fechaStr) {
        try {
            return dateFormat.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("\u001B[31mError al convertir la fecha. Asegúrese de usar el formato dd/MM/yyyy.\u001B[0m");
            return new Date();
        }
    }

    private static void menuGastos(List<Gasto> gastos) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Gestión de Gastos ---");
            System.out.println("1. Añadir Gasto");
            System.out.println("2. Ver Gastos");
            System.out.println("3. Editar Gasto");
            System.out.println("4. Eliminar Gasto");
            System.out.println("5. Ordenar Gastos por Fecha");
            System.out.println("6. Buscar Gasto por ID");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = FuncionesDeEntradas.leerInt();

            switch (opcion) {
                case 1 -> agregarGasto(gastos);
                case 2 -> verGastos(gastos);
                case 3 -> editarGasto(gastos);
                case 4 -> eliminarGasto(gastos);
                case 5 -> ordenarGastos(gastos);
                case 6 -> {
                    System.out.print("Ingrese el ID del gasto a buscar: ");
                    int idGasto = FuncionesDeEntradas.leerInt();
                    Gasto gasto = buscarGastoPorId(gastos, idGasto);
                    if (gasto != null) {
                        System.out.println("Gasto encontrado: " + gasto);
                    } else {
                        System.out.println("Gasto no encontrado.");
                    }
                }
                case 0 -> continuar = false;
                default -> System.out.println("\u001B[31mOpción no válida. Por favor, intente de nuevo.\u001B[0m");
            }
        }
    }

    private static void agregarGasto(List<Gasto> gastos) {
        System.out.print("Ingrese el ID del gasto: ");
        int idGasto = FuncionesDeEntradas.leerInt();
        System.out.print("Ingrese el tipo de gasto: ");
        String tipoGasto = FuncionesDeEntradas.leerString();
        System.out.print("Ingrese el monto: ");
        double monto = FuncionesDeEntradas.leerDouble();
        System.out.print("Ingrese la fecha (dd/MM/yyyy): ");
        String fechaStr = FuncionesDeEntradas.leerString();
        Date fecha = convertirStringADate(fechaStr);
        System.out.print("Ingrese el detalle: ");
        String detalle = FuncionesDeEntradas.leerString();
        System.out.print("Ingrese el tipo de pago: ");
        String tipoPago = FuncionesDeEntradas.leerString();

        Gasto nuevoGasto = new Gasto(idGasto, tipoGasto, monto, fecha, detalle, tipoPago);
        gastos.add(nuevoGasto);
        System.out.println("Gasto añadido exitosamente.");
    }

    private static void verGastos(List<Gasto> gastos) {
        System.out.println("\n--- Gastos Registrados ---");
        for (Gasto gasto : gastos) {
            System.out.println(gasto);
        }
    }

    private static void editarGasto(List<Gasto> gastos) {
        System.out.print("Ingrese el ID del gasto a editar: ");
        int idGasto = FuncionesDeEntradas.leerInt();
        Gasto gasto = buscarGastoPorId(gastos, idGasto);

        if (gasto != null) {
            System.out.print("Ingrese el nuevo tipo de gasto: ");
            String tipoGasto = FuncionesDeEntradas.leerString();
            System.out.print("Ingrese el nuevo monto: ");
            double monto = FuncionesDeEntradas.leerDouble();
            System.out.print("Ingrese la nueva fecha (dd/MM/yyyy): ");
            String fechaStr = FuncionesDeEntradas.leerString();
            Date fecha = convertirStringADate(fechaStr);
            System.out.print("Ingrese el nuevo detalle: ");
            String detalle = FuncionesDeEntradas.leerString();
            System.out.print("Ingrese el nuevo tipo de pago: ");
            String tipoPago = FuncionesDeEntradas.leerString();

            gasto.setTipoGasto(tipoGasto);
            gasto.setMonto(monto);
            gasto.setFecha(fecha);
            gasto.setDetalle(detalle);
            gasto.setTipoPago(tipoPago);
            System.out.println("Gasto editado exitosamente.");
        } else {
            System.out.println("\u001B[31mGasto no encontrado.\u001B[0m");
        }
    }

    private static void eliminarGasto(List<Gasto> gastos) {
        System.out.print("Ingrese el ID del gasto a eliminar: ");
        int idGasto = FuncionesDeEntradas.leerInt();
        Gasto gasto = buscarGastoPorId(gastos, idGasto);

        if (gasto != null) {
            gastos.remove(gasto);
            System.out.println("Gasto eliminado exitosamente.");
        } else {
            System.out.println("\u001B[31mGasto no encontrado.\u001B[0m");
        }
    }

    private static Gasto buscarGastoPorId(List<Gasto> gastos, int idGasto) {
        for (Gasto gasto : gastos) {
            if (gasto.getId() == idGasto) {
                return gasto;
            }
        }
        return null;
    }

    private static void ordenarGastos(List<Gasto> gastos) {
        gastos.sort(Comparator.comparing(Gasto::getFecha));
        System.out.println("Gastos ordenados por fecha.");
    }

    private static void menuCompras(List<Compra> compras) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Gestión de Compras ---");
            System.out.println("1. Añadir Compra");
            System.out.println("2. Ver Compras");
            System.out.println("3. Editar Compra");
            System.out.println("4. Eliminar Compra");
            System.out.println("0. Volver al menú anterior");
            System.out.print("Seleccione una opción: ");
            int opcion = FuncionesDeEntradas.leerInt();

            switch (opcion) {
                case 1 -> agregarCompra(compras);
                case 2 -> verCompras(compras);
                case 3 -> editarCompra(compras);
                case 4 -> eliminarCompra(compras);
                case 0 -> continuar = false;
                default -> System.out.println("\u001B[31mOpción no válida. Por favor, intente de nuevo.\u001B[0m");
            }
        }
    }

    private static void agregarCompra(List<Compra> compras) {
        System.out.print("Ingrese el ID de la compra: ");
        int idCompra = FuncionesDeEntradas.leerInt();
        System.out.print("Ingrese la fecha (dd/MM/yyyy): ");
        String fechaStr = FuncionesDeEntradas.leerString();
        Date fecha = convertirStringADate(fechaStr);
        System.out.print("Ingrese el monto total: ");
        double monto = FuncionesDeEntradas.leerDouble();
        System.out.print("Ingrese el detalle: ");
        String detalle = FuncionesDeEntradas.leerString();
        System.out.print("Ingrese el tipo de pago: ");
        String tipoPago = FuncionesDeEntradas.leerString();

        Compra nuevaCompra = new Compra(idCompra, fecha, monto, detalle, tipoPago);
        compras.add(nuevaCompra);
        System.out.println("Compra añadida exitosamente.");
    }

    private static void verCompras(List<Compra> compras) {
        System.out.println("\n--- Compras Registradas ---");
        for (Compra compra : compras) {
            System.out.println(compra);
        }
    }

    private static void editarCompra(List<Compra> compras) {
        System.out.print("Ingrese el ID de la compra a editar: ");
        int idCompra = FuncionesDeEntradas.leerInt();
        Compra compra = buscarCompraPorId(compras, idCompra);

        if (compra != null) {
            System.out.print("Ingrese la nueva fecha (dd/MM/yyyy): ");
            String fechaStr = FuncionesDeEntradas.leerString();
            Date fecha = convertirStringADate(fechaStr);
            System.out.print("Ingrese el nuevo monto total: ");
            double monto = FuncionesDeEntradas.leerDouble();
            System.out.print("Ingrese el nuevo detalle: ");
            String detalle = FuncionesDeEntradas.leerString();
            System.out.print("Ingrese el nuevo tipo de pago: ");
            String tipoPago = FuncionesDeEntradas.leerString();

            compra.setFecha(fecha);
            compra.setMonto(monto);
            compra.setDetalle(detalle);
            compra.setTipoPago(tipoPago);
            System.out.println("Compra editada exitosamente.");
        } else {
            System.out.println("\u001B[31mCompra no encontrada.\u001B[0m");
        }
    }

    private static void eliminarCompra(List<Compra> compras) {
        System.out.print("Ingrese el ID de la compra a eliminar: ");
        int idCompra = FuncionesDeEntradas.leerInt();
        Compra compra = buscarCompraPorId(compras, idCompra);

        if (compra != null) {
            compras.remove(compra);
            System.out.println("Compra eliminada exitosamente.");
        } else {
            System.out.println("\u001B[31mCompra no encontrada.\u001B[0m");
        }
    }

    private static Compra buscarCompraPorId(List<Compra> compras, int idCompra) {
        for (Compra compra : compras) {
            if (compra.getId() == idCompra) {
                return compra;
            }
        }
        return null;
    }

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		MenuUsuario.scanner = scanner;
	}

@SuppressWarnings("unused")
private static void gestionarGastos(final List<Gasto> gastos) {
    // Implementar la lógica para gestionar gastos
}

@SuppressWarnings("unused")
private static void ordenarGastos1(List<Gasto> gastos) {
    gastos.sort(Comparator.comparing(Gasto::getFecha));
    System.out.println("Gastos ordenados por fecha.");
}

@SuppressWarnings("unused")
private static void buscarGastoPorIdMenu(List<Gasto> gastos) {
    System.out.print("Ingrese el ID del gasto a buscar: ");
    int idGasto = FuncionesDeEntradas.leerInt();
    Gasto gasto = buscarGastoPorId(gastos, idGasto);
    if (gasto != null) {
        System.out.println("Gasto encontrado: " + gasto);
    } else {
        System.out.println("\u001B[31mGasto no encontrado.\u001B[0m");
    }
}

@SuppressWarnings("unused")
private static Gasto buscarGastoPorId1(List<Gasto> gastos, int idGasto) {
    for (Gasto gasto : gastos) {
        if (gasto.getId() == idGasto) {
            return gasto;
        }
    }
    return null;
}
}