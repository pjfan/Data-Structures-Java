package splayTreeOne;

import java.util.Scanner;
import java.util.*;


class TestDriver {
	public static void main(String[] args){
		Scanner inputScan = new Scanner(System.in);
		SplayTree testTree = new SplayTree();
		System.out.println("Welcome to the BST Driver!");
		System.out.println("For your convenience, a new BST has automatically been created.");
		System.out.println("If you'd like to create a new tree simply type the 'new' command.");		
		while (true){
			System.out.println("Type a command to continue.");
			String command = inputScan.next();
			if (command.equals("new")){
				SplayTree newTestTree = new SplayTree();
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
				SPLTNode rootNode = testTree.getCell(testTree.getRootValue());
				SPLTNode currentNode = rootNode;
				
				PreOrderSort printSort = new PreOrderSort();
				printSort.printNode(currentNode,indentLevel);
				
			}	
			else if (command.equals("f")){
				System.out.println("How many random strings do you want to insert into the tree?");
				//This try-catch is here in case the user types something other than an integer in as input.
				try{
					int genNumber = inputScan.nextInt();
					for (int i=0; i<genNumber; i++){
						String random = MyRandom.nextString(6,10);
						//this if statement checks to make sure that the random string generator is not creating/inserting a
						//duplicate string. If a duplicate has been generated the if statement subtracts 1 from i 
						//which ensures another random string will be generated and skips the insert step using a continue statement.
						if (testTree.getRootValue() != null && testTree.getCell(testTree.getRootValue()).contains(random)==true){
							i--;
							continue;
						}
						testTree.insert(random);
						System.out.println("Random string: " + random + " was generated and inserted into the tree." );
					}
					System.out.println("Finished inserting: " + genNumber + " strings into Tree!");
				}
				catch (java.util.InputMismatchException e){
					System.out.println("Error: Please enter an integer value for number of random strings.");
				}
			}
		}
	}
}

class SPLTNode {
	private SPLTNode leftChild = null;
	private SPLTNode rightChild = null;
	private SPLTNode parent = null;
	private String content = null;
	
	public SPLTNode(SPLTNode parent, String content){
		this.parent = parent;
		this.content = content;
	}
	
	public SPLTNode getLeftChild(){
		return this.leftChild;
	}
	
