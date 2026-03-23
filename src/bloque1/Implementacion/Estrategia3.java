package bloque1.Implementacion;
import interfaces.TDAs;

public class Estrategia3 implements TDAs {
    private int[] arreglo;

    @Override
    public void InicializarPila() {
        arreglo = new int[101];
        arreglo[0] = 0;
    }

    @Override
    public void Apilar(int x) {
        int cantidad = arreglo[0];
        arreglo[cantidad + 1] = x;
        arreglo[0] = cantidad + 1;
    }

    @Override
    public void Desapilar() {
        int cantidad = arreglo[0];
        if (cantidad > 0) {
            arreglo[0] = cantidad - 1;
        }
    }

    @Override
    public int Tope() {
        int cantidad = arreglo[0];
        return arreglo[cantidad];
    }

    @Override
    public boolean PilaVacia() {
        return (arreglo[0] == 0);
    }
}