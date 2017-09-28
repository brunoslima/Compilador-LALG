package decoracao;

import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import lexico.AnalisadorLexico;
import lexico.Item;
import lexico.Lexer;
import lexico.Simbolo;
import view.IUPrincipal;

public final class TextoDecoracao extends DocumentFilter {

    private StyledDocument styledDocument;
    private JTextPane pane;
    private final StyleContext styleContext = StyleContext.getDefaultStyleContext();
    private final AttributeSet blueAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLUE);
    private final AttributeSet blackAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.BLACK);
    private final AttributeSet greenAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, new Color(0, 153, 0));
    private final AttributeSet redAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.RED);
    private final AttributeSet grayAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, Color.GRAY);
    private final AttributeSet pinkAttributeSet = styleContext.addAttribute(styleContext.getEmptySet(), StyleConstants.Foreground, new Color(255, 0, 255));

    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attributeSet) throws BadLocationException {
        super.insertString(fb, offset, text, attributeSet);

        handleTextChanged();
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);

        handleTextChanged();
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attributeSet) throws BadLocationException {
        super.replace(fb, offset, length, text, attributeSet);

        handleTextChanged();
    }

    /**
     * Runs your updates later, not during the event notification.
     */
    private void handleTextChanged() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                colorirTexto();
            }
        });
    }

    public void colorirTexto() {
        // Clear existing styles
        styledDocument.setCharacterAttributes(0, pane.getText().length(), blackAttributeSet, true);
        Lexer a = new Lexer(new StringReader(pane.getText()));
        Item t = null;
        
        ArrayList<String> listaReservadas = AnalisadorLexico.getPalavrasReservadas();
        ArrayList<String> listaOperadores = AnalisadorLexico.getOperadores();
        int linha;
        
        try {
            while ((t = a.yylex()) != null) {
                
                if (IUPrincipal.sistema.equals("Linux")) {
                    linha = 0;
                }
                else linha = t.getNumLinha();
                                
                if (listaReservadas.contains(t.getSimbolo())) styledDocument.setCharacterAttributes(t.getOffset()-linha, t.getSimbolo().length(), blueAttributeSet, false);
                else if (t.getTipo() == Simbolo.COMENTARIO_LINHA || t.getTipo() == Simbolo.COMENTARIO_MULTI) styledDocument.setCharacterAttributes(t.getOffset()-linha, t.getSimbolo().length(), grayAttributeSet, false);
                else if (t.getTipo() == Simbolo.NUMERO_INTEIRO) styledDocument.setCharacterAttributes(t.getOffset()-linha, t.getSimbolo().length(), pinkAttributeSet, false);
                else if (t.getTipo() == Simbolo.VALOR_LOGICO_FALSE || t.getTipo() == Simbolo.VALOR_LOGICO_TRUE) styledDocument.setCharacterAttributes(t.getOffset()-linha, t.getSimbolo().length(), greenAttributeSet, false);
                else if (listaOperadores.contains(t.getSimbolo())) styledDocument.setCharacterAttributes(t.getOffset()-linha, t.getSimbolo().length(), redAttributeSet, false);
                else styledDocument.setCharacterAttributes(t.getOffset()-linha, t.getSimbolo().length(), blackAttributeSet, false); 
            }
        } catch (IOException ex) {
            Logger.getLogger(TextoDecoracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TextoDecoracao(JTextPane pane) {
        this.pane = pane;
        styledDocument = pane.getStyledDocument();
    }

}
