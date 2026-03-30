package Bloque3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SIMULACIÓN BLOQUE 3 (CONJUNTOS) ===\n");

        // 1. Padrón Electoral
        PadronElectoral padron = new PadronElectoral();
        padron.simular();

        // 2. Filtro de Spam (Blacklist)
        FiltroDeSpam filtro = new FiltroDeSpam();
        filtro.simular();

        // 3. Gestión de Legajos
        GestionLegajos legajos = new GestionLegajos();
        legajos.simular();

        // Pregunta de Examen: Elegir vs Sacar
        ElegirVsSacar elegirVsSacar = new ElegirVsSacar();
        elegirVsSacar.simular();

        System.out.println("=== FIN DE LA SIMULACIÓN ===");
    }
}