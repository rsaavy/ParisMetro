import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;
import net.datastructures.HeapPriorityQueue;
import net.datastructures.AdjacencyMapGraph;

public class ParisMetro{
    private Graph<Integer,Integer> metroGraph;
    private ArrayList<String> allStations;

    public void test(){
        metroGraph = new AdjacencyMapGraph<Integer,Integer>(true);
    }

    public ParisMetro(String fileName){
        metroGraph = new AdjacencyMapGraph<Integer,Integer>(true);
        allStations = new ArrayList<String>();
    }

    public static Graph readMetro(String fileName, ArrayList<String> stations) throws IOException{
        AdjacencyMapGraph<Integer,Integer> wGraph = new AdjacencyMapGraph<Integer,Integer>(true);
        Hashtable<Integer, Vertex> vertices = new Hashtable<Integer, Vertex>();
        BufferedReader bufferedRead = new BufferedReader(new FileReader(fileName));
        String line;
        String[] data;

        bufferedRead.readLine();
        line = bufferedRead.readLine().trim();
        while( !line.startsWith("$") ) {
            data = line.split(" ", 2);
            int stationID = Integer.parseInt(data[0]);
            stations.add( stationID, data[1] );
            vertices.put( stationID, wGraph.insertVertex( stationID ) );
            line = bufferedRead.readLine().trim();
        }

        line = bufferedRead.readLine();
        while( line != null ) {
            data = line.split(" ", 3);
            Vertex<Integer> vertexFrom = vertices.get( Integer.parseInt(data[0]) );
            Vertex<Integer> vertexTo = vertices.get( Integer.parseInt(data[1]) );
            int weight = Integer.parseInt(data[2]);
            wGraph.insertEdge( vertexFrom, vertexTo, weight);
            line = bufferedRead.readLine();
        }
        bufferedRead.close();

        return wGraph;
    }

    public static void main(String[] args){
        ParisMetro metro = new ParisMetro("metro.txt");
        //metro.test();
        try{
            readMetro("metro.txt", metro.allStations);
        }
        catch(IOException e){
            System.out.println("IOEXCEPTION");
        }
        catch(Exception e){
            System.out.println("EXCEPTION");
        }
    }
}
