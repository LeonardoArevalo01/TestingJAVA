package javaproject;

import java.time.LocalDate;

public class Movimiento {

    private String concepto;
    private LocalDate fecha;
    private double importe;

    public Movimiento(String concepto, LocalDate fecha, double importe) {
        if (importe < 0) {
            throw new IllegalArgumentException("El importe no puede ser negativo");
        }
        this.concepto = concepto;
        this.fecha = fecha;
        this.importe = importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        if (importe < 0) {
            throw new IllegalArgumentException("El importe no puede ser negativo");
        }
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "concepto='" + concepto + '\'' +
                ", fecha=" + fecha +
                ", importe=" + importe +
                '}';
    }
}
