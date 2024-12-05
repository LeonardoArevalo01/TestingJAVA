package javaproject;

import java.time.LocalDate;
import java.util.ArrayList;

public class Debito {
    private String numero;
    private String titular;
    private LocalDate fechaCaducidad;
    private double saldo;
    private ArrayList<Movimiento> movimientos;

    public Debito(String numero, String titular, LocalDate fechaCaducidad) {
        this.numero = numero;
        this.titular = titular;
        this.fechaCaducidad = fechaCaducidad;
        this.saldo = 0;
        this.movimientos = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        saldo += x;
        Movimiento ingreso = new Movimiento("Ingreso", LocalDate.now(), x);
        movimientos.add(ingreso);
    }

    public void pagoEnEstablecimiento(String datos, double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        if (saldo >= monto) {
            saldo -= monto;
            Movimiento pago = new Movimiento("Pago en " + datos, LocalDate.now(), -monto);
            movimientos.add(pago);
            System.out.println("Pago realizado en " + datos + " por " + monto);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el pago.");
        }
    }

    public void retirar(double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        if (saldo >= x) {
            saldo -= x;
            Movimiento retiro = new Movimiento("Retiro", LocalDate.now(), -x);
            movimientos.add(retiro);
            System.out.println("Retiro realizado por " + x);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro.");
        }
    }
}
