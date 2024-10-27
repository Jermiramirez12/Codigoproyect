package clases;

import java.util.Date;

// Clase que representa un índice de inflación
public class Inflacion {
    private int idInflacion; // Identificador único de la inflación
    private double indice; // Valor del índice de inflación
    private Date fecha; // Fecha del índice
    private int gerenteId; // Identificador del gerente que registra el índice

    // Constructor con todos los parámetros necesarios
    public Inflacion(int idInflacion, double indice, Date fecha, int gerenteId) {
        this.idInflacion = idInflacion;
        this.indice = indice;
        this.fecha = fecha;
        this.gerenteId = gerenteId;
    }

    // Métodos getter y setter
    public int getIdInflacion() { return idInflacion; }
    public double getIndice() { return indice; }
    public Date getFecha() { return fecha; }
    public int getGerenteId() { return gerenteId; }
    public void setIndice(double indice) { this.indice = indice; }

    @Override
    public String toString() {
        return "Inflacion{idInflacion=" + idInflacion + ", indice=" + indice + 
                ", fecha=" + fecha + ", gerenteId=" + gerenteId + "}";
    }
}