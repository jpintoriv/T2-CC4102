package dijkstras;

import java.util.ArrayList;

import elements.Element;
import graph.Graph;
import priorityQueues.IPriorityQueue;

public class Dijkstra implements IDijkstra {
	Graph graph;
	double[] dist;
	IPriorityQueue pq;
	int[] prev;
	
	public Dijkstra(Graph graph, IPriorityQueue pq) {
		this.graph = graph;
		this.pq = pq;
		int cantNodes = graph.getCantNodes();
		this.dist = new double[cantNodes];
		this.prev = new int[cantNodes];
	}

	@Override
	public void execute(int originNode) {
		int cantNodes = this.graph.getCantNodes();
	    
	    for(int i = 0; i < cantNodes; i++){
	    	if(i == originNode) {
	    		this.dist[i] = 0;
	    	}else {
	    		this.dist[i] = Double.MAX_VALUE;
	    	}
	    	prev[i] = -1;
	    	this.pq.insert(i, dist[i]);
	    }
	    ArrayList<Integer>[] edges = this.graph.getEdges();
	    while(!this.pq.isEmpty()) {
	    	Element m = this.pq.extractMin();
	    	for(int k = 0; k < edges[m.getValue()].size(); k++){
	    		int v = edges[m.getValue()].get(k);
	    		double newDist = dist[m.getValue()] + this.graph.getDist(m.getValue(), v);
	    		if(newDist < dist[v]) {
	    			dist[v] = newDist;
	    			prev[v] = m.getValue();
	    			this.pq.decreaseKey(v, newDist);
	    		}
	    	}
	    }
	}

	@Override
	public double[] getDistances() {
		return this.dist;
	}

	@Override
	public int[] getPaths() {
		return this.prev;
	}

}
