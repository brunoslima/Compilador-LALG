package gerador;

import interpretador.Comando;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import semantico.AnalisadorSemantico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leandroungari
 */
public class Gerador {
    
    private static Stack<java.lang.Integer> posicaoIF;
    private static Stack<java.lang.Integer> posicaoIFAUX;
    private static Stack<java.lang.Integer> posicaoELSE;
    private static Stack<java.lang.Integer> posicaoWHILE;
    
    private static int posicaoExpressao;
    
    private static String nomePrograma;
    private static int contadorDados;
    
    private static HashMap<String, Variavel> listaVariaveis;
    private static ArrayList<String> listaComandos;

    public static HashMap<String, Variavel> getListaVariaveis() {
        return listaVariaveis;
    }

    public static ArrayList<String> getListaComandos() {
        return listaComandos;
    }
    

    public static void init() {
        
        listaVariaveis = new HashMap<>();
        listaComandos = new ArrayList<>();
        posicaoIF = new Stack<>();
        posicaoIFAUX = new Stack<>();
        posicaoELSE = new Stack<>();
        posicaoWHILE = new Stack<>();
        contadorDados = 0;
    }

    public String getNomePrograma() {
        return nomePrograma;
    }

    public static void setNomePrograma(String nomePrograma) {
        Gerador.nomePrograma = nomePrograma;
    }
    
    //ok
    public static void iniciarPrograma(String nomePrograma) {
        
        if (AnalisadorSemantico.temErro) return;
        Gerador.nomePrograma = nomePrograma;
        listaComandos.add("INPP");
    }
    //ok
    public static void declararVariavel(String nome, int tipo) {
        
        if (AnalisadorSemantico.temErro) return;
        
        Variavel v = null;
        
        if (tipo == Variavel.INT) {
            
            v = new Integer(nome, contadorDados++);
        }
        else if (tipo == Variavel.BOOLEAN) {
            
            v = new Boolean(nome, contadorDados++);
        }
        
        listaVariaveis.put(nome, v);
        
        listaComandos.add("AMEM 1");
    }
    
    //ok
    public static void atribuicaoVariavel(String nomeVariavel) {
        
        if (AnalisadorSemantico.temErro) return;
        
        int enderecoAlocacao = listaVariaveis.get(nomeVariavel).getEnderecoAlocacao();
        
        listaComandos.add("ARMZ " + enderecoAlocacao);
    }
    
