package Estructuras;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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

    //private ListaSimple nodosAceptacion = new ListaSimple();
    private ArrayList nodosAceptacion = new ArrayList();
    //private ListaSimple siguientes = new ListaSimple();
    private ArrayList<String[]> siguientes = new ArrayList();
    //private ListaSimple estados = new ListaSimple();
    private ArrayList estados = new ArrayList();
    //private ListaSimple terminales = new ListaSimple();
    private ArrayList<String[]> terminales = new ArrayList();

    //Constructor
    public ArbolBinario(String nombre, NodoArbol root) {
        this.nombre = nombre;
        this.root = root;
        this.contadorNombreNodos = 1;
    }

    //Método para mostrar el árbol en consola
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
            System.out.println("Siguientes: " + root.getSiguientes()[0] + "->" + root.getSiguientes()[1]);
            mostrarArbol(root.getDerecha());
            return null;
        }
    }

    public void imprimirTerminales() {
        System.out.print("Terminales: ");
        for (String[] i : terminales) {
            System.out.print("t:" + i[0]+"-"+i[1]+ "\t");
        }
        System.out.println("");
    }

    //Método que devuelve el codigo de graphviz del arbol
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
        /*
        digraph G {
        node [shape=record];
        nodo1[label="<n0>|{ F |.|   }| <n1> "];
        nodo2[label="<n2>|{ F |.|   }| <n3> "];
        nodo3[label="    |{ F |#| 3 }|      "];
        nodo4[label="<n4>|{ F |.|   }| <n1> "];
        nodo5[label="    |{ F |b| 2 }|      "];
        nodo6[label="<n5>|{ F |.|   }|      "];
        nodo7[label="    |{ F |b| 1 }|      "];
    
        nodo1:n0 -> nodo2;
        nodo1:n1 -> nodo3;
    
        nodo2:n2 -> nodo4;
        nodo2:n3 -> nodo5;
    
        nodo4:n4 -> nodo6;
    
        nodo6:n5 -> nodo7;
    
        }
         */
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public NodoArbol getRoot() {
        return root;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRoot(NodoArbol root) {
        this.root = root;
    }

    //Inicia el proceso del método del árbol
    public void inicio() {
        nombrarNodos(this.root);            //Asigna los nombres a los nodos
        anulabilidad(this.root);            //Asigna la anulabilidad
        primerosNodoHoja(this.root);        //Primeras posiciones de los nodos hoja
        ultimosNodoHoja(this.root);         //Ultimas posiciones de los nodos hoja
        primerosYultimos(this.root);        //Calcula los primeros y los ulltimos de los nodos no hoja
        calcularSiguientes(this.root);      //Calcula los siguientes de todos los nodos
        declararTerminales(this.root);

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

    //Método para asignar los nombres a los nodos
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
                String ultimosC1 = root.getIzquierda().getUltimos();
                String primerosC2 = root.getDerecha().getPrimeros();

                String siguiente[] = new String[2];
                siguiente[0] = ultimosC1;           //Ultimos de C1 apuntan a primeros de C2
                siguiente[1] = primerosC2;

                root.setSiguientes(siguiente);
            } else if ("+".equals(root.getValor())) {
                String ultimosC2 = root.getIzquierda().getUltimos();
                String primerosC2 = root.getIzquierda().getPrimeros();

                String siguiente[] = new String[2];
                siguiente[0] = ultimosC2;           //Ultimos de C1 apuntan a primeros de C1
                siguiente[1] = primerosC2;

                root.setSiguientes(siguiente);
            } else if ("*".equals(root.getValor())) {
                String ultimosC2 = root.getIzquierda().getUltimos();
                String primerosC2 = root.getIzquierda().getPrimeros();

                String siguiente[] = new String[2];
                siguiente[0] = ultimosC2;           //Ultimos de C1 apuntan a primeros de C1
                siguiente[1] = primerosC2;

                root.setSiguientes(siguiente);
            }
        }
    }

    private void declararTerminales(NodoArbol root) {
        if (root != null) {
            declararTerminales(root.getIzquierda());
            declararTerminales(root.getDerecha());
            //* | + . ?
            if (!"*".equals(root.getValor()) && !"|".equals(root.getValor()) && !"+".equals(root.getValor()) && !".".equals(root.getValor()) && !"?".equals(root.getValor())) {
                String terminal[] = new String[2];
                terminal[0] = String.valueOf(root.getNumero());
                terminal[1] = root.getValor();
                terminales.add(terminal);
            }
        }
    }

    public int[] rangoDeSimbolos(String inicio, String fin) {
        int a = inicio.getBytes(StandardCharsets.US_ASCII)[0];
        int b = fin.getBytes(StandardCharsets.US_ASCII)[0];
        if (a >= 32 && b <= 125) {
            int numeros[] = new int[(b - a + 1)];
            int n = 0;
            for (int i = a; i < b + 1; i++) {
                if ((i >= 32 && i <= 47) || (i >= 58 && i <= 64) || (i >= 91 && i <= 96) || (i >= 123 && i <= 125)) {
                    numeros[n] = i;
                    n++;
                }
            }
            int numero2[] = new int[n];
            System.arraycopy(numeros, 0, numero2, 0, numero2.length);
            return numero2;
        } else {
            int num[] = new int[1];
            num[0] = -1;
            return num;
        }

    }

}
