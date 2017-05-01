package basicGraph;

public class Edge {
	private String label = null;
	private int serialNumber;
	private Node toNode;
	
	public Edge(int serialNumber, Node toNode){
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
}
