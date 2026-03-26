package bloque2;

import bloque2.Implementacion.Estrategia_1_Cola_Prioridad;
import bloque2.Interface.ColaPrioridadTDA;

public class EmbarqueAerolineas {
    private ColaPrioridadTDA embarque;

    public EmbarqueAerolineas() {
        embarque = new Estrategia_1_Cola_Prioridad();
        embarque.InicializarCola();
    }

    public void simular() {
        System.out.println("\n--- 7. EMBARQUE DE AEROLÍNEAS ---");
        int pasajeros = 4;

        // Movilidad reducida (3), Business (2), Mortales (1) [cite: 50]
        embarque.AcolarPrioridad(701, 1); // Mortal 1
        embarque.AcolarPrioridad(702, 2); // Business 1
        embarque.AcolarPrioridad(703, 2); // Business 2 (Llega después de Business 1) [cite: 51]
        embarque.AcolarPrioridad(704, 3); // Movilidad Reducida

        for (int i = 0; i < pasajeros; i++) {
            System.out.println("Sube al avión: Pasajero ID " + embarque.Primero() +
                    " (Grupo Prioritario: " + embarque.Prioridad() + ")");
            embarque.Desacolar();
        }
    }
}
