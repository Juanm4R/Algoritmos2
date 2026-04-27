package bloque4.Implementacion;

import Bloque3.Interface.ConjuntosTDA;
import Bloque3.Implementacion.Estrategia_Conjuntos;
import bloque4.Interfaz.DiccionarioMultiple;

public class DiccionarioMultipleEstatico implements DiccionarioMultiple {

    private static final int MAX = 100;
    private int[] claves;
    private ConjuntosTDA[] valores;
    private int cantidad;

    @Override
    public void InicializarDiccionario() {
        claves = new int[MAX];
        valores = new ConjuntosTDA[MAX];
        cantidad = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int pos = Clave2Indice(clave);

        if (pos == -1) {
            if (cantidad < MAX) {
                claves[cantidad] = clave;
                valores[cantidad] = new Estrategia_Conjuntos();
                valores[cantidad].InicializarConjunto();
                valores[cantidad].Agregar(valor);
                cantidad++;
            }
        } else {
            valores[pos].Agregar(valor);
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int pos = Clave2Indice(clave);

        if (pos != -1) {
            valores[pos].Sacar(valor);

            if (valores[pos].ConjuntoVacio()) {
                Eliminar(clave);
            }
        }
    }

    @Override
    public void Eliminar(int clave) {
        int pos = Clave2Indice(clave);

        if (pos != -1) {
            claves[pos] = claves[cantidad - 1];
            valores[pos] = valores[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public int[] Recuperar(int clave) {
        int[] resultado = new int[MAX];
        int i = 0;

        while (i < MAX) {
            resultado[i] = -1;
            i++;
        }

        int pos = Clave2Indice(clave);

        if (pos != -1) {
            ConjuntosTDA aux = valores[pos];
            ConjuntosTDA copia = new Estrategia_Conjuntos();
            copia.InicializarConjunto();

            int j = 0;
            while (!aux.ConjuntoVacio()) {
                int x = aux.Elegir();
                resultado[j] = x;
                copia.Agregar(x);
                aux.Sacar(x);
                j++;
            }

            while (!copia.ConjuntoVacio()) {
                int x = copia.Elegir();
                aux.Agregar(x);
                copia.Sacar(x);
            }
        }

        return resultado;
    }

    @Override
    public int[] Claves() {
        int[] resultado = new int[MAX];
        int i = 0;

        while (i < MAX) {
            resultado[i] = -1;
            i++;
        }

        i = 0;
        while (i < cantidad) {
            resultado[i] = claves[i];
            i++;
        }

        return resultado;
    }

    private int Clave2Indice(int clave) {
        int i = 0;

        while (i < cantidad && claves[i] != clave) {
            i++;
        }

        if (i < cantidad) {
            return i;
        }

        return -1;
    }
}