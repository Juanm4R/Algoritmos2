package bloque4;

import bloque4.Interfaz.DiccionarioMultiple;

public class TraductorDeIdiomas implements DiccionarioMultiple {
    private static final int MAX_CLAVES = 100;
    private static final int MAX_VALORES = 100;

    private int[] claves;
    private int[][] valores;
    private int[] cantValores;
    private int cantClaves;

    @Override
    public void InicializarDiccionario() {
        claves = new int [MAX_CLAVES];
        valores = new int [MAX_CLAVES][MAX_VALORES];
        cantValores = new int[MAX_CLAVES];
        cantClaves = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int posClave =  obtenerPosicionClave(clave);
        if (posClave == -1) {
            claves[cantClaves] = clave;
            valores[cantClaves][0] = valor;
            cantValores[cantClaves]++;
            cantClaves++;
        }
        else {
            valores[posClave][cantValores[posClave]] = valor;
            cantValores[posClave]++;
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int posClave =  obtenerPosicionClave(clave);
        if (posClave != -1) {
            for (int i = 0; i < cantValores[posClave]; i++){
                if (valores[posClave][i] == valor){
                    valores[posClave][i] = valores[posClave][cantValores[posClave]-1];
                    cantValores[posClave]--;
                }
            }
        }
    }

    @Override
    public void Eliminar(int clave) {
        int posClave =  obtenerPosicionClave(clave);
        if (posClave != -1) {
            // 1. Identificamos el índice de la última clave registrada
            int posUltimaClave = cantClaves - 1;

            // 2. Pisamos la clave a borrar con la última clave
            claves[posClave] = claves[posUltimaClave];

            // 3. Pisamos la cantidad de valores de la clave a borrar con la cantidad de la última
            cantValores[posClave] = cantValores[posUltimaClave];

            // 4. Copiamos todos los valores de la última clave a la fila que quedó vacante
            for (int i = 0; i < cantValores[posUltimaClave]; i++) {
                valores[posClave][i] = valores[posUltimaClave][i];
            }

            // 5. Achicamos el contador general de claves (así la última original "desaparece")
            cantClaves--;
        }
    }

    @Override
    public int[] Recuperar(int clave) {
        int posClave = obtenerPosicionClave(clave);
        if (posClave != -1) {
            int[] valoresNuevos = new int[cantValores[posClave]];
            for (int i = 0; i < cantValores[posClave]; i++){
                valoresNuevos[i] = valores[posClave][i];
            }
            return valoresNuevos;
        }
        return new int[0];
    }

    @Override
    public int[] Claves() {
        int[] clavesAMostrar = new int [cantClaves];
        for (int i = 0; i < cantClaves; i++) {
            clavesAMostrar[i] = claves[i];
        }
        return clavesAMostrar;
    }

    private int obtenerPosicionClave(int clave) {
        for (int i = 0; i < cantClaves; i++) {
            if (claves[i] == clave) {
                return i;
            }
        }
        return -1;
    }
}
