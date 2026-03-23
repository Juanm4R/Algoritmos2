package bloque1;
import bloque1.Implementacion.Estrategia1;
import bloque1.interfaces.TDAs;

public class CallStack {
    public static void simular() {
        TDAs stack = new Estrategia1();
        stack.InicializarPila();

        stack.Apilar(10);
        stack.Apilar(20);
        stack.Apilar(30);

        System.out.println("Función en ejecución: " + stack.Tope());
        stack.Desapilar();
        System.out.println("Volviendo a función: " + stack.Tope());
    }
}