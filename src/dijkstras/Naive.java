package dijkstras;

import java.util.ArrayList;
import graph.Graph;

public class Naive implements IDijkstra {
  double[] dist;
  boolean[] visited;
  int[] prev;
  Graph graph;
  
  public Naive(Graph graph){
    this.graph = graph;
    int cantNodes = graph.getCantNodes();
    
    dist = new double[cantNodes];
    visited = new boolean[cantNodes];
    prev = new int[cantNodes];
  }
  
  public void execute(int originNode){
	int cantNodes = this.graph.getCantNodes();
	  
	for(int i = 0; i < cantNodes; i++){
		this.dist[i] = Double.MAX_VALUE;
		this.visited[i] = false;
		this.prev[i] = -1;
	}
	dist[originNode] = 0;
	
	for(int i = 0; i < cantNodes; i++){
	  double minDist = Double.MAX_VALUE;
	  int minNode = -1;
	  
	  for(int j = 0; j < cantNodes; j++){
	    if(!this.visited[j] && this.dist[j] < minDist){
	      minDist = this.dist[j];
	      minNode = j;
	    }
	  }
	  int u = minNode;
	  this.visited[u] = true;
	  
	  ArrayList<Integer>[] edges = this.graph.getEdges();
	  for(int k = 0; k < edges[u].size(); k++){
	    int v = edges[u].get(k);
	    double distAux = this.graph.getDist(u,v);
	    if(v > this.dist[u] + distAux){
	      this.dist[v] = this.dist[u] + distAux;
	      this.prev[v] = u;
	    }
	  }
	}
    
  }
  
  public double[] getDistances(){
    return this.dist;
  }
  
  @Override
  public int[] getPaths() {
	  return this.prev;
  }
}
