package ds.Graph.Test;
import java.util.HashSet;
import java.util.Set;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import ds.TheAdjacencyMatrix.AdjacencyMatrix;
import ds.TheAdjacencyMatrix.AdjacencyMatrixInterface;

public class AdjacencyMatrixTest extends TestCase {

    //~Constants----------------------------------------------


    //~Data Fields--------------------------------------------


    //~Constructors--------------------------------------------
    @Before
    public void setUp() throws Exception {

        
    }

    //~Methods-------------------------------------------------
    //!~UNDIRECTED GRAPH TESTS
    @Test
    public void testAddVertex() {
        
        System.out.println("TEST ADD VERTEX NUMBER-----------------------------");
        
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        assertEquals(matrix.addVertex("alphabetical"), 0);
        assertEquals(matrix.addVertex("maniacal"), 1);
        assertEquals(matrix.addVertex("cracked"), 2);
        assertEquals(matrix.addVertex("draped"), 3);
        assertEquals(matrix.addVertex("enigma"), 4);
        assertEquals(matrix.addVertex("failure"), 5);
        assertEquals(matrix.addVertex("grasped"), 6);
        assertEquals(matrix.addVertex("hashed"), 7);
        
        assertEquals(matrix.size(), 8);
        
        System.out.println(matrix.printVertices());
        
        System.out.println("----------------------------------------------------");
    }
    
    @Test
    public void testRemoveVertexObject() {
        
        System.out.println("TEST REMOVE VERTEX OBJECT--------------------------");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        System.out.println(matrix.printVertices());
        
        assertTrue(matrix.removeVertex("maniacal"));
        
        assertEquals(matrix.size(), 7);
        
        System.out.println(matrix.printVertices());
        
        assertTrue(matrix.removeVertex("grasped"));
        
        assertEquals(matrix.size(), 6);
        
        System.out.println(matrix.printVertices());
        
        assertEquals(matrix.removeVertex("fakie"), false);
        
        assertEquals(matrix.size(), 6);
        
        System.out.println("----------------------------------------------------");
    }
    
    @Test
    public void testRemoveVertexNumber() {
        
        System.out.println("TEST REMOVE VERTEX NUMBER--------------------------");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        System.out.println(matrix.printVertices());
        
        assertTrue(matrix.removeVertex(3));
        
        assertEquals(matrix.size(), 7);
        
        System.out.println(matrix.printVertices());
        
        assertTrue(matrix.removeVertex(5));
        
        assertEquals(matrix.size(), 6);
        
        System.out.println(matrix.printVertices());
        
        assertFalse(matrix.removeVertex(9));
        
        assertEquals(matrix.size(), 6);
        
        System.out.println(matrix.printVertices());
        
        assertFalse(matrix.removeVertex(25));
        
        assertEquals(matrix.size(), 6);
        
        System.out.println(matrix.printVertices());
        
        System.out.println("----------------------------------------------------");
    }
    
    @Test
    public void testPopVertexObject() {
        
        System.out.println("TEST REMOVE VERTEX OBJECT--------------------------");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        System.out.println(matrix.printVertices());
        
        assertEquals(matrix.popVertex("maniacal"), "maniacal");
        
        System.out.println(matrix.printVertices());
        
        assertEquals(matrix.popVertex("grasped"), "grasped");
        
        System.out.println(matrix.printVertices());
        
        assertEquals(matrix.popVertex("fakie"), null);
        
        System.out.println("----------------------------------------------------");
    }
    
    @Test
    public void testAddEdgeObjects() {
        
        System.out.println("TEST REMOVE VERTEX OBJECT--------------------------");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        System.out.println(matrix.printVertices());
        
        assertTrue(matrix.addEdge("maniacal", "grasped"));
        
        System.out.println(matrix.printEdges());
        
        assertTrue(matrix.removeEdge("maniacal", "grasped"));
        
        System.out.println(matrix.printEdges());
        
        assertTrue(matrix.addEdge("grasped", "maniacal"));
        
        System.out.println(matrix.printEdges());
        
        assertTrue(matrix.removeEdge("grasped", "maniacal"));
        
        System.out.println(matrix.printEdges());
        
        assertTrue(matrix.addEdge("maniacal", "grasped"));
        
        System.out.println(matrix.printEdges());
        
        assertTrue(matrix.removeEdge("grasped", "maniacal"));
        
        System.out.println(matrix.printEdges());
        
        assertTrue(matrix.addEdge("maniacal", "grasped", 27));
        
        System.out.println(matrix.printEdges());
        
        assertFalse(matrix.addEdge("cliff", "grasped"));
        assertFalse(matrix.addEdge("cliff", "graspe"));
        assertFalse(matrix.addEdge("maniacal", "graspedkjhaslkf"));
        
        System.out.println("------------------------------------------------------");
    }
    
    @Test
    public void testAddEdgeNumber() {
        
        System.out.println("TEST REMOVE VERTEX OBJECT--------------------------");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        System.out.println(matrix.printVertices());
        
        assertFalse(matrix.addEdge(0, -1));
        assertTrue(matrix.addEdge(0, 0));
        assertTrue(matrix.addEdge(0, 1));
        assertTrue(matrix.addEdge(0, 2));
        assertTrue(matrix.addEdge(0, 3));
        assertTrue(matrix.addEdge(0, 4));
        assertTrue(matrix.addEdge(0, 5));
        assertTrue(matrix.addEdge(0, 6));
        assertTrue(matrix.addEdge(0, 7));
        assertTrue(matrix.addEdge(0, 8));
        assertTrue(matrix.addEdge(0, 9));
        assertFalse(matrix.addEdge(0, 0));
        assertFalse(matrix.addEdge(0, 11));
        
        System.out.println(matrix.printEdges());
        
        System.out.println("------------------------------------------------------");
    }
    
