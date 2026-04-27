package ImplementacionesEstaticas.bloque2;

import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_1_Cola_Prioridad;
import ImplementacionesEstaticas.bloque2.Interface.ColaPrioridadTDA;

public class DistribucionTickets {
    private ColaPrioridadTDA helpDesk;

    public DistribucionTickets() {
        helpDesk = new Estrategia_1_Cola_Prioridad();
        helpDesk.InicializarCola();
    }

    public void simular() {
        System.out.println("\n--- 8. DISTRIBUCIÓN DE TICKETS IT ---");
        int totalTickets = 2;

        // No me gusta el fondo (0) vs Se rompió el server (999) [cite: 52]
        helpDesk.AcolarPrioridad(404, 999);
        helpDesk.AcolarPrioridad(123, 0);

        for (int i = 0; i < totalTickets; i++) {
            System.out.println("Resolviendo Ticket ID: " + helpDesk.Primero() +
                    " (Nivel Urgencia: " + helpDesk.Prioridad() + ")");
            helpDesk.Desacolar();
        }
    }
}