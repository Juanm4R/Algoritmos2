package bloque4;

import bloque4.Interfaz.DiccionarioMultiple;

public class DiccionarioDeSinonimos implements DiccionarioMultiple {
    private static final int MAX_CLAVES = 100;
    private static final int MAX_VALORES = 100;

    private int[] claves;
    private int[][] valores;
    private int[] cantValores;
    private int cantClaves;


    @Override
    public void InicializarDiccionario() {
        claves = new int[MAX_CLAVES];
        valores = new int[MAX_CLAVES][MAX_VALORES];
        cantValores = new int[MAX_CLAVES];
        cantClaves = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int posClave = buscarClave(clave);

        if (posClave == -1) {
            if (cantClaves < MAX_CLAVES) {
                claves[cantClaves] = clave;
                valores[cantClaves][0] = valor;
                cantValores[cantClaves] = 1;
                cantClaves++;
            }
        }
        else {
            if (!existeValor(posClave, valor) && cantValores[posClave] < MAX_VALORES){
                valores[posClave][cantValores[posClave]] = valor;
                cantValores[posClave]++;
            }
        }
    }

    private boolean existeValor(int posClave, int valor) {
        for (int i=0; i<MAX_VALORES; i++){
            if (valor == valores[posClave][i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public void EliminarValor(int clave, int valor) {

    }

    @Override
    public void Eliminar(int clave) {

    }

    @Override
    public int[] Recuperar(int clave) {
        int pos = buscarClave(clave);
        if (pos != -1) {
            // Creamos un arreglo del tamaño justo de sinónimos que tiene esa clave
            int[] aux = new int[cantValores[pos]];
            for (int i = 0; i < cantValores[pos]; i++) {
                aux[i] = valores[pos][i];
            }
            return aux;
        }
        return new int[0]; // Si no existe la clave, devolvemos arreglo vacío
    }

    @Override
    public int[] Claves() {
        int[] aux = new int[cantClaves];
        for (int i = 0; i < cantClaves; i++) {
            aux[i] = claves[i];
        }
        return aux;
    }

    private int buscarClave(int clave) {
        int i = 0;
        while (i < cantClaves && claves[i] != clave) {
            i++;
        }

        if (i == cantClaves) {
            return -1;
        }
        return i;
    }
}
