/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class TabelaErrosSemantico {
    
    private static ArrayList<ErroSemantico> lista = new ArrayList<>();

    
    public static void init(){
        
        lista.clear();
    }
    
    public static void add (String message, int linha, int coluna) {
        
        lista.add(new ErroSemantico(message, linha, coluna));
    }
    
    public static void visualizar(){
            
        System.out.println("Lista de erros semanticos: ");
        for (ErroSemantico e : lista) {
            e.visualizar();
        }
    }

    private static class ErroSemantico {
        
        private String message;
        private int linha;
        private int coluna;

        public ErroSemantico(String message, int linha, int coluna) {
            this.message = message;
            this.linha = linha;
            this.coluna = coluna;
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
    }
    
}
