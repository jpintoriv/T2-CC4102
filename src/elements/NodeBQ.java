package elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class NodeBQ{
	Element element;
	NodeBQ children, sibling, parent;
	int degree = 0;
	
	public NodeBQ(int x, double p){
		this.element = new Element(x,p);
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public NodeBQ merge(NodeBQ n){
		NodeBQ higher = this;
		NodeBQ lower = n;
		if(this.element.getPriority() < n.element.getPriority()) {
			higher = n;
			lower = this;
		}
		higher.parent = lower;
		higher.sibling = lower.children;
		lower.children = higher;
		lower.degree++;		
		
		return lower;
	}
	
	public List<NodeBQ> deleteFirst(){
		List<NodeBQ> ans = new ArrayList<NodeBQ>();
		NodeBQ node = this.children;
		while(node != null) {
			node.parent = null;
			NodeBQ nextNode = node.sibling;
			node.sibling = null;
			ans.add(node);
			node = nextNode;			
		}
		Collections.reverse(ans);
		return ans;
	}
	
	public NodeBQ getChildren() {
		return this.children;
	}
	
	public NodeBQ getParent() {
		return this.parent;
	}
	
	public NodeBQ getSibling() {
		return this.sibling;
	}

	public int getDegree() {
		return this.degree;
	}
	
	

}
