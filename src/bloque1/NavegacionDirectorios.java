package bloque1;
import bloque1.Implementacion.Estrategia1;
import bloque1.interfaces.TDAs;

public class NavegacionDirectorios {
    private TDAs ruta = new Estrategia1();

    public NavegacionDirectorios() {
        ruta.InicializarPila();
    }

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