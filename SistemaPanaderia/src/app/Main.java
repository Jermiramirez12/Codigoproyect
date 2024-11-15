package app;

import clases.*;
import dao.*;
import funcionesUtiles.FuncionesDeEntradas;
import servicios.UsuarioServicio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsuarioServicio usuarioServicio = new UsuarioServicio();
        usuarioServicio.inicializarUsuarios();

        // Instancias DAO
        VentaDAO ventaDAO = new VentaDAO();
        GastoDAO gastoDAO = new GastoDAO();
        ReporteDAO reporteDAO = new ReporteDAO();
        CompraDAO compraDAO = new CompraDAO();
        InflacionDAO inflacionDAO = new InflacionDAO();
        CIPACDAO cipacDAO = new CIPACDAO();
        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println("\nSeleccione el tipo de usuario:");
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
                boolean regresarAMenuPrincipal = mostrarMenu(usuario, ventaDAO, gastoDAO, reporteDAO, compraDAO, inflacionDAO, cipacDAO);
                if (!regresarAMenuPrincipal) {
                    ejecutar = false; // Termina el programa si el usuario elige salir
                }
            } else {
                System.out.println("No se pudo obtener el usuario.");
            }
        }

        System.out.println("Saliendo del sistema...");
    }

    public static boolean mostrarMenu(Usuario usuario, VentaDAO ventaDAO, GastoDAO gastoDAO, ReporteDAO reporteDAO,
                                      CompraDAO compraDAO, InflacionDAO inflacionDAO, CIPACDAO cipacDAO) {
        System.out.println("\nOpciones para " + usuario.getNombre() + " (" + usuario.getId() + "):");
        System.out.println("1. Ver ventas");
        System.out.println("2. Ver gastos");
        System.out.println("3. Ver reportes");
        System.out.println("4. Ver compras");
        System.out.println("5. Ver inflación");
        System.out.println("6. Ver CIPAC");
        System.out.println("7. Agregar nueva venta");
        System.out.println("8. Agregar nuevo gasto");
        System.out.println("9. Agregar nuevo reporte");
        System.out.println("10. Agregar nueva compra");
        System.out.println("11. Agregar nuevo índice de inflación");
        System.out.println("12. Agregar nuevo aumento de CIPAC");
        System.out.println("13. Salir");

        int opcion = FuncionesDeEntradas.leerInt();

        try {
            switch (opcion) {
                case 1:
                    // Ver Ventas
 
                    for (Venta venta : ventas) {
                        System.out.println(venta);
                    }
                    break;

                case 2:
                    // Ver Gastos
                    List<Gasto> gastos = gastoDAO.getAll();
                    for (Gasto gasto : gastos) {
                        System.out.println(gasto);
                    }
                    break;

                case 3:
                    // Ver Reportes
                    List<Reporte> reportes = reporteDAO.getAll();
                    for (Reporte reporte : reportes) {
                        System.out.println(reporte);
                    }
                    break;

                case 4:
                    // Ver Compras
                    List<Compra> compras = compraDAO.getAll();
                    for (Compra compra : compras) {
                        System.out.println(compra);
                    }
                    break;

                case 5:
                    // Ver Inflación
                    List<Inflacion> inflaciones = inflacionDAO.getAll();
                    for (Inflacion inflacion : inflaciones) {
                        System.out.println(inflacion);
                    }
                    break;

                case 6:
                    // Ver Cipac
                    List<Cipac> cipacs = cipacDAO.getAll();
                    for (Cipac cipac : cipacs) {
                        System.out.println(cipac);
                    }
                    break;

                case 7:
                    // Agregar Nueva Venta
                    System.out.println("Ingrese el tipo de venta:");
                    String tipoVenta = FuncionesDeEntradas.leerString();
                    System.out.println("Ingrese el monto total:");
                    double montoVenta = FuncionesDeEntradas.leerDouble();
                    System.out.println("Ingrese el ID del gerente:");
                    int gerenteIdVenta = FuncionesDeEntradas.leerInt();
                    Venta nuevaVenta = new Venta(0, tipoVenta, montoVenta, new Date(), gerenteIdVenta);
                    ventaDAO.create(nuevaVenta);
                    System.out.println("Venta agregada exitosamente.");
                    break;

                case 8:
                    // Agregar Nuevo Gasto
                    System.out.println("Ingrese el tipo de gasto:");
                    String tipoGasto = FuncionesDeEntradas.leerString();
                    System.out.println("Ingrese el monto del gasto:");
                    double montoGasto = FuncionesDeEntradas.leerDouble();
                    System.out.println("Ingrese el detalle del gasto:");
                    String detalleGasto = FuncionesDeEntradas.leerString();
                    Gasto nuevoGasto = new Gasto(0, tipoGasto, montoGasto, new Date(), detalleGasto, "Efectivo");
                    gastoDAO.create(nuevoGasto);
                    System.out.println("Gasto agregado exitosamente.");
                    break;

                case 9:
                    // Agregar Nuevo Reporte
                    System.out.println("Ingrese el monto total de ventas:");
                    double montoTotalVentas = FuncionesDeEntradas.leerDouble();
                    System.out.println("Ingrese el monto total de gastos:");
                    double montoTotalGastos = FuncionesDeEntradas.leerDouble();
                    Reporte nuevoReporte = new Reporte(0, new Date(), montoTotalVentas, montoTotalGastos, montoTotalVentas - montoTotalGastos, usuario.getId(), usuario.getId());
                    reporteDAO.create(nuevoReporte);
                    System.out.println("Reporte agregado exitosamente.");
                    break;

                case 10:
                    // Agregar Nueva Compra
                    System.out.println("Ingrese el tipo de compra:");
                    String tipoCompra = FuncionesDeEntradas.leerString();
                    System.out.println("Ingrese el nombre del producto:");
                    String nombreCompra = FuncionesDeEntradas.leerString();
                    System.out.println("Ingrese el monto total de la compra:");
                    double montoCompra = FuncionesDeEntradas.leerDouble();
                    Compra nuevaCompra = new Compra(0, 123, tipoCompra, nombreCompra, montoCompra, new Date(), "Proveedor", usuario.getId(), usuario.getId());
                    compraDAO.create(nuevaCompra);
                    System.out.println("Compra agregada exitosamente.");
                    break;

                case 11:
                    // Agregar Nueva Inflación
                    System.out.println("Ingrese el índice de inflación:");
                    double indiceInflacion = FuncionesDeEntradas.leerDouble();
                    Inflacion nuevaInflacion = new Inflacion(0, indiceInflacion, new Date(), usuario.getId());
                    inflacionDAO.create(nuevaInflacion);
                    System.out.println("Índice de inflación agregado exitosamente.");
                    break;

                case 12:
                    // Agregar Nuevo Aumento de CIPAC
                    System.out.println("Ingrese el porcentaje de aumento del CIPAC:");
                    double porcentajeCIPAC = FuncionesDeEntradas.leerDouble();
                    CIPAC nuevoCIPAC = new CIPAC(0, porcentajeCIPAC, new Date(), usuario.getId());
                    cipacDAO.create(nuevoCIPAC);
                    System.out.println("Aumento de CIPAC agregado exitosamente.");
                    break;

                case 13:
                    // Salir
                    System.out.println("Saliendo del menú...");
                    return false;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Error en la operación con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return true; // Regresa al menú principal
    }
}