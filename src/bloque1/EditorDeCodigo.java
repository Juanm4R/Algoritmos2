package bloque1;
import bloque1.Implementacion.Estrategia1;
import bloque1.interfaces.TDAs;

public class EditorDeCodigo {

        private TDAs historial = new Estrategia1();
        public EditorDeCodigo() {
        historial.InicializarPila();
    }

        public void realizarAccion(int codigoAccion) {
            historial.Apilar(codigoAccion);
            System.out.println("Acción ejecutada.");
        }

        public void deshacer() {
            if (!historial.PilaVacia()) {
                historial.Desapilar();
                if (!historial.PilaVacia()) {
                    System.out.println("Restaurado al estado: " + historial.Tope());
                }
            }
        }
    }


