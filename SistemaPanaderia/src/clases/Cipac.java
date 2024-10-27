package clases;

import java.util.Date;

// Clase que representa un aumento del CIPAC (Índice de Precios al Consumidor)
public class Cipac {
    private int idCipac; // Identificador único del CIPAC
    private double porcentajeAumento; // Porcentaje de aumento del CIPAC
    private Date fechaAumento; // Fecha en que se aplica el aumento
    private int gerenteId; // Identificador del gerente que registra el aumento

    // Constructor para inicializar un objeto Cipac
    public Cipac(int idCipac, double porcentajeAumento, Date fechaAumento, int gerenteId) {
        this.idCipac = idCipac;
        this.porcentajeAumento = porcentajeAumento;
        this.fechaAumento = fechaAumento;
        this.gerenteId = gerenteId;
    }

    // Métodos getter y setter
    public int getIdCipac() { return idCipac; }
    public double getPorcentajeAumento() { return porcentajeAumento; }
    public Date getFechaAumento() { return fechaAumento; }
    public int getGerenteId() { return gerenteId; }
    public void setPorcentajeAumento(double porcentajeAumento) { this.porcentajeAumento = porcentajeAumento; }

    @Override
    public String toString() {
        return "Cipac{idCipac=" + idCipac + ", porcentajeAumento=" + porcentajeAumento + 
                ", fechaAumento=" + fechaAumento + ", gerenteId=" + gerenteId + "}";
    }
}