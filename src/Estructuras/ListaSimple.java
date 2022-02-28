/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Squery
 */
public class ListaSimple {

    private NodoSimple primero;

    public ListaSimple() {
        this.primero = null;
    }

    public NodoSimple getPrimero() {
        return primero;
    }

    public void delete() {
        this.primero = null;
    }

    public void insertar(String valor) {
        NodoSimple nodo = new NodoSimple(valor);
        if (this.primero == null) {
            this.primero = nodo;
        } else {
            NodoSimple aux = this.primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

    public void mostrar() {
        NodoSimple aux = this.primero;
        while (aux != null) {
            System.out.println("Valor: " + aux.getValor());
            aux = aux.getSiguiente();
        }
    }
}
