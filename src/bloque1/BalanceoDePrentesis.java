package bloque1;
import bloque1.Implementacion.Estrategia1;
import interfaces.TDAs;

public class BalanceoDePrentesis {
    public static boolean chequear(String expresion) {
        TDAs pila = new Estrategia1();
        pila.InicializarPila();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            if (c == '(') {
                pila.Apilar(1);
            } else if (c == ')') {
                if (pila.PilaVacia()) return false;
                pila.Desapilar();
            }
        }
        return pila.PilaVacia();
    }
}
