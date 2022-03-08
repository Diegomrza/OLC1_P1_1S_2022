package analizadores;
import java_cup.runtime.Symbol; 
import Error.*;
import Proyecto1_Compi.Menu.*;

%%
%class Lector
%public
%line
%char
%cup
%unicode
%ignorecase 

%init{ 
   yyline = 1; 
   yychar = 1;
%init} 

WHITE = [ \r\t]+
COMMENT = "<!"[^("!>")]+"!>"|\/\/.+
IDENTIFICADOR = [a-zA-Z_][a-zA-Z0-9_]*
NUMERO = [0-9]+
AZMINUS = [a-z]
AZMAYUS = [A-Z]
NOTACIONCOMAS = ([a-zA-Z]\,|[0-9]+\,)+([a-zA-Z]|[0-9]+)
//POLACA = ((\.|\||\*|\+|\?|[ ])+(\{[a-zA-Z][a-zA-Z0-9_]*\})+|(\.|\||\*|\+|\?|[ ])+(\"[^\"]*\")+|(\{[a-zA-Z][a-zA-Z0-9_]*\})+)+
SIMBOLO = [\!\#\$\%\&\(\)\,\-\/\:\;\<\=\>\@\\\[\]\^\_\`\{\}] //[ \!\#\$\%\&\(\)\*\+\,\-\.\/\:\;\<\=\>\?\@\\\[\]\^\_\`\{\|\}]
CADENA = \"[\\\"]*[^\"]+\" //({IDENTIFICADOR}{SIMBOLO})+
TKESPECIALES = (\\n|\\\'|\\\")
//SIMBOLOSESPECIALES = \"(\.|\+|\*|\?|\||\;|\:|%%|\"|\-|\,|\~|\ )\"

%%

"{"     {return new Symbol(sym.LLAVELEFT, yytext());} 
"}"     {return new Symbol(sym.LLAVERIGHT, yytext());}
";"     {return new Symbol(sym.PUNTOYCOMA, yytext());}
"%%\n%%" {return new Symbol(sym.CAMBIOSECCION, yytext());}
"-"     {return new Symbol(sym.GUION, yytext());}
">"     {return new Symbol(sym.MAYOR, yytext());}
":"     {return new Symbol(sym.DOSPUNTOS, yytext());}
"~"     {return new Symbol(sym.ONDULADO, yytext());}
"CONJ"  {return new Symbol(sym.CONJ, yytext());}

"*" {return new Symbol(sym.CERRKLEE, yytext());}
"+" {return new Symbol(sym.CERRPOSI, yytext());}
"." {return new Symbol(sym.PUNTO, yytext());}
"?" {return new Symbol(sym.PREGUNTA, yytext());}
"|" {return new Symbol(sym.OR, yytext());}

\n {yychar = 1;}

{WHITE} {}

{COMMENT} {return new Symbol(sym.COMMENT, yytext());}
{AZMINUS} {return new Symbol(sym.AZMINUS, yytext());}
{AZMAYUS} {return new Symbol(sym.AZMAYUS, yytext());}
{TKESPECIALES} {return new Symbol(sym.TKESPECIALES, yytext());}
{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yytext());}
{NUMERO} {return new Symbol(sym.NUMERO, yytext());}
{NOTACIONCOMAS} {return new Symbol(sym.NOTACIONCOMAS, yytext());}

{SIMBOLO} {return new Symbol(sym.SIMBOLO, yytext());}
{CADENA} {return new Symbol(sym.CADENA, yytext());}

. { 
    System.out.println("\u001B[31m"+"Error lexico en: "+yytext()+" en la linea: "+yyline+ " en la columna: "+ yychar+ "\u001B[0m");
    Proyecto1_Compi.Menu.listaErr.addError(new Error_("Error léxico: "+yytext(), "Lexico"));
}
