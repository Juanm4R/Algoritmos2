package ImplementacionesDinamicas.bloque1.Implementacion;
public class Node {
    private int data;
    private Node next;

    // Constructor con parámetros para instanciar en una sola línea
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    //metodos
    // Getters y Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}