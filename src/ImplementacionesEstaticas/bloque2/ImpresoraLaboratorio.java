package ImplementacionesEstaticas.bloque2;

import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_2_Cola;
import ImplementacionesEstaticas.bloque2.Interface.ColaTDA;

public class ImpresoraLaboratorio {
    private ColaTDA spooler;

    public ImpresoraLaboratorio() {
        spooler = new Estrategia_2_Cola();
        spooler.InicializarCola();
    }

    public void simular() {
        System.out.println("\n--- 2. IMPRESORA DEL LABORATORIO ---");
        int cantidadArchivos = 5;

        spooler.Acolar(55); // TP1.pdf
        spooler.Acolar(56); // Resumen.docx
        spooler.Acolar(57); // Imagen.png
        spooler.Acolar(58); // Notas.txt
        spooler.Acolar(59); // CheatSheet.pdf

        for (int i = 0; i < cantidadArchivos; i++) {
            System.out.println("Imprimiendo documento " + (i+1) + " de " + cantidadArchivos + ": ID " + spooler.Primero());
            spooler.Desacolar();
        }
    }
}