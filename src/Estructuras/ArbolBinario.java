package Estructuras;

import Estructuras.Nodos.NodoEstado;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

/**
 *
 * @author Squery
 */
public class ArbolBinario {

    private String nombre;
    private NodoArbol root;
    private int contadorNombreNodos;
    private int contadorEstados = 1;

    private ArrayList nodosAceptacion = new ArrayList();
    private ArrayList<String[]> siguientes = new ArrayList();
    private ArrayList<NodoEstado> estados = new ArrayList();
    private ArrayList<String[]> terminales = new ArrayList();

    private ArrayList<String[]> temporal = new ArrayList();

    //Constructor
    public ArbolBinario(String nombre, NodoArbol root) {
        this.nombre = nombre;
        this.root = root;
        this.contadorNombreNodos = 1;
    }

    //Métodos para mostrar el árbol en consola
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
        for (String[] i : this.terminales) {
            System.out.println("Nodo: " + i[0]);
            System.out.println("Simbolo: " + i[1]);
        }
        System.out.println("");
    }

    public void imprimirSiguientes() {

        for (String[] siguiente : this.siguientes) {
            System.out.print("Nodo: ");
            System.out.println(siguiente[0]);
            System.out.print("Simbolo: ");
            System.out.println(siguiente[1]);

            System.out.print("Siguiente: ");
            System.out.println(siguiente[2]);
            System.out.println("");
        }

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
            String label = "Simbolo: " + nodo[1].getValor() + "\n";
            label += "Primeros: " + nodo[1].getPrimeros() + "\n";
            label += "Ultimos: " + nodo[1].getUltimos() + "\n";
            label += "Anulable: " + nodo[1].isAnulable();
            if (nodo[0] != null) {

                cadena += N + nodo[1].hashCode() + "[label=\"" + label + "\"];\n";
                cadena += N + nodo[0].hashCode() + "->" + N + nodo[1].hashCode() + "\n";
            } else {

                cadena += N + nodo[1].hashCode() + "[label=\"" + label + "\"];\n";
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

    //Inicia el proceso del método del árbol************************************
    public void inicio() {
        nombrarNodos(this.root);            //Asigna los nombres a los nodos
        anulabilidad(this.root);            //Asigna la anulabilidad
        primerosNodoHoja(this.root);        //Primeras posiciones de los nodos hoja
        ultimosNodoHoja(this.root);         //Ultimas posiciones de los nodos hoja
        primerosYultimos(this.root);        //Calcula los primeros y los ulltimos de los nodos no hoja
        calcularSiguientes(this.root);      //Calcula los siguientes de todos los nodos
        declararTerminales(this.root);      //

        tablaSiguientes(this.root);
        quitarRepetidosDeSiguientes(this.root);
        //imprimirSiguientes();
        //generarGrafo(this.root);
        crearPrimerEstado();
        crearEstados();
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

    //Métodos para colocar los anulables----------------------------------------
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

    //Método para asignar los nombres a los nodos ------------------------------
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

    //Primeros y ultimos de los nodos | . * ? +---------------------------------
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

    //Método que calcula el siguiente de cada nodo . + * -----------------------
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
            if (!"*".equals(root.getValor()) && !"|".equals(root.getValor()) && !"+".equals(root.getValor()) && !".".equals(root.getValor()) && !"?".equals(root.getValor()) && !"#".equals(root.getValor())) {
                String terminal[] = new String[3];
                terminal[0] = String.valueOf(root.getNumero());
                terminal[1] = root.getValor();

                terminales.add(terminal);
//                if (!existeTerminal(terminal[1])) {
//                    terminales.add(terminal);
//                }
            }
        }
    }

    private boolean existeTerminal(String terminal) {
        boolean bandera = false;
        for (String[] i : this.terminales) {
            if (terminal.equals(i[1])) {
                bandera = true;
            }
        }
        return bandera;
    }

    //Para el rango de simbolos de la forma Simbolo ~ Simbolo-------------------
    private int[] rangoDeSimbolos(String inicio, String fin) {
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

    //--------------------------------------------------------------------------
    //Creación de estados
    private void crearPrimerEstado() {
        NodoEstado estado0 = new NodoEstado("S0");
        String primeros[] = this.root.getPrimeros().split(",");
        for (String i : primeros) {
            estado0.setNumero(Integer.parseInt(i));
        }
        this.estados.add(estado0);

//        for (NodoEstado i : this.estados) {
//            System.out.println(i.getNombre());
//            ArrayList<Integer> numeros = i.getNumeros();
//            for (Integer n : numeros) {
//                System.out.println("numero: " + n);
//            }
//        }
    }

    private void crearEstados() {
        int tamanio = this.estados.size();
        int contadorIteraciones = 0;
        while (contadorIteraciones < tamanio) {
            ArrayList<Integer> numeros = this.estados.get(contadorIteraciones).getNumeros();
            ArrayList<String[]> termnales = new ArrayList();  //Arreglo temporal para guardar los simbolos

            //Obtenemos los elementos del estado y agregamos el simbolo a una lista temporal
            for (int i = 0; i < numeros.size(); i++) {
                String t[] = obtenerSiguiente(numeros.get(i));
                if (t != null) {
                    termnales.add(t);
                }

            }

            //Luego en una lista temporal global ingresamos el simbolo solamente una vez para juntar el conjunto final en caso de que sean varios
            for (int i = 0; i < termnales.size(); i++) {
                if (temporal.isEmpty()) {
                    temporal.add(termnales.get(i));
                } else {
                    //Symbol,state,follow
                    verificarTemporal(termnales.get(i));
                }
            }
            for (String[] temp : temporal) {
                ArrayList<Integer> elementos = new ArrayList();
                String[] elem = temp[2].split(",");
                for (int i = 0; i < elem.length; i++) {
                    elementos.add(Integer.parseInt(elem[i]));
                }
                if (!existeEstado(elementos)) {
                    NodoEstado nuevoE = new NodoEstado("S" + String.valueOf(contadorEstados));
                    nuevoE.setNumeros(elementos);
                    estados.add(nuevoE);
                    contadorEstados++;
                    tamanio++;
                }
            }
            temporal.clear();
            contadorIteraciones++;
        }
        System.out.println(estados.size());

//        for (NodoEstado estado : this.estados) {
//
//            ArrayList<Integer> numeros = estado.getNumeros();  //Numeros del estado
//            ArrayList<String[]> termnales = new ArrayList();  //Arreglo temporal para guardar los simbolos
//
//            //Obtenemos los elementos del estado y agregamos el simbolo a una lista temporal
//            for (int i = 0; i < numeros.size(); i++) {
//                String t[] = obtenerSiguiente(numeros.get(i));
//                termnales.add(t);
//            }
//
//            //Luego en una lista temporal global ingresamos el simbolo solamente una vez para juntar el conjunto final en caso de que sean varios
//            for (int i = 0; i < termnales.size(); i++) {
//                if (temporal.isEmpty()) {
//                    temporal.add(termnales.get(i));
//                } else {
//                    //Symbol,state,follow
//                    verificarTemporal(termnales.get(i));
//                }
//            }
//            for (String[] temp : temporal) {
//                ArrayList<Integer> elementos = new ArrayList();
//                String[] elem = temp[2].split(",");
//                for (int i = 0; i < elem.length; i++) {
//                    elementos.add(Integer.parseInt(elem[i]));
//                }
//                if (!existeEstado(elementos)) {
//                    NodoEstado nuevoE = new NodoEstado("S" + String.valueOf(contadorEstados));
//                    nuevoE.setNumeros(elementos);
//                    estados.add(estado);
//                    contadorEstados++;
//                }
//            }
//            temporal.clear();
//        }
    }

    private void tablaSiguientes(NodoArbol root) {
        if (root != null) {
            tablaSiguientes(root.getIzquierda());
            tablaSiguientes(root.getDerecha());
            if (".".equals(root.getValor()) || "*".equals(root.getValor()) || "+".equals(root.getValor())) {

                String[] apuntadores = root.getSiguientes()[0].split(",");
                String apuntado = root.getSiguientes()[1];

                if (siguientes.isEmpty()) {
                    for (int i = 0; i < apuntadores.length; i++) {
                        String simbolo = obtenerTerminal(Integer.parseInt(apuntadores[i]))[1];
                        String[] siguiente = {apuntadores[i], simbolo, apuntado};
                        this.siguientes.add(siguiente);
                    }
                } else {

                    for (int i = 0; i < apuntadores.length; i++) {
                        if (existeSiguiente(apuntadores[i]) != null) {
                            existeSiguiente(apuntadores[i])[2] += "," + apuntado;
                        } else {
                            String simbolo = obtenerTerminal(Integer.parseInt(apuntadores[i]))[1];
                            String[] siguiente = {apuntadores[i], simbolo, apuntado};
                            this.siguientes.add(siguiente);
                        }
                    }
                }

            }
        }
    }

    private void quitarRepetidosDeSiguientes(NodoArbol root) {
        if (root != null) {
            quitarRepetidosDeSiguientes(root.getIzquierda());
            quitarRepetidosDeSiguientes(root.getDerecha());
            for (String[] siguiente : this.siguientes) {

                String[] arr = siguiente[2].split(","); //En la posicion 2 están los numeros
                ArrayList<Integer> repetidos = new ArrayList();  //Los ingresamos en un arrayList
                for (int i = 0; i < arr.length; i++) {
                    repetidos.add(Integer.parseInt(arr[i]));
                }
                Set<Integer> hashset = new HashSet(repetidos);
                repetidos.clear();
                repetidos.addAll(hashset);
                Collections.sort(repetidos);
                String sinRepetir = "";
                int contador = 0;
                for (Integer i : repetidos) {
                    if (contador < repetidos.size() - 1) {
                        sinRepetir += i + ",";
                    } else {
                        sinRepetir += i;
                    }
                    contador++;
                }
                siguiente[2] = sinRepetir;
            }

        }

    }

    private String[] obtenerTerminal(int t) {
        String[] nuevo;
        for (String[] i : this.terminales) {
            if (Integer.parseInt(i[0]) == t) {
                nuevo = i;
                return nuevo;
            }
        }
        return null;
    }

    private String[] existeSiguiente(String a) {
        for (String[] i : siguientes) {
            if (a.equals(i[0])) {
                return i;
            }
        }
        return null;
    }

    //Método que le sirve al método crear estados
    private void verificarTemporal(String[] simbolo) {
        boolean bandera = false;
        for (String temp[] : temporal) {
            if (simbolo[1].equals(temp[1])) {
                String[] numerosSimbolo = simbolo[2].split(",");
                String[] numerosTemp = temp[2].split(",");

                ArrayList<Integer> numerosTotales = new ArrayList();

                for (int i = 0; i < numerosSimbolo.length; i++) {
                    numerosTotales.add(Integer.parseInt(numerosSimbolo[i]));
                }
                for (int i = 0; i < numerosTemp.length; i++) {
                    numerosTotales.add(Integer.parseInt(numerosTemp[i]));
                }

                Set<Integer> hashset = new HashSet(numerosTotales);
                numerosTotales.clear();
                numerosTotales.addAll(hashset);
                Collections.sort(numerosTotales);
                String sinRepetir = "";
                int contador = 0;
                for (Integer i : numerosTotales) {
                    if (contador < numerosTotales.size() - 1) {
                        sinRepetir += i + ",";
                    } else {
                        sinRepetir += i;
                    }
                    contador++;
                }
                temp[2] = sinRepetir;
                bandera = true;
            }
        }
        if (!bandera) {
            temporal.add(simbolo);
        }
        //return null;
    }

    private boolean existeEstado(ArrayList<Integer> numeros) {
        boolean bandera = false;
        for (NodoEstado estado : this.estados) {
            ArrayList<Integer> numerosEstado = estado.getNumeros();

            int longitudAnterior = numerosEstado.size();
            int longitudActual = numeros.size();
            int comparador = 0;

            if (longitudAnterior == longitudActual) {
                for (Integer anterior : numerosEstado) {
                    for (Integer numero : numeros) {
                        if (anterior == numero) {
                            comparador++;
                        }
                    }
                }
            }
            if (comparador == longitudActual) {
                bandera = true;
            }
        }

        return bandera;
    }

    private String[] obtenerSiguiente(int simbolo) { //Obteniendo el siguiente recibiendo un simbolo

        for (String[] siguiente : siguientes) {
            if (siguiente[0].equals(String.valueOf(simbolo))) {
                return siguiente;
            }
        }
        return null;
    }
}
