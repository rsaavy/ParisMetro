import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;
import java.io.File;


public class readMetro{
   
    protected static  void read(String filename) throws Exception, IOException{
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String text = "";
        String line = reader.readLine();
        ArrayList<String> lines = new ArrayList<String>();
        Strinig [] liner = line.split(" ");
        lines.add.(liner);
        try{
            int totalVertices = Integer.parseInt(lines.get(0));
                System.out.println("The Total vertices " + totalVertices);
            int totalEdges = Integer.parseInt(lines.get(1));
                System.out.println("The Total edges " + totalEdges);
        } catch(NumberFormatException e){
            System.out.println("not a number");
             } // catch(IOException e){
        //     System.out.println("I/O exception!");
        // }
       
        
        
        // for(int i = 0; i< totalVertices; i++){
		// 	int metroID = Integer.parseInt(lines[0]);
        //     String stationName = lines[1];
        // }
        // Prints all the lines 
        while ( line != null )
            {
                
                text += line + "\n";
                line = reader.readLine();
            }
             System.out.println(text);
            
             if((line = reader.readLine()) != null){
                throw new IOException("This is an incorrect input for the line: " + line);
    
            }
           

   
            reader.close();
	}    

    public static void main(String [] args) throws Exception{
        read(args[0]);
    }
    }
