package desafios;
import ImplementacionesDinamicas.colaConPrioridad.Implementacion.ColaPrioridadDinamica;
import ImplementacionesDinamicas.colaDinamica.Implementacion.ColaDinamica;
//"La cola que se ordena sola"  TDAs: Cola dinámica + Cola con Prioridad dinámica (P=2 mayor)
//Regla:
// negativos → P=0
// cero → P=1
// positivos → P=2

// Pregunta ANTES de escribir código: Dada c = [-3, 5, 0, -1, 7, 2, -4], después de clasificar:
// 1. ¿Qué elemento sale PRIMERO al hacer Desacolar()? ¿Por qué?
//Rta: Sale primero el 5 porque es un elemento de la P=2 que es la cola con mayor prioridad y es el primero en acolarse de los positivos
// 2. ¿Qué elemento sale ÚLTIMO? ¿Por qué?
//Rta: El ultimo elemento en salir es el -4 porque pretenece a P=0 que es la de menor prioridad y ademas fue el ultimo en acolarse. FIFO
// 3. Dentro de la misma prioridad, ¿en qué orden salen?
//Rta: El orden queda a decisión del implementador, lo que conocemos teóricamente como "semántica libre".
// 4. Si hubiera DOS ceros en c, ¿ambos entrarían en P=1? ¿AcolarPrioridad verifica unicidad como Agregar del Conjunto?

public class Desafio5 {
    public void colaOrdenada(ColaDinamica c, ColaPrioridadDinamica cp){
        while (!c.ColaVacia()) {
            int valor = c.Primero();
            if (valor == 0) {
                cp.AcolarPrioridad(valor, 1);
            } else if (valor > 0) {
                cp.AcolarPrioridad(valor, 2);
            } else {
                cp.AcolarPrioridad(valor, 0);
            }
            c.Desacolar();
        }
    }
}
