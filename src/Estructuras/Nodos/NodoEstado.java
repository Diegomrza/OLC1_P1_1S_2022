/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Nodos;

import java.util.ArrayList;

/**
 *
 * @author Squery
 */
public class NodoEstado {

    private String nombre;
    private ArrayList<Integer> numeros = new ArrayList();

    public NodoEstado(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(int numero) {
        this.numeros.add(numero);
    }

    public void setNumero(ArrayList numeros) {
        this.numeros = numeros;
    }

    public ArrayList getNumero() {
        return this.numeros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

}
