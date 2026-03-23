package bloque1;
import Implementacion.Estrategia1;
import interfaces.TDAs;

public class HistorialDeNavegacion {
    private TDAs historial = new Estrategia1();

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


