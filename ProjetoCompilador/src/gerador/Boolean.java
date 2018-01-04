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
public class Boolean extends Variavel{

    private boolean valor;

    public Boolean(boolean valor, String nome, int enderecoAlocacao) {
        super(nome, enderecoAlocacao);
        this.valor = valor;
    }

    public Boolean(String nome, int enderecoAlocacao) {
        super(nome, enderecoAlocacao);
    }
    
    

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
    
    
    
    
}
