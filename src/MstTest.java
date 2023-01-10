import graph.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MstTest {

    // all three tests for known weight of given examples
    @Test
    void bsp1() {
        int weightBsp = 37;
        Graph<Vertex, Edge<Vertex>> graph = GraphRead.FileToGraph("bsp_mst_1.txt", false, false, true);
        Prim_MST prims = new Prim_MST(graph);
        Assertions.assertEquals(weightBsp, prims.primsMstWeight());
    }
    @Test
    void bsp2() {
        int weightBsp = 9;
        Graph<Vertex, Edge<Vertex>> graph = GraphRead.FileToGraph("bsp_mst_2.txt", false, false, true);
        Prim_MST prims = new Prim_MST(graph);
        Assertions.assertEquals(weightBsp, prims.primsMstWeight());
    }
    @Test
    void bsp3() {
        int weightBsp = 17;
        Graph<Vertex, Edge<Vertex>> graph = GraphRead.FileToGraph("bsp_mst_3.txt", false, false, true);
        Prim_MST prims = new Prim_MST(graph);
        Assertions.assertEquals(weightBsp, prims.primsMstWeight());
    }

    /*
    the given graph is constructed as a cross witch all knots connected. The weight is
    the highest at the start vertex: a - b weight 4, a - d  weight 5, a - c weight 6,
    b - c weight 2, b - d weight 3, c - d weight 1,
            /b\                                                /b
     Bsp   a-|-d  so there is only one method the mst can be  a | d in the alphabet order
            \c/                                                 c/
    so the test is checking if the algorithm ignores the smaller weights and starts with
    the heavy ones and goes from start to just the neighbours.
    the result should be 0 1 weight 4, 1 2 weight 2, 2 3 weight 1 -> total weight 7
     */
    @Test
    void checkPriorityPrim(){
        int weightBsp = 7;
        Graph<Vertex, Edge<Vertex>> graph = GraphRead.FileToGraph("test_mst.txt", false, false, true);
        Prim_MST prims = new Prim_MST(graph);
        Assertions.assertEquals(weightBsp, prims.primsMstWeight());

        // same code as in class: Prim_Mst.java
        ArrayList<Edge<Vertex>> edgesListSortedTest = new ArrayList<>(graph.getEdges());
        Collections.sort(edgesListSortedTest);
        int totalWeight = 0;
        Collection<Vertex> vertices = graph.getVertices();
        List<Vertex> visited = new LinkedList<>();
        Graph<Vertex, Edge<Vertex>> mst = new Graph<>(true);
        Vertex start = graph.getVertex(0);

        // weight of the edges in correct order
        int test1 = 4;
        int test2 = 2;
        int test3 = 1;
        // method prims algo, but with switch for checking right edges
        int k = 0;
        while (!vertices.isEmpty()) {
            for (int j = 0; j < edgesListSortedTest.size(); j++) {
                Edge<Vertex> e = edgesListSortedTest.get(j);
                if (e.getVertexA().equals(start) || visited.contains(e.getVertexA())
                        && !visited.contains(e.getVertexB()) || !visited.contains(e.getVertexA())
                        && visited.contains(e.getVertexB())) {
                    switch (k) {
                        case 0 -> {
                            Assertions.assertEquals(test1, e.getWeight());
                            k++;
                        }
                        case 1 -> {
                            Assertions.assertEquals(test2, e.getWeight());
                            k++;
                        }
                        case 3 -> Assertions.assertEquals(test3, e.getWeight());
                    }
                    mst.addVertex(e.getVertexA());
                    mst.addVertex(e.getVertexB());
                    mst.addEdge(e);
                    visited.add(e.getVertexA());
                    visited.add(e.getVertexB());
                    totalWeight = totalWeight + e.getWeight();
                    System.out.println(totalWeight);
                    vertices.remove(e.getVertexA());
                    vertices.remove(e.getVertexB());
                    edgesListSortedTest.remove(e);
                    break;
                }
            }
        }
    }
}


