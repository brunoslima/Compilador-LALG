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
 *
 * @author leandroungari
 */
public class Arquivo {
    
    private File arquivo;
    private ArrayList<String> linhas;

    public Arquivo(File arquivo) throws FileNotFoundException {
    
        this.arquivo = arquivo;
        
        linhas = new ArrayList<>();
        
        this.lerArquivo();
    }
    
    public Arquivo(String filename) throws FileNotFoundException {
    
        this.arquivo = new File(filename);
        
        linhas = new ArrayList<>();
        
        this.lerArquivo();
    }
    
    private void lerArquivo() throws FileNotFoundException{
        
        Scanner leitura = new Scanner(this.arquivo);
        
        while(leitura.hasNextLine()){
            
            this.linhas.add(leitura.nextLine());
        }
        
    }
    
    public ArrayList<String> getLinhas(){
        
        return linhas;
    }
    
    
}
