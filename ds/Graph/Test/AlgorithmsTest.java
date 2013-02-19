package ds.Graph.Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import ds.Graph.Graph;
import ds.GraphAlgorithms.Algorithms;
import ds.TheAdjacencyMatrix.AdjacencyMatrix;


public class AlgorithmsTest {

    @Test
    public void dfsTest() {

        System.out.println("DFS TEST");
        Graph<String> g = new AdjacencyMatrix<String>();
        
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
        
        Algorithms<String> a = new Algorithms<String>();
        
        List<String> list = a.dfs(g, "magician", "block");
        
        System.out.println(list.toString());
    }
    
    @Test 
    public void bfsTest() {
        
        System.out.println("BFS TEST");
        Graph<String> g = new AdjacencyMatrix<String>();
        
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
        
        Algorithms<String> a = new Algorithms<String>();
        
        List<String> list = a.bfs(g, "magician", "block");
        
        System.out.println(list.toString());
    }
    
    @Test
    public void topoSortTest() {
        
        System.out.println("TOPO SORT TEST!");
        Graph<String> g = new AdjacencyMatrix<String>(true);
        
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
        
        Algorithms<String> a = new Algorithms<String>();

        List<String> list = a.topoSort(g);
        
        System.out.println(list.toString());
        
        g.addEdge("buck", "stuck");
        g.addEdge("block", "buck");
        
        assertNull(a.topoSort(g));
        
        System.out.println("TOPO SORT TEST WITH DISJOINT GRAPH");
        Graph<Integer> ig = new AdjacencyMatrix<Integer>(true);
        
        Algorithms<Integer> ia = new Algorithms<Integer>();
        
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
