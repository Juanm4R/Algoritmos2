package ImplementacionesEstaticas.Bloque3.Implementacion;
import ImplementacionesEstaticas.Bloque3.Interface.ConjuntosTDA;

public class Estrategia_Conjuntos implements ConjuntosTDA {
    // Constante para el tamaño máximo
    private static final int MAX = 100;
    // Arreglo descriptivo y contador
    private int[] elementos;
    private int cant;

    @Override
    public void InicializarConjunto() {
        elementos = new int[MAX]; // Instanciamos el arreglo
        cant = 0;                 // El conjunto arranca vacío
    }

    @Override
    public void Agregar(int x) {
        // Validamos que haya espacio Y que no pertenezca (cero duplicados)
        if (cant < MAX && !Pertenece(x)) {
            elementos[cant] = x;
            cant++;
        }
    }

    @Override
    public void Sacar(int x) {
        int i = 0;
        // Buscamos la posición del elemento
        while (i < cant && elementos[i] != x) {
            i++;
        }
        // Si lo encontramos, pisamos con el último y achicamos la cantidad
        if (i < cant) {
            elementos[i] = elementos[cant - 1];
            cant--;
        }
    }

    @Override
    public int Elegir() {
        // Devuelve el último físicamente guardado (arbitrario)
        return elementos[cant - 1];
    }

    @Override
    public boolean Pertenece(int x) {
        int i = 0;
        // Recorremos mientras no lleguemos al final y no encontremos el elemento
        while (i < cant && elementos[i] != x) {
            i++;
        }
        return i < cant; // True si cortó el while antes de llegar al límite 'cant'
    }

    @Override
    public boolean ConjuntoVacio() {
        return cant == 0;
    }
}
