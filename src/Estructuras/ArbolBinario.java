package Estructuras;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Squery
 */
public class ArbolBinario {

    private String nombre;
    private NodoArbol root;

    public ArbolBinario(String nombre, NodoArbol root) {
        this.nombre = nombre;
        this.root = root;
    }

    public void mostrar() {
        System.out.println("Mostrando arbol");
        mostrarArbol(this.root);
    }

    public NodoArbol mostrarArbol(NodoArbol raiz) {
        if (raiz == null) {
            return null;
        } else {
            mostrarArbol(raiz.getDerecha());
            System.out.println(raiz.getValor());
            mostrarArbol(raiz.getIzquierda());
            return null;
        }
    }

    public void generarGrafo(NodoArbol raiz) {
        String cadena = "\n\ndigraph G {\nnode[shape=box]";
        Queue<Object> cola = new LinkedList();
        NodoArbol au[] = new NodoArbol[2];
        au[0] = null;
        au[1] = raiz;
        cola.add(au);
        String N = "Nodo";
        while (cola.isEmpty() != true) {
            NodoArbol nodo[] = (NodoArbol[]) cola.remove();
            if (nodo[0] != null) {
                cadena += N + nodo[1].hashCode()  + "[label=\"" + nodo[1].getValor() + "\"];\n";
                cadena += N + nodo[0].hashCode()  + "->" + N + nodo[1].hashCode() +  "\n";
            } else {
                cadena += N + nodo[1].hashCode() + "[label=\"" + nodo[1].getValor() + "\"];\n";
            }
            if (nodo[1].getIzquierda() != null) {
                NodoArbol aux[] = new NodoArbol[2];
                aux[0] = nodo[1];
                aux[1] = nodo[1].getIzquierda();
                cola.add(aux);
            }
            if (nodo[1].getDerecha() != null) {
                NodoArbol aux2[] = new NodoArbol[2];
                aux2[0] = nodo[1];
                aux2[1] = nodo[1].getDerecha();
                cola.add(aux2);
            }
        }
        cadena += "}";
        System.out.println("Cadena: " + cadena);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoArbol getRoot() {
        return root;
    }

    public void setRoot(NodoArbol root) {
        this.root = root;
    }

}
