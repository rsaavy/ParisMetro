
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.HashMap;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;
import net.datastructures.Edge;
import net.datastructures.HeapPriorityQueue;
import net.datastructures.AdjacencyMapGraph;
import net.datastructures.AdaptablePriorityQueue;
import net.datastructures.HeapAdaptablePriorityQueue;
import net.datastructures.Entry;


public class ParisMetro{
    public static AdjacencyMapGraph<Integer,Integer> metroGraph = new AdjacencyMapGraph<Integer,Integer>(true);
    public static HashMap<Integer, String> allStations = new HashMap<Integer, String>();
    public static HashMap<Integer, Vertex<Integer>> allVertices = new HashMap<Integer, Vertex<Integer>>();
    public static HashMap<Integer, Boolean> brokenStations = new HashMap<Integer, Boolean>();
    private static final int walkingTime = 90;

    public ParisMetro(){
    }

    public static void readMetro(String fileName) throws IOException{
        BufferedReader bufferedRead = new BufferedReader(new FileReader(fileName));
        String line;
        String[] data;

        bufferedRead.readLine();
        line = bufferedRead.readLine().trim();
        while( !line.startsWith("$") ) {
            data = line.split(" ", 2);
            int stationID = Integer.parseInt(data[0]);
            Vertex<Integer> newStation = metroGraph.insertVertex( stationID );
            allStations.put( stationID, data[1] );
            allVertices.put( stationID, newStation );
            line = bufferedRead.readLine().trim();
        }

        line = bufferedRead.readLine();
        while( line != null ) {
            data = line.split(" ", 3);
            Vertex<Integer> vertexFrom = allVertices.get( Integer.parseInt(data[0]) );
            Vertex<Integer> vertexTo = allVertices.get( Integer.parseInt(data[1]) );
            int weight = Integer.parseInt(data[2]);
            metroGraph.insertEdge( vertexFrom, vertexTo, weight);
            line = bufferedRead.readLine();
        }
        bufferedRead.close();
    }

    public static void setBrokenLine( int stationID ){
        brokenStations = sameLine( stationID );
    }

    public static HashMap<Integer, Boolean> sameLine( int stationID ){
        Vertex<Integer> startStation = getVertex( stationID );
        HashMap<Integer, Boolean> sameLineMap = new HashMap<>();
        stationsOnSameLine( sameLineMap, startStation );
        return sameLineMap;
    }

    // Copied the DFS code From my completed lab and modified it for this assignment
    private static void stationsOnSameLine( HashMap<Integer, Boolean> sameLineMap, Vertex<Integer> station ) {

        if( station == null || sameLineMap.containsKey( station.getElement() ) ){
            return;
        }
        sameLineMap.put( station.getElement() , true);

        Iterator<Edge<Integer>> it = metroGraph.outgoingEdges( station ).iterator();
        Vertex<Integer> visitStation;
        Edge<Integer> line;

        while( it.hasNext() ) {
            line = it.next();
            visitStation = metroGraph.opposite( station, line );
            
            if( line.getElement() != -1 ){                
                stationsOnSameLine( sameLineMap, visitStation );
            }
        }
        return;
    }

	private static Vertex<Integer> getVertex(int vert) {
		return allVertices.get( vert );
    }
    
    public static void shortestPath( int stationFrom, int stationTo ) {
        ArrayList<Integer> stationsPath = new ArrayList<>();
        HashMap<Vertex<Integer>, Integer> stationWeights = new HashMap<>();
        HashMap<Integer, Integer> shortestPathsMap;
        Vertex<Integer> start = getVertex(stationFrom);
        Vertex<Integer> end = getVertex(stationTo);
        if( start == null || end == null ){
            System.out.println("Station does not exist");
        }
        try{
            shortestPathsMap = shortestPathAlg(stationWeights, start, end);
            Integer stationID = stationTo;
            stationsPath.add(0, stationID);
            while( (stationID = shortestPathsMap.get(stationID)) != null ) {
                stationsPath.add(0, stationID);
            }
            System.out.println( stationWeights.get( getVertex(stationTo) ) );
            printStations( stationsPath );
        }
        catch(IllegalArgumentException E){
            System.out.println("ILLEGAL ARGUMENT EXCEPTION");
        }
    }

