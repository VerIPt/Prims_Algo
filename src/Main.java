import graph.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        Graph<Vertex, Edge<Vertex>> graph = GraphRead.FileToGraph("bsp_mst_2.txt", false, false, true);
        System.out.println("G_mst:\n" + graph);
        Prim_MST prims = new Prim_MST(graph);
        System.out.println(prims.primsMstGraph());
        System.out.println(prims.primsMstWeight());
    }
}

        /*
        Collection<Edge<Vertex>> edges = graph.getEdges();
        System.out.println(edges);
        Collection<Vertex> vertices = graph.getVertices();
        List<Vertex> visited = new LinkedList<>();
        Graph<Vertex, Edge<Vertex>> mst = new Graph<Vertex, Edge<Vertex>>(true);
        int totalWeight = 0;
        int i = 0;
        ArrayList<Edge<Vertex>> edgesListSorted = new ArrayList<>(edges);
        Collections.sort(edgesListSorted);
        Vertex[] verticesArrayAll = new Vertex[graph.getNumberVertices()];
        // eventuell funktion mit durchlauf für Startknoten suche, falls nicht sortiert?
        for (Vertex vertex : vertices) {
            verticesArrayAll[i] = vertex;
            i++;
        }
        Vertex start = verticesArrayAll[0];
        System.out.println(start);
        while (!vertices.isEmpty()) {
            for (int j = 0; j < edgesListSorted.size(); j++) {
                Edge<Vertex> e = edgesListSorted.get(j);
                if (e.getVertexA().equals(start) || visited.contains(e.getVertexA()) && !visited.contains(e.getVertexB()) || !visited.contains(e.getVertexA()) && visited.contains(e.getVertexB())) {
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


        //System.out.println(edge + " " + edge.getVertexA() + " " + edge.getVertexB());
        //edgePriorityQueue.addAll(edges);
        // Start
/*
        for (Edge<Vertex> e : edgeees) {
            if (e.getVertexA().equals(start) || visited.contains(e.getVertexA()) && !visited.contains(e.getVertexB()) || !visited.contains(e.getVertexA()) && visited.contains(e.getVertexB())) {
                mst.addVertex(e.getVertexA());
                mst.addVertex(e.getVertexB());
                mst.addEdge(e);
                visited.add(e.getVertexA());
                visited.add(e.getVertexB());
                totalWeight = totalWeight + e.getWeight();
            }
            //System.out.println(edgePriorityQueue);


 */



        /*
        for (Edge<Vertex> edge : edgePriorityQueue) {

            if (visited.contains(edge.getVertexA()) && !visited.contains(edge.getVertexB())){
                mst.addVertex(edge.getVertexA());
                mst.addVertex(edge.getVertexB());
                mst.addEdge(edge);
                visited.add(edge.getVertexA());
                visited.add(edge.getVertexB());
                totalWeight = totalWeight + edge.getWeight();
                System.out.println(visited);
            }
        }

         */


/*

        System.out.println("sorted: " + edgePriorityQueue);
        System.out.println("vertices: " + vertices);
        int i = 0;
        for (Vertex vertex : vertices) {
            verticesArray[i] = vertex;
            System.out.println("vertex: " + vertex + ", with id: " + vertex.getId());
            //verticesPriorityQueue.add(vertex);
            System.out.println("stelle " + i + " vertex" + verticesArray[i]);
            i++;
        }


        System.out.println("nachbarn von start : " + graph.getNeighbours(start));

        PriorityQueue<Edge<Vertex>> neighboursWeight1 = new PriorityQueue<>();
        HashMap<Edge<Vertex>, Vertex> WminPred;
        Collection<Edge<Vertex>> e = graph.getIncidentEdges(start);
        for (Edge<Vertex> vertexEdge : e) {
            neighboursWeight1.add(vertexEdge);
            System.out.println("ergebnis" + neighboursWeight1);
        }

        System.out.println("außerhalb der schleife" + neighboursWeight1);
    }
}




        /*
        for (Vertex v : vertices){
            PriorityQueue<Edge<Vertex>> neighboursWeight = new PriorityQueue<>();
            Collection<Edge<Vertex>> e = graph.getIncidentEdges(v);
            Iterator<Edge<Vertex>> iterator = e.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                //neighboursWeight.add(iterator.next());
                System.out.println("this is it: " +neighboursWeight);
            }
        }
        System.out.println();
        System.out.println(verticesPriorityQueue);
/*
        for (int j = 0; j < graph.getNumberVertices(); j++) {
            v1 = graph.getVertex(j);

            for (Edge<Vertex> e : graph.getIncidentEdges(v1)) {
                System.out.println(e + " ist inzident zu " + v1);
            }
        }
    }
}

 */
