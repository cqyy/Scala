abstract class Expr {}
case class Var(name:String) extends Expr
case class Number(num:Double) extends Expr
case class UnOp(op:String,arg:Expr) extends Expr
case class BinOp(op:String,left:Expr,right:Expr) extends Expr 