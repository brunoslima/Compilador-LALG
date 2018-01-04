/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerador;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class Integer extends Variavel{
    
    private int valor;

    public Integer(String nome, int enderecoAlocacao) {
        super(nome, enderecoAlocacao);
    }

    public Integer(int valor, String nome, int enderecoAlocacao) {
        super(nome, enderecoAlocacao);
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
