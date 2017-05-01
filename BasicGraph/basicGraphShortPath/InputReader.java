package basicGraphShortPath;
import java.io.*;
import java.util.Scanner;

public class InputReader {
	public static void main(String[] args){

        // The name of the file to open.
        String fileName = "p3graphData.txt"; // this is default path, meaning it will look
                                             // for the file in the "current" directory...
                                             // meaning whatever directory/folder the java
                                             // program is run in

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            BasicGraph testGraph = new BasicGraph(); 
            while((line = bufferedReader.readLine()) != null) {
                Scanner inputScanner = new Scanner(line);
                String firstNodeName = inputScanner.next();
                if (firstNodeName.equals("-1")){
                	System.out.println("#########################################");
                	testGraph.printGraph();
                	String sourceLine = bufferedReader.readLine();
                	Scanner sourceLineScanner = new Scanner(sourceLine);
                	String sourceNodeName = sourceLineScanner.next();
                	System.out.println("Shortest Paths from source node (" +testGraph.getNode(sourceNodeName).getSerialNumber()+") "+ sourceNodeName + " to: \n");
                	testGraph.shortestPath(sourceNodeName);
                	testGraph = new BasicGraph();
                	bufferedReader.readLine();
                	continue;
                }
                String secondNodeName = inputScanner.next();
                int edgeWeight = inputScanner.nextInt();
                testGraph.addNode(firstNodeName);
                testGraph.addNode(secondNodeName);
                testGraph.addEdge(null, firstNodeName, secondNodeName, edgeWeight);              
            }   
            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
    }
}
