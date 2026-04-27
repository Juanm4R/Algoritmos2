package ImplementacionesEstaticas.bloque2;

public class Main {

    // Este es el verdadero punto de entrada (Entry Point) que busca la JVM
    public static void main(String[] args) {
        System.out.println("====== INICIANDO SIMULADOR BLOQUE 2 (COLAS) ======\n");

        // 1. Instanciamos las simulaciones de Cola Simple (FIFO)
        FilaDelCajero cajero = new FilaDelCajero();
        ImpresoraLaboratorio impresora = new ImpresoraLaboratorio();
        BuffetFacultad buffet = new BuffetFacultad();

        // 2. Instanciamos las simulaciones de Cola de Prioridad (Ranking)
        GuardiaHospital hospital = new GuardiaHospital();
        ExamenFinal examen = new ExamenFinal();
        ProcesadorTareas cpu = new ProcesadorTareas();
        EmbarqueAerolineas aerolinea = new EmbarqueAerolineas();
        DistribucionTickets ticketsIT = new DistribucionTickets();

        // 3. Disparamos la ejecución una por una
        cajero.simular();
        impresora.simular();
        hospital.simular();
        examen.simular();
        buffet.simular();
        cpu.simular();
        aerolinea.simular();
        ticketsIT.simular();

        System.out.println("\n====== FIN DE LA SIMULACIÓN ======");
    }
}