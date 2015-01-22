package simulation

abstract class Simulation {
  type Action = () => Unit
  
  private case class WorkItem(delay:Int,action:Action)
  
  private var workItems:List[WorkItem] = List()
  
  private var curr = 0
  
  def currentTime = curr
  
  
  private def insert(item:WorkItem,items:List[WorkItem]):List[WorkItem] = {
    if(items.isEmpty || item.delay <= items.head.delay) item::items
    items.head :: insert(item,items.tail)
  }
  
  def afterDelay(delay:Int)(block: => Unit):Unit = {
    val item = new WorkItem(delay,() => block)
    workItems = insert(item,workItems)
  }
  
  private def next():Unit = (workItems: @unchecked) match{
    case item::_ => 
      curr = item.delay
      item.action()
  }
  
  def run(){
    afterDelay(0){
      println("*** simulation started, time = "+ currentTime+" ***")
    }
    while(!workItems.isEmpty) next
  }
}