package clases;

import java.util.Date;

public class Gasto {
    private int id;
    private String tipoGasto;
    private double monto;
    private Date fecha;
    private String detalle;
    private String tipoPago;

    // Constructor
    public Gasto(int id, String tipoGasto, double monto, Date fecha, String detalle, String tipoPago) {
        this.id = id;
        this.tipoGasto = tipoGasto;
        this.monto = monto;
        this.fecha = fecha;
        this.detalle = detalle;
        this.tipoPago = tipoPago;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        return "Gasto{" +
                "id=" + id +
                ", tipoGasto='" + tipoGasto + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", detalle='" + detalle + '\'' +
                ", tipoPago='" + tipoPago + '\'' +
                '}';
    }
}