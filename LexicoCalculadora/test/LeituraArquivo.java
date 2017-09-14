
import arquivo.Arquivo;
import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leandroungari
 */
public class LeituraArquivo {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Arquivo arq = new Arquivo("testes.calculadora");
        
        System.out.println(arq.getLinhas());
    }
}
