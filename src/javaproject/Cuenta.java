package javaproject;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cuenta {
    private ArrayList<Movimiento> movimientos;
    private String numero;
    private String titular;

    public Cuenta(String numero, String titular) {
        this.movimientos = new ArrayList<>();
        this.numero = numero;
        this.titular = titular;
    }

    public void addMovimiento(Movimiento m) {
        movimientos.add(m);
    }

    public double getSaldo() {
        double saldo = 0;
        for (Movimiento movimiento : movimientos) {
            saldo += movimiento.getImporte();
        }
        return saldo;
    }

    public void ingresar(double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        Movimiento ingreso = new Movimiento("Ingreso", LocalDate.now(), x);
        addMovimiento(ingreso);
    }

    public void ingresar(String concepto, double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        Movimiento ingreso = new Movimiento(concepto, LocalDate.now(), x);
        addMovimiento(ingreso);
    }

    public void retirar(double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        if (getSaldo() < x) throw new IllegalArgumentException("Saldo insuficiente");
        Movimiento retiro = new Movimiento("Retiro", LocalDate.now(), -x);
        addMovimiento(retiro);
    }

    public void retirar(String concepto, double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        if (getSaldo() < x) throw new IllegalArgumentException("Saldo insuficiente");
        Movimiento retiro = new Movimiento(concepto, LocalDate.now(), -x);
        addMovimiento(retiro);
    }

    public void pagoEnEstablecimiento(String datos, double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto debe ser positivo");
        if (getSaldo() < monto) throw new IllegalArgumentException("Saldo insuficiente");
        Movimiento pago = new Movimiento("Pago en Establecimiento: " + datos, LocalDate.now(), -monto);
        addMovimiento(pago);
    }
}
