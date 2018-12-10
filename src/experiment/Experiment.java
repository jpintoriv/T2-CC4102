package experiment;

import dijkstras.Dijkstra;
import dijkstras.IDijkstra;
import dijkstras.Naive;
import graph.Graph;
import priorityQueues.ClassicHeap;
import priorityQueues.FibonacciQueue;

public class Experiment {

  
  public static void main(String[] args){
	  String typeDijkstra = args[0];
	  int e;
	  try {
		  e = Integer.parseInt(args[1]);
	  }catch(Exception exc){
		  System.out.println("error with factor 'e' for edges");
		  return;
	  }
	  System.out.println(e);
	  if(e != 10 && e != 100 && e != 1000) {
		  System.out.println("error with factor 'e' for edges");
		  return;
	  }
	  Graph graph = new Graph(e);
	  IDijkstra d;
	  
	  if(typeDijkstra.compareTo("naive") == 0) {
		  d = new Naive(graph);
	  }else if(typeDijkstra.compareTo("classicHeap") == 0) {
		  d = new Dijkstra(graph, new ClassicHeap() );
	  }else if(typeDijkstra.compareTo("fiboQueue") == 0) {
		  d = new Dijkstra(graph, new FibonacciQueue());
	  }else {
		  System.out.println("error with type dijkstra algorithm");
		  return;
	  }
	  long  startTime = System.nanoTime();
	  d.execute(0);
	  long endTime = System.nanoTime();
	  
	  System.out.println("Tiempo: " + (endTime-startTime)/1e6 + " ms");
    
  }

}
