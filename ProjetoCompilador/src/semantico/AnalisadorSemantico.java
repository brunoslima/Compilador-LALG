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
 * @author leandroungari
 */
public class AnalisadorSemantico {
    
    private static HashMap<String, Tabela> conjunto = new HashMap<>();
    
    public static Tabela tabelaAtual; 
    private static String programaPrincipal;
    
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

    public static void setProgramaPrincipal(String programaPrincipal) {
        AnalisadorSemantico.programaPrincipal = programaPrincipal;
    }
    
    public static void visualizar(String nome){
        
        Set<String> chaves = conjunto.keySet();
        for (String chave : chaves){
            if(chave != null && chave.equals(nome)){
                System.out.println("Tabela: " + chave);
                conjunto.get(chave).visualizar();
            }
        }
    }
    
    public static void test(String a){
        System.out.println("test" + a);
    }
    
}