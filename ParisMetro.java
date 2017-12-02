import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.io.*;


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
	// WeightedGraph<E> parisMetroGraph;



	public static void readMetro(String fileName) throws Exception, IOException {
		read(fileName);
		// parisMetroGraph = new WeightedGraph();
	}

	public static void read(String fileName) throws Exception, IOException {

		BufferedReader reader = new BufferedReader( new InputStreamReader( new FileInputStream(fileName),"UTF-8"));
		String flag = "$";

		ArrayList<String> stationList = new ArrayList<String>();		

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
		int 	totalEdges = Integer.parseInt(lines[1] );
			System.out.println("The total number of Edges " + totalEdges);
			while( line != null ){
				line = reader.readLine();
				lines =line.split(" ",2);
				System.out.println(" ID: " + lines[0] + " Name: " + lines[1]);
			//  instead of just printing every ID, and Name. I want to add it an array list called StationList. 	
			// Eventually i will doo the same with the Station 1 to Station 2 , and the distance(weight) in seconds	
				stationList.add(lines[1]);
				// if( (line=reader.readLine()) == "$")
				// 	lines = line.split(" ",3);
				// 	System.out.println(" ID1: " + lines[0] + " ID2: " + lines[1] + " Weight: " + lines[2] );
				}
		
		
		}catch (NumberFormatException e) {System.out.println("FUCKING PROBLEM");}
		finally {
			reader.close();
		}		
	

			// for(int i; i < totalVertices; i++){
			// 	String line = reader.readLine();
			// 	String [] lines = line.split(" ",2);
			// 	int metroID = Integer.parseInt(lines[0]);
			// 	String stationName = lines[1];
				
			// 	System.out.println(stationName + metroID);
				
			// 	stationList.add(i,metroID);
	
			// }
			// lines = reader.readFile();

			// for( int i; i<totalEdges;i++){
			// 	 insertEdge(vertex1,vertex2,weight);
			// }
	}
	
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
