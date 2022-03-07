package Proyecto1_Compi;

import Estructuras.Nodos.NodoEstado;
import java.util.*;

public class Proyecto1 {

    public static void main(String[] args) {
        Menu nuevo = new Menu();
        nuevo.setVisible(true);

//        ArrayList<NodoEstado> lista = new ArrayList();
//        NodoEstado estado0 = new NodoEstado("S0");
//        estado0.setNumero(1);
//        estado0.setNumero(2);
//        estado0.setNumero(3);
//        lista.add(estado0);
//
//        ArrayList<Integer> numeros = estado0.getNumeros();
//
//        int tamanio = numeros.size();
//        int contador = 0;
//
//        while (contador < tamanio) {
//            int number = numeros.get(contador);
//            System.out.println("Número: " + number);
//            if (contador == 2) {
//                numeros.add(4);
//                tamanio++;
//            } else if (contador == 3) {
//                numeros.add(5);
//                tamanio++;
//            }
//            contador++;
//        }
//        for (Integer numero : numeros) {
//            numeros.add(4);
//        }

//        boolean siExiste = elementosExistentesDeEstado(lista.get(0).getNumeros());
//        if (siExiste) {
//            System.out.println("Si existe");
//        } else {
//            System.out.println("No existe");
//        }
    }

    public static boolean elementosExistentesDeEstado(ArrayList<Integer> numeros) {
        boolean bandera = false;
        ArrayList<Integer> anteriores = new ArrayList();
        anteriores.add(2);
        anteriores.add(1);
        anteriores.add(3);
        int longitudAnterior = anteriores.size();
        int longitudActual = numeros.size();
        int comparador = 0;

        if (longitudAnterior == longitudActual) {
            for (Integer anterior : anteriores) {
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

        return bandera;
    }
}
