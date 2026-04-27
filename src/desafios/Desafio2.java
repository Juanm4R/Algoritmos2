package desafios;

import ImplementacionesDinamicas.colaConPrioridad.Implementacion.ColaPrioridadDinamica;

//Desafío 2 — "El turno justo" (Cola con Prioridad dinámica) ¿Podés contar los elementos de P=1 sin "saltar" P=2? No: Desacolar() siempre extrae la mayor prioridad disponible.
// Para llegar a P=1 hay que vaciar P=2 primero, y restaurar tdo al terminar. El código termina siendo 15 líneas pero la lógica de restauración requiere pensar en 2 auxiliares.
public class Desafio2 {
    public int ContarPrioridadUno (ColaPrioridadDinamica cola) {
        ColaPrioridadDinamica aux1 = new ColaPrioridadDinamica();
        aux1.InicializarColaPrioridad();
        ColaPrioridadDinamica aux2 = new ColaPrioridadDinamica();
        aux2.InicializarColaPrioridad();
        while (!cola.ColaVacia()) {
            if (cola.Prioridad() != 1) {
                aux1.AcolarPrioridad(cola.Primero(), cola.Prioridad());
                cola.Desacolar();
            } else {
                aux2.AcolarPrioridad(cola.Primero(), cola.Prioridad());
                cola.Desacolar();
            }
        }
        int cont = 0;
        while (!aux2.ColaVacia()) {
            cont += 1;
            cola.AcolarPrioridad(aux2.Primero(), aux2.Prioridad());
            aux2.Desacolar();
        }
        while (!aux1.ColaVacia()) {
            cola.AcolarPrioridad(aux1.Primero(), aux1.Prioridad());
            aux1.Desacolar();
        }
        return cont;
    }
}
