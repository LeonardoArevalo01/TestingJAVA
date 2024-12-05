package javaproject;

import java.time.LocalDate;

import javaproject.Cuenta;

public class Tarjeta {
    private Cuenta cuentaAsociada;
    private LocalDate fechaDeCaducidad;
    private String numero;
    private String titular;

    public Tarjeta(String numero, String titular, LocalDate fechaCaducidad, Cuenta cuenta) {
        this.numero = numero;
        this.titular = titular;
        this.fechaDeCaducidad = fechaCaducidad;
        this.cuentaAsociada = cuenta;

        if (this.fechaDeCaducidad.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de caducidad no puede ser anterior a la fecha actual.");
        }
    }

    public void realizarPago(double monto, String datos) {
        if (fechaDeCaducidad.isBefore(LocalDate.now())) {
            throw new IllegalStateException("La tarjeta ha caducado.");
        }
        cuentaAsociada.pagoEnEstablecimiento(datos, monto);
    }

    public double consultarSaldo() {
        return cuentaAsociada.getSaldo();
    }

    // Getters y Setters
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public LocalDate getFechaDeCaducidad() {
        return fechaDeCaducidad;
    }
}
