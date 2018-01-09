import java.util.List;
import java.util.ArrayList;


public class VertexCover {
	
	public static void main(String[] args){
		/**
		 * Génère un graphe aléatoire et cherche le vertex cover
		 */
		Graph g = new Graph(Integer.parseInt(args[0]));
		
		g.display();
		exhaustiveResearch(g);
	}
	
	public static void exhaustiveResearch(Graph g){
		int minCover = g.getSize();
		ArrayList<Integer> verticeCover = new ArrayList<Integer>();
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		for(int i=0;i<g.getSize();i++){
			set.add(i);
		}
		
		ArrayList<ArrayList<Integer>> subsets = getSubsets(set);
		subsets.remove(0);
		for(ArrayList<Integer> subset : subsets){
			
				Graph tempGraph;
				tempGraph = new Graph(g);
				tempGraph.deleteEdgesFromVerticesList(subset);
				if(!tempGraph.hasEdge() && subset.size() < minCover){
					minCover = subset.size();
					verticeCover = subset;
				}
			
		}
		System.out.println("Min Vertex Cover : "+minCover+ " with  : "+ verticeCover.toString());
	}
	public int approximativeResearch(Graph g){
		return 0;
	}
	
	public static ArrayList<ArrayList<Integer>> getSubsets(List<Integer> sortedInts) {
	    int n=sortedInts.size();
	    ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
	    
	    long combinations = 1 << n;
	    for (int setNumber=0; setNumber<combinations; setNumber++) {
	      ArrayList<Integer> aResult = new ArrayList<Integer>();
	      for (int digit=0; digit<n; digit++) {
	        if ((setNumber & (1<<digit)) > 0) {
	          aResult.add(sortedInts.get(digit));
	        }
	      }
	      subsets.add(aResult);
	    }
	    return subsets;
	  }
	
}
