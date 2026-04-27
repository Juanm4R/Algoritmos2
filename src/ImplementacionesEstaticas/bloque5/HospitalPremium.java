package ImplementacionesEstaticas.bloque5;

import ImplementacionesEstaticas.bloque2.Interface.ColaPrioridadTDA;
import ImplementacionesEstaticas.bloque2.Implementacion.Estrategia_1_Cola_Prioridad;
import ImplementacionesEstaticas.bloque1.interfaces.Pila;
import ImplementacionesEstaticas.bloque1.Implementacion.Estrategia1;

public class HospitalPremium {

    // El TDA que administra la sala de espera
    private ColaPrioridadTDA sala;

    public HospitalPremium() {
        // Instanciamos usando bloque 2
        sala = new Estrategia_1_Cola_Prioridad();
        sala.InicializarCola();
    }

    public void simular() {
        System.out.println("--- 1. HOSPITAL PREMIUM ---");

        // 1. LLEGAN LOS PACIENTES A LA GUARDIA
        // Acolamos al Paciente ID 501 (Infarto -> Prioridad Alta: 100)
        sala.AcolarPrioridad(501, 100);
        // Acolamos al Paciente ID 502 (Raspón -> Prioridad Baja: 1)
        sala.AcolarPrioridad(502, 1);

        System.out.println("Llegaron pacientes a la sala. El TDA los ordena por prioridad.");

        // 2. EL MÉDICO LLAMA AL SIGUIENTE
        int pacienteAtendido = sala.Primero();
        sala.Desacolar(); // Lo sacamos de la sala de espera
        System.out.println("El médico atiende al paciente ID: " + pacienteAtendido);

        // 3. REGISTRO DE SÍNTOMAS DEL PACIENTE (Usando tu Pila del Bloque 1)
        Pila sintomas = new Estrategia1();
        sintomas.InicializarPila();

        // Simulamos síntomas con IDs (10=Sudor, 20=Mareo, 30=Dolor de Pecho)
        sintomas.Apilar(10);
        sintomas.Apilar(20);
        sintomas.Apilar(30);

        System.out.println("El médico registró 3 síntomas en el historial (Pila).");

        // 4. CONSULTA DEL ÚLTIMO SÍNTOMA
        // Como es una Pila (LIFO), el Tope nos da el último que ingresó.
        System.out.println("El síntoma más crítico/reciente (Tope) es el ID: " + sintomas.Tope());
        System.out.println();
    }
}