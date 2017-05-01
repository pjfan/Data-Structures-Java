package binaryHeap;

public class BinaryHeap {
	private BHeapNode[] BHeapArray;
	private int size;
	
	public BinaryHeap(){
		this.BHeapArray = new BHeapNode[1];
		this.size = 0;
	}
	
	public BHeapNode getMin(){
		if (this.size > 0){			
			return this.BHeapArray[1];
		}
		else{
			return null;
		}
	}
	
	public int size(){
		return this.size;
	}
	
	public void insert(int priority, String info){
		this.size++;
		if (this.BHeapArray.length<(this.size+1)){
			BHeapNode[] newArray = new BHeapNode[this.size+1];
			for (int i=0; i<this.BHeapArray.length; i++){
				newArray[i] = this.BHeapArray[i];
			}
			this.BHeapArray = newArray;
		}
		BHeapNode newNode = new BHeapNode(priority, info);
		bubbleUp(this.size, newNode);
	}
	
	public void bubbleUp(int insertionIndex, BHeapNode insertNode){
		int parentIndex = (int) Math.floor(insertionIndex/2.0);
		if (parentIndex == 0){
			this.BHeapArray[insertionIndex] = insertNode;
			return;
		}
		if (this.BHeapArray[parentIndex].getPriority() < insertNode.getPriority()){
			this.BHeapArray[insertionIndex] = insertNode;
			return;
		}
		else{
			this.BHeapArray[insertionIndex] = this.BHeapArray[parentIndex];
			bubbleUp(parentIndex, insertNode);
		}
	}
	
	public void delMin(){
		if (this.size == 0){
			return;
		}
		if (this.size == 1){
			this.BHeapArray[1] = null;
			this.size--;
			return;
		}
		this.BHeapArray[1] = null;
		BHeapNode lastNode = this.BHeapArray[this.size];
		this.BHeapArray[this.size] = null;
		bubbleDown(1,lastNode);
		this.size--;
	}
	
	public void bubbleDown(int insertionIndex, BHeapNode lastNode){
		int childIndex1 = insertionIndex*2;
		int childIndex2 = (insertionIndex*2)+1;
		try{
			if (this.BHeapArray[childIndex1] == null){
				this.BHeapArray[insertionIndex] = lastNode;
				return;
			}
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e){
			this.BHeapArray[insertionIndex] = lastNode;
			return;
		}
		try{
			if (this.BHeapArray[childIndex2] == null){
				if (this.BHeapArray[childIndex1].getPriority() > lastNode.getPriority()){
					this.BHeapArray[insertionIndex] = lastNode;
					return;
				}
				else{
					this.BHeapArray[insertionIndex] = this.BHeapArray[childIndex1];
					bubbleDown(childIndex1, lastNode);
					return;
				}
			}
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			if (this.BHeapArray[childIndex1].getPriority() > lastNode.getPriority()){
				this.BHeapArray[insertionIndex] = lastNode;
				return;
			}
			else{
				this.BHeapArray[insertionIndex] = this.BHeapArray[childIndex1];
				bubbleDown(childIndex1, lastNode);
				return;
			}
		}
		if (lastNode.getPriority() < this.BHeapArray[childIndex2].getPriority() && lastNode.getPriority() < this.BHeapArray[childIndex1].getPriority()){
			this.BHeapArray[insertionIndex] = lastNode;
			return;
		}
		else if (lastNode.getPriority() > this.BHeapArray[childIndex2].getPriority() && lastNode.getPriority() < this.BHeapArray[childIndex1].getPriority()){
			this.BHeapArray[insertionIndex] = this.BHeapArray[childIndex2];
			bubbleDown(childIndex2, lastNode);
			return;
		}		
		else if (lastNode.getPriority() < this.BHeapArray[childIndex2].getPriority() && lastNode.getPriority() > this.BHeapArray[childIndex1].getPriority()){
			this.BHeapArray[insertionIndex] = this.BHeapArray[childIndex1];
			bubbleDown(childIndex1, lastNode);
			return;
		}
		else{
			if (this.BHeapArray[childIndex2].getPriority()>this.BHeapArray[childIndex1].getPriority()){
				this.BHeapArray[insertionIndex] = this.BHeapArray[childIndex1];
				bubbleDown(childIndex1, lastNode);
				return;
			}
			else{
				this.BHeapArray[insertionIndex] = this.BHeapArray[childIndex2];
				bubbleDown(childIndex2, lastNode);
				return;
			}
		}
	}
	public void build(BHeapNode[] nodeArray){
		this.BHeapArray = new BHeapNode[nodeArray.length+1];
		this.size = nodeArray.length;
		for (int x=0;x<nodeArray.length;x++){
			this.BHeapArray[x+1]=nodeArray[x];
		}
		for (int i=this.size;i>1;i--){
			if (i%2 != 0){
				continue;
			}
			else{
				int parentIndex = (int) Math.floor(i/2);
				bubbleDown(parentIndex,this.BHeapArray[parentIndex]);
			}
		}
	}
	
	public BHeapNode[] getArray(){
		return this.BHeapArray;
	}
}
