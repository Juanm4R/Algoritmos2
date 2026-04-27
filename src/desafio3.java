package desafio6;

import desafio6.conjuntosDinamicos.ConjuntoDinamico;

public class main {
    public static boolean esUnica(PilaTDA p) {
        PilaTDA aux = new PilaLD();
        ConjuntoTDA c = new ConjuntoDinamico();

        aux.InicializarPila();
        c.InicializarConjunto();

        boolean esUnica = true;

        while (!p.PilaVacia()) {
            int x = p.Tope();
            p.Desapilar();

            if (c.Pertenece(x)) {
                esUnica = false;
            } else {
                c.Agregar(x);
            }

            aux.Apilar(x);
        }

        while (!aux.PilaVacia()) {
            p.Apilar(aux.Tope());
            aux.Desapilar();
        }

        return esUnica;
    }
}
    public static void main(String[] args){
        Interface.ConjuntoTDA c = new ConjuntoDinamico();

        public static void main(String[] args) {
            PilaTDA p1 = new PilaLD();
            p1.InicializarPila();
            p1.Apilar(1);
            p1.Apilar(3);
            p1.Apilar(2);
            p1.Apilar(3);

            System.out.println("¿Es única p1?: " + esUnica(p1)); // false

            PilaTDA p2 = new PilaLD();
            p2.InicializarPila();
            p2.Apilar(1);
            p2.Apilar(2);
            p2.Apilar(3);

            System.out.println("¿Es única p2?: " + esUnica(p2)); // true

            System.out.print("p1 luego del método: ");
            while (!p1.PilaVacia()) {
                System.out.print(p1.Tope() + " ");
                p1.Desapilar();
            }
    }
}
