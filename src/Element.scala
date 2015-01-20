abstract class Element {
  def contents:Array[String]
  
  def width = if(contents.length == 0 ) 0 else contents(0).length
  
  def height = contents.length
  
  def above(that:Element):Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    new ArrayElement(this1.contents ++ that1.contents)
  }
  
  def beside(that:Element):Element = {
    val this1 = this highten that.height
    val that1 = that highten this.height
    new ArrayElement(
        for( (line1,line2) <- this1.contents zip that1.contents)
          yield (line1 + line2))
  }
  
  private def widen(w:Int):Element ={
    if (this.width >= w) this
    else{
      val left = (w - this.width)/2
      val right = w -(this.width + left)
      new ArrayElement(
          for(line <- contents)
            yield (space(left) + line + space(right))
            )
    }
  }
  
  protected def highten(h:Int):Element = {
    if (this.height >= h) this
    else{
      val more = for(i <- 0 until h - this.height) yield space(this.width)
      new ArrayElement(this.contents ++ more)          
    }
  }
  
  protected def space(n:Int):String = {
    val arr = new Array[Char](n)
    for(i <- 0 until n)
      arr(i) = ' '
    new String(arr)
  }
  
 protected def mkString(ch:Char,length:Int):String = {
   val arr = new Array[Char](length)
   for(i <- 0 until length)
     arr(i)=ch
   new String(arr)
 } 
 
 override def toString:String = {
   contents mkString "\n"
 }
}

class ArrayElement(val contents:Array[String]) extends Element{
  for(line <- contents)
    assume(line.length == this.width,"element is not rectangular")
}

class LineElement(line:String) extends Element{
  override def contents = Array(line)
  override def width = line.length
  override def height = 1
}

class UniformElement(
    ch:Char,
    override val width:Int,
    override val height:Int) extends Element{
  private val line = mkString(ch,width)
  override val contents = Array(line)
  }

object Element{
  def elem(contents:Array[String]):Element = new ArrayElement(contents)
  def elem(line:String):Element = new LineElement(line)
  def elem(ch:Char,width:Int,height:Int):Element = new UniformElement(ch,width,height)
}