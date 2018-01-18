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
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author brunoslima
 * @author leandroungari
 */
public class Interpretador {

    private ArrayList<String[]> codigo;
    private Stack<Integer> pilha;
    private String texto;
    
    private int contadorInstrucao;
    private boolean flagIncrementarInstrucao;
    private boolean flagEncerrarExecucao;
    
    public Interpretador() {
        
        this.texto = "";
        this.codigo = new ArrayList<>();
        this.pilha = new Stack<>();
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
            this.texto += linha + "\n";
            codigo.add(linha.split(Pattern.quote(" ")));
        }
        
        arquivo.close();
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        
        System.out.println(comando[0]);
        
        switch(comando[0]){
            
            //OK
            case "CRCT":
                
                Comando.crct(Integer.parseInt(comando[1]));
                break;
            
                //OK
            case "CRVL":
                
                Comando.crvl(Integer.parseInt(comando[1]));
                break;
            
            //OK
            case "ARMZ":
                
                Comando.armz(Integer.parseInt(comando[1]));
                break;
            
            //OK
            case "SOMA":
                
                Comando.soma();
                break;
                
            //OK    
            case "SUBT":
                
                Comando.subt();
                break;    
            
            //OK    
            case "MULT":
                
                Comando.mult();
                break;
                
            //OK    
            case "DIVI":
                
                Comando.divi();
                break;    
            
            //OK    
            case "MODI":
                
                Comando.modi();
                break;
            
            //OK    
            case "INVR":
                
                Comando.invr();
                break;
            
            //OK    
            case "CONJ":
                
                Comando.conj();
                break;
            
            //OK    
            case "DISJ":
                
                Comando.disj();
                break;
                
            //OK
            case "NEGA":
                
                Comando.nega();
                break;
            
            //OK    
            case "CMME":
                
                Comando.cmme();
                break;
            
            //OK    
            case "CMMA":
                
                Comando.cmma();
                break;
            
            //OK    
            case "CMIG":
                
                Comando.cmig();
                break;
                
            //OK
            case "CMDG":
                
                Comando.cmdg();
                break;
            
            //OK    
            case "CMAG":
                
                Comando.cmag();
                break;
                
            //OK
            case "CMEG":
                
                Comando.cmeg();
                break;
            
            //OK    
            case "DSVS":
                
                Comando.dsvs(Integer.parseInt(comando[1]));
                break;
                
            //OK
            case "DSVF":
                
                Comando.dsvf(Integer.parseInt(comando[1]));
                break;
                
            //OK
            case "NADA":
                
                Comando.nada();
                break;
                
            //OK    
            case "LEIT":
                
                Comando.leit();
                break;
                
            //OK    
            case "LEICH":
                
                Comando.leich();
                break;
            
            //OK    
            case "IMPR":
                
                Comando.impr();
                break;
            
            //OK    
            case "IMPC":
                
                Comando.impc();
                break;
                
            //OK
            case "IMPE":
                
                Comando.impe();
                break;
            
            //OK
            case "INPP":
                
                Comando.inpp();
                break;
                
            //OK
            case "AMEM":
                
                Comando.amem(Integer.parseInt(comando[1]));
                break;
            
            //OK
            case "DMEM":
                
                Comando.dmem(Integer.parseInt(comando[1]));
                break;
                
            //OK    
            case "PARA":
                
                Comando.para();
                break;
                

        }
    }
}
