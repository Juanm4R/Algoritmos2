package ImplementacionesEstaticas.bloque2;
import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_2_Cola;
import ImplementacionesEstaticas.bloque2.Interface.ColaTDA;

public class FilaDelCajero {
    private ColaTDA fila;

    public FilaDelCajero() {
        fila = new Estrategia_2_Cola();
        fila.InicializarCola();
    }

    public void simular() {
        System.out.println("--- 1. FILA DEL CAJERO ---");
        int cantidadClientes = 3; // Llevamos el registro nosotros

        fila.Acolar(1001); // Cliente 1
        fila.Acolar(1002); // Cliente 2
        fila.Acolar(1003); // Cliente 3

        // Usamos FOR basado en la cantidad que ingresamos
        for (int i = 0; i < cantidadClientes; i++) {
            System.out.println("Turno " + (i+1) + " - Atendiendo cliente: " + fila.Primero());
            fila.Desacolar();
        }
    }
}

