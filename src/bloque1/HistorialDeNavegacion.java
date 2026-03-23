package bloque1;
import bloque1.Implementacion.Estrategia1;
import bloque1.interfaces.TDAs;

public class HistorialDeNavegacion {
    private TDAs historial = new Estrategia1();
    public HistorialDeNavegacion() {
        historial.InicializarPila();

    }
    public void navegar(int idPagina) {
        historial.Apilar(idPagina);
        System.out.println("Visitando página ID: " + idPagina);
    }

    public void retroceder() {
        if (!historial.PilaVacia()) {
            historial.Desapilar(); // Sacamos la página donde estamos
            if (!historial.PilaVacia()) {
                System.out.println("Ahora estás en: " + historial.Tope());
            }
        }
    }
}


