/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author brunoslima
 * @author leandroungari
 */
public class Arquivo {
    
    private File arquivo;
    //private ArrayList<String> linhas;
    private String texto;

    public Arquivo(File arquivo) throws FileNotFoundException {
    
        this.arquivo = arquivo;
        
        //linhas = new ArrayList<>();
        this.texto = "";
        
        this.lerArquivo();
    }
    
    public Arquivo(String filename) throws FileNotFoundException {
    
        this.arquivo = new File(filename);
        
        //linhas = new ArrayList<>();
        this.texto = "";
        
        this.lerArquivo();
    }
    
    private void lerArquivo() throws FileNotFoundException{
        
        Scanner leitura = new Scanner(this.arquivo);
        
        while(leitura.hasNextLine()){
            
            //this.linhas.add(leitura.nextLine());
            this.texto += leitura.nextLine() + "\n";
        }
        
    }
    
    /*
    public ArrayList<String> getLinhas(){
        
        return linhas;
    }*/
    
    /*
    public String getTexto(){
        
        String texto = "";
        
        for(String a : this.linhas){
            texto += a + "\n";
        }
        
        return(texto);
    }*/
    
    public String getTexto(){
        
        return this.texto;
    }
    
    
}
