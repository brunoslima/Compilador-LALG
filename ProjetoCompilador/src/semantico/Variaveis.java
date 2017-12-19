/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semantico;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class Variaveis {
    
    public String nome;
    public String tipo;
    public String valor;
    
    public static final int BOOLEAN = 2;
    public static final int REAL = 3;
    public static final int INT = 5;

    public Variaveis(String nome, int tipo) {
    
        this.nome = nome;
        if(tipo == 5) this.tipo = "INT";
        else if(tipo == 3) this.tipo = "REAL";
        else if(tipo == 2) this.tipo = "BOOLEAN";
        
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    public void visualizar(){
        System.out.println("(" + this.nome + "," + this.tipo + ")");
    }
}
