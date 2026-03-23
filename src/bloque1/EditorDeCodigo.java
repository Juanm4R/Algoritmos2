package bloque1;
import Implementacion.Estrategia1;
import interfaces.TDAs;

public class EditorDeCodigo {

        private TDAs historial = new Estrategia1();

        public void realizarAccion(int codigoAccion) {
            historial.Apilar(codigoAccion); // 1. Guardo la acción que acabo de hacer
            System.out.println("Acción ejecutada.");
        }

        public void deshacer() {
            if (!historial.PilaVacia()) {
                historial.Desapilar(); // 2. Borro la última acción (la saco del tope)
                if (!historial.PilaVacia()) {
                    // 3. El nuevo tope es lo que había ANTES del error
                    System.out.println("Restaurado al estado: " + historial.Tope());
                }
            }
        }
    }


