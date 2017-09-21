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

WHITE=[ \t\r\n]

COMENTARIO_ABRE       = \{
COMENTARIO_FECHA      = \}
COMENTARIO_NAO_FECHA_MULTI   = [^}]
COMENTARIO_CORPO_MULTI    = {COMENTARIO_NAO_FECHA_MULTI}*
COMENTARIO_MULTI         = {COMENTARIO_ABRE}{COMENTARIO_CORPO_MULTI}{COMENTARIO_FECHA}

COMENTARIO_LINHA = "//"{COMENTARIO_LINHA_NAO_FECHA}*{COMENTARIO_LINHA_FECHA}
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

NUMERO_INTEIRO=[0-9]+


IDENTIFICADOR=[_|a-z|A-Z][a-z|A-Z|0-9]*

%{

%}
%%
{WHITE} {/*Ignore*/}

{COMENTARIO_LINHA} {/*Ignore*/}
{COMENTARIO_MULTI} {/*Ignore*/}

{PROGRAM} {return add(PALAVRA_RESERVADA_PROGRAM, yytext());}
{BEGIN} {return add(PALAVRA_RESERVADA_BEGIN, yytext());}
{END} {return add(PALAVRA_RESERVADA_END, yytext());}
{PROCEDURE} {return add(PALAVRA_RESERVADA_PROCEDURE, yytext());}
{VAR} {return add(PALAVRA_RESERVADA_VAR, yytext());}

{INT} {return add(TIPO_INTEIRO, yytext());}
{REAL} {return add(TIPO_REAL, yytext());}
{BOOLEAN} {return add(TIPO_BOOLEANO, yytext());}
{TRUE} {return add(VALOR_LOGICO_TRUE, yytext());}
{FALSE} {return add(VALOR_LOGICO_FALSE, yytext());}

{READ} {return add(PALAVRA_RESERVADA_READ, yytext());}
{WRITE} {return add(PALAVRA_RESERVADA_WRITE, yytext());}

{DOIS_PONTOS} {return add(SIMBOLO_DOIS_PONTOS, yytext());}
{PONTO_VIRGULA} {return add(SIMBOLO_PONTO_VIRGULA, yytext());}
{VIRGULA} {return add(SIMBOLO_VIRGULA, yytext());}
{PONTO} {return add(SIMBOLO_PONTO, yytext());}

{IF} {return add(ESTRUTURA_CONDICAO_IF, yytext());}
{THEN} {return add(ESTRUTURA_CONDICAO_THEN, yytext());}
{ELSE} {return add(ESTRUTURA_CONDICAO_ELSE, yytext());}

{WHILE} {return add(ESTRUTURA_REPETICAO_WHILE, yytext());}
{DO} {return add(ESTRUTURA_REPETICAO_DO, yytext());}

{SIMBOLO_IGUAL} {return add(SIMBOLO_IGUAL, yytext());}
{SIMBOLO_DIFERENTE} {return add(SIMBOLO_DIFERENTE, yytext());}
{SIMBOLO_MENOR} {return add(SIMBOLO_MENOR, yytext());}
{SIMBOLO_MENOR_IGUAL} {return add(SIMBOLO_MENOR_IGUAL, yytext());}
{SIMBOLO_MAIOR} {return add(SIMBOLO_MAIOR, yytext());}
{SIMBOLO_MAIOR_IGUAL} {return add(SIMBOLO_MAIOR_IGUAL, yytext());}

{OP_ATRIBUICAO} {return add(OPERADOR_ATRIBUICAO, yytext());}
{OP_ADICAO} {return add(OPERADOR_ADICAO, yytext());}
{OP_SUBTRACAO} {return add(OPERADOR_SUBTRACAO, yytext());}
{OP_DIVISAO} {return add(OPERADOR_DIVISAO, yytext());}
{OP_MULTIPLICACAO} {return add(OPERADOR_MULTIPLICACAO, yytext());}
{OP_AND} {return add(OPERADOR_AND, yytext());}
{OP_OR} {return add(OPERADOR_OR, yytext());}
{OP_NOT} {return add(OPERADOR_NOT, yytext());}

{PARENTESES_ABRE} {return add(PARENTESES_ABRE, yytext());}
{PARENTESES_FECHA} {return add(PARENTESES_FECHA, yytext());}

{NUMERO_INTEIRO} {return add(NUMERO_INTEIRO, yytext());}
{IDENTIFICADOR} {return add(IDENTIFICADOR, yytext());}

. {return add(ERROR, yytext());}