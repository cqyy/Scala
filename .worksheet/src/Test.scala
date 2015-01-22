import Element._

object Test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(71); 
  
  val list = "a"::"b"::"c"::"d"::Nil;System.out.println("""list  : List[String] = """ + $show(list ));$skip(12); val res$0 = 
  list.head;System.out.println("""res0: String = """ + $show(res$0))}
  
}
