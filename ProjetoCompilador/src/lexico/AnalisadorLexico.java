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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * @author brunoslima
 * @author leandroungari
 */
public class AnalisadorLexico {

    private ArrayList<Item> tabela;
    public static int linha;
    public static int coluna;

    private static final ArrayList<String> palavrasReservadas  = new ArrayList<>();
    private static final ArrayList<String> operadores  = new ArrayList<>();


    public AnalisadorLexico() {

        this.tabela = new ArrayList<>();

        //this.gerarLexico();
        
        palavrasReservadas.addAll(Arrays.asList(new String[]{
            "begin", "end",
            "program", "boolean", "int", "procedure",
            "while", "do", "if", "then", "else", "var", "read", "write"
        }));
        
        operadores.addAll(Arrays.asList(new String[]{
            "<", ">", ">=", "<=", "=", "<>", ":=",
            "+", "-", "*", "div", "and", "or", "not"
        }));
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
        Lexer l = new Lexer(new StringReader(textoLinha));
        Item item = null;
        while (true) {

            

            try {

                item = l.yylex();

                if (item == null) {
                    return;
                }

                if (       item.getTipo() != Simbolo.NOVA_LINHA
                        && item.getTipo() != Simbolo.COMENTARIO_LINHA
                        && item.getTipo() != Simbolo.ESPACO
                        && item.getTipo() != Simbolo.COMENTARIO_MULTI
                        && item.getTipo() != Simbolo.TAB) {
                    this.tabela.add(item);
                }

            } catch (IOException ex) {
                Logger.getLogger(AnalisadorLexico.class.getName()).log(Level.SEVERE, null, ex);
            }

   
        }

    }

    public ArrayList<Item> getTabela() {
        return tabela;
    }

    public static ArrayList<String> getPalavrasReservadas() {
        return palavrasReservadas;
    }
    
    public static ArrayList<String> getOperadores() {
        return operadores;
    }

}
