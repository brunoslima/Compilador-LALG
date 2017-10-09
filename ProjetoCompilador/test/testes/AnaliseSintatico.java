package testes;


import java.io.File;
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author brunoslima
 * @author leandroungari
 */
public class AnaliseSintatico {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/sintatico/Lexer.flex");

        jflex.Main.generate(file);
        
    }
}
