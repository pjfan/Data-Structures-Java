package binarySearchTree;

public class BinarySearchTree {
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
