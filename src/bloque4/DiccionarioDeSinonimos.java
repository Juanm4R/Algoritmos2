package bloque4;

import bloque4.Interfaz.DiccionarioMultiple;

public class DiccionarioDeSinonimos implements DiccionarioMultiple {
    private static final int MAX_CLAVES = 100;
    private static final int MAX_VALOR = 100;

    private int[] claves;
    private int[][] valores;
    private int[] cantValores;
    private int cantClaves;


    @Override
    public void InicializarDiccionario() {
        
    }

    @Override
    public void Agregar(int clave, int valor) {

    }

    @Override
    public void EliminarValor(int clave, int valor) {

    }

    @Override
    public void Eliminar(int clave) {

    }

    @Override
    public int[] Recuperar(int clave) {
        return new int[0];
    }

    @Override
    public int[] Claves() {
        return new int[0];
    }
}
