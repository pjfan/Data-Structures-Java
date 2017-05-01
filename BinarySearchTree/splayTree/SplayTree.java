package splayTree;

public class SplayTree {
	private TreeNode root = null;
	private int size;
	
	public SplayTree(){
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
			TreeNode insertNode = this.getCell(insertString);
			insertNode.splay();
			this.root = insertNode;
			this.size++;
		}
	}
	
	public String findMin(){
		if (this.root == null){
			return null;
		}
		TreeNode minNode = this.getCell(this.root.findMin());
		minNode.splay();
		this.root = minNode;
		return minNode.getContent();
	}
	
	public String findMax(){
		if (this.root == null){
			return null;
		}
		TreeNode maxNode = this.getCell(this.root.findMax());
		maxNode.splay();
		this.root = maxNode;
		return maxNode.getContent();
	}
	
	public boolean contains(String searchString){
		if (this.root == null){
			return false;
		}
		if (this.root.contains(searchString) == true){
			TreeNode contentNode = this.getCell(searchString);
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
		else if (this.root.contains(remString)==true){
			TreeNode remNodeParent = this.getCell(remString).getParent();
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
