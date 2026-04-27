package ImplementacionesEstaticas.bloque4.Interfaz;

public interface DiccionarioMultiple {
    void InicializarDiccionario();
    void Agregar(int clave, int valor);
    void EliminarValor(int clave, int valor);
    void Eliminar(int clave);
    int[] Recuperar(int clave);
    int[] Claves();
}