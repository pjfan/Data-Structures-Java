package bridgePatternQueue;

public interface QueueImpl {
	public void enqueue(double x);
	public void dequeue() throws EmptyQueueException;
	public double front() throws EmptyQueueException;
	public int size();
	public boolean empty();
}
