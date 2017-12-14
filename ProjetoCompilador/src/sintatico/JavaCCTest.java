package sintatico;


import arquivo.Arquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import semantico.AnalisadorSemantico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leandroungari
 */
public class JavaCCTest {

    public static void main(String[] args) throws FileNotFoundException {

        String sourcecode = "teste.txt";

        Arquivo arq = new Arquivo(new File(sourcecode));
        String texto = arq.getTexto();

        Grammar g = new Grammar(new StringReader(texto));

        Grammar.ReInit(new StringReader(texto));
        try {        
            Grammar.compilationUnit();
        } catch (sintatico.ParseException ex) {
            Logger.getLogger(JavaCCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\nAnálise sintática concluída com sucesso.");
        
        System.out.println(RecuperacaoErros.getErros());
        
        Set<String> chaves = AnalisadorSemantico.conjunto.keySet();
        for (String chave : chaves){
            if(chave != null){
                System.out.println("chave: " + chave);
                AnalisadorSemantico.conjunto.get(chave).visualizar();
            }
        }
    }

    public static List<Token> tokenize(Grammar parser) throws FileNotFoundException {
        List<Token> tokens = new ArrayList<>();

        Token token = Grammar.getNextToken();
        while (token.kind != GrammarConstants.EOF) {
            tokens.add(token);
            token = Grammar.getNextToken();
        }
        return tokens;
    }
}
