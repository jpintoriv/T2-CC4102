package elements;

public class Element {
	int x;
	Double p;
	
	public Element(int x, Double p) {
		this.x = x;
		this.p = p;
	}
	
	public int getValue() {
		return this.x;
	}
	
	public Double getPriority() {
		return this.p;
	}
	
	public void setPriority(Double newPriority) {
		this.p = newPriority;
	}
}
