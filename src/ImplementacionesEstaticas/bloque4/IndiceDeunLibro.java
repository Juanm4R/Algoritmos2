package ImplementacionesEstaticas.bloque4;

import ImplementacionesEstaticas.bloque4.Interfaz.DiccionarioMultiple;

public class IndiceDeunLibro implements DiccionarioMultiple {

    private static final int MAX_CLAVES = 100;
    private static final int MAX_VALORES = 100;

    private int[] claves;
    private int[][] valores;
    private int[] cantValores;
    private int cantidadClaves;

    @Override
    public void InicializarDiccionario() {
        claves = new int[MAX_CLAVES];
        valores = new int[MAX_CLAVES][MAX_VALORES];
        cantValores = new int[MAX_CLAVES];
        cantidadClaves = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int posClave = buscarClave(clave);

        if (posClave == -1) { // Si la palabra no está en el índice
            if (cantidadClaves < MAX_CLAVES) {
                claves[cantidadClaves] = clave;
                valores[cantidadClaves][0] = valor;
                cantValores[cantidadClaves] = 1;
                cantidadClaves++;
            }
        } else { // Si la palabra ya existe, agregamos la nueva página
            // Verificamos que la página no esté repetida y haya espacio
            if (!existeValor(posClave, valor) && cantValores[posClave] < MAX_VALORES) {
                valores[posClave][cantValores[posClave]] = valor;
                cantValores[posClave]++;
            }
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int posClave = buscarClave(clave);

        if (posClave != -1) {
            int posValor = buscarValor(posClave, valor);

            if (posValor != -1) {
                // Estrategia: Pisamos con el último valor para no dejar huecos
                valores[posClave][posValor] = valores[posClave][cantValores[posClave] - 1];
                cantValores[posClave]--;

                if (cantValores[posClave] == 0) {
                    Eliminar(clave);
                }
            }
        }
    }

    @Override
    public void Eliminar(int clave) {
        int posClave = buscarClave(clave);
        if (posClave != -1) {
            // Pisamos la clave con la última del arreglo para mantener alineación
            claves[posClave] = claves[cantidadClaves - 1];
            valores[posClave] = valores[cantidadClaves - 1];
            cantValores[posClave] = cantValores[cantidadClaves - 1];
            cantidadClaves--;
        }
    }


    @Override
    public int[] Recuperar(int clave) {
        // 1. Buscamos la posición de la palabra (clave) en el arreglo [cite: 171]
        int posClave = buscarClave(clave);

        // 2. Si no existe la palabra, devolvemos un arreglo vacío [cite: 22, 162]
        if (posClave == -1) {
            return new int[0];
        }

        // 3. Creamos un arreglo del tamaño exacto de páginas encontradas [cite: 197]
        int[] aux = new int[cantValores[posClave]];

        // 4. Copiamos las páginas de la matriz al arreglo que verá el usuario [cite: 203]
        for (int i = 0; i < cantValores[posClave]; i++) {
            aux[i] = valores[posClave][i];
        }

        return aux;
    }

    @Override
    public int[] Claves() {
        // Retornamos todas las palabras que tiene el índice actualmente [cite: 89, 152]
        int[] aux = new int[cantidadClaves];
        for (int i = 0; i < cantidadClaves; i++) {
            aux[i] = claves[i];
        }
        return aux;
    }

    // --- EL MOTOR: Búsqueda Lineal ---
    private int buscarClave(int clave) {
        int i = 0;
        // Recorremos mientras no nos pasemos del tope y no encontremos la clave [cite: 137, 180]
        while (i < cantidadClaves && claves[i] != clave) {
            i++;
        }

        // Si i es menor al tope, significa que lo encontramos en esa posición [cite: 179]
        if (i < cantidadClaves) {
            return i;
        }

        return -1; // No está la palabra en el libro
    }


    // Este método busca la posición de una página específica dentro de una palabra
    private int buscarValor(int posClave, int valor) {
        int i = 0;
        // Recorremos el arreglo de valores de esa clave específica
        while (i < cantValores[posClave] && valores[posClave][i] != valor) {
            i++;
        }

        if (i < cantValores[posClave]) {
            return i; // Encontramos la página en esta posición
        }
        return -1; // La página no está registrada para esta palabra
    }

    // Este método devuelve true o false si la página ya existe
    private boolean existeValor(int posClave, int valor) {
        // Si buscarValor devuelve algo distinto a -1, es porque ya existe
        return buscarValor(posClave, valor) != -1;
    }
}