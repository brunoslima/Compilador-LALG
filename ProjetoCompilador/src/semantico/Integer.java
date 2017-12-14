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
public class Integer extends Variaveis {
    
    private int valor;

    public Integer(String nome, int tipo) {
        super(nome, tipo);
        
    }
    
    public Integer(int valor, String nome, int tipo) {
        super(nome, tipo);
        this.valor = valor;
    }
    
    public void visualizar(){
        
        System.out.println("(" + this.nome + "," + this.tipo + "," + this.valor + ")");
        
    }
}
