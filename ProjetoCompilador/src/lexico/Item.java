/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

/**
 * @author brunoslima
 * @author leandroungari
 */
public class Item {
    
    private String simbolo;
    private Simbolo tipo;
    private int numLinha;
    private int numColunaInicial;
    private int numColunaFinal;
    private int offset;

    public Item(String simbolo, Simbolo tipo, int numLinha, int numColunaInicial, int numColunaFinal) {
        this.simbolo = simbolo;
        this.tipo = tipo;
        this.numLinha = numLinha;
        this.numColunaInicial = numColunaInicial;
        this.numColunaFinal = numColunaFinal;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    
    
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public Simbolo getTipo() {
        return tipo;
    }

    public void setTipo(Simbolo tipo) {
        this.tipo = tipo;
    }

    public int getNumLinha() {
        return numLinha;
    }

    public void setNumLinha(int numLinha) {
        this.numLinha = numLinha;
    }

    public int getNumColunaInicial() {
        return numColunaInicial;
    }

    public void setNumColunaInicial(int numColunaInicial) {
        this.numColunaInicial = numColunaInicial;
    }

    public int getNumColunaFinal() {
        return numColunaFinal;
    }

    public void setNumColunaFinal(int numColunaFinal) {
        this.numColunaFinal = numColunaFinal;
    }

    @Override
    public String toString() {
        return "{"
                + "\"simbolo\": " + this.getSimbolo() + ", "
                + "\"tipo\": " + this.getTipo()+ ", "
                + "\"numLinha\": " + this.getNumLinha()+ ", "
                + "\"numColunaInicial\": " + this.getNumColunaInicial()+ ", "
                + "\"numColunaFinal\": " + this.getNumColunaFinal()+ " }";
                
                
    }
    
    
}
