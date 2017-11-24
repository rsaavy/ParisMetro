import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import net.datastructures.AdjacencyMapGraph;
//import net.datastructures.Dijkstra;
import net.datastructures.Edge;
import net.datastructures.Graph;
import net.datastructures.GraphAlgorithms;
import net.datastructures.Map;
import net.datastructures.Vertex;
import net.datastructures.Entry;
import net.datastructures.ArrayList;



import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;

public class ParisMetro {
	Graph<String, Integer> parisMetroGraph;
	AdjacencyMapGraph parisMetroGraph = new AdjacencyMapGraph<ArrayList<ArrayList<Edge>>>(false);

	Object DISTANCE = new Object();




	/**
	 * Create a WeightGraph from file
	 * Modified by Thais Bardini on November 19th, 2017 (tbard069@uottawa.ca)
	 */
	 /*
	public ParisGraph(String fileName) throws Exception, IOException {
	}
*/
	/**
	 * Read a list of vertex from file
	 *
	 */
	protected void read(String fileName) throws Exception, IOException {
		BufferedReader graphFile = new BufferedReader(new FileReader(fileName));

    Hashtable<String, Vertex> vertices = new Hashtable<String, Vertex>();

    // Read the edges and insert
    String line;

    while ((line = graphFile.readLine()) != null) {
			String flag = "$";

			StringTokenizer st = new StringTokenizer(line);

			if (st.countTokens() != 3){
		 	 throw new IOException("This is an incorrect input for the line: " + line);
		 }
			if( st.countTokens() == 2){
				StringTokenizer st = new StringTokenizer(line);
				Integer id = new Integer(st.nextToken());
				String metroName = st.nextToken();
				Vertex<Integer>  metroid = vertices.get(id);
				Vertex<String>  nameid  = vertices.get(metroName);
				}
			if(flag == st.nextToken()){
				StringTokenizer dt = new StringTokenizer(line);
				Integer startid= new Integer(dt.nextToken());
				Integer endid = new Integer (dt.nextToken());
				Integer distance = new Integer(st.nextToken());
				Vertex<String> distance = vertices.get(startid);
			}
      if (metroid == null) {
        // Source vertex not in graph -- insert
        metroid = sGraph.insertVertex(id);
        vertices.put(id, metroid);}
			}
}
}
