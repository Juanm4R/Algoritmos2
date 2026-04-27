package ImplementacionesEstaticas.Bloque3;
import ImplementacionesEstaticas.Bloque3.Interface.ConjuntosTDA;
import ImplementacionesEstaticas.Bloque3.Implementacion.Estrategia_Conjuntos;

public class FiltroDeSpam {
    private ConjuntosTDA blacklist;

    public FiltroDeSpam() {
        blacklist = new Estrategia_Conjuntos();
        blacklist.InicializarConjunto();
    }

    public void simular() {
        System.out.println("--- 3. FILTRO DE SPAM (BLACKLIST) ---");

        // Agregamos los IDs de las palabras prohibidas a la blacklist
        blacklist.Agregar(101); // "gana"
        blacklist.Agregar(102); // "crypto"
        blacklist.Agregar(103); // "premio"

        // Simulamos el array mail: {"compra", "rifas", "y", "gana", "un", "auto"}
        // Traducido a IDs numéricos:
        int[] mail = {50, 51, 52, 101, 53, 54};

        System.out.println("Analizando mail entrante...");
        boolean esSpam = false;

        for (int i = 0; i < mail.length; i++){
            // Usamos Pertenece() tal como lo pensaste en tu código
            if(blacklist.Pertenece(mail[i])){
                System.out.println("ALERTA: El mail contiene una palabra prohibida (Código: " + mail[i] + ").");
                esSpam = true;
            }
        }

        if (!esSpam) {
            System.out.println("El mail pasó el filtro correctamente.");
        }
        System.out.println();
    }
}