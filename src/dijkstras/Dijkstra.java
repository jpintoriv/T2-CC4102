package dijkstras;

import java.util.ArrayList;

import elements.Element;
import graph.Graph;
import priorityQueues.IPriorityQueue;

public class Dijkstra implements IDijkstra {
	Graph graph;
	int originNode;
	double[] dist;
	IPriorityQueue pq;
	int[] prev;
	
	public Dijkstra(Graph graph, int originNode, IPriorityQueue pq) {
		this.graph = graph;
		this.originNode = originNode;
		this.pq = pq;
	}

	@Override
	public void execute() {
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

}
