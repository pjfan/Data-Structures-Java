package splayTree;

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
		TreeNode originalParent = this.parent;
		this.parent = null;
		
		//set grandparents right/left child to this and set this.parent to grandparent only if grandparents != null.
		if (originalParent.getParent() != null){
			TreeNode grandParent = originalParent.getParent();
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
		TreeNode shiftLeftChild = this.leftChild;
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
		TreeNode originalParent = this.parent;
		this.parent = null;
		
		//set grandparents right/left child to this and set this.parent to grandparent only if grandparents != null.
		if (originalParent.getParent() != null){
			TreeNode grandParent = originalParent.getParent();
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
		TreeNode shiftRightChild = this.rightChild;
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