	public SPLTNode getRightChild(){
		return this.rightChild;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public SPLTNode getParent(){
		return this.parent;
	}
	
	public void setLeftChild(SPLTNode newLeftChild){
		if (newLeftChild != null){
			newLeftChild.setParent(this);
		}
		this.leftChild = newLeftChild;
	}
	
	public void setRightChild(SPLTNode newRightChild){
		if (newRightChild != null){
			newRightChild.setParent(this);			
		}
		this.rightChild = newRightChild;
	}
	
	public void setContent(String newContent){
		this.content = newContent;
	}
	
	public void setParent(SPLTNode newParentNode){
		this.parent = newParentNode;
	}
	
	public void insert(String insertString){
		int sortingInt = this.content.compareTo(insertString);
		if (sortingInt >= 0 && this.leftChild == null){
			SPLTNode node = new SPLTNode(null, insertString);
			this.setLeftChild(node);
		}
		else if (sortingInt >= 0 && this.leftChild != null){
			this.leftChild.insert(insertString);
		}
		else if (sortingInt < 0 && this.rightChild == null){
			SPLTNode node = new SPLTNode(null, insertString);
			this.setRightChild(node);
		}
		else {
			this.rightChild.insert(insertString);
		}
	}
	
	public String findMin(){
		if (this.leftChild == null){
			return this.content;
		}
		else{
			return this.leftChild.findMin();
		}
	}
	
	public String findMax(){
		if (this.rightChild == null){
			return this.content;
		}
		else {
			return this.rightChild.findMax();
		}
	}
	
	public boolean contains(String searchString){
		if (this.content.equals(searchString)){
			return true;
		}
		int containsInt = this.content.compareTo(searchString);
		if (containsInt >= 0 && this.leftChild == null){
			return false;
		}
		else if(containsInt>=0 && this.leftChild != null){
			return this.leftChild.contains(searchString);
		}
		else if (containsInt < 0 && this.rightChild == null){
			return false;
		}
		else{
			return this.rightChild.contains(searchString);
		}
	}
	
	public void remove(String remString){
		if (this.content.equals(remString)){
			if (this.leftChild == null && this.rightChild==null){
				if(this.parent.getRightChild() == this){
					this.parent.setRightChild(null);
					this.parent = null;
					return;
				}
				else if (this.parent.getLeftChild() == this){
					this.parent.setLeftChild(null);
					this.parent = null;
					return;
				}
			}
			else if (this.rightChild != null && this.leftChild == null) {
				if (this.parent.getLeftChild() == this){
					this.parent.setLeftChild(this.rightChild);					
					this.parent = null;
					return;
				}
				else if (this.parent.getRightChild() == this){
					this.parent.setRightChild(this.rightChild);
					this.parent = null;
					return;
				}
			}
			else if (this.leftChild != null && this.rightChild == null){
				if (this.parent.getLeftChild() == this){
					this.parent.setLeftChild(this.leftChild);
					this.parent = null;
					return;
				}
				else if (this.parent.getRightChild() == this){
					this.parent.setRightChild(this.leftChild);
					this.parent = null;
					return;
				}
			}
			else if(this.leftChild != null && this.rightChild != null){
				String newMin = this.rightChild.findMin();
				this.content = newMin;
				this.rightChild.remove(newMin);
				return;
			}
		}
		else{
			int removerInt = this.content.compareTo(remString);
			if(removerInt>=0 && this.leftChild != null){
				this.leftChild.remove(remString);
			}
			else if(removerInt<0 && this.rightChild != null){
				this.rightChild.remove(remString);
			}
			else{
				return;
			}
		}
	}
	
	public SPLTNode getCell(String searchString){
		if (this.content.equals(searchString)){
			return this;
		}
		int containsInt = this.content.compareTo(searchString);
		if (containsInt >= 0 && this.leftChild == null){
			return null;
		}
		else if(containsInt>=0 && this.leftChild != null){
			return this.leftChild.getCell(searchString);
		}
		else if (containsInt < 0 && this.rightChild == null){
			return null;
		}
		else{
			return this.rightChild.getCell(searchString);
		}
	
	}
	public void splay(){
		if (this.parent == null){
			return;
		}
		if (this.parent != null && this.parent.getParent() == null){
			if (this.parent.getRightChild() == this){
				this.zigR();
			}
			else if (this.parent.getLeftChild() == this){
				this.zigL();
			}
		}
		else if (this.parent != null && this.parent.getParent() != null && this.parent.getRightChild() == this && this.parent.getParent().getRightChild() == this.parent){
			this.zigzigR();
		}
		else if (this.parent != null && this.parent.getParent() != null && this.parent.getLeftChild() == this && this.parent.getParent().getLeftChild() == this.parent){
			this.zigzigL();
		}
		else if (this.parent != null && this.parent.getParent() != null && this.parent.getRightChild() == this && this.parent.getParent().getLeftChild() == this.parent){
			this.zigzagRL();
		}
		else if (this.parent != null && this.parent.getParent() != null && this.parent.getLeftChild() == this && this.parent.getParent().getRightChild() == this.parent){
			this.zigzagLR();
		}		
		this.splay();
	}
	
	public void zigR(){
		//set this.parent variable to point to null (since there's no grandparent). 
		SPLTNode originalParent = this.parent;
		this.parent = null;
		
		//set grandparents right/left child to this and set this.parent to grandparent only if grandparents != null.
		if (originalParent.getParent() != null){
			SPLTNode grandParent = originalParent.getParent();
			if (grandParent.getRightChild() == originalParent){
				grandParent.setRightChild(this);
				this.parent = grandParent;
			}
			if (grandParent.getLeftChild()==originalParent){
				grandParent.setLeftChild(this);
				this.parent = grandParent;
			}
		}
				
		//set original parent node's parent variable to point to this.
		originalParent.setParent(this);
		
		//set this node's left child variable to point to original parent node.
		SPLTNode shiftLeftChild = this.leftChild;
		this.leftChild = originalParent;
		
		//set this node's shiftLeftChild as original parent's right child.
		originalParent.setRightChild(shiftLeftChild);
		
		//set this node's original left child's parent as the originalParent.
		if (shiftLeftChild != null){
			shiftLeftChild.setParent(originalParent);
		}		
		return;
	}
	
	public void zigL(){
		//set this.parent variable to point to null (since there's no grandparent). 
		SPLTNode originalParent = this.parent;
		this.parent = null;
		
		//set grandparents right/left child to this and set this.parent to grandparent only if grandparents != null.
		if (originalParent.getParent() != null){
			SPLTNode grandParent = originalParent.getParent();
			if (grandParent.getRightChild() == originalParent){
				grandParent.setRightChild(this);
				this.parent = grandParent;
			}
			if (grandParent.getLeftChild()==originalParent){
				grandParent.setLeftChild(this);
				this.parent = grandParent;
			}
		}
		
		//set original parent node's parent variable to point to this.
		originalParent.setParent(this);
		
		//set this node's right child variable to point to original parent node.
		SPLTNode shiftRightChild = this.rightChild;
		this.rightChild = originalParent;
		
		//set this node's shiftRightChild as original parent's left child.
		originalParent.setLeftChild(shiftRightChild);
		
		//set this node's original right child's parent as the originalParent.
		if (shiftRightChild != null){
			shiftRightChild.setParent(originalParent);
		}		
		return;
	}
	
	public void zigzigR(){
		this.parent.zigR();
		this.zigR();
		return;

	}
	
	public void zigzigL(){
		this.parent.zigL();
		this.zigL();
		return;
	}
	
	public void zigzagRL(){
		this.zigR();
		this.zigL();
		return;
	}
	
	public void zigzagLR(){
		this.zigL();
		this.zigR();
		return;
	}
	
}

class SplayTree {
	private SPLTNode root = null;
	private int size;
	
