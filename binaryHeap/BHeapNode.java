package binaryHeap;

public class BHeapNode {
	private int priority;
	private String info;
	
	public BHeapNode(int priority, String info){
		this.priority = priority;
		this.info = info;
	}
	public int getPriority(){
		return this.priority;
	}	
	public String getInfo(){
		return this.info;
	}
}
