package basicGraph;
import java.util.Scanner;

public class TestDriver {
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
