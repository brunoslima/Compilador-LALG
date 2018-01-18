/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintatico;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author bruno
 */
public class RecuperacaoErros {
    
    public static ArrayList<String> listaErros = new ArrayList();
    public static boolean foiExecutado = false;

    public static ArrayList<String> getListaErros() {
        return listaErros;
    }

    public static void setListaErros(ArrayList<String> listaErros) {
        RecuperacaoErros.listaErros = listaErros;
    }

    public static boolean isFoiExecutado() {
        return foiExecutado;
    }

    public static void setFoiExecutado(boolean foiExecutado) {
        RecuperacaoErros.foiExecutado = foiExecutado;
    }
    
    
    
    public static void adicionarErro(String erro){
        
        listaErros.add(erro);
    }
    
    public static String getErros(){
        
        String lista = "";
        for (Iterator<String> iterator = listaErros.iterator(); iterator.hasNext();) {
             
            lista += iterator.next();
            
        }
        
        return lista;
    }
}
