package binarySearchTree;

public class TreeNode {
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
