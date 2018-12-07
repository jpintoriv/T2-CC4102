package experiment;

import graph.Graph;
import naive.Naive;

public class Experiment {

  
  public static void main(String[] args){
    Graph oli = new Graph(10);
    Naive n = new Naive(oli,0);
    n.execute();
    
  }

}
