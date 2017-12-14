package testes;


import arquivo.Arquivo;
import java.io.File;
import java.io.FileNotFoundException;

public class Sintatico {

    public static void main(String[] args) throws FileNotFoundException {


        String sourcecode = "novo.txt";

        Arquivo arq = new Arquivo(new File(sourcecode));
        String texto = arq.getTexto();
        

        
     

    }
}