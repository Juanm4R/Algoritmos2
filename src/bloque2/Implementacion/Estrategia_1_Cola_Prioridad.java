package bloque2.Implementacion;
import bloque2.Interface.ColaPrioridadTDA;

public class Estrategia_1_Cola_Prioridad implements ColaPrioridadTDA {
    private static final int MAX = 100;
    private int[] elementos;
    private int[] prioridades;
    private int cantidad;

    @Override
    public void InicializarCola() {
        elementos = new int[MAX];
        prioridades = new int[MAX];
        cantidad = 0;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        if (cantidad < MAX) {
            // Guardamos al final de los arreglos (lógica simple de inserción)
            elementos[cantidad] = x;
            prioridades[cantidad] = prioridad;
            cantidad++;
        }
    }

    //Metodo privado auxiliar para encontrar el índice del elemento más urgente
    private int obtenerIndiceMayorPrioridad() {
        int indiceMayor = 0;
        // Buscamos el mayor valor de prioridad, recordando que: Mayor valor = Mayor prioridad
        for (int i = 1; i < cantidad; i++) {
            if (prioridades[i] > prioridades[indiceMayor]) {
                indiceMayor = i;
            }
        }
        return indiceMayor;
    }

    @Override
    public void Desacolar() {
        if (!ColaVacia()) {
            int indiceMayor = obtenerIndiceMayorPrioridad();
            // Para eliminar, pisamos el elemento de mayor prioridad con el ÚLTIMO elemento ingresado
            // Esto evita tener que desplazar todos los elementos (como en la Estrategia 2 de Pilas)
            elementos[indiceMayor] = elementos[cantidad - 1];
            prioridades[indiceMayor] = prioridades[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public int Primero() {
        return elementos[obtenerIndiceMayorPrioridad()];
    }

    @Override
    public int Prioridad() {
        return prioridades[obtenerIndiceMayorPrioridad()];
    }

    @Override
    public boolean ColaVacia() {
        return cantidad == 0;
    }
}

