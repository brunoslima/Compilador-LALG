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
    
    
    private String nomePrograma;
    private int contadorDados;
    
    private HashMap<String, Variavel> listaVariaveis;
    private ArrayList<String> listaComandos;

    public Gerador(HashMap<String, Variavel> listaVariaveis, ArrayList<String> listaComandos) {
        this.listaVariaveis = listaVariaveis;
        this.listaComandos = listaComandos;
        this.contadorDados = 0;
    }

    public Gerador(String nomePrograma, HashMap<String, Variavel> listaVariaveis, ArrayList<String> listaComandos) {
        this.nomePrograma = nomePrograma;
        this.listaVariaveis = listaVariaveis;
        this.listaComandos = listaComandos;
        this.contadorDados = 0;
    }

    public String getNomePrograma() {
        return nomePrograma;
    }

    public void setNomePrograma(String nomePrograma) {
        this.nomePrograma = nomePrograma;
    }
    
    /**
     * Comandos de geração de código
     * 
     */
    
    public void iniciarPrograma(String nomePrograma) {
        
        this.nomePrograma = nomePrograma;
        listaComandos.add("INPP");
    }
    
    public void declararVariavel(String nome, int tipo) {
        
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
    
    public void atribuicaoVariavel(String nomeVariavel) {
        
        int enderecoAlocacao = listaVariaveis.get(nomeVariavel).getEnderecoAlocacao();
        
        listaComandos.add("ARMZ " + enderecoAlocacao);
    }
    
    public void leituraInteiro() {
        
        listaComandos.add("LEIT");
    }
    
    
    public void leituraCaracter() {
        
        listaComandos.add("LEICH");
    }
    
    public void carregarValorConstante(int valor) {
        
        listaComandos.add("CRCT " + valor);
    }
    
    public void carregarValorDaVariavel(String nomeVariavel) {
        
        int enderecoAlocacao = listaVariaveis.get(nomeVariavel).getEnderecoAlocacao();
        
        listaComandos.add("CRVL " + enderecoAlocacao);
    }
    
    public void adicao() {
        
        listaComandos.add("SOMA");
    } 
    
    public void subtracao() {
        
        listaComandos.add("SUBT");
    }
    
    public void multiplicacao() {
        
        listaComandos.add("MULT");
    }
    
    public void divisao() {
        
        listaComandos.add("DIVI");
    }
    
    public void modulo() {
        
        listaComandos.add("MODI");
    }
    
    public void inversao() {
        
        listaComandos.add("INVR");
    }
    
    public void conjuncao() {
        
        listaComandos.add("CONJ");
    }
    
    public void disjuncao() {
        
        listaComandos.add("DISJ");
    }
    
    public void negacao() {
        
        listaComandos.add("NEGA");
    }
    
    public void comparaMaior() {
        
        listaComandos.add("CMMA");
    }
    
    public void comparaMenor() {
        
        listaComandos.add("CMME");
    }
    
    public void comparaIgual() {
        
        listaComandos.add("CMIG");
    }
    
    public void comparaDesigual() {
        
        listaComandos.add("CMDG");
    }
    
    public void comparaMenorIgual() {
        
        listaComandos.add("CMEG");
    }
    
    public void comparaMaiorIgual() {
        
        listaComandos.add("CMAG");
    }
    
    public void desvioIncondicional(){
        
        listaComandos.add("DSVS");
    }
    
    public void desvioSeFalso(){
        
        listaComandos.add("DSVF");
    }
    
    public void executaNada(){
        
        listaComandos.add("NADA");
    }
    
    public void imprimeInteiro(){
        
        listaComandos.add("IMPR");
    }
    
    public void imprimeCaracter(){
        
        listaComandos.add("IMPC");
    }
    
    public void imprimeNovaLinha(){
        
        listaComandos.add("IMPE");
    }
    
    public void alocaMemoria(int n) {
        
        listaComandos.add("AMEM " + n);
    }
    
    public void desalocaMemoria(int n) {
        
        listaComandos.add("DMEM " + n);
    }
    
    public void finalizarPrograma(){
        
        listaComandos.add("PARA");
    }
    
    
    public void gerarArquivo(String filename) throws FileNotFoundException{
        
        
        PrintStream arquivo = new PrintStream(new File(filename));
        
        for(String comando: listaComandos){
            
            arquivo.println(comando);
        }
        
        arquivo.close();
    }
    
}
