package javaproject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class Test1 {

    @Test
    public void testIngresarMontoValido() {
        Credito credito = new Credito("12345", "Juan Perez", LocalDate.now().plusYears(1), 2000);
        credito.ingresar(500);
        assertEquals(2500, credito.getSaldo());
    }

    @Test
    public void testRetirarMontoValido() {
        Credito credito = new Credito("12345", "Juan Perez", LocalDate.now().plusYears(1), 2000);
        credito.retirar(1000);
        assertEquals(1000, credito.getSaldo());
    }

    @Test
    public void testRetirarMontoInsuficiente() {
        Credito credito = new Credito("12345", "Juan Perez", LocalDate.now().plusYears(1), 2000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            credito.retirar(2500);
        });
        assertEquals("Saldo insuficiente", exception.getMessage());
    }

    @Test
    public void testIngresarMontoNegativo() {
        Credito credito = new Credito("12345", "Juan Perez", LocalDate.now().plusYears(1), 2000);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            credito.ingresar(-100);
        });
        assertEquals("El importe debe ser positivo", exception.getMessage());
    }
}
