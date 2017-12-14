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
 * @author brunoslima
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
            
            v = new Boolean(nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(nome, tipo);
        }
        
        listaParametros.add(v);
        tabelaVariaveis.put(nome, v);
    }
    
    public static void addParametro(String nome, int tipo, int valor){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean((valor == 1), nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(valor, nome, tipo);
        }
        
        listaParametros.add(v);
        tabelaVariaveis.put(nome, v);
    }

    public static void addVariavel(String nome, int tipo){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(nome, tipo);
        }
        
        tabelaVariaveis.put(nome, v);
    }
    
    public static void addVariavel(String nome, int tipo, int valor){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean((valor == 1), nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(valor, nome, tipo);
        }
        
        tabelaVariaveis.put(nome, v);
    }

    public static void separarVariaveis(String literal){

        String [] elementos;
        literal = literal.replace(";", "");
        
        if(literal.charAt(0) == 'i' && literal.charAt(1) == 'n' && literal.charAt(2) == 't'){ //int
            
            literal = literal.replace("int", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){
                
                addVariavel(elementos[i], 5); //5 == int
            }
            
        }
        else if(literal.charAt(0) == 'b' && literal.charAt(1) == 'o'){ //boolean
            
            literal = literal.replace("boolean", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){

                addVariavel(elementos[i], 2); //2 == boolean
            }
            
        }
        
    }
    
    public static void visualizar(){
        
        System.out.println("Lista de parametros: ");
        for (Variaveis v : listaParametros) {
            v.visualizar();
        }
        
        System.out.println("Variaveis: ");
        Set<String> chaves = tabelaVariaveis.keySet();
        for (String chave : chaves){
            if(chave != null){
                tabelaVariaveis.get(chave).visualizar();
            }
        }
    }
    
}
