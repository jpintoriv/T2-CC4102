package graph;

import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
	int cantNodes = 10000;
	int e;
	
	ArrayList<Integer>[] edges;
	Hashtable<Integer, Double>[] dist;
	
	@SuppressWarnings("unchecked")
	public Graph(int factorEdges) {
		this.e = this.cantNodes*factorEdges;
		this.edges = new ArrayList[this.cantNodes];
		this.dist = new Hashtable[this.cantNodes];
		this.setEdges();
	}
	
	private void setEdges() {
		 for(int i = 0; i < cantNodes-1; i++){
		      this.edges[i] = new ArrayList<Integer>();
		      this.edges[i].add(i+1);
	         	      
		      dist[i] = new Hashtable<Integer, Double>();
		      this.genterateDist(i, i+1);
		      
		    }
		 this.edges[cantNodes-1] = new ArrayList<Integer>();
		 
		 for(int i = 0; i < this.e - (this.cantNodes-1); i++){
		   int salida = (int) (Math.random() * cantNodes) ;
           int entrada = (int) (Math.random() * cantNodes) ;
		   while(salida == entrada){
		     salida = (int) (Math.random() * cantNodes) ;
	         entrada = (int) (Math.random() * cantNodes) ;
		   }
		   this.edges[salida].add(entrada);
		   this.genterateDist(salida, entrada);
		 }
	}
	
	private void genterateDist(int x, int y){
	  int min = Math.min(x, y);
      int max = Math.max(x, y);
      
      this.dist[min].put(max, Math.random());
	}
	
	public double getDist(int x, int y){
	  int min = Math.min(x, y);
      int max = Math.max(x, y);
 
      return this.dist[min].get(max);	  
	}
	
	public ArrayList<Integer>[] getEdges(){
	  return this.edges;
	}
	
	public int getCantNodes(){
	  return this.cantNodes;
	}

}
