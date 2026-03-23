package bloque1.Implementacion;
import interfaces.TDAs;

public class Estrategia1 implements TDAs {
    private int[] arreglo;
    private int indice;

    @Override
    public void InicializarPila() {
        arreglo = new int[100];
        indice = 0;
    }

    @Override
    public void Apilar(int x) {
        arreglo[indice] = x;
        indice++;
    }

    @Override
    public void Desapilar() {
        if (indice > 0) {
            indice--;
        }
    }

    @Override
    public int Tope() {
        return arreglo[indice - 1];
    }

    @Override
    public boolean PilaVacia() {
        return (indice == 0);
    }
}