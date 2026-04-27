package ImplementacionesEstaticas.Bloque3;
import ImplementacionesEstaticas.Bloque3.Interface.ConjuntosTDA;
import ImplementacionesEstaticas.Bloque3.Implementacion.Estrategia_Conjuntos;

//Justificacion a respuesta
//Si llamás a la operación Elegir dos veces seguidas sin haber llamado a Sacar
// en el medio, el TDA te va a devolver exactamente el mismo elemento.
//Esto sucede porque el metódo Elegir te devuelve un valor de forma arbitraria,
// pero no es necesariamente aleatorio en cada ejecución. Hasta que no saques el elemento o
// modifiques la estructura, el puntero o índice interno que usa la implementación suele
// devolver lo mismo.

//Codigo:
public class ElegirVsSacar {
    private ConjuntosTDA materias;

    public ElegirVsSacar() {
        materias = new Estrategia_Conjuntos();
        materias.InicializarConjunto();
    }

    public void simular() {
        System.out.println("--- 6. OPERACIÓN ELEGIR VS SACAR ---");

        materias.Agregar(101); // Algoritmos I
        materias.Agregar(102); // Algoritmos II
        materias.Agregar(103); // Base de Datos

        int elegida1 = materias.Elegir();
        int elegida2 = materias.Elegir();

        System.out.println("Primera llamada a Elegir(): " + elegida1);
        System.out.println("Segunda llamada a Elegir() sin hacer Sacar(): " + elegida2);

        System.out.println();
    }
}