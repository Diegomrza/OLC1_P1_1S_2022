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

WHITE = [ \r\t\n]+

COMMENT = "<!"[^("<"|"!"|">")]*"!>"|\/\/.+
IDENTIFICADOR = [a-zA-Z_][a-zA-Z0-9_]*
NUMERO = [0-9]+
POLACA = ((\.|\||\*|\+|\?)(\{\w+\}){1,2}|(\.|\||\*|\+|\?)\"[a-zA-Z_.|+*?]+\"|(\.|\||\*|\+|\?)(\.|\||\*|\+|\?)((\{\w+\}){1,2}|\"[a-zA-Z_.|+*?]+\"))+
LEXEMA = \"[^\"]*\"
NOTACION = (([0-9]+\,)+|([0-9]+\,[0-9]+)+)[0-9]+|(([a-z]\,)+|([a-z]\,[a-z])+)[a-z]

%%

"{"     {return new Symbol(sym.LLAVELEFT, yytext());} 
"}"     {return new Symbol(sym.LLAVERIGHT, yytext());}
";"     {return new Symbol(sym.PUNTOYCOMA, yytext());}
"%%"  {return new Symbol(sym.CAMBIO, yytext());}  
"-"     {return new Symbol(sym.GUION, yytext());}
">"     {return new Symbol(sym.MAYOR, yytext());}
":"     {return new Symbol(sym.DOSPUNTOS, yytext());}
"~"     {return new Symbol(sym.VIRGULILLA, yytext());}
"CONJ"  {return new Symbol(sym.CONJ, yytext());}
//"\n"    {return new Symbol (sym.SALTODELINEA, yytext());}

{WHITE} {}

{COMMENT}       {return new Symbol(sym.COMMENT, yytext());}
{NUMERO}        {return new Symbol(sym.NUMERO, yytext());}  
{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yytext());}  
{LEXEMA}        {return new Symbol(sym.LEXEMA, yytext());}
{POLACA}        {return new Symbol(sym.POLACA, yytext());}
{NOTACION}      {return new Symbol(sym.NOTACION, yytext());}

. {
    System.out.println("\u001B[31m"+"Lexical error: "+yytext()+"\u001B[0m");
}
