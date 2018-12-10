package priorityQueues;

import elements.Element;

public interface IPriorityQueue {
	
	void insert(int value, double priority);
	
	Element extractMin();
	
	boolean isEmpty();
	
	void decreaseKey(int value, double newPriority);

}
