import graph.*;


public class Main {
    public static void main(String[] args) {


        Graph<Vertex, Edge<Vertex>> graph = GraphRead.FileToGraph("test_mst.txt", false, false, true);
        Prim_MST prims = new Prim_MST(graph);
        System.out.println(graph);
        System.out.println(prims.primsMstGraph());

    }
}
