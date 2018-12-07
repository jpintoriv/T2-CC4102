package graph;

import java.util.ArrayList;
import java.util.Hashtable;

public class Graph {
	int cantNodes = 10000;
	int e;
	
	ArrayList<Integer>[] edges;
	Hashtable<Integer, Double> dist;
	
	@SuppressWarnings("unchecked")
	public Graph(int factorEdges) {
		this.e = this.cantNodes*factorEdges;
		edges = new ArrayList[this.cantNodes];
		dist = new Hashtable<Integer, Double>();
		this.setEdges();
	}
	
	private void setEdges() {
		 for(int i = 0; i < cantNodes-1; i++){
		      this.edges[i] = new ArrayList<Integer>();
		      this.edges[i].add(i+1);
		    }
		 this.edges[cantNodes-1] = new ArrayList<Integer>();
		 
		 for(int i = 0; i < this.e - (this.cantNodes-1); i++){
			 int salida = (int) (Math.random() * cantNodes) ;
		     int entrada = (int) (Math.random() * cantNodes) ;
		     
		     this.edges[salida].add(entrada);
		     
		     int min = Math.min(salida, entrada);
		     int max = Math.max(salida, entrada);
		     
		     String in = Integer.toString(min);
		     String fi = Integer.toString(max);
		     String conc = in + fi;
		     
		     int tosave = Integer.parseInt(conc);
		     
		     this.dist.put(tosave, Math.random());
		     if(i%1000==0)
		         System.out.println(i);
		 }
	}

}
