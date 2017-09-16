/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class AnalisadorLexico {
    
    
    private static ArrayList<Item> tabela = new ArrayList<>();
    
    
    // ^[0-9]+\.[0-9]{1,6}$ => número real com até 6 casas depois da vírgula
    // ^[0-9]+$             => número inteiro
    // ^\+$                 => adição
    // ^\-$                 => subtração
    // ^\*$                 => multiplicação
    // ^\/$                 => divisão
    // ^\($                 => abre parentese
    // ^\)$                 => fecha parentese
    
    public AnalisadorLexico(){
        
        this.tabela.clear();
        
        //this.gerarLexico();
    }
    
    
    public void gerarLexico(){
        
        File file = new File("src/lexico/Lexer.flex");
        
        jflex.Main.generate(file);
    }
    
    public void analisar(String texto){
        
        Lexer l = new Lexer(new StringReader(texto));
        try {
            l.yylex();
        } catch (IOException ex) {
            Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static ArrayList<Item> getTabela() {
        return tabela;
    }
    
  
    
    
}
