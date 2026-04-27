package ImplementacionesEstaticas.bloque1;
import ImplementacionesEstaticas.bloque1.Implementacion.Estrategia1;
import ImplementacionesEstaticas.bloque1.interfaces.Pila;

public class ReverseStrings {
    public static void ejecutar(String palabra) {
        Pila pila = new Estrategia1();
        pila.InicializarPila();


        for (int i = 0; i < palabra.length(); i++) {
            pila.Apilar((int) palabra.charAt(i));
        }


        System.out.print("Resultado: ");
        while (!pila.PilaVacia()) {
            System.out.print((char) pila.Tope());
            pila.Desapilar();
        }
    }
}