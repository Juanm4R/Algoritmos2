package bloque1;
import Implementacion.Estrategia1;
import interfaces.TDAs;

public class CallStack {
    public static void simular() {
        TDAs stack = new Estrategia1();
        stack.InicializarPila();

        stack.Apilar(10); // Main entra a la pila
        stack.Apilar(20); // Promedio entra a la pila
        stack.Apilar(30); // Sumar entra a la pila (Tope actual)

        System.out.println("Función en ejecución: " + stack.Tope());
        stack.Desapilar(); // Sumar termina, volvemos a Promedio
        System.out.println("Volviendo a función: " + stack.Tope());
    }
}