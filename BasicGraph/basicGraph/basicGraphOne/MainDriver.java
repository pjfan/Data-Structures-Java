package basicGraphOne;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

//===============================================================
//main driver and test code
//===============================================================

public class MainDriver {
	public static void main(String[] args){
		Scanner inputScan = new Scanner(System.in);
		BasicGraph testGraph = new BasicGraph();
		System.out.println("Welcome to the Graph Driver!");
		System.out.println("For your convenience, a new Graph has automatically been created.");
		while (true){
			System.out.println("Type a command to continue.");
			String command = inputScan.next();
			if (command.equals("q")){
				System.out.println("Thanks for testing the Graph Driver! Goodbye.");
				break;
			}
			else if (command.equals("an")){
				System.out.println("Please enter a name for the node.");
				String name = inputScan.next();
				testGraph.addNode(name);
			}
			else if (command.equals("ae")){
				System.out.println("Please enter the name of a node for the edge to start from.");
				String fromNodeName = inputScan.next();
				System.out.println("Please enter the name of a node for the edge to end at.");
				String toNodeName = inputScan.next();
				System.out.println("(Optional) Enter \"yes\" to this prompt if you would like to give your edge a name.");
				String yesOrNo = inputScan.next();
				if (yesOrNo.equals("yes")){
					System.out.println("Please enter edge name.");
					String name = inputScan.next();
					testGraph.addEdge(name, fromNodeName, toNodeName);
				}
				else{
					testGraph.addEdge(null, fromNodeName, toNodeName);
				}
			}
			else if (command.equals("dn")){
				System.out.println("Please enter the name of the node you would like to remove.");
				String delNodeName = inputScan.next();
				testGraph.deleteNode(delNodeName);
			}
			else if (command.equals("de")){
				System.out.println("Please enter the name of the starting node for the edge you would like to delete.");
				String fromNodeName = inputScan.next();
				System.out.println("Please enter the name of the eding node for the edge you would like to delete.");
				String toNodeName = inputScan.next();
				testGraph.deleteEdge(fromNodeName, toNodeName);
			}
			else if (command.equals("s")){
				System.out.println("The number of nodes is: " + testGraph.getNodeSize());
				System.out.println("The number of edges is: " + testGraph.getEdgeSize());
			}
			else if (command.equals("pg")){
				testGraph.printGraph();
			}
			else if (command.equals("pn")){
				System.out.println("Please enter the name of the node you would like to print.");
				String nodeName = inputScan.next();
				testGraph.printNode(nodeName);
			}
		}
	}
}

//================================================================
//Graph class(es)
//================================================================


class BasicGraph {
	//Hash map for all nodes in the graph, key is the unique node name. Value is the node.
	private HashMap<String, Node> nodeStorage;
	//Hash map for the edges. Key is the name of the node the edge starts at. Value is an array list of edges that start from that node and go elsewhere.
	private HashMap<String, ArrayList<Edge>> edgeStorage;
	private ArrayList<String> nodeStoreOrdList;
	private int nodeSize;
	private int edgeSize;
	private int nodeIdAssign;
	private int edgeIdAssign;
	
	public BasicGraph(){
		this.nodeSize = 0;
		this.edgeSize = 0;
		this.nodeIdAssign = 0;
		this.edgeIdAssign = 0;
		this.nodeStoreOrdList = new ArrayList<String>();
		this.nodeStorage = new HashMap<String,Node>();
		this.edgeStorage = new HashMap<String, ArrayList<Edge>>();
	}
	public boolean addNode(String name){
		//Checks to see if a node of that name already exists in the graph.
		if (this.nodeStorage.containsKey(name)==true){
			System.out.println("A node with that name is already in the graph.");
			return false; 
		}
		Node inputNode = new Node(this.nodeIdAssign,name);
		//Add node to the nodeStorage hash map. Add an empty array list to the edgeStorage hash map for the new node.
		this.nodeStorage.put(name, inputNode);
		this.edgeStorage.put(name, new ArrayList<Edge>());
		this.nodeIdAssign++;
		this.nodeSize++;
		this.nodeStoreOrdList.add(name);
		return true;
	}
	
