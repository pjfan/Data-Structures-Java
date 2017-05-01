package basicGraphTopoSort;

public class Node {
	private int serialNumber;
	private String name;
	private int indegree;
	
	public Node(int serialNumber, String name){
		this.serialNumber = serialNumber;
		this.name = name;
		this.indegree=0;
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
}
