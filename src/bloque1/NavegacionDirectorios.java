package bloque1;
import Implementacion.Estrategia1;
import interfaces.TDAs;

public class NavegacionDirectorios {
    private TDAs ruta = new Estrategia1();

    public void entrar(int carpetaID) {
        ruta.Apilar(carpetaID);
    }

    public void subirNivel() {
        if (!ruta.PilaVacia()) {
            ruta.Desapilar();
            System.out.println("Carpeta actual: " + (ruta.PilaVacia() ? "C:/" : ruta.Tope()));
        }
    }
}