package bridgePatternQueue;

public class QueueImplArray implements QueueImpl{
	private double[] privateArray;
	
	public QueueImplArray(){
		this.privateArray = new double[0];
	}
	
	public void enqueue(double value){
		double[] newPrivateArray = new double[this.privateArray.length+1];
		
		for (int i=0; i<this.privateArray.length; i++){
			newPrivateArray[i] = this.privateArray[i];
		}
		
		newPrivateArray[this.privateArray.length] = value;
		this.privateArray = newPrivateArray;
	}
	
	public void dequeue() throws EmptyQueueException{
		if (this.privateArray.length == 0){
			throw new EmptyQueueException("Cannot deque() on an Empty Queue");
		}
		double[] newPrivateArray = new double[this.privateArray.length-1];
		
		for (int i=0; i<newPrivateArray.length; i++){
			newPrivateArray[i] = this.privateArray[i+1];
		}
		this.privateArray = newPrivateArray;
	}
	
	public double front() throws EmptyQueueException{
		if (this.privateArray.length == 0){
			throw new EmptyQueueException("Cannot perform front() on an Empty Queue");
		}
		return privateArray[0];
	}
	
	public int size(){
		return privateArray.length;
	}
	
	public boolean empty(){
		if (privateArray.length == 0){
			return true;
		}
		return false;
	}
}


