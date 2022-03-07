package Estructuras.Nodos;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Squery
 */
public class NodoEstado {

    private String nombre;
    private ArrayList<Integer> items = new ArrayList();

    public NodoEstado(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNumero(int numero) {
        if (!this.items.isEmpty()) {
            if (!existe(numero)) {
                this.items.add(numero);
                Collections.sort(this.items);
            }
        } else {
            this.items.add(numero);
        }

    }

    public ArrayList<Integer> getNumeros() {
        return this.items;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.items = numeros;
    }

    public boolean existe(int numero) {
        boolean bandera = false;
        for (int n : this.items) {
            if (numero == n) {
                bandera = true;
            }
        }
        return bandera;
    }

}
