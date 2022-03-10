package Estructuras;

import java.util.*;

/**
 *
 * @author Squery
 */
public class NodoConjunto {

    private String nombre;
    private ArrayList<Integer> elementos = new ArrayList();

    public NodoConjunto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Integer> elementos) {
        this.elementos = elementos;
    }

}
