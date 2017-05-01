package binaryHeap;

import java.util.Scanner;

public class BHeapDriver {
	public static void main(String[] args){
		if (args.length != 0){
			// 1. Read in the arguments and save them in arrays
			int[] priorityArray = new int[args.length/2];
			String[] valueArray = new String[args.length/2];
			System.out.println("Mode 2");
			int na = args.length; // our test data will make this even
			for (int i=0; i < na; i++) {
				if (i%2==0){
					priorityArray[i/2] = Integer.parseInt(args[i]);					
				}
				if(i%2!=0){
					valueArray[(i-1)/2] = args[i];
				}
			}
			
			// 2. Create Binary Heap.
			BinaryHeap testHeap = new BinaryHeap();
			
			// 3. Insert arguments in BinaryHeap.
			for (int j=0; j<priorityArray.length; j++){
				testHeap.insert(priorityArray[j], valueArray[j]);
			}
			
			// 4. Print Heap.
			BHeapNode[] nodeArray = testHeap.getArray();
			String results = "";
			for (int k=0; k<nodeArray.length; k++){
				if (nodeArray[k]!= null){
					results+=nodeArray[k].getPriority();
					results+=":";
					results+=nodeArray[k].getInfo();
					if (k != testHeap.size()){
						results+=", ";
					}
				}
			}
			System.out.println(results);
			
			// 5. Create new empty Heap.
			BinaryHeap newHeap = new BinaryHeap();
			
			// 6. Take saved arrays of inputs and use the build operation on them.
			BHeapNode[] buildArray = new BHeapNode[priorityArray.length];
			for (int x=0; x<priorityArray.length; x++){
				buildArray[x] = new BHeapNode(priorityArray[x], valueArray[x]);
			}
			newHeap.build(buildArray);
			
			// 7. Print the Binary Heap generated using build.
			
			BHeapNode[] nodeBuildArray = newHeap.getArray();
			String buildResults = "";
			for (int k=0; k<nodeBuildArray.length; k++){
				if (nodeBuildArray[k]!= null){
					buildResults+=nodeBuildArray[k].getPriority();
					buildResults+=":";
					buildResults+=nodeBuildArray[k].getInfo();
					if (k != newHeap.size()){
						buildResults+=", ";
					}
				}
			}
			System.out.println(buildResults);
			
			// 8. Generate a sorted output sequence.
			String sortedResults = "";
			int initialSize = newHeap.size();
			for (int i=0; i<initialSize; i++){
				sortedResults+=newHeap.getMin().getPriority();
				sortedResults+=":";
				sortedResults+=newHeap.getMin().getInfo();
				if (i!=initialSize-1){
					sortedResults+=", ";
				}
				newHeap.delMin();
			}
			System.out.println(sortedResults);	
		}
		else{
			Scanner inputScan = new Scanner(System.in);
			BinaryHeap testHeap = new BinaryHeap();
			System.out.println("Mode 1");
			System.out.println("We will do the interactive test driver.");
			System.out.println("Welcome to the BHeap Driver!");
			System.out.println("For your convenience, a new BHeap has automatically been created.");
			System.out.println("If you'd like to create a new bheap simply type the 'n' command.");		
			while (true){
				System.out.println("Type a command to continue.");
				String command = inputScan.next();
				if (command.equals("q")){
					System.out.println("Thank you for testing the BHeap! Goodbye!");
					break;
				}	
				else if (command.equals("n")){
					BinaryHeap newTestHeap = new BinaryHeap();
					testHeap = newTestHeap;
				}
				else if (command.equals("i")){		
					System.out.println("What is the integer priority?");
					int priority = inputScan.nextInt();
					System.out.println("What is the String value?");
					String value = inputScan.next();
					testHeap.insert(priority, value);
				}
				else if (command.equals("d")){		
					testHeap.delMin();
				}
				else if (command.equals("g")){
					String[] nodeValue = new String[2];
					nodeValue[0] = Integer.toString(testHeap.getMin().getPriority());
					nodeValue[1] = testHeap.getMin().getInfo();
					System.out.println(nodeValue[0]+":"+nodeValue[1]);
				}
				else if (command.equals("s")){
					System.out.println(testHeap.size() + " Elements");
				}
				else if (command.equals("b")){
					System.out.println("Input -1 for the integer priority to break the loop");
					BHeapNode[] storageArray = new BHeapNode[0];
					while (true){
						System.out.println("What is the integer priority?");
						int priority = inputScan.nextInt();
						if (priority == -1){
							break;
						}
						System.out.println("What is the String value?");
						String value = inputScan.next();
						BHeapNode[] newStorageArray = new BHeapNode[storageArray.length+1];
						for (int i=0; i<storageArray.length; i++){
							newStorageArray[i] = storageArray[i];
						}
						storageArray = newStorageArray;
						BHeapNode inputNode = new BHeapNode(priority, value);
						storageArray[storageArray.length-1] = inputNode;
					}
					testHeap.build(storageArray);
				}
				else if (command.equals("f")){
					System.out.println("How many random items do you want to insert into the BHeap?");
					//This try-catch is here in case the user types something other than an integer in as input.
					try{
						int genNumber = inputScan.nextInt();
						for (int i=0; i<genNumber; i++){
							int randInt = (int)(Math.random() * 100 + 1);
							String randString = MyRandom.nextString(6,10);
							testHeap.insert(randInt, randString);
						}
					}
					catch (java.util.InputMismatchException e){
						System.out.println("Error: Please enter an integer value for number of random items.");
					}
				}
				else if (command.equals("p")){
					BHeapNode[] nodeArray = testHeap.getArray();
					String results = "";
					for (int i=0; i<nodeArray.length; i++){
						if (nodeArray[i]!= null){
							results+=nodeArray[i].getPriority();
							results+=":";
							results+=nodeArray[i].getInfo();
							if (i != testHeap.size()){
								results+=", ";
							}
						}
					}
					System.out.println(results);
				}
				else if (command.equals("o")){
					String results = "";
					int initialSize = testHeap.size();
					for (int i=0; i<initialSize; i++){
						results+=testHeap.getMin().getPriority();
						results+=":";
						results+=testHeap.getMin().getInfo();
						if (i!=initialSize-1){
							results+=", ";
						}
						testHeap.delMin();
					}
					System.out.println(results);	
				}
			}
		}
	}
}