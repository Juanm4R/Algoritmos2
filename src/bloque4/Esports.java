package bloque4;
import bloque4.Interfaz.DiccionarioSimple;


public class Esports  implements DiccionarioSimple{
    private int[] claves;
    private int[] valores;
    private int cantidad;

    @Override
    public void InicializarDiccionario() {
        claves = new int[100];
        valores = new int[100];
        cantidad = 0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int i = 0;
        // Buscamos si la clave ya existe
        while (i < cantidad && claves[i] != clave) {
            i++;
        }
        if (i < cantidad) {
            // Si existe, actualizamos el valor (el puntaje)
            valores[i] = valor;
        } else {
            // Si no existe, se agrega al final
            claves[cantidad] = clave;
            valores[cantidad] = valor;
            cantidad++;
        }
    }

    @Override
    public void Eliminar(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                // Movemos el último al lugar del eliminado para no dejar huecos
                claves[i] = claves[cantidad - 1];
                valores[i] = valores[cantidad - 1];
                cantidad--;
                break;
            }
        }
    }

    @Override
    public int[] Claves() {
        int[] aux = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            aux[i] = claves[i];
        }
        return aux;
    }


}
