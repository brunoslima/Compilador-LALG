package decoracao;

import java.io.IOException;
import java.io.StringReader;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class MyHTML2Text extends HTMLEditorKit.ParserCallback {
    
    StringBuffer s;
    
    public MyHTML2Text() {}
    
    public void parse(StringReader in) throws IOException {
        s = new StringBuffer();
        ParserDelegator delegator = new ParserDelegator();
        delegator.parse(in, this, Boolean.TRUE);
    }
    public void handleText(char[] text, int pos) {
        s.append(text);
        
        //s.append("\n");
    }
    public String getText() {
        return s.toString();
    }
}