	public SplayTree(){
		this.root = null;
		this.size = 0;
	}
	
	public void insert(String insertString){
		if (this.root == null){
			this.root = new SPLTNode(null, insertString);
			this.size++;
		}
		else{
			this.root.insert(insertString);
			SPLTNode insertNode = this.getCell(insertString);
			insertNode.splay();
			this.root = insertNode;
			this.size++;
		}
	}
	
	public String findMin(){
		if (this.root == null){
			return null;
		}
		SPLTNode minNode = this.getCell(this.root.findMin());
		minNode.splay();
		this.root = minNode;
		return minNode.getContent();
	}
	
	public String findMax(){
		if (this.root == null){
			return null;
		}
		SPLTNode maxNode = this.getCell(this.root.findMax());
		maxNode.splay();
		this.root = maxNode;
		return maxNode.getContent();
	}
	
	public boolean contains(String searchString){
		if (this.root == null){
			return false;
		}
		if (this.root.contains(searchString) == true){
			SPLTNode contentNode = this.getCell(searchString);
			contentNode.splay();
			this.root = contentNode;
		}
		return this.root.contains(searchString);
	}
	
	public void remove(String remString){
		if (this.root == null){
			return;
		}
		else if (this.root.getContent().equals(remString) && this.root.getLeftChild() == null && this.root.getRightChild() == null){
			this.root = null;
			this.size--;
			return;
		}
		else if (this.root.getContent().equals(remString) && this.root.getLeftChild() != null && this.root.getRightChild() == null){
			this.root.getLeftChild().setParent(null);
			SPLTNode temp = this.root;
			this.root = this.root.getLeftChild();
			temp.setLeftChild(null);
			this.size--;
			return;
		}
		else if (this.root.getContent().equals(remString) && this.root.getLeftChild() == null && this.root.getRightChild() != null){
			this.root.getRightChild().setParent(null);
			SPLTNode temp = this.root;
			this.root = this.root.getRightChild();
			temp.setRightChild(null);
			this.size--;
			return;
		}
		else if (this.root.getContent().equals(remString) && this.root.getLeftChild()!=null && this.root.getRightChild() != null){
			String newContent = this.root.getRightChild().findMin();
			this.root.setContent(newContent);
			this.root.getRightChild().remove(newContent);
			this.size--;
			return;
		}
		else if (this.root.contains(remString)==true){
			SPLTNode remNodeParent = this.getCell(remString).getParent();
			this.root.remove(remString);
			remNodeParent.splay();
			this.root = remNodeParent;
			this.size--;
			return;
		}
		else{
			return;
		}
	}
	
	public SPLTNode getCell(String searchString){
		if (this.root==null){
			return null;
		}
		return this.root.getCell(searchString);
	}
	
	public String getRootValue(){
		if (this.root==null){
			return null;
		}
		return this.root.getContent();
	}
	
	public int getSize(){
		return this.size;
	}
	
	public boolean empty(){
		if (this.root == null){
			return true;
		}
		return false;
	}
	
}

class PreOrderSort {
	public PreOrderSort(){
	}
	public void printNode(SPLTNode currentNode, int indent){
		if (currentNode == null){
			return;
		}
		StringBuilder spaces = new StringBuilder(indent);
		for (int i=0; i<indent; i++){
			spaces.append("  ");
		}
		String indents = spaces.toString();
		System.out.println(indents+" "+currentNode.getContent());
		if (currentNode.getLeftChild() != null){
			printNode(currentNode.getLeftChild(), indent+1);
		}
		if (currentNode.getRightChild() != null){
			printNode(currentNode.getRightChild(), indent+1);
	
		}
	}
}



class MyRandom {

  private static Random rn = new Random();

  private MyRandom(){ }

  public static int rand(int lo, int hi) {
     int n = hi - lo + 1;
     int i = rn.nextInt() % n;
     if (i < 0) i = -i;
     return lo + i;
  }

  public static String nextString(int lo, int hi) {
     int n = rand(lo, hi);
     byte b[] = new byte[n];
     for (int i = 0; i < n; i++)
     b[i] = (byte)rand('a', 'z');
     return new String(b, 0);
  }

  public static String nextString() {
     return nextString(5, 25);
  }
  
}

