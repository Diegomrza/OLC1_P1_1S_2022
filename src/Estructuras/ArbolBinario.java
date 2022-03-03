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
    private int contadorNombreNodos;
    
    private ListaSimple nodosAceptacion = new ListaSimple();
    private ListaSimple siguientes = new ListaSimple();
    private ListaSimple estados = new ListaSimple();
    private ListaSimple terminales = new ListaSimple();
    
    public ArbolBinario(String nombre, NodoArbol root) {
        this.nombre = nombre;
        this.root = root;
        this.contadorNombreNodos = 1;
    }
    
    public void mostrar() {
        System.out.println("Mostrando arbol");
        mostrarArbol(this.root);
    }
    
    public NodoArbol mostrarArbol(NodoArbol root) {
        if (root == null) {
            return null;
        } else {
            mostrarArbol(root.getIzquierda());
            System.out.println("Simbolo: " + root.getValor());
            System.out.println("Etiqueta: " + root.getNumero());
            System.out.println("Primeros: " + root.getPrimeros());
            System.out.println("Ultimos: " + root.getUltimos());
            System.out.println("");
            mostrarArbol(root.getDerecha());
            return null;
        }
    }
    
    public void generarGrafo(NodoArbol root) {
        String cadena = "\n\ndigraph G {\nnode[shape=box]";
        Queue<Object> cola = new LinkedList();
        NodoArbol au[] = new NodoArbol[2];
        au[0] = null;
        au[1] = root;
        cola.add(au);
        String N = "Nodo";
        while (cola.isEmpty() != true) {
            NodoArbol nodo[] = (NodoArbol[]) cola.remove();
            if (nodo[0] != null) {
                cadena += N + nodo[1].hashCode() + "[label=\"" + nodo[1].getValor() + "\"];\n";
                cadena += N + nodo[0].hashCode() + "->" + N + nodo[1].hashCode() + "\n";
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
        System.out.println("Cadena: " + nombre + " " + cadena);
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
    
    public void inicio() {
        nombrarNodos(this.root);    //Asigna los nombres a los nodos
        anulabilidad(this.root);    //Asigna la anulabilidad
        primerosNodoHoja(this.root);        //Primeras posiciones de los nodos hoja
        ultimosNodoHoja(this.root);         //Ultimas posiciones de los nodos hoja
        primerosYultimos(this.root);
        calcularSiguientes(this.root);
    }
    
    private void anulabilidad(NodoArbol root) {
        if (root != null) {
            anulabilidad(root.getIzquierda());
            anulabilidad(root.getDerecha());
            if (root.getIzquierda() == null && root.getDerecha() == null) { //Si 
                root.setAnulable(false);
            }
            or(root);
            punto(root);
            kleene(root);
            pregunta(root);
            positiva(root);
        }
    }

    //Métodos para colocar los anulables
    private void or(NodoArbol root) {
        if ("|".equals(root.getValor())) {
            if (root.getIzquierda().isAnulable() || root.getDerecha().isAnulable()) {
                root.setAnulable(true);
            } else {
                root.setAnulable(false);
            }
        }
    }
    
    private void punto(NodoArbol root) {
        if (".".equals(root.getValor())) {
            if (root.getIzquierda().isAnulable() && root.getDerecha().isAnulable()) {
                root.setAnulable(true);
            } else {
                root.setAnulable(false);
            }
        }
    }
    
    private void kleene(NodoArbol root) {
        if ("*".equals(root.getValor())) {
            root.setAnulable(true);
        }
    }
    
    private void pregunta(NodoArbol root) {
        if ("?".equals(root.getValor())) {
            root.setAnulable(true);
        }
    }
    
    private void positiva(NodoArbol root) {
        if (".".equals(root.getValor())) {
            if (root.getIzquierda().isAnulable()) {
                root.setAnulable(true);
            } else {
                root.setAnulable(false);
            }
        }
    }

    //Métodos para asignar los nombres a los nodos
    private void nombrarNodos(NodoArbol root) {
        if (root != null) {
            nombrarNodos(root.getIzquierda());
            nombrarNodos(root.getDerecha());
            if (!"|".equals(root.getValor()) && !".".equals(root.getValor()) && !"*".equals(root.getValor()) && !"?".equals(root.getValor()) && !"+".equals(root.getValor())) {
                root.setNumero(contadorNombreNodos);
                contadorNombreNodos++;
            }
        }
    }
    
    private void primerosNodoHoja(NodoArbol root) {
        if (root != null) {
            primerosNodoHoja(root.getIzquierda());
            primerosNodoHoja(root.getDerecha());
            if (!"|".equals(root.getValor()) && !".".equals(root.getValor()) && !"*".equals(root.getValor()) && !"?".equals(root.getValor()) || !"+".equals(root.getValor())) {
                root.setPrimeros(String.valueOf(root.getNumero()));
            }
        }
    }
    
    private void ultimosNodoHoja(NodoArbol root) {
        if (root != null) {
            ultimosNodoHoja(root.getIzquierda());
            ultimosNodoHoja(root.getDerecha());
            if (!"|".equals(root.getValor()) && !".".equals(root.getValor()) && !"*".equals(root.getValor()) && !"?".equals(root.getValor()) || !"+".equals(root.getValor())) {
                root.setUltimos(String.valueOf(root.getNumero()));
            }
        }
    }
    
    private void primerosYultimos(NodoArbol root) {
        if (root != null) {
            primerosYultimos(root.getIzquierda());
            primerosYultimos(root.getDerecha());
            
            if ("|".equals(root.getValor())) {
                root.setPrimeros(juntarPrimeros(root));
                root.setUltimos(juntarUltimos(root));
            } else if (".".equals(root.getValor())) {
                if (root.getIzquierda().isAnulable()) {
                    root.setPrimeros(juntarPrimeros(root));
                } else {
                    root.setPrimeros(root.getIzquierda().getPrimeros());
                }
                if (root.getDerecha().isAnulable()) {
                    root.setUltimos(juntarUltimos(root));
                } else {
                    root.setUltimos(root.getDerecha().getUltimos());
                }
            } else if ("*".equals(root.getValor()) || "?".equals(root.getValor()) || "+".equals(root.getValor())) {
                root.setPrimeros(root.getIzquierda().getPrimeros());
                root.setUltimos(root.getIzquierda().getUltimos());
            }
//            else if ("?".equals(root.getValor())) {
//                root.setPrimeros(root.getIzquierda().getPrimeros());
//                root.setUltimos(root.getIzquierda().getUltimos());
//            } else if ("+".equals(root.getValor())) {
//                root.setPrimeros(root.getIzquierda().getPrimeros());
//                root.setUltimos(root.getIzquierda().getUltimos());
//            }
        }
    }
    
    private String juntarPrimeros(NodoArbol root) {
        String[] primerosIzq = root.getIzquierda().getPrimeros().split(",");
        String[] primerosDer = root.getDerecha().getPrimeros().split(",");
        
        String PRIMEROS = "";
        for (int i = 0; i < primerosIzq.length; i++) {
            PRIMEROS += primerosIzq[i] + ",";
        }
        for (int j = 0; j < primerosDer.length; j++) {
            if (j < primerosDer.length - 1) {
                PRIMEROS += primerosDer[j] + ",";
            } else {
                PRIMEROS += primerosDer[j];
            }
        }
        return PRIMEROS;
    }
    
    private String juntarUltimos(NodoArbol root) {
        String[] ultimosIzq = root.getIzquierda().getUltimos().split(",");
        String[] ultimosDer = root.getDerecha().getUltimos().split(",");
        String ULTIMOS = "";
        for (int i = 0; i < ultimosIzq.length; i++) {
            ULTIMOS += ultimosIzq[i] + ",";
        }
        for (int j = 0; j < ultimosDer.length; j++) {
            if (j < ultimosDer.length - 1) {
                ULTIMOS += ultimosDer[j] + ",";
            } else {
                ULTIMOS += ultimosDer[j];
            }
        }
        return ULTIMOS;
    }

    //
    private void calcularSiguientes(NodoArbol root) { //Solo se calcula con . + *
        if (root != null) {
            calcularSiguientes(root.getIzquierda());
            calcularSiguientes(root.getDerecha());
            if (".".equals(root.getValor())) {
                
            } else if ("+".equals(root.getValor())) {
                
            } else if ("*".equals(root.getValor())) {
                
            }
        }
    }
}
