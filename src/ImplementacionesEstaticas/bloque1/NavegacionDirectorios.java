package ImplementacionesEstaticas.bloque1;
import ImplementacionesEstaticas.bloque1.Implementacion.Estrategia1;
import ImplementacionesEstaticas.bloque1.interfaces.Pila;

public class NavegacionDirectorios {
    private Pila ruta = new Estrategia1();

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