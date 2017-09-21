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
import java.util.regex.Pattern;

/**
 * @author brunoslima
 * @author leandroungari
 */
public class AnalisadorLexico {

    private ArrayList<Item> tabela;

    // ^[0-9]+\.[0-9]{1,6}$ => número real com até 6 casas depois da vírgula
    // ^[0-9]+$             => número inteiro
    // ^\+$                 => adição
    // ^\-$                 => subtração
    // ^\*$                 => multiplicação
    // ^\/$                 => divisão
    // ^\($                 => abre parentese
    // ^\)$                 => fecha parentese
    public AnalisadorLexico() {

        this.tabela = new ArrayList<>();

        //this.gerarLexico();
    }

    /**
     *
     */
    public void gerarLexico() {

        File file = new File("src/lexico/Lexer.flex");

        jflex.Main.generate(file);
    }

    /**
     *
     * @param texto Refere-se ao texto da linha do arquivo
     * @param numLinha Refere-se ao número da linha do arquivo
     */
    public void analisar(String texto, int numLinha) {

        String textoLinha = texto;
        int posicao = 0;
        while (!textoLinha.isEmpty()) {

            Lexer l = new Lexer(new StringReader(textoLinha));
            Item item = null;
            
            
            try {

                item = l.yylex();
                
                if (item == null) return; 
                
                int colunaInicial = posicao;
                int colunaFinal = colunaInicial + item.getSimbolo().length() - 1;
                
                item.setNumLinha(numLinha);
                item.setNumColunaInicial(colunaInicial);
                item.setNumColunaFinal(colunaFinal);
                
                this.tabela.add(item);
                
            } catch (IOException ex) {
                Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
            }

            posicao += item.getSimbolo().length();
            textoLinha = textoLinha.replaceFirst(Pattern.quote(item.getSimbolo()), "");
        }

    }

    public ArrayList<Item> getTabela() {
        return tabela;
    }

}
