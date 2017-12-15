/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

/**
 *
 * @author leandroungari
 */
public abstract class Variavel {
    
    private String nome;
    private int enderecoAlocacao;
    
    public static final int INT = 5;
    public static final int REAL = 3;
    public static final int BOOLEAN = 2;
    

    public Variavel(String nome, int enderecoAlocacao) {
        this.nome = nome;
        this.enderecoAlocacao = enderecoAlocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEnderecoAlocacao() {
        return enderecoAlocacao;
    }

    public void setEnderecoAlocacao(int enderecoAlocacao) {
        this.enderecoAlocacao = enderecoAlocacao;
    }
    
    
    
}
