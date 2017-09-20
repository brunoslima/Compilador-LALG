package lexico;
import static lexico.Simbolo.*;


%{

private Item add(Simbolo descricao, String lexema) {
    
    return new Item(lexema, descricao, yyline, yycolumn, yycolumn + lexema.length()-1);
}

%}

%%
%class Lexer
%type Item
R = [0-9]+\.[0-9]{1,6}
I = [0-9]+
WHITE=[ \t\r\n]
COMENTARIO_COMPLETO=[\/\*.*\*\/]
COMENTARIO_ABRE=[\/\*.*]
%{

%}
%%
{WHITE} {/*Ignore*/}
"+" {return add(OP_SOMA, yytext());}
"*" {return add(OP_MULTIPLICACAO, yytext());}
"-" {return add(OP_SUBTRACAO, yytext());}
"/" {return add(OP_DIVISAO, yytext());}
"(" {return add(PARENTESE_ABRE, yytext());}
")" {return add(PARENTESE_FECHA, yytext());}
{R} {return add(NUM_REAL, yytext());}
{I} {return add(NUM_INTEIRO, yytext());}
. {return add(ERROR, yytext());}