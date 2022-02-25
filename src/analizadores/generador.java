/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadores;

/**
 *
 * @author Squery
 */
public class generador {

    public static void main(String[] args) {
        try {
            String ruta = "src/analizadores/";
            String opcFlex[] = {ruta + "lex.jflex", "-d", ruta};
            jflex.Main.generate(opcFlex);

            String opcCup[] = {"-destdir", ruta, "-parser", "Parser", ruta + "parser.cup"};
            java_cup.Main.main(opcCup);
        } catch (Exception e) {
        }
    }
}
