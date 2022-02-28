package analizadores;
import java_cup.runtime.Symbol; 

%%
%class Lector
%public
%line
%char
%cup
%unicode
%ignorecase 


%init{ 
   
%init} 

WHITE = [ \r\t\n\f]+
COMMENT = "<!"[^("!>")]+"!>"|\/\/.+
IDENTIFICADOR = [a-zA-Z_][a-zA-Z0-9_]*
NUMERO = [0-9]+
AZMINUS = [a-z]
AZMAYUS = [A-Z]
NOTACIONCOMAS = ([a-zA-Z]\,|[0-9]+\,)+([a-zA-Z]|[0-9]+)
POLACA = ((\.|\||\*|\+|\?|[ ])+(\{[a-zA-Z][a-zA-Z0-9_]*\})+|(\.|\||\*|\+|\?|[ ])+(\"[^\"]*\")+|(\{[a-zA-Z][a-zA-Z0-9_]*\})+)+
CADENA = \"[^\"\n]*\"
SIMBOLO = [ \!\"\#\$\%\&\'\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\\\[\]\^\_\`\{\|\}]

%%

"{"     {return new Symbol(sym.LLAVELEFT, yytext());} 
"}"     {return new Symbol(sym.LLAVERIGHT, yytext());}
";"     {return new Symbol(sym.PUNTOYCOMA, yytext());}
"%%"    {return new Symbol(sym.CAMBIOSECCION, yytext());}  
"-"     {return new Symbol(sym.GUION, yytext());}
">"     {return new Symbol(sym.MAYOR, yytext());}
":"     {return new Symbol(sym.DOSPUNTOS, yytext());}
"~"     {return new Symbol(sym.ONDULADO, yytext());}
"CONJ"  {return new Symbol(sym.CONJ, yytext());}
//"\n"    {return new Symbol (sym.SALTODELINEA, yytext());}

{WHITE} {}

{COMMENT}       {return new Symbol(sym.COMMENT, yytext());}
{AZMINUS}       {return new Symbol(sym.AZMINUS, yytext());}
{AZMAYUS}       {return new Symbol(sym.AZMAYUS, yytext());}
{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yytext());}
{NUMERO}        {return new Symbol(sym.NUMERO, yytext());}
{NOTACIONCOMAS} {return new Symbol(sym.NOTACIONCOMAS, yytext());}
{POLACA}        {return new Symbol(sym.POLACA, yytext());}
{CADENA}        {return new Symbol(sym.CADENA, yytext());}
{SIMBOLO}       {return new Symbol(sym.SIMBOLO, yytext());}

. {
    System.out.println("\u001B[31m"+"Lexical error: "+yytext()+"\u001B[0m");
}
