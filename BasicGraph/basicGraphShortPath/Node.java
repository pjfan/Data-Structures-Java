package basicGraphShortPath;

public class Node {
	private int serialNumber;
	private String name;
	private int indegree;
	
	private boolean known;
	private Node prevNode;
	private int pathValue;
	
	public Node(int serialNumber, String name){
		this.serialNumber = serialNumber;
		this.name = name;
		this.indegree=0;
		this.known = false;
		this.prevNode = null;
		this.pathValue = Integer.MAX_VALUE;
	}	
	public String getName(){
		return this.name;
	}
	public int getSerialNumber(){
		return this.serialNumber;
	}
	public int getIndegree(){
		return this.indegree;
	}
	public void addOneIndegree(){
		this.indegree++;
	}
	public void subOneIndegree(){
		this.indegree--;
	}
	public int getPathValue(){
		return this.pathValue;
	}
	public Node getPrevNode(){
		return this.prevNode;
	}
	public boolean getKnown(){
		return this.known;
	}
	public void setPathValue(int newPathValue){
		this.pathValue = newPathValue;
	}
	public void setPrevNode(Node newPrevNode){
		this.prevNode = newPrevNode;
	}
	public void setKnown(boolean newKnown){
		this.known = newKnown;
	}
}
