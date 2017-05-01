package splayTree;

public class PreOrderSort {
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

