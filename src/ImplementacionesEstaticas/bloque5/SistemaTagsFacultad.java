package ImplementacionesEstaticas.bloque5;
import ImplementacionesEstaticas.bloque4.Interfaz.DiccionarioMultiple;
import ImplementacionesEstaticas.bloque4.Implementacion.DiccionarioMultipleEstatico;

public class SistemaTagsFacultad {
    // Nuestro mapa de Carreras -> Conjunto de Materias
    private DiccionarioMultiple planDeEstudios;

    public SistemaTagsFacultad() {
        // Instanciamos el diccionario
        planDeEstudios = new DiccionarioMultipleEstatico();
        planDeEstudios.InicializarDiccionario();
    }

    public void simular() {
        System.out.println("--- 2. SISTEMA DE TAGS DE FACULTAD ---");

        int idCarreraSoftware = 1121;
        int idAlgoritmos1 = 101;
        int idAlgoritmos2 = 102;

        System.out.println("Configurando el plan de la carrera: " + idCarreraSoftware);

        // 1. AGREGAMOS MATERIAS AL PLAN
        planDeEstudios.Agregar(idCarreraSoftware, idAlgoritmos1);
        planDeEstudios.Agregar(idCarreraSoftware, idAlgoritmos2);
        System.out.println("Se agregaron Algoritmos I (101) y Algoritmos II (102).");

        // 2. INTENTO DE DUPLICACIÓN (Acá brilla el TDA Conjunto)
        System.out.println("Intentando agregar Algoritmos I (101) de nuevo...");
        planDeEstudios.Agregar(idCarreraSoftware, idAlgoritmos1);

        System.out.println("Por qué usamos Diccionario Múltiple:");
        System.out.println("Como el 'Valor' asociado a la carrera es internamente un CONJUNTO, el TDA verifica automáticamente si la materia 101 ya Pertenece(). Como ya está, la ignora y evita duplicados en el plan de estudios.");
        System.out.println();
    }
}