    //This method is sponsored by GraphAlgorithms.java Lab 10
    private static HashMap<Integer,Integer> shortestPathAlg( 
                    HashMap<Vertex<Integer>, Integer> stationWeights, Vertex<Integer> start, Vertex<Integer> end) {
        //Taken from GraphAlgorithms class, this priority queue compares using natural ordering of keys
        // in this case the keys are an integer value of the current distance to the station
        AdaptablePriorityQueue<Integer, Vertex<Integer>> stationsToVisit = new HeapAdaptablePriorityQueue<>();

        //Entries hashmap used for replacing keys in the Priority queue
        HashMap<Vertex<Integer>, Entry<Integer,Vertex<Integer>>> stationEntries = new HashMap<>();

        //Stations already visited
        HashMap<Vertex<Integer>, Boolean> cloud = new HashMap<>();

        //Stores a vertex as a key and the value is the parent of the vertex as would be represented in a tree
        HashMap<Integer, Integer> shortestPathsMap = new HashMap<>();

        //Add all stations/vertices to the priority queue with weight 0 for starting station and infinity/integer
        //max value for all other stations
        Iterator<Vertex<Integer>> it = metroGraph.vertices().iterator();
        Vertex<Integer> currVertex;
        while(it.hasNext()) {
            currVertex = it.next();
            if( currVertex == start ) {
                stationEntries.put(currVertex, stationsToVisit.insert(0, currVertex));
                stationWeights.put(currVertex, 0);
                shortestPathsMap.put(currVertex.getElement(), null);
            }
            else{
                stationEntries.put(currVertex, stationsToVisit.insert(Integer.MAX_VALUE, currVertex));
                stationWeights.put(currVertex, Integer.MAX_VALUE);
            }
        }

        Entry<Integer,Vertex<Integer>> currStation;
        Vertex<Integer> oppositeStation;
        Edge<Integer> line;
        int currWeight;
        while( !stationsToVisit.isEmpty() ){
            currStation = stationsToVisit.removeMin();
            currVertex = currStation.getValue();
            currWeight = currStation.getKey();
            cloud.put( currVertex, true );
            Iterator<Edge<Integer>> edges = metroGraph.outgoingEdges( currVertex ).iterator();

            while( edges.hasNext() ){
                line = edges.next();
                oppositeStation = metroGraph.opposite(currVertex, line);
                if( !cloud.containsKey(oppositeStation) &&
                     !brokenStations.containsKey( oppositeStation.getElement() ) ) {

                    //Edge relaxation on each visitable station 
                    int newWeight;
                    if( line.getElement() == -1 ){ // replace -1 with walking time
                        newWeight = currWeight + walkingTime;
                    }
                    else{
                        newWeight = currWeight + line.getElement();
                    }
                    if( newWeight < stationWeights.get( oppositeStation ) ){  // better path found
                        stationWeights.replace(oppositeStation, newWeight );
                        stationsToVisit.replaceKey( stationEntries.get(oppositeStation), newWeight );
                        if( shortestPathsMap.containsKey(oppositeStation.getElement()) ){
                            shortestPathsMap.replace(oppositeStation.getElement(), currVertex.getElement());
                        }
                        else{
                            shortestPathsMap.put(oppositeStation.getElement(), currVertex.getElement());
                        }
                    }
                }
            }
            stationEntries.remove(currVertex);
        }
        return shortestPathsMap;
    }
    

    public static void printStations( ArrayList<Integer> stations ) {
        Iterator<Integer> it = stations.iterator();
        while( it.hasNext() ) {
            System.out.print( it.next() + " " );
        }
    }
    
    public static void main(String[] args){ 
        try{
            ParisMetro.readMetro("metro.txt");
            System.out.println("Input: ");
            if( args.length == 1 ) {
                int stationID = Integer.parseInt( args[0] );
                System.out.println("N1 = " + stationID);
                System.out.println("Output:");
                ArrayList<Integer> sameLine = new ArrayList<Integer>( ParisMetro.sameLine( stationID ).keySet() );
                printStations( sameLine );
            }
            else if( args.length == 2 ) {
                int stationFrom = Integer.parseInt( args[0] );
                int stationTo = Integer.parseInt( args[1] );
                System.out.println("N1 = " + stationFrom + "N2 = " + stationTo);
                ParisMetro.shortestPath( stationFrom, stationTo );
            }
            else if( args.length == 3 ) {                
                int stationFrom = Integer.parseInt( args[0] );
                int stationTo = Integer.parseInt( args[1] );
                int stationBroken = Integer.parseInt( args[2] );
                System.out.println("N1 = " + stationFrom + "N2 = " + stationTo + "N3 = " + stationBroken);
                ParisMetro.setBrokenLine( stationBroken );
                ParisMetro.shortestPath( stationFrom, stationTo );
            }
        }
        catch(IOException e){
            System.out.println("IOException e");
        }
        catch(Exception e){
            System.out.println("EXCEPTION");
        }
                        
    }
}
