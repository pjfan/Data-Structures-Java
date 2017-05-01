package bridgePatternQueue;
 
public class QueueDriver{
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
