/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class TabelaErrosSemantico {
    
    public static ArrayList<Erro> lista = new ArrayList<>();

    
    public static void init(){
        
        lista.clear();
    }
    
    public static void add (String message, int linha, int coluna) {
        
        lista.add(new Erro(message, linha, coluna));
    }
    
    public static void add (String message) {
        
        lista.add(new Erro(message));
    }
    
    public static String getErros(){
        
        String listaString = "";
        for (Erro e : lista) {
            listaString += e.getString();
        }        
        
        return listaString;
    }
    
    public static void visualizar(){
            
        System.out.println("Lista de erros semanticos: ");
        for (Erro e : lista) {
            e.visualizar();
        }
    }

    private static class Erro {
        
        private String message;
        private int linha;
        private int coluna;

        public Erro(String message, int linha, int coluna) {
            this.message = message;
            this.linha = linha;
            this.coluna = coluna;
        }
        
        public Erro(String message) {
            this.message = message;
        }        

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getLinha() {
            return linha;
        }

        public void setLinha(int linha) {
            this.linha = linha;
        }

        public int getColuna() {
            return coluna;
        }

        public void setColuna(int coluna) {
            this.coluna = coluna;
        }
        
        public void visualizar(){
            
            System.out.println(getMessage() + " - Linha: " + getLinha() + " Coluna: " + getColuna());
        }
        
        public String getString(){
            
            return getMessage() + " - Linha: " + getLinha() + " Coluna: " + getColuna() + "\n";
        }
    }
    
}
