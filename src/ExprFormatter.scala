import Element._

class ExprFormatter {
  /** Contains all operators in groups of increasing precedence */
  protected val opGroups = Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("ˆ"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
      )
      
      /** A mapping from operators to their precedence */
private val precedence = {
  val assocs = 
    for { 
    i <- 0 until opGroups.length 
    op <- opGroups(i) }
  yield op -> i
  Map() ++ assocs
  }
  
  protected val unaryPrecedence = opGroups.length
  
  protected val fractionPrecedence = -1
  
  private def format(e:Expr,enclPrec:Int):Element = e match{
    case Var(v) => elem(v)
    case Number(n) => elem(n.toString())
    case UnOp(op,args) => elem(op) beside format(args,unaryPrecedence)
    case BinOp("/",left,right) =>
      val top = format(left,fractionPrecedence)
      val bot = format(right,fractionPrecedence)
      val line = elem('-',top.width,1)
      val frac = top above line above bot
      frac
    case BinOp(op,left,right) =>
      val pre = precedence(op)
      val l = format(left,pre)
      val r = format(right,pre)
      val frac = l beside elem(" " + op + " ") beside r
      if(pre >= enclPrec) frac
      elem("( ") beside frac beside elem(" )")      
  }
  
  def format(e:Expr):Element = format(e,0)  
}