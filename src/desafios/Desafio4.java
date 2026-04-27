package desafios;

import ImplementacionesEstaticas.Bloque3.Implementacion.Estrategia_Conjuntos;
import ImplementacionesEstaticas.Bloque3.Interface.ConjuntosTDA;

public class Desafio4 {
    public ConjuntosTDA diferenciaSimetrica(ConjuntosTDA a, ConjuntosTDA b) {
        ConjuntosTDA resultado = new Estrategia_Conjuntos();
        resultado.InicializarConjunto();

        ConjuntosTDA copiaA = clonar(a);
        ConjuntosTDA copiaB = clonar(b);

        while (!copiaA.ConjuntoVacio()) {
            int elemento = copiaA.Elegir();
            if (!b.Pertenece(elemento)) {
                resultado.Agregar(elemento);
            }
            copiaA.Sacar(elemento);
        }

        while (!copiaB.ConjuntoVacio()) {
            int elemento = copiaB.Elegir();
            if (!a.Pertenece(elemento)) {
                resultado.Agregar(elemento);
            }
            copiaB.Sacar(elemento);
        }

        return resultado;
    }

    private ConjuntosTDA clonar(ConjuntosTDA origen) {
        ConjuntosTDA destino = new Estrategia_Conjuntos();
        ConjuntosTDA aux = new Estrategia_Conjuntos();
        destino.InicializarConjunto();
        aux.InicializarConjunto();

        while (!origen.ConjuntoVacio()) {
            int x = origen.Elegir();
            aux.Agregar(x);
            origen.Sacar(x);
        }

        while (!aux.ConjuntoVacio()) {
            int x = aux.Elegir();
            origen.Agregar(x);
            destino.Agregar(x);
            aux.Sacar(x);
        }

        return destino;
    }
}
