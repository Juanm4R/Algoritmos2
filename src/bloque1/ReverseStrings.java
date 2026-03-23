package bloque1;
import bloque1.Implementacion.Estrategia1;
import interfaces.TDAs;

public class ReverseStrings {
    public static void ejecutar(String palabra) {
        TDAs pila = new Estrategia1();
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