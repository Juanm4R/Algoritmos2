package desafios;

import ImplementacionesDinamicas.bloque1.Implementacion.PilaDinamica;
import ImplementacionesDinamicas.bloque1.Interface.PilaTDA;
import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_2_Cola;
import ImplementacionesEstaticas.bloque2.Interface.ColaTDA;

public class Desafio1 {

    public static boolean desafio1(ColaTDA origen) {
        ColaTDA copiaIdentica = new Estrategia_2_Cola();
        PilaTDA copiaInvertida = new PilaDinamica();
        ColaTDA aux = new Estrategia_2_Cola();

        copiaIdentica.InicializarCola();
        copiaInvertida.InicializarPila();
        aux.InicializarCola();

        while (!origen.ColaVacia()) {
            int x = origen.Primero();
            copiaIdentica.Acolar(x);
            copiaInvertida.Apilar(x);
            aux.Acolar(x);
            origen.Desacolar();
        }

        while (!aux.ColaVacia()) {
            origen.Acolar(aux.Primero());
            aux.Desacolar();
        }

        boolean coinciden = true;

        while (!copiaIdentica.ColaVacia() && coinciden) {
            if (copiaIdentica.Primero() != copiaInvertida.Tope()) {
                coinciden = false;
            }
            copiaIdentica.Desacolar();
            copiaInvertida.Desapilar();
        }

        return coinciden;
    }
}
