package javaproject;

import java.time.LocalDate;
import java.util.ArrayList;

public class Credito {
    private double credito;
    private ArrayList<Movimiento> movimientos;
    private String numero;
    private String titular;
    private LocalDate fechaCaducidad;

    public Credito(String numero, String titular, LocalDate fechaCaducidad, double creditoInicial) {
        this.setNumero(numero);
        this.setTitular(titular);
        this.setFechaCaducidad(fechaCaducidad);
        this.credito = creditoInicial;
        this.movimientos = new ArrayList<>();
    }

    public double getCreditoDisponible() {
        // Lógica para calcular el crédito disponible
        return credito; // Ejemplo simple, debe ser ajustado
    }

    public double getSaldo() {
        double saldo = 0;
        for (Movimiento movimiento : movimientos) {
            saldo += movimiento.getImporte();
        }
        return saldo;
        //suma todos los movimientos sin detectar que son retiros o ingresos 
    }

    public void ingresar(double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        Movimiento ingreso = new Movimiento("Ingreso", LocalDate.now(), x);
        movimientos.add(ingreso);
        credito += x; // Ajustar el crédito disponible
    }

    public void liquidar(int mes, int año) {
        // Lógica para liquidar deudas, posiblemente usando los movimientos
    }

    public void pagoEnEstablecimiento(String datos, double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        Movimiento pago = new Movimiento("Pago en Establecimiento: " + datos, LocalDate.now(), -x);
        movimientos.add(pago);
        credito -= x; // Ajustar el crédito disponible
    }

    public void retirar(double x) {
        if (x <= 0) throw new IllegalArgumentException("El importe debe ser positivo");
        if (credito < x) throw new IllegalArgumentException("Crédito insuficiente");
        Movimiento retiro = new Movimiento("Retiro", LocalDate.now(), -x);
        movimientos.add(retiro);
        credito -= x; // Ajustar el crédito disponible
    }

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
}