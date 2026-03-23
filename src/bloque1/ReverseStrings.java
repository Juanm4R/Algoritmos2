package bloque1;
import Implementacion.Estrategia1;
import interfaces.TDAs;

public class ReverseStrings {
    public static void ejecutar(String palabra) {
        TDAs pila = new Estrategia1();
        pila.InicializarPila();

        // PASO 1: Metemos cada letra en la pila
        for (int i = 0; i < palabra.length(); i++) {
            pila.Apilar((int) palabra.charAt(i));
        }

        // PASO 2: Las sacamos. La última en entrar ('S') es la primera en salir.
        System.out.print("Resultado: ");
        while (!pila.PilaVacia()) {
            System.out.print((char) pila.Tope());
            pila.Desapilar();
        }
    }
}