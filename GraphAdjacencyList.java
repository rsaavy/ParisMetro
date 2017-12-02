
import java.util.*;


public class GraphAdjacencyList {


	private Map<Integer,ArrayList<Integer>> parisMap;

	public GraphAdjacencyList(int vertices){
		parisMap = new HashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<=vertices;i++){
			ArrayList<Integer> neighbours = new ArrayList<Integer>();
			parisMap.put(i, neighbours);
		}
	}
	public void addEdge(int v, int w){
		if(v > parisMap.size() || w > parisMap.size()){
			return;
		}
		(parisMap.get(v)).add(w);
		(parisMap.get(w)).add(v);
	}
	public ArrayList<Integer> getNeighbours(int v){ 
		if(v>parisMap.size()){
			return null;
		}
		return new ArrayList<Integer>(parisMap.get(v));
	}



	public static void readMetro(String fileName) throws Exception, IOException {
		read(fileName);

	}

	public static void read(String fileName) throws Exception, IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream(fileName),"UTF-8"));
		
		try {
			
			String line =  reader.readLine();
			String [] lines = line.split(" ");
			int totalVertices = Integer.parseInt(lines[0]);
				System.out.println("The total number of Vertices " + totalVertices);
			int totalEdges = Integer.parseInt(lines[1]);
				System.out.println("The total number of Edges " + totalEdges);
			
			line = reader.readLine();
			lines = line.split(" ",2);


			while( !line.equals("$") ){
				System.out.println(" ID: " + lines[0] + " Name: " + lines[1]);
				line = reader.readLine();
				lines =line.split(" ",2);
				verticeList.add(lines[1]);
				while(count <= number_edges){
			source = scan.nextInt();
			dest = scan.nextInt();
			adjacencyList.addEdge(source, dest);
			count++;
		}
			}
			
			line = reader.readLine();

			


			while(line != null) {
				lines = line.split(" ",3);
			 	System.out.println(" ID1: " + lines[0] + " ID2: " + lines[1] + " Weight: " + lines[2] );
			 	line = reader.readLine();
			}
		
		} catch (NumberFormatException e) {System.out.println("FUCKING PROBLEM");}
		finally {
			reader.close();
		}











	public static void main(String args[]){
		readMetro("metro.txt");
		int count = 1, source, dest;
	
		int number_vertices = totalVertices;
		int number_edges = totalEdges;
		GraphAdjacencyList adjacencyList = new GraphAdjacencyList(number_vertices);
	
	 	System.out.println("Enter edges in format <source> <destination>");
	
		
		System.out.println("The given adjacency List for the graph\n");
		for(int i=1;i<=number_vertices;i++){
			System.out.print(i + "->");
			ArrayList<Integer> edgeList = adjacencyList.getNeighbours(i);
			for(int j=1;;j++){
				if(j!=edgeList.size()){
					System.out.print(edgeList.get(j-1)+" -> ");
				}
				else{
					System.out.print(edgeList.get(j-1));
					break;
				}
			}
			System.out.println();
		}
		
	}
}

