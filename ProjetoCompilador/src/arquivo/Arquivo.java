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
    
    public Arquivo(){
        
        this.texto = "";
    }
    
    private void lerArquivo() throws FileNotFoundException{
        
        Scanner leitura = new Scanner(this.arquivo);
        int num = 0;
        while(leitura.hasNextLine()){
            
            //this.linhas.add(leitura.nextLine());
            this.texto += leitura.nextLine() + /*"\n"*/ System.lineSeparator();
            num++;
        }
        
        System.out.println("Número de linhas: " + num);
        
    }
    
    public void setTexto(String fonte){
        
        this.texto = fonte;
    }
    
    public String getTexto(){
        
        return this.texto;
    }
    
    
}
