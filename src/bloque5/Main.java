package bloque5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inicio de simulacion del bloque 5");
        // 1- Hospital Premium
        HospitalPremium hospital = new HospitalPremium();
        hospital.simular();

        // 2- Sistema de Tags Facultad
        SistemaTagsFacultad facultadSistem = new SistemaTagsFacultad();
        facultadSistem.simular();
        System.out.println("Fin de simulacion del bloque");
    }
}
