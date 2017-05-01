package basicGraphShortPath;
import java.util.Comparator;

public class ShortPathComparator implements Comparator<Node>{
	public int compare(Node a, Node b){
		if (a.getPathValue() > b.getPathValue()){
			return 1;
		}
		else if (a.getPathValue() < b.getPathValue()){
			return -1;
		}
		else{
			return 0;
		}
	}
}
