package binarySearchTree;
import java.util.Scanner;


public class TestDriver {
	public static void main(String[] args){
		Scanner inputScan = new Scanner(System.in);
		BinarySearchTree testTree = new BinarySearchTree();
		System.out.println("Welcome to the BST Driver!");
		System.out.println("For your convenience, a new BST has automatically been created.");
		System.out.println("If you'd like to create a new tree simply type the 'new' command.");		
		while (true){
			System.out.println("Type a command to continue.");
			String command = inputScan.next();
			if (command.equals("new")){
				BinarySearchTree newTestTree = new BinarySearchTree();
				testTree = newTestTree;
				System.out.println("Created new Tree!");
			}
			else if (command.equals("i")){
				System.out.println("Please enter the String you would like to insert!");
				String insertString = inputScan.next();
				testTree.insert(insertString);
				System.out.println("Inserted String: " + insertString);
			}
			
			else if (command.equals("r")){
				System.out.println("Please enter the String you would like to remove!");
				String removeString = inputScan.next();
				testTree.remove(removeString);
				System.out.println("Removed String (but only if it was already in the tree): " + removeString);
			}
			
			else if (command.equals("c")){
				System.out.println("Please enter the String you would like to see if the tree contains!");
				String containsString = inputScan.next();
				System.out.println("Is that String in the tree?: "+ testTree.contains(containsString));
			}	
			else if (command.equals("g")){
				System.out.println("Please enter the String you would like to get the Node for!");
				String getNodeString = inputScan.next();
				testTree.getCell(getNodeString);
				System.out.println("The Node containing String: " + getNodeString + " is: " + testTree.getCell(getNodeString));
			}	
			else if (command.equals("x")){
				System.out.println("The max is: " + testTree.findMax());
			}	
			else if (command.equals("n")){
				System.out.println("The min is: " + testTree.findMin());
			}	
			else if (command.equals("v")){
				System.out.println("The Root Value is: " + testTree.getRootValue());
			}	
			else if (command.equals("s")){
				System.out.println("The Tree Size is: " + testTree.getSize());
			}	
			else if (command.equals("e")){
				System.out.println("Is the Tree Empty?: "+testTree.empty());
			}	
			else if (command.equals("q")){
				System.out.println("Thank you for testing the BST! Goodbye!");
				break;
			}	
			else if (command.equals("p")){
				int indentLevel = 0;
				TreeNode rootNode = testTree.getCell(testTree.getRootValue());
				TreeNode currentNode = rootNode;
				
				PreOrderSort printSort = new PreOrderSort();
				printSort.printNode(currentNode,indentLevel);
			}	
		}
	}
}


