package bloque4;

public class Main {
    static void main(String[] args) {
        DiccionarioDeSinonimos miDiccio = new DiccionarioDeSinonimos();
        miDiccio.InicializarDiccionario();

        // 1. Agregamos valores (Clave 10: "Feliz")
        System.out.println("Agregando sinónimos para la clave 10...");
        miDiccio.Agregar(10, 500); // 500 = "Contento"
        miDiccio.Agregar(10, 501); // 501 = "Alegre"
        miDiccio.Agregar(10, 500); // Intento duplicado (no debería agregarse)

        // 2. Agregamos otra clave (Clave 20: "Triste")
        miDiccio.Agregar(20, 600); // 600 = "Deprimido"

        // 3. Recuperar y mostrar
        int[] misClaves = miDiccio.Claves();
        System.out.println("Claves en el diccionario: " + misClaves.length);

        for (int c : misClaves) {
            System.out.print("Clave " + c + " tiene los sinónimos: ");
            int[] sinonimos = miDiccio.Recuperar(c);
            for (int s : sinonimos) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
