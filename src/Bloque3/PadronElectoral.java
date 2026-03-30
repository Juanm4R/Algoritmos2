package Bloque3;
import Bloque3.Interface.ConjuntosTDA;
import Bloque3.Implementacion.Estrategia_Conjuntos;

public class PadronElectoral {
    private ConjuntosTDA c;

    public PadronElectoral() {
        c = new Estrategia_Conjuntos(); // Instanciamos tu TDA (antes le decías ConjuntoA)
        c.InicializarConjunto();
    }

    public void simular() {
        System.out.println("--- 1. PADRÓN ELECTORAL ---");
        int persona = 1003;

        // Probemos qué pasa si intentamos votar por primera vez
        System.out.println("La persona " + persona + " intenta votar...");
        if(c.Pertenece(persona)){
            System.out.println("RECHAZADO: La persona ya ha votado.");
        } else {
            c.Agregar(persona);
            System.out.println("La persona ha votado.");
        }

        // Si intentamos de nuevo, ahora sí debería bloquearlo
        System.out.println("La persona " + persona + " intenta votar de nuevo...");
        if(c.Pertenece(persona)){
            System.out.println("RECHAZADO: La persona ya ha votado.");
        }
        System.out.println();
    }
}