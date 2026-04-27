package desafios;

import ImplementacionesDinamicas.bloque1.Interface.PilaTDA;
import ImplementacionesEstaticas.bloque2.Interface.ColaTDA;

public static boolean Desafio1 (ColaTDA origen) {
    ColaTDA copiaIdentica = new ColaTDA(); copiaIdentica.InicializarCola(); //para comparar
    PilaTDA copiaInvertida = new PilaTDA(); copiaInvertida.InicializarPila();
    ColaTDA aux = new ColaTDA(); aux.InicializarCola();
    while (!origen.ColaVacia()){
        int x = origen.Primero();
        copiaIdentica.Acolar(x); copiaInvertida.Apilar(x); aux.Acolar(x);
        origen.Desacolar();
    }
    while(!aux.ColaVacia()){
        origen.Acolar(aux.Primero()); aux.Desacolar();
    }
    boolean coinciden = true; //Comparo Cola con Pila
    while(!copiaIdentica.ColaVacia() && coinciden){
        if(copiaIdentica.Primero() != copiaInvertida.Tope()){
            coinciden = false;
        }
        copiaIdentica.Desacolar(); copiaInvertida.Desapilar();
    }
    return coinciden;
}
