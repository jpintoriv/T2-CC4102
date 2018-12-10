package dijkstras;

public interface IDijkstra {
	void execute(int originNode);
	
	double[] getDistances();
	
	int[] getPaths();
}