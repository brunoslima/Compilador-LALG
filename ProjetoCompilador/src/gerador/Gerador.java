package gerador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

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
        
        Gerador.nomePrograma = nomePrograma;
        listaComandos.add("INPP");
    }
    //ok
    public static void declararVariavel(String nome, int tipo) {
        
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
    
    public static void atribuicaoVariavel(String nomeVariavel) {
        
        int enderecoAlocacao = listaVariaveis.get(nomeVariavel).getEnderecoAlocacao();
        
        listaComandos.add("ARMZ " + enderecoAlocacao);
    }
    
    public static void leituraInteiro() {
        
        listaComandos.add("LEIT");
    }
    
    
    public static void leituraCaracter() {
        
        listaComandos.add("LEICH");
    }
    
    public static void carregarValorConstante(int valor) {
        
        listaComandos.add("CRCT " + valor);
    }
    
    public static void carregarValorDaVariavel(String nomeVariavel) {
        
        int enderecoAlocacao = listaVariaveis.get(nomeVariavel).getEnderecoAlocacao();
        
        listaComandos.add("CRVL " + enderecoAlocacao);
    }
    
    public static void adicao() {
        
        listaComandos.add("SOMA");
    } 
    
    public static void subtracao() {
        
        listaComandos.add("SUBT");
    }
    
    public static void multiplicacao() {
        
        listaComandos.add("MULT");
    }
    
    public static void divisao() {
        
        listaComandos.add("DIVI");
    }
    
    public static void modulo() {
        
        listaComandos.add("MODI");
    }
    
    public static void inversao() {
        
        listaComandos.add("INVR");
    }
    
    public static void conjuncao() {
        
        listaComandos.add("CONJ");
    }
    
    public static void disjuncao() {
        
        listaComandos.add("DISJ");
    }
    
    public static void negacao() {
        
        listaComandos.add("NEGA");
    }
    
    public static void comparaMaior() {
        
        listaComandos.add("CMMA");
    }
    
    public static void comparaMenor() {
        
        listaComandos.add("CMME");
    }
    
    public static void comparaIgual() {
        
        listaComandos.add("CMIG");
    }
    
    public static void comparaDesigual() {
        
        listaComandos.add("CMDG");
    }
    
    public static void comparaMenorIgual() {
        
        listaComandos.add("CMEG");
    }
    
    public static void comparaMaiorIgual() {
        
        listaComandos.add("CMAG");
    }
    
    public static void desvioIncondicional(){
        
        listaComandos.add("DSVS");
    }
    
    public static void desvioSeFalso(){
        
        listaComandos.add("DSVF");
    }
    
    public static void executaNada(){
        
        listaComandos.add("NADA");
    }
    
    public static void imprimeInteiro(){
        
        listaComandos.add("IMPR");
    }
    
    public static void imprimeCaracter(){
        
        listaComandos.add("IMPC");
    }
    
    public static void imprimeNovaLinha(){
        
        listaComandos.add("IMPE");
    }
    
    public static void alocaMemoria(int n) {
        
        listaComandos.add("AMEM " + n);
    }
    
    public static void desalocaMemoria(int n) {
        
        listaComandos.add("DMEM " + n);
    }
    
    //ok
    public static void finalizarPrograma(){
        
        listaComandos.add("PARA");
    }
    
    
    ///////////////////////////
    public static void listaVariaveisRead(String s) {
        
        //System.out.println("Lista: " + s + " >");
        String[] lista = s.split(",");
        
        for(String variavel: lista){
            
            Gerador.leituraInteiro();
            Gerador.atribuicaoVariavel(variavel);
        }

    }
    
    public static void listaVariaveisWrite(String s){
        
        String[] lista = s.split(",");
        
        for(String variavel: lista){
            
            Gerador.carregarValorDaVariavel(variavel);
            Gerador.imprimeInteiro();
        }
    }
    
    
    public static void gerarArquivo(String filename) throws FileNotFoundException{
        
        
        PrintStream arquivo = new PrintStream(new File(filename));
        
        for(String comando: listaComandos){
            
            arquivo.println(comando);
        }
        
        arquivo.close();
    }
    
}
