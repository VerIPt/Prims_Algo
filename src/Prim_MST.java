/**
 * @autor Maushart(939781)
 */

import graph.*;
import java.util.*;

public class Prim_MST extends Graph<Vertex, Edge<Vertex>>{
    private Graph<Vertex, Edge<Vertex>> graph;
    private Collection<Edge<Vertex>> edges;
    private Collection<Vertex> vertices;
    private List<Vertex> visited = new LinkedList<>();
    private Graph<Vertex, Edge<Vertex>> mst = new Graph<>(true);
    private int totalWeight = 0;

    // Constructor
    public Prim_MST(Graph<Vertex, Edge<Vertex>> graph) {
        super(true);
        this.graph = graph;
        this.edges = graph.getEdges();
        this.vertices = graph.getVertices();
    }

    private void primsMst(){
        // creates sorted linked-list with weight of given edges
        ArrayList<Edge<Vertex>> edgesListSorted = new ArrayList<>(edges);
        Collections.sort(edgesListSorted);

        // saves and declares start vertex with search for vertex with the smallest ID
        int i = 0;
        for (Vertex vertex : vertices) {
            i = vertex.getId();
            break;
        }
        Vertex start = graph.getVertex(i);
        /*
         * Iterating through sorted Linked list with all edges of the Graph, checks the first vertex
         * and saves its edge to his neighbour with the minimal weight to the new graph "mst". After
         * this the vertices are saved in a list of all visited vertices(to not get doubled) "visited"
         * and removed from the given vertices of the graph "vertices". At least the edge is getting
         * removed from sorted list "edgesListSorted" and breaks the loop to iterate again through the
         * whole list to check for edges that are in the list before the last saved edge as long as all
         * vertices have been proceeded during the while loop
         */
        while (!vertices.isEmpty()) {
            for (int j = 0; j < edgesListSorted.size(); j++) {
                Edge<Vertex> e = edgesListSorted.get(j);
                if (e.getVertexA().equals(start) || visited.contains(e.getVertexA())
                        && !visited.contains(e.getVertexB()) || !visited.contains(e.getVertexA())
                        && visited.contains(e.getVertexB())) {
                    mst.addVertex(e.getVertexA());
                    mst.addVertex(e.getVertexB());
                    mst.addEdge(e);
                    visited.add(e.getVertexA());
                    visited.add(e.getVertexB());
                    totalWeight = totalWeight + e.getWeight();
                    vertices.remove(e.getVertexA());
                    vertices.remove(e.getVertexB());
                    edgesListSorted.remove(e);
                    break;
                }
            }
        }
    }

    /**
     * Method for getting total weight of the mst
     * @return Integer with total weight
     */
    public Integer primsMstWeight(){
        primsMst();
        return totalWeight;
    }

    /**
     * Method for getting graph of the mst
     * @return Graph of mst
     */
    public Graph<Vertex, Edge<Vertex>> primsMstGraph() {
        primsMst();
        return mst;
    }
}
