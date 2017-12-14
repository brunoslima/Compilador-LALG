/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class AnalisadorSemantico {
    
    public static HashMap<String, Tabela> conjunto = new HashMap<>();
    
    public static Tabela tabelaAtual; 
    public static String programaPrincipal;
    
    public static void init() {
        
        conjunto.clear();
        
        tabelaAtual = null;
    }
    
    public static void addProcedure(String nome, int linha, int coluna){
        
        if (conjunto.containsKey(nome)) {
            
            TabelaErrosSemantico.add("Procedimento já declarado", linha, coluna);
        }
        else {
            conjunto.put(nome, new Tabela(nome));
        }
    }
    
    public static void selectProcedure(String nome){
        
        tabelaAtual = conjunto.get(nome);
        tabelaAtual.visualizar();
    }

    public static void setProgramaPrincipal(String programaPrincipal) {
        AnalisadorSemantico.programaPrincipal = programaPrincipal;
    }

    public static void visualizar(){
        
        Set<String> chaves = conjunto.keySet();
        for (String chave : chaves){
            if(chave != null){
                System.out.println("\nTitulo: " + chave);
                conjunto.get(chave).visualizar();
            }
        }
    }
    
    public static void visualizar(String nome){
        
        Set<String> chaves = conjunto.keySet();
        for (String chave : chaves){
            if(chave != null && chave.equals(nome)){
                System.out.println("\nTitulo: " + chave);
                conjunto.get(chave).visualizar();
            }
        }
    }
    
}