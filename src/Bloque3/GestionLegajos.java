package Bloque3;
import Bloque3.Interface.ConjuntosTDA;
import Bloque3.Implementacion.Estrategia_Conjuntos;

public class GestionLegajos {
    private ConjuntosTDA legajos;

    public GestionLegajos() {
        legajos = new Estrategia_Conjuntos();
        legajos.InicializarConjunto();
    }

    public void simular() {
        System.out.println("--- 5. GESTIÓN DE LEGAJOS ---");

        int legajoAlumno = 112233; // ID único del alumno

        System.out.println("El alumno se anota a la Licenciatura en Gestión de TI.");
        legajos.Agregar(legajoAlumno);
        System.out.println("✅ Legajo " + legajoAlumno + " registrado en la base de datos general.");

        System.out.println("Meses después, el mismo alumno se anota a la Tecnicatura en Desarrollo de Software.");
        System.out.println("El sistema intenta registrar el legajo " + legajoAlumno + " de nuevo...");

        // El sistema intenta agregarlo de nuevo al conjunto general
        legajos.Agregar(legajoAlumno);

        System.out.println("Respuesta de Modelado: El sistema NO duplica el ID porque la operación Agregar() del TDA Conjunto verifica automáticamente con Pertenece() antes de insertar. El tamaño de la base de datos se mantiene intacto.");
        System.out.println();
    }
}