    //ok
    public static void leituraInteiro() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("LEIT");
    }
    
    //ok
    public static void leituraCaracter() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("LEICH");
    }
    
    public static void verificaIf(){
        
        if (AnalisadorSemantico.temErro) return;
        
        posicaoIF.push(listaComandos.size());
        //posicaoIF = listaComandos.size();
        executaNada();
    }
    
    public static void desvioIf(){
        
        if (AnalisadorSemantico.temErro) return;
        
        desvioSeFalso(posicaoIF.peek(), listaComandos.size());
        posicaoIFAUX.push(posicaoIF.pop());
    }
    
    public static void verificaElse(){
        
        if (AnalisadorSemantico.temErro) return;
        
        executaNada();
        posicaoELSE.push(listaComandos.size() - 1);
        //posicaoELSE = listaComandos.size() - 1;
    }
    
    public static void setExpressao(int num) {
        
        if (AnalisadorSemantico.temErro) return;
        
        posicaoExpressao = num;
    }
    
    public static void desvioElse(){
        
        if (AnalisadorSemantico.temErro) return;
        
        desvioIncondicional(posicaoELSE.peek(), listaComandos.size());
        desvioSeFalso(posicaoIFAUX.pop(), posicaoELSE.pop() + 1);
    }
    
    public static void verificaWhile() {
        
        if (AnalisadorSemantico.temErro) return;
        
        posicaoWHILE.push(listaComandos.size());
        executaNada();
    }
    
    public static int getContador() {
        
        return listaComandos.size();
    }
    
    public static void desvioWhile() {
        
        if (AnalisadorSemantico.temErro) return;
        
        executaNada();
        desvioIncondicional(listaComandos.size() - 1, posicaoExpressao);
        desvioSeFalso(posicaoWHILE.pop(), listaComandos.size());
    }
    
    public static void verificaRelacao(String simbolo){
        
        if (AnalisadorSemantico.temErro) return;
        
        switch(simbolo) {
            //<SIMBOLO_IGUAL> 
            //| t = <SIMBOLO_DIFERENTE> 
            //| t = <SIMBOLO_MENOR> 
            //| t = <SIMBOLO_MENOR_IGUAL> 
            //| t = <SIMBOLO_MAIOR_IGUAL> 
            //| t = <SIMBOLO_MAIOR>
            case "=":
                comparaIgual();
                break;
                
            case "<>":
                comparaDesigual();
                break;
                
            case "<":
                comparaMenor();
                break;
                
            case "<=":
                comparaMenorIgual();
                break;
                
            case ">=":
                comparaMaiorIgual();
                break;
                
            case ">":
                comparaMaior();
                break;
        }
    }
    
    public static void inverterSinal() {
        
        if (AnalisadorSemantico.temErro) return;
        
        inversao();
    }
    
    public static void verificarOperador(String operador){
        
        if (AnalisadorSemantico.temErro) return;
        
        switch(operador) {
            
            case "+":
                adicao();
                break;
                
            case "-":
                subtracao();
                break;
                
            case "or":
                disjuncao();
                break;
                
            case "*":
                multiplicacao();
                break;
                
            case "div":
                divisao();
                
                break;
                
            case "and":
                disjuncao();
                break;
                
            case "not":
                
                negacao();
                break;
        }
    }
    
    public static void carregarValorConstante(int valor) {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CRCT " + valor);
    }
    
    public static void carregarValorDaVariavel(String nomeVariavel) {
        
        if (AnalisadorSemantico.temErro) return;
        
        int enderecoAlocacao = listaVariaveis.get(nomeVariavel).getEnderecoAlocacao();
        
        listaComandos.add("CRVL " + enderecoAlocacao);
    }
    
    public static void adicao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("SOMA");
    } 
    
    public static void subtracao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("SUBT");
    }
    
    public static void multiplicacao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("MULT");
    }
    
    public static void divisao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("DIVI");
    }
    
    public static void modulo() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("MODI");
    }
    
    public static void inversao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("INVR");
    }
    
    public static void conjuncao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CONJ");
    }
    
    public static void disjuncao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("DISJ");
    }
    
    public static void negacao() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("NEGA");
    }
    
    public static void comparaMaior() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CMMA");
    }
    
    public static void comparaMenor() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CMME");
    }
    
    public static void comparaIgual() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CMIG");
    }
    
    public static void comparaDesigual() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CMDG");
    }
    
    public static void comparaMenorIgual() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CMEG");
    }
    
    public static void comparaMaiorIgual() {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("CMAG");
    }
    
    public static void desvioIncondicional(int posicaoComando, int posicaoDesvio){
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.set(posicaoComando, "DSVS " + posicaoDesvio);
    }
    
    public static void desvioSeFalso(int posicaoComando, int posicaoDesvio){
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.set(posicaoComando, "DSVF " + posicaoDesvio);
    }
    
    public static void executaNada(){
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("NADA");
    }
    
    public static void imprimeInteiro(){
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("IMPR");
    }
    
    public static void imprimeCaracter(){
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("IMPC");
    }
    
    public static void imprimeNovaLinha(){
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("IMPE");
    }
    
    public static void alocaMemoria(int n) {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("AMEM " + n);
    }
    
    public static void desalocaMemoria(int n) {
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("DMEM " + n);
    }
    
    //ok
    public static void finalizarPrograma(){
        
        if (AnalisadorSemantico.temErro) return;
        
        listaComandos.add("PARA");
    }
    
    
    ///////////////////////////
    public static void listaVariaveisRead(String s) {
        
        if (AnalisadorSemantico.temErro) return;
        
        //System.out.println("Lista: " + s + " >");
        String[] lista = s.split(",");
        
        for(String variavel: lista){
            
            Gerador.leituraInteiro();
            Gerador.atribuicaoVariavel(variavel);
        }

    }
    
    public static void listaVariaveisWrite(String s){
        
        if (AnalisadorSemantico.temErro) return;
        
        String[] lista = s.split(",");
        
        for(String variavel: lista){
            
            Gerador.carregarValorDaVariavel(variavel);
            Gerador.imprimeInteiro();
        }
    }
    
    
    public static void gerarArquivo(String filename) throws FileNotFoundException{
        
        if (AnalisadorSemantico.temErro) return;
        
        PrintStream arquivo = new PrintStream(new File(filename));
        
        for(String comando: listaComandos){
            
            arquivo.println(comando);
        }
        
        arquivo.close();
    }
    
}