	public boolean addEdge(String name, String fromNodeName, String toNodeName){
		//Checks if the nodes the edge connects already exist.
		if (this.nodeStorage.get(fromNodeName) == null){
			System.out.println("Sorry the node you stated the edge begins at does not exist.");
			return false;
		}
		if (this.nodeStorage.get(toNodeName) == null){
			System.out.println("Sorry the node you stated the edge ends at does not exist.");
			return false;
		}
		//Checks to see if the edge already exists in the graph.
		ArrayList<Edge> edgeList = this.edgeStorage.get(fromNodeName);
		for (int i=0; i<edgeList.size(); i++){
			if (edgeList.get(i).getToNode().getName().equals(toNodeName)){
				System.out.println("Sorry that edge already exists in the graph.");
				return false;
			}
		}
		Edge inputEdge = new Edge(this.edgeIdAssign, this.nodeStorage.get(toNodeName));
		inputEdge.setLabel(name);
		this.edgeStorage.get(fromNodeName).add(inputEdge);
		this.edgeIdAssign++;
		this.edgeSize++;
		return true;
	}
	public boolean deleteNode(String delNodeName){
		//Check to see if the Node is in the graph.
		if (this.nodeStorage.get(delNodeName)==null){
			System.out.println("That node was not found in the graph.");
			return false;
		}
		//Remove all the edges starting at that node.
		this.edgeSize -= this.edgeStorage.get(delNodeName).size();
		this.edgeStorage.remove(delNodeName);
		//Remove all the edges going to that node.
		Iterator<ArrayList<Edge>> edgeLists = this.edgeStorage.values().iterator();
		while (edgeLists.hasNext() == true){
			ArrayList<Edge> checkEdgeList = edgeLists.next();
			for (int i=0; i<checkEdgeList.size(); i++){
				if (checkEdgeList.get(i).getToNode().getName().equals(delNodeName)){
					checkEdgeList.remove(i);
					this.edgeSize--;
				}
			}
		}
		//Remove the node.
		this.nodeStorage.remove(delNodeName);
		this.nodeStoreOrdList.remove(delNodeName);
		this.nodeSize--;
		return true;
	}
	public boolean deleteEdge(String fromNodeName, String toNodeName){
		//Check to see if the fromNodeName and toNodeName exist.
		if (this.nodeStorage.containsKey(fromNodeName) == false){
			System.out.println("Sorry that starting node name was not found in the graph.");
			return false;
		}
		ArrayList<Edge> edgeList = this.edgeStorage.get(fromNodeName);
		int listSize = edgeList.size();
		for (int i=0; i<listSize; i++){
			if (edgeList.get(i).getToNode().getName().equals(toNodeName)){
				edgeList.remove(i);
				System.out.println("Edge was successfully removed!");
				this.edgeSize--;
				return true;
			}
		}
		System.out.println("Sorry the edge between those two nodes was not found.");
		return false;
	}
	public int getNodeSize(){
		return this.nodeSize;
	}
	public int getEdgeSize(){
		return this.edgeSize;
	}
	public void printGraph(){
		for (int i=0; i<this.nodeStoreOrdList.size(); i++){
			this.printNode(this.nodeStoreOrdList.get(i));
		}
	}
	
	public void printNode(String nodeName){
		if (this.nodeStorage.containsKey(nodeName)==false){
			System.out.println("That node was not found in this graph.");
			return;
		}
		System.out.print("("+this.nodeStorage.get(nodeName).getSerialNumber()+")"+this.nodeStorage.get(nodeName).getName());
		ArrayList<Edge> edgeList = this.edgeStorage.get(nodeName);
		for (int i=0; i<edgeList.size(); i++){
			Edge currentEdge = edgeList.get(i);
			System.out.print("\n");
			String printEdge = "  ("+currentEdge.getSerialNumber()+")";
			if (currentEdge.getLabel()!= null){
				printEdge+="("+currentEdge.getLabel()+")";
			}
			printEdge += "---> "+currentEdge.getToNode().getName();
			System.out.print(printEdge);
		}
		System.out.print("\n");
		System.out.println();
	}
}


class Node {
	private int serialNumber;
	private String name;
	
	public Node(int serialNumber, String name){
		this.serialNumber = serialNumber;
		this.name = name;
	}	
	public String getName(){
		return this.name;
	}
	public int getSerialNumber(){
		return this.serialNumber;
	}
}


class Edge {
	private String label = null;
	private int serialNumber;
	private Node toNode;
	
	public Edge(int serialNumber, Node toNode){
		this.serialNumber = serialNumber;
		this.toNode = toNode;
	}
	public void setLabel(String name){
		this.label = name;
	}
	public String getLabel(){
		return this.label;
	}
	
	public int getSerialNumber(){
		return this.serialNumber;
	}
	
	public Node getToNode(){
		return this.toNode;
	}
}

