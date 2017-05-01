package basicGraph;

public class Node {
	private int serialNumber;
	private String name;
	
	public Node(int serialNumber, String name){
		this.serialNumber = serialNumber;
		this.name = name;
	}	
	public String getName(){
		return this.name;
	}
	public int getSerialNumber(){
		return this.serialNumber;
	}
}
