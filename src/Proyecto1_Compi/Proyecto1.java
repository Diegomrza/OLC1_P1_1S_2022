package Proyecto1_Compi;

import Estructuras.ArbolBinario;
import analizadores.Lector;
import analizadores.Parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class Proyecto1 {

    public static void main(String[] args) {
        Menu nuevo = new Menu();
        nuevo.setVisible(true);
//        System.out.println("");

//        ArbolBinario arbol = new ArbolBinario();
//        arbol.insertar(0);
//        arbol.insertar(1);
//        arbol.insertar(10);
//        arbol.insertar(3);
//        arbol.insertar(8);
//        arbol.insertar(7);
//        arbol.insertar(9);
//
//        arbol.mostrar();
//        try {
//            String text = leer();
//
//            Lector scanner = new Lector(new BufferedReader(new StringReader(text)));
//            Parser parser = new Parser(scanner);
//            parser.parse();
//        } catch (Exception e) {
//        }
    }

    static String leer() throws IOException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese una ruta de archivo: ");

        String textoFinal = "";
        String rutaArchivo = entrada.nextLine();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                textoFinal += linea + "\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return textoFinal;
    }

}
