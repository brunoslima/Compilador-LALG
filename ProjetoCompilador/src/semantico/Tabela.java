/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import gerador.Gerador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import static semantico.AnalisadorSemantico.conjunto;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class Tabela {
    
    public ArrayList<Variaveis> listaParametros = new ArrayList<>();
    public HashMap<String, Variaveis> tabelaVariaveis = new HashMap<>();
    
    public String nome;
    
    public Tabela(String nome) {
        
        this.nome = nome;
        listaParametros.clear();
        tabelaVariaveis.clear();
    }
    
    public void addParametro(String nome, int tipo){
        
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
    
    public void addParametro(String nome, int tipo, int valor){
        
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

    public void addVariavel(String nome, int tipo){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean(nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(nome, tipo);
        }
        
        tabelaVariaveis.put(nome, v);
    }
    
    public void addVariavel(String nome, int tipo, int valor){
        
        Variaveis v = null;
        
        if (tipo == Variaveis.BOOLEAN) {
            
            v = new Boolean((valor == 1), nome, tipo);
        }
        else if (tipo == Variaveis.INT) {
            
            v = new Integer(valor, nome, tipo);
        }
        
        tabelaVariaveis.put(nome, v);
    }

    public void separarVariaveis(String literal, int linha, int coluna){

        String [] elementos;
        literal = literal.replace(";", "");
        
        if(literal.charAt(0) == 'i' && literal.charAt(1) == 'n' && literal.charAt(2) == 't'){ //int
            
            literal = literal.replace("int", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){
                
                if(!verificarExistencia(elementos[i])) {
                    
                    addVariavel(elementos[i], 5);
                    
                    Gerador.declararVariavel(elementos[i], gerador.Variavel.INT);
                    
                } //5 == int
                else TabelaErrosSemantico.add("Variavel " + elementos[i] + " já declarada neste escopo", linha, coluna);
            }
            
        }
        else if(literal.charAt(0) == 'b' && literal.charAt(1) == 'o'){ //boolean
            
            literal = literal.replace("boolean", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){

                if(!verificarExistencia(elementos[i])) {
                    addVariavel(elementos[i], 2);
                    
                    Gerador.declararVariavel(elementos[i], gerador.Variavel.BOOLEAN);
                } //2 == boolean
                else TabelaErrosSemantico.add("Variavel " + elementos[i] + " já declarada neste escopo", linha, coluna);
            }
            
        }
        
    }
    
    public void separarParametros(String literal, int linha, int coluna){

        String [] elementos;
        
        if(literal.contains("int")){ //int
            
            literal = literal.replace("int", "");

            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){
                
                if(!verificarExistencia(elementos[i])) addParametro(elementos[i], 5); //5 == int
                else TabelaErrosSemantico.add("Variavel " + elementos[i] + " já declarada neste parametro", linha, coluna);
            }
            
        }
        else if(literal.contains("boolean")){ //boolean
            
            literal = literal.replace("boolean", "");
            
            elementos = literal.split(",");
            for(int i = 0; i < elementos.length; i++){

                if(!verificarExistencia(elementos[i]))addParametro(elementos[i], 2); //2 == boolean
                else TabelaErrosSemantico.add("Variavel " + elementos[i] + " já declarada neste escopo", linha, coluna);
            }
            
        }
        
    }
    
    public boolean verificarExistencia(String nome){

        for (Variaveis v : listaParametros) {
            if(v.nome.equals(nome)){
                return true;
            }
        }
        
        Set<String> chaves = tabelaVariaveis.keySet();
        for (String chave : chaves){
            if(chave.equals(nome)){
                return true;
            }
        }
        
        return false;
    }
    
    public void visualizar(){
        
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
    
    public void atribuirValor(String variavel, String valor){
                
        Variaveis v = tabelaVariaveis.get(variavel);
        //v.setValor(valor); //String que vem como parametro
    }
    
}
