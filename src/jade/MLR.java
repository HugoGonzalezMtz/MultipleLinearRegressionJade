package jade;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class MLR extends Agent{
    protected void setup(){
        addBehaviour(new MyOneShotBehaviour());
    } 
    
  public class MyOneShotBehaviour extends OneShotBehaviour{
      
      public void action(){
        System.out.println("Agent Activated");  
        Implementing metodo = new Implementing();
        metodo.ResultadoFinal();
      }
      
      public int onEnd() {
        System.out.println("Agent killed");
        myAgent.doDelete();
        return super.onEnd();
        }
      
  }
}
