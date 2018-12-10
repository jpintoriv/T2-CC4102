package priorityQueues;

import java.util.ArrayList;
import java.util.List;

import elements.Element;
import elements.NodeBQ;

public class FibonacciQueue implements IPriorityQueue {
	List<NodeBQ> fibQueue;
	int cantValues;
	public int indMaxPriority;
	public double maxPriority;
	
	public FibonacciQueue() {
		this.cantValues = 0;
		this.fibQueue = new ArrayList<NodeBQ>();
		this.indMaxPriority = -1;
		this.maxPriority = Double.MAX_VALUE;
	}

	@Override
	public void insert(int value, double priority) {
		NodeBQ nodeToInsert = new NodeBQ(value,priority);
		if(this.indMaxPriority == -1) {
			this.indMaxPriority = 0;
			this.maxPriority = priority;
		}else if(this.maxPriority > priority) {
			this.indMaxPriority = this.fibQueue.size();
			this.maxPriority = priority;
		}
		this.cantValues++;
		fibQueue.add(nodeToInsert);		
	}

	@Override
	public Element extractMin() {
		NodeBQ minNode = this.fibQueue.remove(indMaxPriority);
		Element ans = minNode.getElement();
		List<NodeBQ> childrensMaxValue = minNode.deleteFirst();		
		this.indMaxPriority = -1;
		this.maxPriority = -1;
		
		this.fibQueue = this.suma(this.fibQueue, childrensMaxValue);
		this.cantValues--;
		return ans;
	}
	
	public List<NodeBQ> suma (List<NodeBQ> l1, List<NodeBQ> l2) {
		int maxCantValues = Integer.max(l1.size(), l2.size());
		int[] degrees = new int[this.cantValues+maxCantValues];
		List<NodeBQ> ans = new ArrayList<NodeBQ>();		
				
		for(NodeBQ actualNode: l1) {
			while(degrees[actualNode.getDegree()] != 0) {
				NodeBQ sameDegree = ans.remove(degrees[actualNode.getDegree()]-1);
				int init = degrees[actualNode.getDegree()]-1;
				degrees[actualNode.getDegree()] = 0;
				for(int i = init; i < ans.size(); i++) {
					if(degrees[ans.get(i).getDegree()] != 0) {
						degrees[ans.get(i).getDegree()] = i+1;
					}
				}
				actualNode = actualNode.merge(sameDegree);
			}
			ans.add(actualNode);
			degrees[actualNode.getDegree()] = ans.size();
		}
		
		for(NodeBQ actualNode: l2) {
			while(degrees[actualNode.getDegree()] != 0) {
				NodeBQ sameDegree = ans.remove(degrees[actualNode.getDegree()]-1);
				int init = degrees[actualNode.getDegree()]-1;
				degrees[actualNode.getDegree()] = 0;
				for(int i = init; i < ans.size(); i++) {
					if(degrees[ans.get(i).getDegree()] != 0) {
						degrees[ans.get(i).getDegree()] = i+1;
					}
				}
				
				actualNode = actualNode.merge(sameDegree);
			}
			ans.add(actualNode);
			degrees[actualNode.getDegree()] = ans.size();
			
		}
		int i = 0;
		for(NodeBQ actualNode: ans) {
			if(this.maxPriority > actualNode.getElement().getPriority()) {
				this.indMaxPriority = i;
				this.maxPriority = actualNode.getElement().getPriority();
			}
			i++;
		}
		return ans;
	}

	@Override
	public boolean isEmpty() {
		return this.cantValues == 0;
	}

	@Override
	public void decreaseKey(int value, double newPriority) {
		// TODO Auto-generated method stub

	}

}