    @Test
    public void testRemoveEdgeElement() {
        
        System.out.println("TEST REMOVE VERTEX OBJECT--------------------------");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        System.out.println(matrix.printVertices());
        
        assertFalse(matrix.addEdge(0, -1));
        assertTrue(matrix.addEdge(0, 0));
        assertTrue(matrix.addEdge(0, 1));
        assertTrue(matrix.addEdge(0, 2));
        assertTrue(matrix.addEdge(0, 3));
        assertTrue(matrix.addEdge(0, 4));
        assertTrue(matrix.addEdge(0, 5));
        assertTrue(matrix.addEdge(0, 6));
        assertTrue(matrix.addEdge(0, 7));
        assertTrue(matrix.addEdge(0, 8));
        assertTrue(matrix.addEdge(0, 9));
        assertFalse(matrix.addEdge(0, 0));
        assertFalse(matrix.addEdge(0, 11));
        
        System.out.println(matrix.printEdges());
        
        assertTrue(matrix.removeEdge("alphabetical", "maniacal"));
        assertTrue(matrix.removeEdge("alphabetical", "draped"));
        assertTrue(matrix.removeEdge("grasped", "alphabetical"));
        
        System.out.println("------------------------------------------------------");
    }
    
    @Test
    public void testMakeCopy() {
        
        System.out.println("TEST MAKE COPY--------------------------");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        AdjacencyMatrixInterface<String> copy = matrix.makeCopy();
        
        assertEquals(matrix.printEdges(), copy.printEdges());
        assertEquals(matrix.printVertices(), copy.printVertices());
    }
    
    @Test
    public void testGetEdgesTo() {
        
        System.out.println("TEST GET EDGES TO (UNDIRECTED)");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        matrix.addEdge("alphabetical", "maniacal");
        matrix.addEdge("maniacal", "cracked");
        matrix.addEdge("cracked", "alphabetical");
        matrix.addEdge("cracked", "hashed");
        matrix.addEdge("enigma", "cracked");
        
        Set<String> set = new HashSet<String>();
        set.add("maniacal");
        set.add("enigma");
        set.add("hashed");
        set.add("alphabetical");
        
        for (String s : matrix.getEdgesTo("cracked")) {
            
            assertTrue(set.contains(s));
        }
        System.out.println(matrix.printEdges());
        matrix.getEdgesTo("null");
        matrix.getEdgesTo(null);
        
        //----------------------------------------------------
        //----------------------------------------------------
        
        System.out.println("TEST GET EDGES TO (DIRECTED)");
        matrix = new AdjacencyMatrix<String>(true);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        matrix.addEdge("alphabetical", "maniacal");
        matrix.addEdge("maniacal", "cracked");
        matrix.addEdge("cracked", "alphabetical");
        matrix.addEdge("cracked", "hashed");
        matrix.addEdge("enigma", "cracked");
        
        set = new HashSet<String>();
        set.add("hashed");
        set.add("alphabetical");
        
        for (String s : matrix.getEdgesTo("cracked")) {
            
            assertTrue(set.contains(s));
        }
        System.out.println(matrix.printEdges());
        matrix.getEdgesTo("null");
        matrix.getEdgesTo(null);
    }
    
    @Test
    public void testGetEdgesFrom() {
        
        System.out.println("TEST GET EDGES FROM (UNDIRECTED)");
        AdjacencyMatrixInterface<String> matrix = new AdjacencyMatrix<String>(false);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        matrix.addEdge("alphabetical", "maniacal");
        matrix.addEdge("maniacal", "cracked");
        matrix.addEdge("cracked", "alphabetical");
        matrix.addEdge("cracked", "hashed");
        matrix.addEdge("enigma", "cracked");
        
        Set<String> set = new HashSet<String>();
        set.add("maniacal");
        set.add("enigma");
        set.add("hashed");
        set.add("alphabetical");
        
        for (String s : matrix.getEdgesFrom("cracked")) {
            
            assertTrue(set.contains(s));
        }
        System.out.println(matrix.printEdges());
        matrix.getEdgesFrom("null");
        matrix.getEdgesFrom(null);
        
        //----------------------------------------------------
        //----------------------------------------------------
        
        System.out.println("TEST GET EDGES FROM (DIRECTED)");
        matrix = new AdjacencyMatrix<String>(true);
        
        matrix.addVertex("alphabetical");
        matrix.addVertex("maniacal");
        matrix.addVertex("cracked");
        matrix.addVertex("draped");
        matrix.addVertex("enigma");
        matrix.addVertex("failure");
        matrix.addVertex("grasped");
        matrix.addVertex("hashed");
        
        matrix.addEdge("alphabetical", "maniacal");
        matrix.addEdge("maniacal", "cracked");
        matrix.addEdge("cracked", "alphabetical");
        matrix.addEdge("cracked", "hashed");
        matrix.addEdge("enigma", "cracked");
        
        set = new HashSet<String>();
        set.add("enigma");
        set.add("maniacal");
        
        for (String s : matrix.getEdgesFrom("cracked")) {
            
            assertTrue(set.contains(s));
        }
        System.out.println(matrix.printEdges());
        matrix.getEdgesFrom("null");
        matrix.getEdgesFrom(null);
    }
}