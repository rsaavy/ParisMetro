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
	ArrayList<Integer,String> stations = new ArrayList<Integer,String>;
	ArrayList<Integer,ArrayList<Edge> > distances = new ArrayList<Integer,- List<Edge>>;
			
			


	protected static void read(String fileName) throws Exception, IOException {
		
		BufferedReader graphFile = new BufferedReader(new FileReader(fileName));
		String flag = "$";		
		if((line = graphFile.readLine()) != null){
			throw new IOException("This is an incorrect input for the line: " + line);

		}

		/* This is the first line that we need to read.  */
		String lines =  graphFile.readLine();
		String [] lineSeperator = lines.split(" ");
		int totalVertices = Integer.parseInt(lineSeperator[0]);
		int totalEdges = Integer.parseInt(lineSeperator[1] );


		/* This is the second line we have to read  */

		 for(int i = 1; i< totalVertices &&; i++){
		String lines = graphFile.readLine();
		String [] lineSeperator = lines.split(" ", 2);

		int metroID = Integer.parseInt(lineSeperator[0]);
		String stationName = lineSeperator[1];
		}	
		if( lineSeperator[0] = flag)
		{
			for(int  i = 0;i< totalEdges; i++){
				String lines = graphFile.readLine(); 
				String [] lineSeperator = lines.split(" ", 3);

			}
		}
		}

		

    // while ((line = graphFile.readLine()) != null) {
	// 		String flag = "$";



	// 		if (st.countTokens() != 3 	){
	// 	 	 throw new IOException("This is an incorrect input for the line: " + line);
	// 	 }
	// 		if( st.countTokens() == 2){
	// 			StringTokenizer st = new StringTokenizer(line);
	// 			Integer id = new Integer(st.nextToken());
	// 			String metroName = st.nextToken();
	// 			Vertex<Integer>  metroid = stations.get(id);
	// 			Vertex<String>  nameid  = stations.get(metroName);
	// 			}
	// 		if(flag == st.nextToken()){
	// 			StringTokenizer dt = new StringTokenizer(line);
	// 			Integer startid= new Integer(dt.nextToken());
	// 			Integer endid = new Integer (dt.nextToken());
	// 			Integer distance = new Integer(st.nextToken());
	// 			Vertex<String> distance = vertices.get(startid);
	// 		}
    //   if (metroid == null) {
    //     // Source vertex not in graph -- insert
    //     metroid = sGraph.insertVertex(id);
    //     vertices.put(id, metroid);}
	// 		}



}}}
