/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.HashMap;

/**
 *
 * @author leandroungari
 */
public class AnalisadorSemantico {
    
    private static HashMap<String, Tabela> conjunto = new HashMap<>();
    
    private static Tabela tabelaAtual; 
    
    public static void init() {
        
        conjunto.clear();
        
        tabelaAtual = null;
    }
    
    public static void addProcedure(String nome, int linha, int coluna){
        
        if (conjunto.containsKey(nome)) {
            
            TabelaErrosSemantico.add("Procedimento já declarado", linha, coluna);
        }
        else {
            conjunto.put(nome, new Tabela());
        }
    }
    
    public static void selectProcedure(String nome){
        
        tabelaAtual = conjunto.get(nome);
    }
    
    
    
    
    
}
