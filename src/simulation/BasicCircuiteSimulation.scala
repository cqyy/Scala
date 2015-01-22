package simulation


abstract class BasicCircuiteSimulation extends Simulation{
  def InverterDelay: Int
  def AndGateDelay: Int
  def OrGateDelay: Int
  
  class Wire() { 
    private var singal = false
    private var actions:List[Action] = List()
    
    def getSingal = singal
    
    def setSingal(s:Boolean) = {
      if(s != singal){
        singal = s
        actions.foreach(_())
      }
    }
    
    def addAction(action:() => Unit) = {
      actions = action :: actions
    }
  }
  def inverter(input: Wire, output: Wire) {...}
  def andGate(a1: Wire, a2: Wire, output: Wire) {...}
  def orGate(o1: Wire, o2: Wire, output: Wire) {...}
  def probe(name: String, wire: Wire) {...}
}