/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;

import javax.swing.JOptionPane;

/**
 *
 * @author leandroungari
 */
public class Comando {
    
    private static Interpretador interpretador;

    public static void setInterpretador(Interpretador interpretador) {
        Comando.interpretador = interpretador;
    }
    
    
    
    public static void crct(int c) {
        
        interpretador.getPilha().push(c);
    }
    
    public static void crvl(int n) {
        
        interpretador.getPilha().push(interpretador.getPilha().get(n));
    }
    
    public static void armz(int n){
        
        interpretador.getPilha().set(n, interpretador.getPilha().pop());
    }
    
    public static void soma(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push(a+b);
    }
    
    public static void subt() {
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push(b-a);
    }
    
    public static void mult() {
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push(a*b);
    }
    
    public static void divi() throws Exception {
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        if (a == 0) {
            throw new Exception("Erro - Divisão por zero!");
        }
        
        interpretador.getPilha().push(b/a);
    }
    
    public static void modi() {
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push(a%b);
    }
    
    public static void invr(){
        
        int a = interpretador.getPilha().pop();
        interpretador.getPilha().push(-a);
    }
    
    public static void conj(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( a == b && b == 1) ? 1 : 0));
    }
    
    public static void disj(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( a == 1 || b == 1) ? 1 : 0));
    }
    
    public static void nega(){
        
        int a = interpretador.getPilha().pop();
        interpretador.getPilha().push(1-a);
    }
    
    public static void cmme(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( b < a) ? 1 : 0));
    }
    
    public static void cmma(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( b > a) ? 1 : 0));
    }
    
    public static void cmig(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( b == a) ? 1 : 0));
    }
    
    public static void cmdg(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( b != a) ? 1 : 0));
    }
    
    public static void cmag(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( b >= a) ? 1 : 0));
    }
    
    public static void cmeg(){
        
        int a = interpretador.getPilha().pop();
        int b = interpretador.getPilha().pop();
        
        interpretador.getPilha().push((( b >= a) ? 1 : 0));
    }
    
    public static void dsvs(int p){
        
        interpretador.setContadorInstrucao(p);
        interpretador.setFlagIncrementarInstrucao(false);
    }
    
    public static void dsvf(int p){
        
        int a = interpretador.getPilha().pop();
        
        if (a == 0) {
            interpretador.setContadorInstrucao(p);
            interpretador.setFlagIncrementarInstrucao(false);
        }
    }
    
    public static void nada(){
        
        
    }
    
    public static void leit(){
        
        //mostra o texto pedindo a entrada também na tela
        String valor = JOptionPane.showInputDialog(null, "Entre com um valor inteiro: ");
        
        interpretador.getPilha().push(Integer.parseInt(valor));
    }

    static void leich() {
        
        //mostra o texto pedindo a entrada também na tela
        String valor = JOptionPane.showInputDialog(null, "Entre com um valor caracter: ");
        
        interpretador.getPilha().push(Integer.parseInt(valor));
    }

    static void impr() {
        
        //imprime numero inteiro
    }

    static void impc() {
        
        //imprime o caracter, lembrar de fazer cast
    }

    static void impe() {
        
        //imprime uma quebra de linha
    }

    static void inpp() {
        
        interpretador.setContadorInstrucao(-1);
    }

    static void amem(int parseInt) {
        
        for (int i = 0; i < parseInt; i++) {
            
            interpretador.getPilha().push(0);
        }
    }

    static void dmem(int parseInt) {
        
        for (int i = 0; i < parseInt; i++) {
            
            interpretador.getPilha().pop();
        }
    }

    static void para() {
        
        //Mostrar texto com mensagem de fim de execução
        interpretador.setFlagEncerrarExecucao(true);
    }
}
