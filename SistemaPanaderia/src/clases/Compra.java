package clases;

import java.util.Date;

public class Compra {
    private int id;
    private Date fecha;
    private double monto;
    private String detalle;
    private String tipoPago;

    // Constructor
    public Compra(int id, Date fecha, double monto, String detalle, String tipoPago) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.detalle = detalle;
        this.tipoPago = tipoPago;
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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", monto=" + monto +
                ", detalle='" + detalle + '\'' +
                ", tipoPago='" + tipoPago + '\'' +
                '}';
    }
}