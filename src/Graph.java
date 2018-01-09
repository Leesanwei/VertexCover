import java.util.ArrayList;



public class Graph {
	
	private boolean[][] matrice;
	
	/**
	 * Constructor to copy a graph (and not have )
	 * @param g
	 */
	public Graph(Graph g){
		this.matrice = new boolean[g.getSize()][g.getSize()];
		for(int i=0;i<g.getSize();i++){
			
			for(int j=i;j<g.getSize();j++){
			
				if(g.matrice[i][j]){
					this.matrice[j][i] = true;

				}else{
					this.matrice[j][i] = false;
				}
			}
		}
	}
	
	public Graph(int verticesNb){
		
		this.matrice = new boolean[verticesNb][verticesNb];
		
		for(int i=0;i<verticesNb;i++){
			
			for(int j=i;j<verticesNb;j++){
				if(i == j){
					this.matrice[i][j] = false;
				}
				else{
					this.matrice[i][j] = Math.random() >= 0.5;
					this.matrice[j][i] = this.matrice[i][j];

				}
			}
		}
	}
	
	public void display(){
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("********************** Here is our graph *************************");
		System.out.println(" ");
		System.out.println(" ");

		for(int i=0;i<this.matrice.length;i++){
					
			for(int j=0;j<this.matrice.length;j++){
				
				System.out.print(this.matrice[i][j]+"\t");
			}
			
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println(" ");

	}
	
	public int getSize(){
		return this.matrice.length;
	}
	
	public boolean hasEdge(){
		boolean found = false;
		int i = 0;
		int j = 0;
		while(!found && i<this.matrice.length){
			
			while(!found && j<this.matrice.length){
				
				found = this.matrice[i][j];
				j++;
			}
			i++;
			j=0;
		}
		return found;
	}
	
	public void deleteEdgesFromVerticesList(ArrayList<Integer> vertices){
		
		for(int i=0;i<this.getSize();i++){
			
			if(vertices.contains(i)){
				
				for(int j=0;j<this.getSize();j++){
					
					this.matrice[i][j] = false;
					this.matrice[j][i] = false;

				}
			}
			
			
		}
	}
	public boolean[][] getMatrice() {
		
		return this.matrice;
	}
}
