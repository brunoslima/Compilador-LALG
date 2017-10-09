package sintatico;
import java_cup.runtime.Symbol;


%%
%cup
%public
%class Lexer
%type java_cup.runtime.Symbol
%char
%line
%column

WHITE=[ ]
TAB=[\t]
NOVA_LINHA = [\r|\n|\r\n]

COMENTARIO_ABRE       = \{
COMENTARIO_FECHA      = \}
COMENTARIO_NAO_FECHA_MULTI   = [^}]
COMENTARIO_CORPO_MULTI    = {COMENTARIO_NAO_FECHA_MULTI}*
COMENTARIO_MULTI         = {COMENTARIO_ABRE}{COMENTARIO_CORPO_MULTI}{COMENTARIO_FECHA}{0,1}

COMENTARIO_LINHA = "\/\/"{COMENTARIO_LINHA_NAO_FECHA}*{COMENTARIO_LINHA_FECHA}
COMENTARIO_LINHA_FECHA = [\n]
COMENTARIO_LINHA_NAO_FECHA = [^\n]

PROGRAM="program"
BEGIN="begin"
END="end"
PROCEDURE="procedure"
VAR="var"

INT="int"
REAL="real"
BOOLEAN="boolean"
TRUE="true"
FALSE="false"

READ="read"
WRITE="write"

DOIS_PONTOS=":"
PONTO_VIRGULA=";"
VIRGULA=","
PONTO="."

IF="if"
THEN="then"
ELSE="else"

WHILE="while"
DO="do"

SIMBOLO_IGUAL="="
SIMBOLO_DIFERENTE="<>"
SIMBOLO_MENOR="<"
SIMBOLO_MENOR_IGUAL="<="
SIMBOLO_MAIOR=">"
SIMBOLO_MAIOR_IGUAL=">="

OP_ATRIBUICAO=":="
OP_ADICAO=[\+]
OP_SUBTRACAO="-"
OP_DIVISAO="div"
OP_MULTIPLICACAO=[\*]
OP_AND="and"
OP_OR="or"
OP_NOT="not"

PARENTESES_ABRE="("
PARENTESES_FECHA=")"

NUMERO_INTEIRO=[0-9]{1,10}
NUMERO_REAL = [0-9]+\.[0-9]{1,6}

IDENTIFICADOR=[_|a-z|A-Z][a-z|A-Z|0-9]*

%{



private Symbol add(int descricao, String lexema) {
    
   
    return new Symbol(descricao, yyline, yycolumn, lexema);
}

%}
%%
{WHITE} {return add(Sym.ESPACO, yytext());}
{TAB} {return add(Sym.TAB, yytext());}
{NOVA_LINHA} {return add(Sym.NOVA_LINHA, yytext());}

{COMENTARIO_LINHA} {return add(Sym.COMENTARIO_LINHA, yytext());}
{COMENTARIO_MULTI} {return add(Sym.COMENTARIO_MULTI, yytext());}

{PROGRAM} {return add(Sym.PROGRAM, yytext());}
{BEGIN} {return add(Sym.BEGIN, yytext());}
{END} {return add(Sym.END, yytext());}
{PROCEDURE} {return add(Sym.PROCEDURE, yytext());}
{VAR} {return add(Sym.VAR, yytext());}

{INT} {return add(Sym.INT, yytext());}
{REAL} {return add(Sym.REAL, yytext());}
{BOOLEAN} {return add(Sym.BOOLEAN, yytext());}
{TRUE} {return add(Sym.TRUE, yytext());}
{FALSE} {return add(Sym.FALSE, yytext());}

{READ} {return add(Sym.READ, yytext());}
{WRITE} {return add(Sym.WRITE, yytext());}

{DOIS_PONTOS} {return add(Sym.DOIS_PONTOS, yytext());}
{PONTO_VIRGULA} {return add(Sym.PONTO_VIRGULA, yytext());}
{VIRGULA} {return add(Sym.VIRGULA, yytext());}
{PONTO} {return add(Sym.PONTO, yytext());}

{IF} {return add(Sym.IF, yytext());}
{THEN} {return add(Sym.THEN, yytext());}
{ELSE} {return add(Sym.ELSE, yytext());}

{WHILE} {return add(Sym.WHILE, yytext());}
{DO} {return add(Sym.DO, yytext());}

{SIMBOLO_IGUAL} {return add(Sym.SIMBOLO_IGUAL, yytext());}
{SIMBOLO_DIFERENTE} {return add(Sym.SIMBOLO_DIFERENTE, yytext());}
{SIMBOLO_MENOR} {return add(Sym.SIMBOLO_MENOR, yytext());}
{SIMBOLO_MENOR_IGUAL} {return add(Sym.SIMBOLO_MENOR_IGUAL, yytext());}
{SIMBOLO_MAIOR} {return add(Sym.SIMBOLO_MAIOR, yytext());}
{SIMBOLO_MAIOR_IGUAL} {return add(Sym.SIMBOLO_MAIOR_IGUAL, yytext());}

{OP_ATRIBUICAO} {return add(Sym.OP_ATRIBUICAO, yytext());}
{OP_ADICAO} {return add(Sym.OP_ADICAO, yytext());}
{OP_SUBTRACAO} {return add(Sym.OP_SUBTRACAO, yytext());}
{OP_DIVISAO} {return add(Sym.OP_DIVISAO, yytext());}
{OP_MULTIPLICACAO} {return add(Sym.OP_MULTIPLICACAO, yytext());}
{OP_AND} {return add(Sym.OP_AND, yytext());}
{OP_OR} {return add(Sym.OP_OR, yytext());}
{OP_NOT} {return add(Sym.OP_NOT, yytext());}

{PARENTESES_ABRE} {return add(Sym.PARENTESES_ABRE, yytext());}
{PARENTESES_FECHA} {return add(Sym.PARENTESES_FECHA, yytext());}

{NUMERO_INTEIRO} {return add(Sym.NUMERO_INTEIRO, yytext());}
{NUMERO_REAL} {return add(Sym.NUMERO_REAL, yytext());}
{IDENTIFICADOR} {return add(Sym.IDENTIFICADOR, yytext());}

<<EOF>> {return add(Sym.EOF, yytext());}

. {return add(Sym.ERROR, yytext());}