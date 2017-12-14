package testes;


import arquivo.Arquivo;
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
public class LeituraArquivo {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        Arquivo arq = new Arquivo("testes.txt");
        
        //System.out.println(arq.getLinhas());
        System.out.println(arq.getTexto());
    }
}
