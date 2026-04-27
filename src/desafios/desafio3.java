package desafios;

import ImplementacionesDinamicas.bloque1.Implementacion.PilaDinamica;
import ImplementacionesDinamicas.bloque1.Interface.PilaTDA;
import ImplementacionesEstaticas.Bloque3.Implementacion.Estrategia_Conjuntos;
import ImplementacionesEstaticas.Bloque3.Interface.ConjuntosTDA;

public class desafio3 {

    public static boolean esUnica(PilaTDA p) {
        PilaTDA aux = new PilaDinamica();
        ConjuntosTDA conjunto = new Estrategia_Conjuntos();

        aux.InicializarPila();
        conjunto.InicializarConjunto();

        boolean esUnica = true;

        while (!p.PilaVacia()) {
            int x = p.Tope();
            p.Desapilar();

            if (conjunto.Pertenece(x)) {
                esUnica = false;
            } else {
                conjunto.Agregar(x);
            }

            aux.Apilar(x);
        }

        while (!aux.PilaVacia()) {
            p.Apilar(aux.Tope());
            aux.Desapilar();
        }

        return esUnica;
    }
}
