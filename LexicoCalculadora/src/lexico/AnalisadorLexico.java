/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bruno
 */
public class AnalisadorLexico {
    
    public static final int NUM_REAL = 1;
    public static final int NUM_INTEIRO = 2;
    public static final int OP_SOMA = 3;
    public static final int OP_SUBTRACAO = 4;
    public static final int OP_MULTIPLICACAO = 5;
    public static final int OP_DIVISAO = 6;
    public static final int PARENTESE_ABRE = 7;
    public static final int PARENTESE_FECHA = 8;
    
    private ArrayList<Item> tabela;
    
    
    // ^[0-9]+\.[0-9]{1,6}$ => número real com até 6 casas depois da vírgula
    // ^[0-9]+$             => número inteiro
    // ^\+$                 => adição
    // ^\-$                 => subtração
    // ^\*$                 => multiplicação
    // ^\/$                 => divisão
    // ^\($                 => abre parentese
    // ^\)$                 => fecha parentese
    
    public AnalisadorLexico(){
        
        this.tabela = new ArrayList<>();
    }
    
    public void analisar(String texto){
        
        
    
        
    }

    public ArrayList<Item> getTabela() {
        return tabela;
    }
    
  
    
    
}
