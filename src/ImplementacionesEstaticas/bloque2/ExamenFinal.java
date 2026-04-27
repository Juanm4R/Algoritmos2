package ImplementacionesEstaticas.bloque2;

import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_1_Cola_Prioridad;
import ImplementacionesEstaticas.bloque2.Interface.ColaPrioridadTDA;

public class ExamenFinal {
    private ColaPrioridadTDA examen;

    public ExamenFinal() {
        examen = new Estrategia_1_Cola_Prioridad();
        examen.InicializarCola();
    }

    public void simular() {
        System.out.println("\n--- 4. EXAMEN FINAL ---");
        int inscriptos = 2;

        examen.AcolarPrioridad(800, 5);  // Regular
        examen.AcolarPrioridad(830, 10); // Promocionado

        for (int i = 0; i < inscriptos; i++) {
            System.out.println("Alumno llamado a rendir: ID " + examen.Primero());
            examen.Desacolar();
        }
    }
}