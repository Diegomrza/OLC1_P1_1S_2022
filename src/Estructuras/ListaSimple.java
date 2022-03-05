package Estructuras;

/**
 *
 * @author Squery
 */
import Estructuras.Nodos.*;

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

    public void insertar(String nombre, String tipo, String notacion, String expRegular, String cadena) {
        expRegular = expRegular.replaceAll(" ", "");
        NodoSimple nodo = new NodoSimple(nombre, tipo, notacion, expRegular, cadena);
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

    public void insertarNodoAceptacion() { //
        NodoAceptacion nodo = new NodoAceptacion();
    }

    public void insertarSiguientes() { //
        NodoSiguientes nodo = new NodoSiguientes();
    }

    public void insertarEstados() { //
        //NodoEstado nodo = new NodoEstado();
    }

    public void insertarTerminales() { //
        NodoTerminal nodo = new NodoTerminal();
    }

    public void mostrar() {
        NodoSimple aux = this.primero;
        while (aux != null) {
            if ("CONJUNTO".equals(aux.getTipo())) {
                System.out.println("Tipo: " + aux.getTipo());
                System.out.println("Nombre: " + aux.getNombre());
                System.out.println("Notacion: " + aux.getNotacion());
                System.out.println("");
            } else if ("REGULAR".equals(aux.getTipo())) {
                System.out.println("Tipo: " + aux.getTipo());
                System.out.println("Nombre: " + aux.getNombre());
                System.out.println("Expresion: " + aux.getExpRegular());
                System.out.println("");
            } else if ("CADENA".equals(aux.getTipo())) {
                System.out.println("Tipo: " + aux.getTipo());
                System.out.println("Nombre: " + aux.getNombre());
                System.out.println("Cadena: " + aux.getCadena());
                System.out.println("");
            }
            aux = aux.getSiguiente();
        }
    }
}
