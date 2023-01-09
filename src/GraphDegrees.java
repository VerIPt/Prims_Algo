import java.util.*;
import graph.*;

public class GraphDegrees {
    /**
     * Die Funktion getVertexDegrees bestimmt zu jedem Knoten des übergebenen Graphen den Knotengrad
     * @param g der Graph zu dessen Knoten die Knotengrade bestimmt werden sollen
     * @return eine HashMap, die zu jedem Knoten als Wert den Knotengrad beinhaltet
     */
    public static HashMap<Vertex, Integer> getVertexDegrees(Graph<Vertex,Edge<Vertex>> g) {
        HashMap<Vertex,Integer> degrees = new HashMap<>(g.getNumberVertices()*2);

        Collection<Vertex> vertices = g.getVertices();

        for (Vertex v : vertices) {
            Collection<Vertex> neighbours = g.getNeighbours(v);
            int degree_v = neighbours.size();
            degrees.put(v, degree_v);
        }

        return degrees;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph<Vertex,Edge<Vertex>> mst_graph = GraphRead.FileToGraph("bsp_mst_1.txt",false, false,true);

        HashMap<Vertex, Integer> degrees_mst_graph = getVertexDegrees(mst_graph);

        Collection<Vertex> mst_vertices = mst_graph.getVertices();

        for (Vertex v : mst_vertices) {
            System.out.println("Grad von " + v.getId() + ": " + degrees_mst_graph.get(v));
        }
    }

}
