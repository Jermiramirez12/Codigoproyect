package clases;

import java.util.Date;

public class Venta {
    private int id;
    private Date fecha;
    private double montoTotal;
    private String detalle;
    private String tipoVenta;
    private int gerenteId; // ID del gerente asociado

    // Constructor
    public Venta(int id, Date fecha, double montoTotal, String detalle, String tipoVenta, int gerenteId) {
        this.id = id;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.detalle = detalle;
        this.tipoVenta = tipoVenta;
        this.gerenteId = gerenteId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public int getGerenteId() {
        return gerenteId;
    }

    public void setGerenteId(int gerenteId) {
        this.gerenteId = gerenteId;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", montoTotal=" + montoTotal +
                ", detalle='" + detalle + '\'' +
                ", tipoVenta='" + tipoVenta + '\'' +
                ", gerenteId=" + gerenteId +
                '}';
    }
}