package bloque1.Implementacion;
import bloque1.interfaces.Pila;

public class Estrategia2 implements Pila {
    private int[] arreglo;
    private int indice;

    @Override
    public void InicializarPila() {
        arreglo = new int[100];
        indice = 0;
    }

    @Override
    public void Apilar(int x) {
        for (int i = indice; i > 0; i--) {
            arreglo[i] = arreglo[i - 1];
        }
        arreglo[0] = x;
        indice++;
    }

    @Override
    public void Desapilar() {
        if (indice > 0) {
            for (int i = 0; i < indice - 1; i++) {
                arreglo[i] = arreglo[i + 1];
            }
            indice--;
        }
    }

    @Override
    public int Tope() {
        return arreglo[0];
    }

    @Override
    public boolean PilaVacia() {
        return (indice == 0);
    }
}
