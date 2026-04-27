package desafios;

import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_1_Cola_Prioridad;
import ImplementacionesEstaticas.bloque2.Interface.ColaPrioridadTDA;

public class Desafio5 {
    public static void main(String[] args) {
        ColaPrioridadTDA cp = new Estrategia_1_Cola_Prioridad();
        cp.InicializarCola();

        int[] c = {-3, 5, 0, -1, 7, 2, -4};

        for (int x : c) {
            int p;

            if (x > 0) {
                p = 2;
            } else if (x == 0) {
                p = 1;
            } else {
                p = 0;
            }

            cp.AcolarPrioridad(x, p);
        }

        System.out.println("Salida de la cola:");
        while (!cp.ColaVacia()) {
            System.out.println("Elemento: " + cp.Primero() + " (P: " + cp.Prioridad() + ")");
            cp.Desacolar();
        }
    }
}
