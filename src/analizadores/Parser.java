
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package analizadores;

import java_cup.runtime.*;
import java.util.ArrayList;
import Proyecto1_Compi.Menu.*;
import Estructuras.ArbolBinario;
import Estructuras.NodoArbol;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\042\000\002\002\004\000\002\002\007\000\002\002" +
    "\010\000\002\002\004\000\002\002\003\000\002\002\004" +
    "\000\002\002\003\000\002\003\004\000\002\003\003\000" +
    "\002\003\004\000\002\003\003\000\002\003\004\000\002" +
    "\003\003\000\002\004\004\000\002\004\003\000\002\004" +
    "\004\000\002\004\003\000\002\010\003\000\002\005\013" +
    "\000\002\005\013\000\002\005\013\000\002\005\011\000" +
    "\002\005\013\000\002\006\007\000\002\007\006\000\002" +
    "\011\004\000\002\011\004\000\002\011\004\000\002\011" +
    "\005\000\002\011\005\000\002\011\003\000\002\011\005" +
    "\000\002\011\003\000\002\011\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\112\000\010\004\005\015\006\026\007\001\002\000" +
    "\012\002\ufffd\004\005\015\006\026\007\001\002\000\022" +
    "\002\ufff0\004\ufff0\005\ufff0\015\ufff0\016\ufff0\020\ufff0\025" +
    "\ufff0\026\ufff0\001\002\000\010\004\005\005\015\025\017" +
    "\001\002\000\012\002\ufffb\004\005\015\006\026\007\001" +
    "\002\000\004\002\011\001\002\000\004\002\001\001\002" +
    "\000\004\002\ufffc\001\002\000\012\004\005\005\015\020" +
    "\ufff9\025\017\001\002\000\012\004\005\005\015\020\ufff5" +
    "\025\017\001\002\000\004\021\064\001\002\000\012\004" +
    "\005\005\015\020\ufff7\025\017\001\002\000\004\023\035" +
    "\001\002\000\004\020\021\001\002\000\006\004\005\005" +
    "\023\001\002\000\010\004\005\005\023\016\ufff1\001\002" +
    "\000\004\023\031\001\002\000\010\004\005\005\023\016" +
    "\ufff3\001\002\000\004\016\026\001\002\000\012\002\000" +
    "\004\005\015\006\026\007\001\002\000\004\002\uffff\001" +
    "\002\000\004\016\ufff4\001\002\000\004\012\032\001\002" +
    "\000\004\017\033\001\002\000\010\004\uffe9\005\uffe9\016" +
    "\uffe9\001\002\000\004\016\ufff2\001\002\000\004\005\036" +
    "\001\002\000\004\021\037\001\002\000\004\022\040\001" +
    "\002\000\014\006\041\007\042\010\044\011\043\013\045" +
    "\001\002\000\004\024\060\001\002\000\004\024\055\001" +
    "\002\000\004\017\054\001\002\000\004\024\051\001\002" +
    "\000\004\024\046\001\002\000\004\013\047\001\002\000" +
    "\004\017\050\001\002\000\012\004\uffeb\005\uffeb\020\uffeb" +
    "\025\uffeb\001\002\000\004\010\052\001\002\000\004\017" +
    "\053\001\002\000\012\004\uffee\005\uffee\020\uffee\025\uffee" +
    "\001\002\000\012\004\uffec\005\uffec\020\uffec\025\uffec\001" +
    "\002\000\004\007\056\001\002\000\004\017\057\001\002" +
    "\000\012\004\uffef\005\uffef\020\uffef\025\uffef\001\002\000" +
    "\004\006\061\001\002\000\004\017\062\001\002\000\012" +
    "\004\uffed\005\uffed\020\uffed\025\uffed\001\002\000\004\020" +
    "\ufff8\001\002\000\004\022\065\001\002\000\024\012\066" +
    "\013\074\014\067\015\077\027\071\030\073\031\070\032" +
    "\072\033\075\001\002\000\026\012\uffe3\013\uffe3\014\uffe3" +
    "\015\uffe3\017\uffe3\027\uffe3\030\uffe3\031\uffe3\032\uffe3\033" +
    "\uffe3\001\002\000\026\012\uffe1\013\uffe1\014\uffe1\015\uffe1" +
    "\017\uffe1\027\uffe1\030\uffe1\031\uffe1\032\uffe1\033\uffe1\001" +
    "\002\000\024\012\066\013\074\014\067\015\077\027\071" +
    "\030\073\031\070\032\072\033\075\001\002\000\024\012" +
    "\066\013\074\014\067\015\077\027\071\030\073\031\070" +
    "\032\072\033\075\001\002\000\024\012\066\013\074\014" +
    "\067\015\077\027\071\030\073\031\070\032\072\033\075" +
    "\001\002\000\024\012\066\013\074\014\067\015\077\027" +
    "\071\030\073\031\070\032\072\033\075\001\002\000\026" +
    "\012\uffe0\013\uffe0\014\uffe0\015\uffe0\017\uffe0\027\uffe0\030" +
    "\uffe0\031\uffe0\032\uffe0\033\uffe0\001\002\000\024\012\066" +
    "\013\074\014\067\015\077\027\071\030\073\031\070\032" +
    "\072\033\075\001\002\000\004\017\102\001\002\000\004" +
    "\005\100\001\002\000\004\016\101\001\002\000\026\012" +
    "\uffe2\013\uffe2\014\uffe2\015\uffe2\017\uffe2\027\uffe2\030\uffe2" +
    "\031\uffe2\032\uffe2\033\uffe2\001\002\000\012\004\uffea\005" +
    "\uffea\020\uffea\025\uffea\001\002\000\024\012\066\013\074" +
    "\014\067\015\077\027\071\030\073\031\070\032\072\033" +
    "\075\001\002\000\026\012\uffe4\013\uffe4\014\uffe4\015\uffe4" +
    "\017\uffe4\027\uffe4\030\uffe4\031\uffe4\032\uffe4\033\uffe4\001" +
    "\002\000\026\012\uffe7\013\uffe7\014\uffe7\015\uffe7\017\uffe7" +
    "\027\uffe7\030\uffe7\031\uffe7\032\uffe7\033\uffe7\001\002\000" +
    "\026\012\uffe6\013\uffe6\014\uffe6\015\uffe6\017\uffe6\027\uffe6" +
    "\030\uffe6\031\uffe6\032\uffe6\033\uffe6\001\002\000\026\012" +
    "\uffe8\013\uffe8\014\uffe8\015\uffe8\017\uffe8\027\uffe8\030\uffe8" +
    "\031\uffe8\032\uffe8\033\uffe8\001\002\000\024\012\066\013" +
    "\074\014\067\015\077\027\071\030\073\031\070\032\072" +
    "\033\075\001\002\000\026\012\uffe5\013\uffe5\014\uffe5\015" +
    "\uffe5\017\uffe5\027\uffe5\030\uffe5\031\uffe5\032\uffe5\033\uffe5" +
    "\001\002\000\004\020\ufff6\001\002\000\004\020\ufffa\001" +
    "\002\000\004\002\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\112\000\006\002\007\010\003\001\001\000\006\002" +
    "\113\010\003\001\001\000\002\001\001\000\012\003\017" +
    "\005\012\006\015\010\013\001\001\000\006\002\011\010" +
    "\003\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\012\003\112\005\012\006\015\010\013\001" +
    "\001\000\012\003\111\005\012\006\015\010\013\001\001" +
    "\000\002\001\001\000\012\003\062\005\012\006\015\010" +
    "\013\001\001\000\002\001\001\000\002\001\001\000\010" +
    "\004\024\007\023\010\021\001\001\000\010\004\033\007" +
    "\023\010\021\001\001\000\002\001\001\000\010\004\027" +
    "\007\023\010\021\001\001\000\002\001\001\000\006\002" +
    "\026\010\003\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\011\075\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\011\107" +
    "\001\001\000\004\011\106\001\001\000\004\011\105\001" +
    "\001\000\004\011\104\001\001\000\002\001\001\000\004" +
    "\011\102\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\011\103\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\011\110\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



	/*Method that is called when parser can be recovered*/
	public void syntax_error(Symbol s){ 
            System.out.println("\u001B[31m" + "Error sintactico: " +s.value+"\u001B[0m"+s.left+s.right); 
            //Instruction.lista.addError(new Error_("Sintactico error: "+s.value, "Sintactico"));
    }
	/*Method that is called when parser can't be recovered*/
	public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception{ 
            System.out.println("\u001B[31m"+"Error sintactico uncovered: " +s.value+"\u001B[0m"+s.left+s.right); 
            //Instruction.lista.addError(new Error_("Sintactico error: "+s.value, "Sintactico"));
    } 


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= LLAVELEFT expresion CAMBIOSECCION expresion2 LLAVERIGHT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // inicio ::= LLAVELEFT expresion CAMBIOSECCION expresion2 LLAVERIGHT inicio 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // inicio ::= comentario inicio 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // inicio ::= comentario 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // inicio ::= SALTODELINEA inicio 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // inicio ::= SALTODELINEA 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // expresion ::= conjunto expresion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // expresion ::= conjunto 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expresion ::= regulares expresion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // expresion ::= regulares 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expresion ::= comentario expresion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expresion ::= comentario 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expresion2 ::= evaluar expresion2 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion2",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // expresion2 ::= evaluar 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion2",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // expresion2 ::= comentario expresion2 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion2",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // expresion2 ::= comentario 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion2",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // comentario ::= COMMENT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("comentario",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // conjunto ::= CONJ DOSPUNTOS IDENTIFICADOR GUION MAYOR AZMINUS ONDULADO AZMINUS PUNTOYCOMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 Proyecto1_Compi.Menu.elementos.insertar(a,"CONJUNTO",b+"-"+c,"",""); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // conjunto ::= CONJ DOSPUNTOS IDENTIFICADOR GUION MAYOR AZMAYUS ONDULADO AZMAYUS PUNTOYCOMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 Proyecto1_Compi.Menu.elementos.insertar(a,"CONJUNTO",b+"-"+c,"",""); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // conjunto ::= CONJ DOSPUNTOS IDENTIFICADOR GUION MAYOR NUMERO ONDULADO NUMERO PUNTOYCOMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 Proyecto1_Compi.Menu.elementos.insertar(a,"CONJUNTO",b+"-"+c,"",""); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // conjunto ::= CONJ DOSPUNTOS IDENTIFICADOR GUION MAYOR NOTACIONCOMAS PUNTOYCOMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 Proyecto1_Compi.Menu.elementos.insertar(a,"CONJUNTO",b,"",""); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // conjunto ::= CONJ DOSPUNTOS IDENTIFICADOR GUION MAYOR SIMBOLO ONDULADO SIMBOLO PUNTOYCOMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-6)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String b = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 Proyecto1_Compi.Menu.elementos.insertar(a,"CONJUNTO",b+"-"+c,"",""); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("conjunto",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // regulares ::= IDENTIFICADOR GUION MAYOR polaca PUNTOYCOMA 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		NodoArbol b = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 NodoArbol root = new NodoArbol(".",b,new NodoArbol("#", null, null)); ArbolBinario tree = new ArbolBinario(a, root); tree.generarGrafo(root); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("regulares",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // evaluar ::= IDENTIFICADOR DOSPUNTOS CADENA PUNTOYCOMA 
            {
              Object RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int jleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int jright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String j = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 Proyecto1_Compi.Menu.elementos.insertar(i,"CADENA","","",j); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("evaluar",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // polaca ::= CERRKLEE polaca 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodoArbol a = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NodoArbol("*", a, null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // polaca ::= CERRPOSI polaca 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodoArbol a = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NodoArbol("+", a, null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // polaca ::= PREGUNTA polaca 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodoArbol a = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NodoArbol("?", a, null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // polaca ::= PUNTO polaca polaca 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		NodoArbol a = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodoArbol b = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NodoArbol(".", a, b); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // polaca ::= OR polaca polaca 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		NodoArbol a = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		NodoArbol b = (NodoArbol)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NodoArbol("|", a, b); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // polaca ::= CADENA 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 a = a.replace("\"", ""); RESULT = new NodoArbol(a, null, null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // polaca ::= LLAVELEFT IDENTIFICADOR LLAVERIGHT 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = new NodoArbol(a, null, null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // polaca ::= TKESPECIALES 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NodoArbol(a, null, null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // polaca ::= SIMBOLO 
            {
              NodoArbol RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new NodoArbol(a, null, null); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("polaca",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
