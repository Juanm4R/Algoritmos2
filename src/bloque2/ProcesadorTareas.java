package bloque2;

import bloque2.Implementacion.Estrategia_1_Cola_Prioridad;
import bloque2.Interface.ColaPrioridadTDA;

public class ProcesadorTareas {
    private ColaPrioridadTDA scheduler;

    public ProcesadorTareas() {
        scheduler = new Estrategia_1_Cola_Prioridad();
        scheduler.InicializarCola();
    }

    public void simular() {
        System.out.println("\n--- 6. PROCESADOR DE TAREAS (OS) ---");
        int procesos = 2;

        // Spotify tiene prioridad 10
        scheduler.AcolarPrioridad(100, 10);
        // Proceso del sistema operativo tiene prioridad 50
        scheduler.AcolarPrioridad(1, 50);

        for (int i = 0; i < procesos; i++) {
            System.out.println("CPU Ejecutando PID: " + scheduler.Primero() +
                    " (Prioridad: " + scheduler.Prioridad() + ")");
            scheduler.Desacolar();
        }
    }
}