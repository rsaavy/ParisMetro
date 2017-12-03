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
	Graph<stations, Integer> parisMetroGraph;

	public ParisGraph(String fileName) throws Exception, IOException {

		read(fileName);
		parisMetroGraph = new Graph(stations,Integer);
	}

	public static void read(String fileName) throws Exception, IOException {


		BufferedReader graphFile = new BufferedReader(new FileReader(fileName));
		String flag = "$";

	ArrayList<String> stations = new ArrayList(String);
	ArrayList<Integer,Integer> distances = new ArrayList(Integer,Integer);

		if((line = graphFile.readLine()) != null){
			throw new IOException("This is an incorrect input for the line: " + line);

		}

		/* This is the first line that we need to read.  */
		String line =  graphFile.readLine();
		String [] lines = line.split(" ");
		int totalVertices = Integer.parseInt(lines[0]);
		int totalEdges = Integer.parseInt(lines[1] );


		/* This is the second line we have to read  */

		 for(int i = 1; i< totalVertices; i++){
			int metroID = Integer.parseInt(lines[0]);
			String stationName = lines[1];

			stations.add(i,stationName);
		}
		line = graphFile.readLine();
		if( lineSeperator[0] = flag)
		{
			for(int  i = 0;i< totalEdges; i++){
				String line = graphFile.readLine();
				String [] lineSeperator = line.split(" ");

				int metroid1 = lines[0];

				int metroid = lines[1];
				int distance = lines[2];

			}
		}
		}



}}}
}
