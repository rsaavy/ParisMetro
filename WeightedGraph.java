import java.util.ArrayList;
import java.util.HashMap;


public class WeightedGraph<E>{

    private class Edge{
        private E vertexFrom;
        private E vertextTo;
        private int weight;

        public Edge(E _vertexFrom, E _vertexTo, int weight_){
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
        insert(vertexFrom);
        insert(vertexTo);
        edges.add( new Edge(vertexFrom, vertexTo, weight) );
    }



}
