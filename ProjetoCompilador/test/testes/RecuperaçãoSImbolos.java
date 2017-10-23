/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import arquivo.Arquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import sintatico.Lexer;
import sintatico.Parser;

/**
 *
 * @author leandroungari
 */
public class RecuperaçãoSImbolos {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String sourcecode = "novo.txt";

        Arquivo arq = new Arquivo(new File(sourcecode));
        String texto = arq.getTexto();

        Lexer l = new Lexer(new StringReader(texto));
        
        while(true){
            System.out.println(l.next_token());
        }

    }
}
