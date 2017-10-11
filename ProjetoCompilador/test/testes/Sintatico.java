package testes;


import arquivo.Arquivo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import sintatico.Lexer;
import sintatico.Parser;

public class Sintatico {

    public static void main(String[] args) throws FileNotFoundException {


        String sourcecode = "teste.txt";

        Arquivo arq = new Arquivo(new File(sourcecode));
        String texto = arq.getTexto();
        
        try {
            Parser p = new Parser(new Lexer(new StringReader(texto)));
            String result = String.valueOf( p.debug_parse());
            System.out.println(result);
            
            System.out.println("Compilacao concluida com sucesso...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}