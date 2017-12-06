	import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.HashMap;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;
import net.datastructures.HeapPriorityQueue;
import net.datastructures.AdjacencyMapGraph;

public class ParisMetro{
    public AdjacencyMapGraph<Integer,Integer> metroGraph;
    public ArrayList<String> allStations;
    public HashMap<Integer, Boolean> sameStations;

    public ParisMetro(){
        metroGraph = new AdjacencyMapGraph<Integer,Integer>(true);
        allStations = new ArrayList<String>();
        sameStations = new HashMap<Integer, Boolean>();
    }

    public static AdjacencyMapGraph readMetro(String fileName, ArrayList<String> stations) throws IOException{
        AdjacencyMapGraph<Integer,Integer> wGraph = new AdjacencyMapGraph<Integer,Integer>(true);
        HashMap<Integer, Vertex> hVertices = new HashMap<>();
        BufferedReader bufferedRead = new BufferedReader(new FileReader(fileName));
        String line;
        String[] data;

        bufferedRead.readLine();
        line = bufferedRead.readLine().trim();
        while( !line.startsWith("$") ) {
            data = line.split(" ", 2);
            int stationID = Integer.parseInt(data[0]);
            stations.add( stationID, data[1] );
            Vertex<Integer> newStation = wGraph.insertVertex( stationID );
            hVertices.put( stationID, newStation );
            line = bufferedRead.readLine().trim();
        }

        line = bufferedRead.readLine();
        while( line != null ) {
            data = line.split(" ", 3);
            Vertex<Integer> vertexFrom = hVertices.get( Integer.parseInt(data[0]) );
            Vertex<Integer> vertexTo = hVertices.get( Integer.parseInt(data[1]) );
            int weight = Integer.parseInt(data[2]);
            wGraph.insertEdge( vertexFrom, vertexTo, weight);
            line = bufferedRead.readLine();
        }
        bufferedRead.close();

        return wGraph;
    }

    public void sameLine( int stationID ) throws Exception{
        Vertex<Integer> startStation = getVertex( stationID );
        stationsOnSameLine( startStation );
    }

    private void stationsOnSameLine( Vertex<Integer> station ) {

        if( station == null || sameStations.containsKey( station.getElement() ) ){
            return;
        }

        sameStations.put( station.getElement() , true);

        Iterator<Edge<Integer>> it = metroGraph.outgoingEdges( station ).iterator();
        Vertex<Integer> visitStation;
        Edge<Integer> line;

        while( it.hasNext() ) {
            line = it.next();
            visitStation = metroGraph.opposite( station, line );
            
            if( line.getElement() != -1 ){                
                stationsOnSameLine( visitStation );
            }
        }

        return;
    }

/*

  private void sameLine(Graph<String,String> graph, Vertex<String> v ) {
    
        if(v == null || visited.containsKey(v.getElement())) return;
    
        visited.put(v.getElement(), true);
        startVisit(v);
    
        Iterator<Edge<String>> edges = graph.outgoingEdges(v).iterator();
        Vertex<String> opposite;
    
        while(edges.hasNext()) {
            opposite = graph.opposite(v, edges.next());
            DFS(graph, opposite);
        }
    
        finishVisit(v);
    
        return;
}*/

    // From Lab net library
	protected Vertex<Integer> getVertex(int vert) throws Exception {
		// Go through vertex list to find vertex -- why is this not a map
		for (Vertex<Integer> vs : metroGraph.vertices()) {
			if (vs.getElement().equals(vert)) {
				return vs;
			}
        }
		throw new Exception("Vertex not in graph: " + vert);
	}


    public static void main(String[] args){
        ParisMetro metro = new ParisMetro();
        try{
            metro.metroGraph = ParisMetro.readMetro("metro.txt", metro.allStations);
            metro.sameLine(Integer.parseInt(args[0]));
            for(int i = 0 ; i < 375; i++){
                if( metro.sameStations.containsKey(i)){
                    System.out.println(metro.allStations.get(i));
                }
            }
            
        }
        catch(IOException e){
            System.out.println("IOException e");
        }
        catch(Exception e){
            System.out.println("EXCEPTION");
        }
        
        //ArrayList<Vertex> sameStations = metro.stationsOnSameLine( 200 );
     
/*
        Iterator it = metro.allStations.iterator();
        while(it.hasNext()){
            System.out.println( (String) it.next() );
        }*/
        
    }
}
