/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author leandroungari
 */
public class Tabela {
    
    private static ArrayList<Variaveis> listaParametros = new ArrayList<>();
    
    private static HashMap<String, Variaveis> tabelaVariaveis = new HashMap<>();
    
    
    public Tabela() {
        
        listaParametros.clear();
        tabelaVariaveis.clear();
    }
    
    public static void addParametro(String nome, int tipo){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(nome);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(nome);
        }
        
        listaParametros.add(v);
        tabelaVariaveis.put(nome, v);
    }
    
    public static void addParametro(String nome, int tipo, int valor){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean((valor == 1), nome);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(valor, nome);
        }
        
        listaParametros.add(v);
        tabelaVariaveis.put(nome, v);
    }

    public static void addVariavel(String nome, int tipo){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(nome);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(nome);
        }
        
        tabelaVariaveis.put(nome, v);
    }
    
    public static void addVariavel(String nome, int tipo, int valor){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean((valor == 1), nome);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(valor, nome);
        }
        
        tabelaVariaveis.put(nome, v);
    }
    
    public void visualizar(){
        
        System.out.println("Lista de parametros: ");
        for (Variaveis v : listaParametros) {
            v.visualizar();
        }
        
        Set<String> chaves = tabelaVariaveis.keySet();
        for (String chave : chaves){
            if(chave != null){
                System.out.println("Tabela: " + chave);
                tabelaVariaveis.get(chave).visualizar();
            }
        }
    }
    
}
