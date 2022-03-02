/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Squery
 */
public class NodoSimple {

    private String nombre;          //Todo nodo tiene un nombre
    private NodoSimple siguiente;   //Todo nodo tiene un siguiente
    private String tipo;            //El nodo puede ser de tipo: Conjunto, Regular ó Lexema

    //Conjuntos
    private String notacion;        //Atributo para los conjuntos
    //Expresiones regulares
    private String expRegular;      //Atributo para las expresiones regulares
    //Lexemas
    private String cadena;          //Atributo para las cadenas de entrada
    //Arbol binario
    private ArbolBinario arbol;

    //Constructor
    public NodoSimple(String nombre, String tipo, String notacion, String expRegular, String cadena) {
        this.nombre = nombre;
        this.siguiente = null;
        this.tipo = tipo;

        this.notacion = notacion;

        this.expRegular = expRegular;

        this.cadena = cadena;
    }

    public String getNotacion() {
        return notacion;
    }

    public void setNotacion(String notacion) {
        this.notacion = notacion;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setExpRegular(String expRegular) {
        this.expRegular = expRegular;
    }

    public String getExpRegular() {
        return this.expRegular;
    }

    public ArbolBinario getArbol() {
        return this.arbol;
    }
}
