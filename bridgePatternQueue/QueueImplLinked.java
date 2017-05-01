package bridgePatternQueue;

public class QueueImplLinked implements QueueImpl {
	private int queueSize = 0;
	private Node front = null;
	private Node rear = null;
	
	public QueueImplLinked(){}
	
	public void enqueue(double value){
		if (this.queueSize == 0){
			this.front = new Node(null, value);
			this.rear = this.front;
			this.queueSize++;
		}
		else{
			Node newRearNode = new Node(null, value);
			this.rear.setNext(newRearNode);
			this.rear = newRearNode;
			this.queueSize++;
		}
	}	
	
	public void dequeue() throws EmptyQueueException{
		if (this.queueSize == 0){
			throw new EmptyQueueException("Cannot deque() on an Empty Queue");
		}
		this.front = this.front.getNext();
		this.queueSize--;
	}
	public double front() throws EmptyQueueException{
		if (queueSize == 0){
			throw new EmptyQueueException("Cannot perform front() on an Empty Queue");
		}
		return this.front.getValue();
	}
	
	public int size(){
		return this.queueSize;
	}
	
	public boolean empty(){
		if (this.queueSize==0){
			return true;
		}
		return false;
	}
}
