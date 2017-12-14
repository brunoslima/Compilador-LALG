/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpretador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author leandroungari
 */
public class Interpretador {

    private ArrayList<String[]> codigo;
    private Stack<Integer> pilha;
    
    private int contadorInstrucao;
    private boolean flagIncrementarInstrucao;
    private boolean flagEncerrarExecucao;
    
    public Interpretador(ArrayList<String[]> codigo, Stack<Integer> pilha) {
        
        this.codigo = codigo;
        this.pilha = pilha;
        this.contadorInstrucao = 0;
        this.flagIncrementarInstrucao = true;
        this.flagEncerrarExecucao = false;
    
        Comando.setInterpretador(this);
    }

    public void setFlagIncrementarInstrucao(boolean flagIncrementarInstrucao) {
        this.flagIncrementarInstrucao = flagIncrementarInstrucao;
    }

    public void setFlagEncerrarExecucao(boolean flagEncerrarExecucao) {
        this.flagEncerrarExecucao = flagEncerrarExecucao;
    }
    
    

    public ArrayList<String[]> getCodigo() {
        return codigo;
    }

    public void setCodigo(ArrayList<String[]> codigo) {
        this.codigo = codigo;
    }

    public Stack<Integer> getPilha() {
        return pilha;
    }

    public void setPilha(Stack<Integer> pilha) {
        this.pilha = pilha;
    }

    public void setContadorInstrucao(int contadorInstrucao) {
        this.contadorInstrucao = contadorInstrucao;
    }
    
    
    
    public void lerArquivo(String filename) throws FileNotFoundException {
        
        Scanner arquivo = new Scanner(new File(filename));
        
        while (arquivo.hasNextLine()) {
            
            String linha = arquivo.nextLine();
            
            codigo.add(linha.split(Pattern.quote(" ")));
        }
        
        arquivo.close();
    }
    
    public void executar() {
        
        String[] comando;
        
        for(contadorInstrucao = 0; contadorInstrucao < codigo.size(); ) {
            
            try {
                
                comando = codigo.get(contadorInstrucao);
                this.interpretar(comando);
                
                if (flagIncrementarInstrucao) {
                    
                    contadorInstrucao++;
                }
                else {
                    
                    flagIncrementarInstrucao = true;
                }
                
                if (flagEncerrarExecucao) {
                    
                    return;
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro de Execução", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void interpretar(String[] comando) throws Exception {
        
        switch(comando[0]){
            
            case "CRCT":
                
                Comando.crct(Integer.parseInt(comando[1]));
                break;
            
            case "CRVL":
                
                Comando.crvl(Integer.parseInt(comando[1]));
                break;
                
            case "ARMZ":
                
                Comando.armz(Integer.parseInt(comando[1]));
                break;
            
            case "SOMA":
                
                Comando.soma();
                break;
                
            case "SUBT":
                
                Comando.subt();
                break;    
            
            case "MULT":
                
                Comando.mult();
                break;
                
            case "DIVI":
                
                Comando.divi();
                break;    
            
            case "MODI":
                
                Comando.modi();
                break;
                
            case "INVR":
                
                Comando.invr();
                break;
                
            case "CONJ":
                
                Comando.conj();
                break;
                
            case "DISJ":
                
                Comando.disj();
                break;
                
            case "NEGA":
                
                Comando.nega();
                break;
            
            case "CMME":
                
                Comando.cmme();
                break;
                
            case "CMMA":
                
                Comando.cmma();
                break;
            
            case "CMIG":
                
                Comando.cmig();
                break;
                
            case "CMDG":
                
                Comando.cmdg();
                break;
                
            case "CMAG":
                
                Comando.cmag();
                break;
                
            case "CMEG":
                
                Comando.cmeg();
                break;
                
            case "DSVS":
                
                Comando.dsvs(Integer.parseInt(comando[1]));
                break;
                
            case "DSVF":
                
                Comando.dsvf(Integer.parseInt(comando[1]));
                break;
                
            case "NADA":
                
                Comando.nada();
                break;
                
                
            case "LEIT":
                
                Comando.leit();
                break;
                
            case "LEICH":
                
                Comando.leich();
                break;
                
            case "IMPR":
                
                Comando.impr();
                break;
                
            case "IMPC":
                
                Comando.impc();
                break;
                
            case "IMPE":
                
                Comando.impe();
                break;
                
            case "INPP":
                
                Comando.inpp();
                break;
                
            case "AMEM":
                
                Comando.amem(Integer.parseInt(comando[1]));
                break;
            
            case "DMEM":
                
                Comando.dmem(Integer.parseInt(comando[1]));
                break;
                
            case "PARA":
                
                Comando.para();
                break;
                

        }
    }
}
