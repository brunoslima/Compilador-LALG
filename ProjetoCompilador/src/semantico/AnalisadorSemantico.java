/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

import java.util.HashMap;
import java.util.Set;
import java.util.regex.Pattern;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class AnalisadorSemantico {
    
    public static HashMap<String, Tabela> conjunto = new HashMap<>();
    
    public static Tabela tabelaAtual; 
    public static String programaPrincipal;
    public static boolean temErro;
    public static boolean foiExecutado /*= true*/; //inicializado verdadeiro só para testes
    
    public static void init() {
        
        conjunto.clear();
        AnalisadorSemantico.temErro = false;
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
    
    public static String getProgramaPrincipal(){
        return programaPrincipal;
    }

    public static void verificaVariaveisNaoUtilizadas(){
        
        Set<String> chaves = conjunto.keySet();
        for (String chave : chaves){
            if(chave != null){
                conjunto.get(chave).verificarVariaveisNaoUtilizadas();
            }
        }        
    }
    
    public static void verificaTiposParametrosRW(String s, int linha, int coluna, int RW){
        
        String[] expressoes = s.split (Pattern.quote (","));
        
        String tipo = "";
        for (int i = 0; i < expressoes.length; i++) {
            
            tipo = tabelaAtual.tabelaVariaveis.get(expressoes[i]).tipo;
            
            for (int j = 0; j < expressoes.length; j++) {
                
                if(!tipo.equals(tabelaAtual.tabelaVariaveis.get(expressoes[j]).tipo)){
                    if(RW == 0) TabelaErrosSemantico.add("ERRO - Parametros de tipos diferentes passados ao READ", linha, coluna);
                    else TabelaErrosSemantico.add("ERRO - Parametros de tipos diferentes passados ao WRITE", linha, coluna);
                    return;
                }
            }
        }

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