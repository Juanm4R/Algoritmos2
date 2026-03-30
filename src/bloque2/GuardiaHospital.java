package bloque2;

import bloque2.Implementacion.Estrategia_1_Cola_Prioridad;
import bloque2.Interface.ColaPrioridadTDA;

public class GuardiaHospital {
    private ColaPrioridadTDA triage;

    public GuardiaHospital() {
        triage = new Estrategia_1_Cola_Prioridad();
        triage.InicializarCola();
    }

    public void simular() {
        System.out.println("\n--- 3. GUARDIA DEL HOSPITAL (TRIAGE) ---");
        int cantidadPacientes = 3;

        triage.AcolarPrioridad(10, 1);   // Pibe con raspón (Prioridad 1)
        triage.AcolarPrioridad(11, 100); // Jubilado con bobazo (Prioridad 100)
        triage.AcolarPrioridad(12, 50);  // Adulto con fractura (Prioridad 50)

        for (int i = 0; i < cantidadPacientes; i++) {
            System.out.println("Atendiendo paciente urgencia " + (i+1) + ": ID " + triage.Primero() +
                    " (Nivel: " + triage.Prioridad() + ")");
            triage.Desacolar();
        }
    }
}