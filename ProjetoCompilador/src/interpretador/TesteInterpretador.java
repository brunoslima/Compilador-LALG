/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leandroungari
 */
public class TesteInterpretador {

    public static void main(String[] args) {

        Interpretador in = new Interpretador();
        try {

            in.lerArquivo("programa.in");

            in.executar();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TesteInterpretador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
