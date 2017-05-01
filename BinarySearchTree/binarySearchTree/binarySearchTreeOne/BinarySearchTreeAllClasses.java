package binarySearchTreeOne;
import java.util.Scanner;


class BinarySearchTreeDriver{
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

class TreeNode {
	private TreeNode leftChild = null;
	private TreeNode rightChild = null;
	private TreeNode parent = null;
	private String content = null;
	
	public TreeNode(TreeNode parent, String content){
		this.parent = parent;
		this.content = content;
	}
	
	public TreeNode getLeftChild(){
		return this.leftChild;
	}
	
	public TreeNode getRightChild(){
		return this.rightChild;
	}
	
	public String getContent(){
		return this.content;
	}
	
	public TreeNode getParent(){
		return this.parent;
	}
	
	public void setLeftChild(TreeNode newLeftChild){
		if (newLeftChild != null){
			newLeftChild.setParent(this);
		}
		this.leftChild = newLeftChild;
	}
	
	public void setRightChild(TreeNode newRightChild){
		if (newRightChild != null){
			newRightChild.setParent(this);			
		}
		this.rightChild = newRightChild;
	}
	
	public void setContent(String newContent){
		this.content = newContent;
	}
	
	public void setParent(TreeNode newParentNode){
		this.parent = newParentNode;
	}
	
	public void insert(String insertString){
		int sortingInt = this.content.compareTo(insertString);
		if (sortingInt >= 0 && this.leftChild == null){
			TreeNode node = new TreeNode(null, insertString);
			this.setLeftChild(node); 
		}
		else if (sortingInt >= 0 && this.leftChild != null){
			this.leftChild.insert(insertString);
		}
		else if (sortingInt < 0 && this.rightChild == null){
			TreeNode node = new TreeNode(null, insertString);
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
	
	public TreeNode getCell(String searchString){
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
	
}

class BinarySearchTree {
	private TreeNode root = null;
	private int size;
	
	public BinarySearchTree(){
		this.root = null;
		this.size = 0;
	}
	
	public void insert(String insertString){
		if (this.root == null){
			this.root = new TreeNode(null, insertString);
			this.size++;
		}
		else{
			this.root.insert(insertString);
			this.size++;
		}
	}
	
	public String findMin(){
		if (this.root == null){
			return null;
		}
		return this.root.findMin();
	}
	
	public String findMax(){
		if (this.root == null){
			return null;
		}
		return this.root.findMax();
	}
	
	public boolean contains(String searchString){
		if (this.root == null){
			return false;
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
			TreeNode temp = this.root;
			this.root = this.root.getLeftChild();
			temp.setLeftChild(null);
			this.size--;
			return;
		}
		else if (this.root.getContent().equals(remString) && this.root.getLeftChild() == null && this.root.getRightChild() != null){
			this.root.getRightChild().setParent(null);
			TreeNode temp = this.root;
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
		else if (this.contains(remString)==true){			
			this.root.remove(remString);
			this.size--;
			return;
		}
		else{
			return;
		}
	}
	
	public TreeNode getCell(String searchString){
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
	public void printNode(TreeNode currentNode, int indent){
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

