/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Squery
 */
public class ArbolBinario {

    private NodoArbol root;

    public void insertar(int valor) {
        this.root = insertar(valor, this.root);
    }

    public NodoArbol insertar(int valor, NodoArbol raiz) {
        NodoArbol nuevo = new NodoArbol(valor);
        if (raiz == null) {
            raiz = nuevo;
        } else if (raiz.getValor() < nuevo.getValor()) {
            raiz.setIzquierda(insertar(valor, raiz.getIzquierda()));
        } else if (raiz.getValor() > nuevo.getValor()) {
            raiz.setDerecha(insertar(valor, raiz.getDerecha()));
        } else {
            System.out.println("Son iguales");
        }
        return raiz;
    }

    public void mostrar() {
        mostrar(this.root);
    }

    public NodoArbol mostrar(NodoArbol raiz) {
        if (raiz == null) {
            return null;
        } else {
            mostrar(raiz.getDerecha());

            System.out.println(raiz.getValor());

            mostrar(raiz.getIzquierda());
            return null;
        }

    }
}
