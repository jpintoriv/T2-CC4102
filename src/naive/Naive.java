package naive;

import java.util.ArrayList;
import java.util.Arrays;

import graph.Graph;

public class Naive {
  double[] dist;
  boolean[] visited;
  int[] prev;
  Graph graph;
  
  public Naive(Graph graph, int originNode){
    this.graph = graph;
    int cantNodes = graph.getCantNodes();
    
    dist = new double[cantNodes];
    Arrays.fill(dist, Double.MAX_VALUE);
    dist[originNode] = 0;
    
    visited = new boolean[cantNodes];
    Arrays.fill(visited, false);
    
    prev = new int[cantNodes];
    Arrays.fill(prev, -1);
  }
  
  public void execute(){
    int cantNodes = this.graph.getCantNodes();
    
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
}
