package desafios;

// Imports de TDAs e Implementaciones (Ajustá los paquetes si el IDE te lo pide)
import ImplementacionesDinamicas.bloque1.Implementacion.PilaDinamica;
import ImplementacionesDinamicas.bloque1.Interface.PilaTDA;
import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_2_Cola;
import ImplementacionesEstaticas.bloque2.Interface.ColaTDA;
import ImplementacionesDinamicas.colaConPrioridad.Implementacion.ColaPrioridadDinamica;
import ImplementacionesEstaticas.Bloque3.Implementacion.Estrategia_Conjuntos;
import ImplementacionesEstaticas.Bloque3.Interface.ConjuntosTDA;
import ImplementacionesDinamicas.colaDinamica.Implementacion.ColaDinamica;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO BATERÍA DE PRUEBAS - TP ALGORITMOS II ===\n");

        // ---------------------------------------------------------
        // DESAFÍO 1: El espejo de la Cola (Palíndrome)
        // ---------------------------------------------------------
        System.out.println("--- Prueba Desafío 1 ---");
        ColaTDA colaD1 = new Estrategia_2_Cola();
        colaD1.InicializarCola();
        // Cargamos un palíndrome: 1 -> 2 -> 3 -> 2 -> 1
        colaD1.Acolar(1); colaD1.Acolar(2); colaD1.Acolar(3); colaD1.Acolar(2); colaD1.Acolar(1);

        boolean esPalindrome = Desafio1.desafio1(colaD1);
        System.out.println("¿La cola [1,2,3,2,1] es espejo? (Esperado: true) -> " + esPalindrome);


        // ---------------------------------------------------------
        // DESAFÍO 2: El turno justo (Contar P=1)
        // ---------------------------------------------------------
        System.out.println("\n--- Prueba Desafío 2 ---");
        ColaPrioridadDinamica cpD2 = new ColaPrioridadDinamica();
        cpD2.InicializarColaPrioridad();
        // Acolamos elementos mezclados: Valores y Prioridades
        cpD2.AcolarPrioridad(100, 2); // P=2
        cpD2.AcolarPrioridad(200, 1); // P=1 (Este cuenta)
        cpD2.AcolarPrioridad(300, 0); // P=0
        cpD2.AcolarPrioridad(400, 1); // P=1 (Este cuenta)

        Desafio2 d2 = new Desafio2();
        int cantP1 = d2.ContarPrioridadUno(cpD2);
        System.out.println("Cantidad de elementos con Prioridad 1 (Esperado: 2) -> " + cantP1);


        // ---------------------------------------------------------
        // DESAFÍO 3:(Unicidad)
        // ---------------------------------------------------------
        System.out.println("\n--- Prueba Desafío 3 ---");
        PilaTDA pilaD3 = new PilaDinamica();
        pilaD3.InicializarPila();
        // Cargamos pila con un duplicado: 10, 20, 10
        pilaD3.Apilar(10); pilaD3.Apilar(20); pilaD3.Apilar(10);

        boolean unica = Desafio3.esUnica(pilaD3);
        System.out.println("¿La pila [10, 20, 10] tiene elementos únicos? (Esperado: false) -> " + unica);


        // ---------------------------------------------------------
        // DESAFÍO 4: conjunto (Diferencia Simétrica)
        // ---------------------------------------------------------
        System.out.println("\n--- Prueba Desafío 4 ---");
        ConjuntosTDA conjA = new Estrategia_Conjuntos(); conjA.InicializarConjunto();
        conjA.Agregar(1); conjA.Agregar(2); conjA.Agregar(3); // A = {1, 2, 3}

        ConjuntosTDA conjB = new Estrategia_Conjuntos(); conjB.InicializarConjunto();
        conjB.Agregar(3); conjB.Agregar(4); conjB.Agregar(5); // B = {3, 4, 5}

        Desafio4 d4 = new Desafio4();
        ConjuntosTDA diffSimetrica = d4.diferenciaSimetrica(conjA, conjB);

        System.out.print("Diferencia simétrica de {1,2,3} y {3,4,5} (Esperado: 1, 2, 4, 5) -> { ");
        // Imprimimos destruyendo el conjunto resultado para verificar
        while (!diffSimetrica.ConjuntoVacio()) {
            int elem = diffSimetrica.Elegir();
            System.out.print(elem + " ");
            diffSimetrica.Sacar(elem);
        }
        System.out.println("}");


        // ---------------------------------------------------------
        // DESAFÍO 5: La cola que se ordena sola
        // ---------------------------------------------------------
        System.out.println("\n--- Prueba Desafío 5 ---");
        ColaDinamica colaD5 = new ColaDinamica();
        colaD5.InicializarCola();
        // Arreglo de la consigna: [-3, 5, 0, -1, 7, 2, -4]
        int[] datosD5 = {-3, 5, 0, -1, 7, 2, -4};
        for (int dato : datosD5) {
            colaD5.Acolar(dato);
        }

        ColaPrioridadDinamica cpD5 = new ColaPrioridadDinamica();
        cpD5.InicializarColaPrioridad();

        Desafio5 d5 = new Desafio5();
        d5.colaOrdenada(colaD5, cpD5);

        System.out.println("Cola original procesada. Vaciando Cola con Prioridad resultante:");
        while (!cpD5.ColaVacia()) {
            System.out.println("Valor: " + cpD5.Primero() + " | Prioridad: " + cpD5.Prioridad());
            cpD5.Desacolar();
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("PRUEBAS FINALIZADAS. ¡Listo para pushear al Main del repo!");
    }
}