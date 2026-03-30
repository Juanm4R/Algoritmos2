package bloque4.Interfaz;

public interface DiccionarioSimple {
    void InicializarDiccionario();
    void Agregar(int clave, int valor);
    void Eliminar (int clave);
    int[] Claves();

}
