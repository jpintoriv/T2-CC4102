package priorityQueues;

import elements.Element;

public class ClassicHeap implements IPriorityQueue {
	Element values[];
	int cantValues;
	int posValue[];
	
	public ClassicHeap(int size) {
		this.values = new Element[size];
		this.cantValues = 0;
		this.posValue = new int[size];
	}
	
	public ClassicHeap() {
		this.values = new Element[100001];
		this.cantValues = 0;
		this.posValue = new int[100001];
	}

	@Override
	public void insert(int value, double priority) {
		Element newElement = new Element(value,priority);
		values[this.cantValues] = newElement;
		posValue[value] = this.cantValues;
		this.emerger(this.cantValues);
		this.cantValues++;
	}
	
	private void emerger(int pos) {
		for(int i = pos; i > 0 && values[i].getPriority() < values[(i-1)/2].getPriority(); i = (i-1)/2) {
			Element temp = values[i];
			values[i] = values[(i-1)/2];
			values[(i-1)/2] = temp;
			posValue[values[i].getValue()] = i;
			posValue[values[(i-1)/2].getValue()] = (i-1)/2;
		}
	}

	@Override
	public Element extractMin() {
		Element ans = this.values[0];
		this.cantValues--;
		this.values[0] = this.values[this.cantValues];
		posValue[ans.getValue()] = -1;
		this.sumergir(0);
		return ans;
	}
	
	private void sumergir(int pos) {
		int posValueToMove = pos;
		while(2*posValueToMove+1 <= this.cantValues){
			int higherChildren = 2*posValueToMove+1;
			if(higherChildren+1 < this.cantValues && values[higherChildren+1].getPriority() < values[higherChildren].getPriority() ) {
				higherChildren ++;				
			}
			if(values[posValueToMove].getPriority() < values[higherChildren].getPriority()) {
				break;
			}
			Element temp = values[posValueToMove];
			values[posValueToMove] = values[higherChildren];
			values[higherChildren] = temp;
			
			posValue[values[higherChildren].getValue()] = higherChildren;
			posValue[values[posValueToMove].getValue()] = posValueToMove;			
			
			posValueToMove = higherChildren;			
		}
	}

	@Override
	public boolean isEmpty() {
		return this.cantValues == 0;
	}

	@Override
	public void decreaseKey(int value, double newPriority) {
		int pos = posValue[value];
		values[pos].setPriority(newPriority);
		
		int father = (pos-1)/2;
		if(values[father].getPriority() > newPriority) {
			this.emerger(pos);
		}else {
			this.sumergir(pos);
		}		
	}

}
