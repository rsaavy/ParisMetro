import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.FileReader;

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
	// Graph<stations, Integer> parisMetroGraph;



	public static void readMetro(String fileName) throws Exception, IOException {
		read(fileName);
		// parisMetroGraph = new Graph(stationList,Integer);
	}

	public static void read(String fileName) throws Exception, IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream(fileName),"UTF-8"));
		String flag = "$";

		// ArrayList<String> stationList = new ArrayList(String);		

		// ArrayList<stationList,Integer> distances = new ArrayList(Integer,Integer);

		// if((line = graphFile.readLine()) != null){
		// 	throw new IOException("This is an incorrect input for the line: " + line);

		// }

		/* This is the first line that we need to read.  */
		try{
		String line =  reader.readLine();
		String [] lines = line.split(" ");
		int totalVertices = Integer.parseInt(lines[0]);
		System.out.println("The total number of Vertices " + totalVertices);
		int totalEdges = Integer.parseInt(lines[1] );
			System.out.println("The total number of Edges " + totalEdges);
	} catch (NumberFormatException e) {
			System.out.println("FUCKING PROBLEM");
		}
	}
		/* This is the second line we have to read  */

		//  for(int i = 0; i< totalVertices; i++){
		// 	int metroID = Integer.parseInt(lines[0]);
		// 	String stationName = lines[1];

		// 	stationList.add(i,stationName);

		// }
		// line = graphFile.readLine();

		// 	for(int  i = 0;i< totalEdges; i++){

		// 		String Edges = graphFile.readLine();
		// 		String [] listofEdgesStrings = line.split(" ");

		// 		int metroid1 = lines[0];

		// 		int metroid = lines[1];
		// 		int distance = lines[2];

		// 	}
		// }


		public static void main(String[] args) throws Exception,IOException {
			readMetro("metro.txt");

		}

}
