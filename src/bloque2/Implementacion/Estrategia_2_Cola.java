package bloque2.Implementacion;
import bloque2.Interface.ColaTDA;

public class Estrategia_2_Cola implements ColaTDA {

    // Tamaño máximo estático en memoria
    private static final int MAX = 100;
    private int[] elementos;

    // Solo necesitamos saber dónde está el primero y cuántos elementos hay.
    // Con esos dos datos, podemos calcular matemáticamente dónde debe ir el último.
    private int indicePrimero;
    private int cantidad;

    @Override
    public void InicializarCola() {
        elementos = new int[MAX];
        indicePrimero = 0;
        cantidad = 0;
    }

    @Override
    public void Acolar(int x) {
        // Validamos que la cola no esté físicamente llena
        if (cantidad < MAX) {
            // MAGIA MATEMÁTICA: Calculamos el índice donde insertaremos.
            // Si el arreglo se "termina", el '%' hace que vuelva a empezar desde el índice 0.
            int indiceUltimo = (indicePrimero + cantidad) % MAX;

            elementos[indiceUltimo] = x;
            cantidad++;
        }
    }

    @Override
    public void Desacolar() {
        // Solo podemos sacar a alguien si hay gente en la fila
        if (!ColaVacia()) {
            // Avanzamos el puntero del primero hacia la derecha.
            // Si estaba en la posición 99 y el MAX es 100, (99+1)%100 = 0. ¡Da la vuelta!
            indicePrimero = (indicePrimero + 1) % MAX;
            cantidad--;
            // Nota: El dato viejo sigue en memoria, pero es ignorado.
            // Se sobrescribirá cuando el índice de Acolar dé la vuelta.
        }
    }

    @Override
    public int Primero() {
        // Devolvemos el elemento al que apunta nuestro índice frontal
        return elementos[indicePrimero];
    }

    @Override
    public boolean ColaVacia() {
        return cantidad == 0;
    }
}