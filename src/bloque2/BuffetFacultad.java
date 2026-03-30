package bloque2;

import bloque2.Implementacion.Estrategia_2_Cola;
import bloque2.Interface.ColaTDA;

public class BuffetFacultad {
    private ColaTDA filaPancho;

    public BuffetFacultad() {
        // Fila para el sanguchito de milanesa, sin colados [cite: 46, 47]
        filaPancho = new Estrategia_2_Cola();
        filaPancho.InicializarCola();
    }

    public void simular() {
        System.out.println("--- 5. BUFFET DE LA FACULTAD ---");
        int cantidadAlumnos = 3;

        filaPancho.Acolar(901); // Llega primero
        filaPancho.Acolar(902); // Llega segundo
        filaPancho.Acolar(903); // El "vibe coder" llega último y va al final [cite: 47]

        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Entregando sanguchito a: Alumno ID " + filaPancho.Primero());
            filaPancho.Desacolar();
        }
    }
}