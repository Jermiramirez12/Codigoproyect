package clases;

import java.util.Date;

// Clase que representa un reporte financiero
public class Reporte {
    private int idReporte; // Identificador único del reporte
    private Date fechaGeneracion; // Fecha de generación del reporte
    private double montoTotalVentas; // Total de ventas
    private double montoTotalGastos; // Total de gastos
    private double montoTotalCompras; // Total de compras
    private double indiceInflacion; // Índice de inflación
    private double aumentoCipac; // Aumento del CIPAC
    private double rentabilidad; // Rentabilidad del negocio
    private int duenoId; // Identificador del dueño
    private int gerenteId; // Identificador del gerente

    // Constructor con todos los parámetros necesarios
    public Reporte(int idReporte, Date fechaGeneracion, double montoTotalVentas, double montoTotalGastos, 
                   double montoTotalCompras, double indiceInflacion, double aumentoCipac, double rentabilidad, int duenoId, int gerenteId) {
        this.idReporte = idReporte;
        this.fechaGeneracion = fechaGeneracion;
        this.montoTotalVentas = montoTotalVentas;
        this.montoTotalGastos = montoTotalGastos;
        this.montoTotalCompras = montoTotalCompras;
        this.indiceInflacion = indiceInflacion;
        this.aumentoCipac = aumentoCipac;
        this.rentabilidad = rentabilidad;
        this.duenoId = duenoId;
        this.gerenteId = gerenteId;
    }

    // Métodos getter y setter
    public int getIdReporte() { return idReporte; }
    public Date getFechaGeneracion() { return fechaGeneracion; }
    public double getMontoTotalVentas() { return montoTotalVentas; }
    public double getMontoTotalGastos() { return montoTotalGastos; }
    public double getMontoTotalCompras() { return montoTotalCompras; }
    public double getIndiceInflacion() { return indiceInflacion; }
    public double getAumentoCipac() { return aumentoCipac; }
    public double getRentabilidad() { return rentabilidad; }
    public int getDuenoId() { return duenoId; }
    public int getGerenteId() { return gerenteId; }

    public void setMontoTotalVentas(double montoTotalVentas) { this.montoTotalVentas = montoTotalVentas; }
    public void setMontoTotalGastos(double montoTotalGastos) { this.montoTotalGastos = montoTotalGastos; }
    public void setMontoTotalCompras(double montoTotalCompras) { this.montoTotalCompras = montoTotalCompras; }
    public void setIndiceInflacion(double indiceInflacion) { this.indiceInflacion = indiceInflacion; }
    public void setAumentoCipac(double aumentoCipac) { this.aumentoCipac = aumentoCipac; }
    public void setRentabilidad(double rentabilidad) { this.rentabilidad = rentabilidad; }

    @Override
    public String toString() {
        return "Reporte{idReporte=" + idReporte + ", fechaGeneracion=" + fechaGeneracion + ", montoTotalVentas=" + montoTotalVentas +
                ", montoTotalGastos=" + montoTotalGastos + ", montoTotalCompras=" + montoTotalCompras +
                ", indiceInflacion=" + indiceInflacion + ", aumentoCipac=" + aumentoCipac + 
                ", rentabilidad=" + rentabilidad + ", duenoId=" + duenoId + ", gerenteId=" + gerenteId + "}";
    }
}