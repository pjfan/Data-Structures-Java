package bridgePatternQueue;

public class Node {
	
	private Node nextNode = null;
	private double value;
	
	public Node(Node nextNode, double value){
		this.nextNode = nextNode;
		this.value = value;
	}
	public Node getNext(){
		return this.nextNode;
	}
	public double getValue(){
		return this.value;
	}
	public void setNext(Node nextNode){
		this.nextNode = nextNode;
	}
}
