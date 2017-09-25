/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decoracao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author leandroungari
 */
public class TextoDecoracao {

    private String texto;
    private HTMLEditorKit kit;
    
    public TextoDecoracao(String texto) {

        kit = new HTMLEditorKit();
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(".palavra-reservada {color: blue;}"); 
        styleSheet.addRule(".palavra-reservada:hover{font-weight: bold;}");
        styleSheet.addRule("* {font-family: Consolas, sans-serif;}");
        styleSheet.addRule(".tab {display: inline-block;}");
        
        this.texto = texto;
        
    }
    
    public TextoDecoracao() {

        kit = new HTMLEditorKit();
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(".palavra-reservada {color: blue;}"); 
        styleSheet.addRule("* {font-family: Consolas, sans-serif;}");
        styleSheet.addRule(".tab {display: inline-block;}");

    }

    

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public HTMLEditorKit getKit() {
        return kit;
    }

    public void setKit(HTMLEditorKit kit) {
        this.kit = kit;
    }

    public void apply(String simbolo) {
        
     
        if (simbolo.equals("\t")) {
      
            this.texto = this.texto.replaceAll(Pattern.quote(simbolo), "<span class='tab'>&#9;</span>");
        }
        else if (simbolo.equals("\n")) {
            
            this.texto = this.texto.replaceAll(Pattern.quote(simbolo), "<span class='quebra-linha'><br></span>");
        }
        else {
            
            this.texto = this.texto.replaceAll(Pattern.quote(simbolo),"<span class='palavra-reservada'>" + simbolo + "</span>");
        }
        
        
    }
    
    public String removerTags(){
        
        
        String s = this.texto
                         .replaceAll("<span class=\"quebra-linha\">", "\n")
                         .replaceAll("<span class=\"tab\">", "\t")
                         .replaceAll("<span[^>]*>", "")
                         .replaceAll("</span>", "")
                         .replaceAll("<br>", "")
                         .replaceAll("&#9;", "")
                         .replaceAll("&gt;", ">")
                         .replaceAll("&lt;","<");
        
        return s.substring(44, s.length()-19);
                         
                    
    }

}
