package basicGraphTopoSort;

public class Edge {
	private String label = null;
	private int serialNumber;
	private int weight;
	private Node toNode;
	
	public Edge(int serialNumber, Node toNode, int weight){
		this.weight = weight;
		this.serialNumber = serialNumber;
		this.toNode = toNode;
	}
	
	public void setLabel(String name){
		this.label = name;
	}
	public String getLabel(){
		return this.label;
	}
	
	public int getSerialNumber(){
		return this.serialNumber;
	}
	
	public Node getToNode(){
		return this.toNode;
	}
	
	public int getWeight(){
		return this.weight;
	}
}
