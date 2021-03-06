/* Generated By:JavaCC: Do not edit this line. Parser.java */
package javacc;

public class Parser implements ParserConstants {
  public static void main(String [] args) throws ParseException,
  TokenMgrError
  {
    Parser parser;
    if (args.length == 0)
    {
      System.out.println("Parser: Reading from standard input... ");
      parser = new Parser(System.in);
    }
    else if (args.length == 1)
    {
      System.out.println("Parser: Reading from file " + args [0] + "...");
      try
      {
        parser = new Parser(new java.io.FileInputStream(args [0]));
      }
      catch (java.io.FileNotFoundException e)
      {
        System.out.println("Parser: File " + args [0] + " not found.");
        return;
      }
    }
    else
    {
      System.out.println("Parser: Usage is one of:");
      System.out.println(" java Parser < inputfile");
      System.out.println("OR");
      System.out.println(" java Scanner inputfile");
      return;
    }
    try
    {
      parser.Start();
      System.out.println("Parser: Program parsed successfully.");
    }
    catch (ParseException e)
    {
      System.out.println("Parser: Encountered errors on parsing.");
      e.printStackTrace();
    }
  }

  final public void Start() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FUNCTION:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      funcao();
    }
    jj_consume_token(0);
  }

  final public void funcao() throws ParseException {
    jj_consume_token(FUNCTION);
    jj_consume_token(IDENTIFICADOR);
    listaDeParametros();
    jj_consume_token(DOISPONTOS);
    tipoDeParametro();
    blocoFuncao();
  }

  final public void listaDeParametros() throws ParseException {
    jj_consume_token(PARENTESE1);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      nomeParametro();
      contListaDeParametro();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(PARENTESE2);
  }

  final public void nomeParametro() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(DOISPONTOS);
    tipoDeParametro();
  }

  final public void contListaDeParametro() throws ParseException {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VIRGULA:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(VIRGULA);
      nomeParametro();
    }
  }

  final public void tipoDeParametro() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIPOINTEGER:
      jj_consume_token(TIPOINTEGER);
      break;
    case TIPOSTRING:
      jj_consume_token(TIPOSTRING);
      break;
    case TIPOREAL:
      jj_consume_token(TIPOREAL);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void blocoFuncao() throws ParseException {
    jj_consume_token(IS);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      blocoVar();
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    blocoCode();
  }

  final public void blocoVar() throws ParseException {
    jj_consume_token(VAR);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      declaraVariavel();
    }
    jj_consume_token(ENDVAR);
  }

  final public void declaraVariavel() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(DOISPONTOS);
    tipoDeParametro();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PARENTESE1:
      inicializacao();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
    jj_consume_token(PONTOVIRGULA);
  }

  final public void inicializacao() throws ParseException {
    jj_consume_token(PARENTESE1);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      jj_consume_token(STRING);
      break;
    case INTEGER:
    case REAL:
    case IDENTIFICADOR:
    case PLUS:
    case SUB:
      operacao();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PARENTESE2);
  }

  final public void blocoCode() throws ParseException {
    jj_consume_token(CODE);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
      case REAL:
      case IDENTIFICADOR:
      case STRING:
      case PLUS:
      case SUB:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
      expressao();
    }
    retorno();
    jj_consume_token(ENDCODE);
  }

  final public void expressao() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
    case REAL:
    case IDENTIFICADOR:
    case PLUS:
    case SUB:
      operacao();
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PONTOVIRGULA);
  }

  final public void retorno() throws ParseException {
    jj_consume_token(RETURN);
    expressao();
  }

  final public void operacao() throws ParseException {
    valor();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case SUB:
    case MULT:
    case DIV:
    case MOD:
      operador();
      operacao();
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
  }

  final public void valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
    case REAL:
    case PLUS:
    case SUB:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case SUB:
        sinal();
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEGER:
        jj_consume_token(INTEGER);
        break;
      case REAL:
        jj_consume_token(REAL);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void operador() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case SUB:
      jj_consume_token(SUB);
      break;
    case MULT:
      jj_consume_token(MULT);
      break;
    case DIV:
      jj_consume_token(DIV);
      break;
    case MOD:
      jj_consume_token(MOD);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void sinal() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      jj_consume_token(PLUS);
      break;
    case SUB:
      jj_consume_token(SUB);
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  /** Generated Token Manager. */
  public ParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x40,0x40000,0x800000,0x380,0x800,0x40000,0x2000000,0x180f0000,0x180f0000,0x180f0000,0xf8000000,0x18000000,0x30000,0x18070000,0xf8000000,0x18000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 16; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[34];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 16; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 34; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
