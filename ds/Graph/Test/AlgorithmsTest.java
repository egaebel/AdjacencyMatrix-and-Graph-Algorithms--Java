package ds.Graph.Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import ds.Graph.Graph;
import ds.GraphAlgorithms.Algorithms;
import ds.TheAdjacencyMatrix.AdjacencyMatrix;
import ds.TheAdjacencyMatrix.IntEdge;


public class AlgorithmsTest {

    @Test
    public void primsTest() {
        
        System.out.println("PRIMS TEST");
        AdjacencyMatrix<String, IntEdge> g = new AdjacencyMatrix<String, IntEdge>();
        
        g.addVertex("magician");
        g.addVertex("stuck");
        g.addVertex("buck");
        g.addVertex("muck");
        g.addVertex("struck");
        g.addVertex("block");
        
        System.out.println(g.printEdges());
        System.out.println("Randomizing edges");
        g.makeGraphRandom();
        System.out.println(g.printEdges());
        System.out.println("Randomized!");
        
        Algorithms<String, IntEdge> a = new Algorithms<String, IntEdge>();
        
        Graph<String> t = a.primMinSpanTree(g);
        System.out.println(t.printEdges());
    }
    
    @Test
    public void dfsTest() {

        System.out.println("DFS TEST");
        Graph<String> g = new AdjacencyMatrix<String, IntEdge>();
        
        g.addVertex("magician");
        g.addVertex("stuck");
        g.addVertex("buck");
        g.addVertex("muck");
        g.addVertex("struck");
        g.addVertex("block");
        
        g.addEdge("magician", "stuck");
        g.addEdge("stuck", "struck");
        g.addEdge("struck", "buck");
        g.addEdge("buck", "muck");
        g.addEdge("muck", "block");
        
        g.addEdge("buck", "stuck");
        g.addEdge("struck", "magician");
        g.addEdge("block", "buck");
        g.addEdge("buck", "magician");
        
        Algorithms<String, IntEdge> a = new Algorithms<String, IntEdge>();
        
        List<String> list = a.dfs(g, "magician", "block");
        
        System.out.println(list.toString());
    }
    
    @Test 
    public void bfsTest() {
        
        System.out.println("BFS TEST");
        Graph<String> g = new AdjacencyMatrix<String, IntEdge>();
        
        g.addVertex("magician");
        g.addVertex("stuck");
        g.addVertex("buck");
        g.addVertex("muck");
        g.addVertex("struck");
        g.addVertex("block");
        
        g.addEdge("magician", "stuck");
        g.addEdge("stuck", "struck");
        g.addEdge("struck", "buck");
        g.addEdge("buck", "muck");
        g.addEdge("muck", "block");
        
        g.addEdge("buck", "stuck");
        g.addEdge("struck", "magician");
        g.addEdge("block", "buck");
        g.addEdge("buck", "magician");
        
        Algorithms<String, IntEdge> a = new Algorithms<String, IntEdge>();
        
        List<String> list = a.bfs(g, "magician", "block");
        
        System.out.println(list.toString());
    }
    
    @Test
    public void topoSortTest() {
        
        System.out.println("TOPO SORT TEST!");
        Graph<String> g = new AdjacencyMatrix<String, IntEdge>(true);
        
        g.addVertex("magician");
        g.addVertex("stuck");
        g.addVertex("buck");
        g.addVertex("muck");
        g.addVertex("struck");
        g.addVertex("block");
        
        g.addEdge("magician", "stuck");
        g.addEdge("stuck", "struck");
        g.addEdge("struck", "buck");
        g.addEdge("buck", "muck");
        g.addEdge("muck", "block");
        
        
        //g.addEdge("struck", "magician");
        //g.addEdge("buck", "magician");
        
        Algorithms<String, IntEdge> a = new Algorithms<String, IntEdge>();

        List<String> list = a.topoSort(g);
        
        System.out.println(list.toString());
        
        g.addEdge("buck", "stuck");
        g.addEdge("block", "buck");
        
        assertNull(a.topoSort(g));
        
        System.out.println("TOPO SORT TEST WITH DISJOINT GRAPH");
        Graph<Integer> ig = new AdjacencyMatrix<Integer, IntEdge>(true);
        
        Algorithms<Integer, IntEdge> ia = new Algorithms<Integer, IntEdge>();
        
        ig.addVertex(0);
        ig.addVertex(1);
        ig.addVertex(2);
        ig.addVertex(3);
        ig.addVertex(4);
        ig.addVertex(5);
        ig.addVertex(6);
        ig.addVertex(7);
        ig.addVertex(8);
        
        ig.addEdge(1, 2);
        ig.addEdge(2, 3);
        ig.addEdge(3, 4);
        ig.addEdge(5, 6);
        ig.addEdge(3, 8);
        
        assertNotNull(ia.topoSort(ig));
    }
}
