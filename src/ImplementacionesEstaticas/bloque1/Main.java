package ImplementacionesEstaticas.bloque1;

public class Main {
    public static void main(String[] args) {

        //  CONSIGNA 1: REVERSIÓN DE STRINGS ---
        System.out.println("--- 1. Reversión ---");
        String palabra = "ALGORITMOS";
        // Usamos la lógica de apilar y desapilar para invertir
        ReverseStrings.ejecutar(palabra);
        System.out.println("\n");


        //  CONSIGNA 2: BALANCEO DE PARÉNTESIS ---
        System.out.println("--- 2. Balanceo ---");
        String expresion = "((a+b)*c)";
        boolean estaOk = BalanceoDePrentesis.chequear(expresion);
        System.out.println("¿La expresión " + expresion + " es válida?: " + estaOk);
        System.out.println();


        // --- CONSIGNA 3: EDITOR DE CÓDIGO  ---
        System.out.println("--- 3. Editor (Deshacer) ---");
        EditorDeCodigo miEditor = new EditorDeCodigo();
        miEditor.realizarAccion(1); // Versión 1
        miEditor.realizarAccion(2); // Versión 2
        miEditor.deshacer();       // Debería volver a la 1
        System.out.println();


        // --- CONSIGNA 4: HISTORIAL DE NAVEGACIÓN ---
        System.out.println("--- 4. Navegador (Atrás) ---");
        HistorialDeNavegacion miChrome = new HistorialDeNavegacion();
        miChrome.navegar(101); // Google
        miChrome.navegar(202); // UADE
        System.out.println("Apretando botón atrás...");
        miChrome.retroceder(); // Debería mostrar ID 101
        System.out.println();


        // --- CONSIGNA 5: PILA DE LLAMADAS (CALL STACK) ---
        System.out.println("--- 5. Call Stack ---");
        CallStack.simular();
        System.out.println();


        // --- CONSIGNA 6: NAVEGACIÓN DE DIRECTORIOS ---
        System.out.println("--- 6. Carpetas (Subir Nivel) ---");
        NavegacionDirectorios misArchivos = new NavegacionDirectorios();
        misArchivos.entrar(10); // C:/
        misArchivos.entrar(20); // Usuarios
        misArchivos.subirNivel(); // Debería volver a C:/ (ID 10)

    }
}