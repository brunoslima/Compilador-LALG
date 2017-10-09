package testes;


import arquivo.Arquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Arrays;
import sintatico.Lexer;
import sintatico.Parser;

public class Sintatico {

    public static void main(String[] args) throws FileNotFoundException {


        String sourcecode = "teste.txt";

        Arquivo arq = new Arquivo(new File(sourcecode));
        String texto = arq.getTexto();
        
        try {
            Parser p = new Parser(new Lexer(new StringReader(texto)));
            String result = String.valueOf( p.parse().value);
            System.out.println(result);
            
            System.out.println("Compilacao concluida com sucesso...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}