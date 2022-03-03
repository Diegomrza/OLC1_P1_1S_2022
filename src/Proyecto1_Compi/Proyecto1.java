package Proyecto1_Compi;

import Estructuras.ArbolBinario;
import Estructuras.ListaSimple;
import Estructuras.NodoArbol;
import java.util.ArrayList;
import java.util.Collections;

public class Proyecto1 {

    public static void main(String[] args) {
        Menu nuevo = new Menu();
        nuevo.setVisible(true);

//        String primerosi = "1";
//        String primerosd = "4";
//
//        String primerosIzq[] = primerosi.split(",");
//        String primerosDer[] = primerosd.split(",");
//
//        String PRIMEROS = "";
//        for (int i = 0; i < primerosIzq.length; i++) {
//                PRIMEROS += primerosIzq[i] + ",";
//        }
//        for (int j = 0; j < primerosDer.length; j++) {
//            if (j < primerosDer.length - 1) {
//                PRIMEROS += primerosDer[j] + ",";
//            } else {
//                PRIMEROS += primerosDer[j];
//            }
//
//        }
//        System.out.println(PRIMEROS);
//        ArrayList<Object> lista = new ArrayList();
//        lista.add(new NodoArbol("Diego", null, null));
//        lista.add(new NodoArbol("Angel", null, null));
//        lista.add(new NodoArbol("Jairo", null, null));
//        lista.add(new NodoArbol("Chejo", null, null));
//        lista.add(new NodoArbol("Mayorga", null, null));
//        lista.add(new NodoArbol("Jeranio", null, null));
//
//        ArbolBinario arbol = new ArbolBinario("Nombre", null);
//
//        int contador = 0;
//        while (contador < lista.size()) {
//            NodoArbol nodo = (NodoArbol) lista.get(contador);
//            System.out.println("Elemento: " + nodo.getValor());
//            contador++;
//        }
//        for (Object i : lista) {
//            NodoArbol node = (NodoArbol) i;
//            System.out.println(node.getValor());
//        }
//
//        ArrayList<Integer> listaNumeros = new ArrayList();
//        for (int i = 1; i < 11; i++) {
//            int numeroRandom = (int) (Math.random() * (100 - 0) + 0);
//            listaNumeros.add(numeroRandom);
//        }
//        
//        System.out.println("Numeros ordenados:");
//        Collections.sort(listaNumeros);
//        for (Integer i : listaNumeros) {
//            System.out.println(i);
//        }
    }
}
