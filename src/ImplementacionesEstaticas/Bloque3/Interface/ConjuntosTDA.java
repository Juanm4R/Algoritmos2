package ImplementacionesEstaticas.Bloque3.Interface;
public interface ConjuntosTDA {
    // Inicializa la estructura (ej: instanciar el arreglo y variables)
    void InicializarConjunto();

    // Agrega un elemento garantizando que no haya duplicados
    void Agregar(int x);

    // Elimina el elemento del conjunto si es que existe
    void Sacar(int x);

    // Devuelve un elemento arbitrario del conjunto
    int Elegir();

    // Chequea si un elemento específico ya está en el conjunto
    boolean Pertenece(int x);

    // Verifica si el conjunto no tiene elementos
    boolean ConjuntoVacio();
}
