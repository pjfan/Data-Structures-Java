package bridgePatternQueueOne;

//===============================================================
//  main driver and test code
//===============================================================
class QueueDriver{
	public static void main(String[] args){
		Queue queueArray = new Queue(new QueueImplArray());
		Queue queueLinked = new Queue(new QueueImplLinked());
		System.out.println("Array Implementation of Queue");
		System.out.println("=========================================");
		System.out.println("Size of Empty Queue: "+queueArray.size());
		try{
			System.out.println("Front of Empty Queue: " + queueArray.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Empty Queue: " + e.getMessage());
		}
		System.out.println("Empty() method on new Queue: " + queueArray.empty());
		
		System.out.println("-----------------------------------------");
		queueArray.enqueue(5.0);
		System.out.println("Enqueue the real number: 5.0");
		System.out.println("Size of Queue after one enqueue: " + queueArray.size());
		try{
			System.out.println("Front of Queue after one enqueue: " + queueArray.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after one enqueue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after one enqueue: " + queueArray.empty());
		
		System.out.println("-----------------------------------------");
		queueArray.enqueue(6.0);
		System.out.println("Enqueue the real number: 6.0");
		System.out.println("Size of Queue after second enqueue: " + queueArray.size());
		try{
			System.out.println("Front of Queue after second enqueue: " + queueArray.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after second enqueue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after second enqueue: " + queueArray.empty());
		
		System.out.println("-----------------------------------------");
		try{
			queueArray.dequeue();
			System.out.println("Perform first dequeue() on Queue");
		}
		catch (EmptyQueueException e){
			System.out.println("Perform first dequeue() on Queue: " + e.getMessage());
		}
		System.out.println("Size of Queue after first dequeue: " + queueArray.size());
		try{
			System.out.println("Front of Queue after first dequeue: " + queueArray.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after first dequeue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after first dequeue: " + queueArray.empty());

		System.out.println("-----------------------------------------");
		try{
			queueArray.dequeue();
			System.out.println("Performed second dequeue() on Queue");
		}
		catch (EmptyQueueException e){
			System.out.println("Performed second dequeue() on Queue: " + e.getMessage());
		}
		System.out.println("Size of Queue after second dequeue: " + queueArray.size());
		try{
			System.out.println("Front of Queue after second dequeue: " + queueArray.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after second dequeue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after first dequeue: " + queueArray.empty());
		
		System.out.println("-----------------------------------------");
		try{
			queueArray.dequeue();
			System.out.println("Performed third dequeue() on Queue");
		}
		catch (EmptyQueueException e){
			System.out.println("Attempted third dequeue() on Queue: " + e.getMessage());
		}		
		System.out.println("-----------------------------------------");
		
		System.out.println("Linked List Implementation of Queue");
		System.out.println("=========================================");
		System.out.println("Size of Empty Queue: " + queueLinked.size());
		try{
			System.out.println("Front of Empty Queue: " + queueLinked.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Empty Queue: " + e.getMessage());
		}
		System.out.println("Empty() method on new Queue: " + queueLinked.empty());
		
		System.out.println("-----------------------------------------");
		queueLinked.enqueue(5.0);
		System.out.println("Enqueue the real number: 5.0");
		System.out.println("Size of Queue after one enqueue: " + queueLinked.size());
		try{
			System.out.println("Front of Queue after one enqueue: " + queueLinked.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after one enqueue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after one enqueue: " + queueLinked.empty());
		
		System.out.println("-----------------------------------------");
		queueLinked.enqueue(6.0);
		System.out.println("Enqueue the real number: 6.0");
		System.out.println("Size of Queue after second enqueue: " + queueLinked.size());
		try{
			System.out.println("Front of Queue after second enqueue: " + queueLinked.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after second enqueue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after second enqueue: " + queueLinked.empty());
		
		System.out.println("-----------------------------------------");
		try{
			queueLinked.dequeue();
			System.out.println("Perform first dequeue() on Queue");
		}
		catch (EmptyQueueException e){
			System.out.println("Perform first dequeue() on Queue: " + e.getMessage());
		}
		System.out.println("Size of Queue after first dequeue: " + queueLinked.size());
		try{
			System.out.println("Front of Queue after first dequeue: " + queueLinked.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after first dequeue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after first dequeue: " + queueLinked.empty());

		System.out.println("-----------------------------------------");
		try{
			queueLinked.dequeue();
			System.out.println("Performed second dequeue() on Queue");
		}
		catch (EmptyQueueException e){
			System.out.println("Performed second dequeue() on Queue: " + e.getMessage());
		}
		System.out.println("Size of Queue after second dequeue: " + queueLinked.size());
		try{
			System.out.println("Front of Queue after second dequeue: " + queueLinked.front());
		}
		catch (EmptyQueueException e){
			System.out.println("Front of Queue after second dequeue: " + e.getMessage());
		}
		System.out.println("Empty() method on Queue after first dequeue: " + queueLinked.empty());
		
		System.out.println("-----------------------------------------");
		try{
			queueLinked.dequeue();
			System.out.println("Performed third dequeue() on Queue");
		}
		catch (EmptyQueueException e){
			System.out.println("Attempted third dequeue() on Queue: " + e.getMessage());
		}
		
		System.out.println("-----------------------------------------");
	}
}

//===============================================================
//  front end abstraction 
//===============================================================
class Queue{
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

//===============================================================
//  back end implementations
//===============================================================
interface QueueImpl {
	public void enqueue(double x);
	public void dequeue() throws EmptyQueueException;
	public double front() throws EmptyQueueException;
	public int size();
	public boolean empty();
}

class QueueImplArray implements QueueImpl{
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


//any classes here you may need for array implementation

class QueueImplLinked implements QueueImpl {
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

//and other classes you may need, like LinkCell, to complete the linked  implementation

class Node {
	
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

class EmptyQueueException extends Exception{
	public EmptyQueueException(String message){
		super(message);
	}
}

