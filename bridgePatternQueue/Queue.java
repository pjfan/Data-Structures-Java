package bridgePatternQueue;

public class Queue{
	protected QueueImpl queueImpl;
	
	public Queue(QueueImpl queueImpl){
		this.queueImpl = queueImpl;
	}
	public void enqueue(double value){
		this.queueImpl.enqueue(value);
		}
	public void dequeue() throws EmptyQueueException{
		this.queueImpl.dequeue();
	}
	
	public double front() throws EmptyQueueException{
		return this.queueImpl.front();
	}
	public int size(){
		return this.queueImpl.size();
	}
	public boolean empty(){
		return this.queueImpl.empty();
	}
}
