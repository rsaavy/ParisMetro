import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraph<E>{
/*
    //<Vertex , Adjacent Vertices < Vertex, Weight > >
    private ArrayList<Vertex> hGraph;

    public WeightedGraph(){
        hGraph = new HashMap<E,HashMap<E,Integer>>();
    }

    public int numVertices(){
        return hGraph.size();
    }

    public boolean containsVertex(E vertex){
        return hGraph.containsKey(vertex);
    }

    public void insertVertex(E vertex){
        if( containsVertex(vertex) ){
            return;
        }
        hGraph.put(vertex, new HashMap<E,Integer>());
    }

    public void insertEdge(E vertexFrom, E vertexTo, int weight){
        if( !containsVertex(vertexFrom) ){
            insertVertex(vertexFrom);
        }
        if( !containsVertex(vertexTo) ){
            insertVertex(vertexTo);
        }
        HashMap<E,Integer> adjacentVertices = hGraph.get(vertexFrom);
        adjacentVertices.put(vertexTo, weight);
    }
*/

    private class Vertex<E>{
        private E value;
        private String name;
    }

    private class Edge{
        private E vertexFrom;
        private E vertexTo;
        private int weight;

        public Edge(E _vertexFrom, E _vertexTo, int _weight){
            vertexFrom= _vertexFrom;
            vertexTo = _vertexTo;
            weight = _weight;
        }

        public int getWeight(){
            return weight;
        }
    }

    private ArrayList<E> vertices;
    private ArrayList<Edge> edges;

    public WeightedGraph(){
        vertices = new ArrayList<E>();
        edges = new ArrayList<Edge>();
    }

    public int numVertices(){
        return vertices.size();
    }

    public int numEdges(){
        return edges.size();
    }

    public void insertVertex(E vertex){
        if( containsVertex(vertex) ) return;
        vertices.add( vertex );
    }

    public boolean containsVertex(E vertex){
        return vertices.contains(vertex);
    }

    public void insertEdge(E vertexFrom, E vertexTo, int weight){
        insertVertex(vertexFrom);
        insertVertex(vertexTo);
        edges.add( new Edge(vertexFrom, vertexTo, weight) );
    }



}
