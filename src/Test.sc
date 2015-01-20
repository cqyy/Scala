import Element._

object Test {
 	elem(Array("Hello","Hi"))                 //> java.lang.AssertionError: assumption failed: element is not rectangular
                                                  //| 	at scala.Predef$.assume(Predef.scala:196)
                                                  //| 	at ArrayElement$$anonfun$2.apply(Element.scala:63)
                                                  //| 	at ArrayElement$$anonfun$2.apply(Element.scala:62)
                                                  //| 	at scala.collection.IndexedSeqOptimized$class.foreach(IndexedSeqOptimize
                                                  //| d.scala:33)
                                                  //| 	at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:186)
                                                  //| 	at ArrayElement.<init>(Element.scala:62)
                                                  //| 	at Element$.elem(Element.scala:81)
                                                  //| 	at Test$$anonfun$main$1.apply$mcV$sp(Test.scala:4)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at Test$.main(Test.scala:3)
                                                  //| 	at Test.main(Test.scala)
           
}