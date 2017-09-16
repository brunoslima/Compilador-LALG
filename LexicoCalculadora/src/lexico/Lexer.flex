package lexico;
import static lexico.Simbolo.*;
import static lexico.AnalisadorLexico;

%{

private void add(String descricao, String lexema) {
    
    AnalisadorLexico.getTabela().add(new Item(lexema, descricao, yyline, yycolumn, yycolumn + descricao.length()-1));
}

%}

%%
%class Lexer
%type void
R = [0-9]+\.[0-9]{1,6}
I = [0-9]+
WHITE=[ \t\r\n]
%{
public String lexema;
%}
%%
{WHITE} {/*Ignore*/}
"+" {add(OP_SOMA, yytext());}
"*" {add(OP_MULTIPLICACAO, yytext());}
"-" {add(OP_SUBTRACAO, yytext());}
"/" {add(OP_DIVISAO, yytext());}
"(" {add(PARENTESE_ABRE, yytext());}
")" {add(PARENTESE_FECHA, yytext());}
{R} {add(NUM_REAL, yytext());}
{I} {add(NUM_INTEIRO, yytext());}
. {add(ERROR, yytext());}