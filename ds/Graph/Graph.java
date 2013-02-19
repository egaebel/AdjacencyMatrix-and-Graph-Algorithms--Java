package ds.Graph;

import java.util.List;

/**
 * An interface for a graph which defines default graph operations.
 * 
 * add, remove, pop, size, toString.
 * 
 * @author Ethan Gaebel (egaebel)
 *
 */
public interface Graph<T> {

    /**
     * Adds a vertex to the graph.
     * 
     * @param element the element to add to the graph.
     */
    public int addVertex(T element);
    /**
     * Removes the vertex holding the specified element from the graph.
     * Returns true if it was present, false otherwise. 
     * 
     * @param element the element to remove from the graph.
     * @return true if the element was present, false otherwise.
     */
    public boolean removeVertex(T element);
    /**
     * Removes the vertex holding the specified element from the Graph, returns
     * the element if successful, returns null otherwise.
     *  
     * @param element the element to remove from the graph.
     * @return the element which was removed from the graph, or null if it wasn't present.
     */
    public T popVertex(T element);
    /**
     * Get a List<T> of all of the vertices in the graph. By Vertices here I am referring to 
     * the elements which are stored in the graph, not some vertex object.
     * 
     * @return a List<T> of all of the elements in the graph.
     */
    public List<T> getVertices();
    /**
     * Adds an edge between vertex1 and vertex2.
     * If it's directed, adds the edge from index1 to index 2. 
     * Returns true if the edge doesn't exist, false otherwise.
     * 
     * @param element1 the first vertex element (element held in the vertex).
     * @param element2 the second vertex element.
     * @return true if an edge doesn't exist, false otherwise.
     */
    public boolean addEdge(T element1, T element2);
    /**
     * Gets a List<T> of all of the elements that the passed element
     * has an edge to.
     * 
     * i.e. edges e from element TO v.
     * 
     * @param element the element to find the edges for.
     * @return the List of edges associated with element.
     */
    public List<T> getEdgesTo(T element);
    /**
     * Gets a List<T> of all of the elements that the passed element
     * has edges from.
     * 
     * i.e. edges e from v to element.
     * 
     * @param element the element to find edges from.
     * @return the List of edges
     */
    public List<T> getEdgesFrom(T element);
    /**
     * Removes the edge between two vertices.
     * If it's directed, removes the edge from index1 to index 2.
     * Returns true if the edge exists, false otherwise.
     * 
     * @param element1 the first vertex element.
     * @param element2 the second vertex element.
     * @return true if the edge exists, false otherwise.
     */
    public boolean removeEdge(T element1, T element2);
    /**
     * Tells the size of the graph (that is, the number of vertices).
     * 
     * @return the number of vertices in the graph.
     */
    public int size();
    /**
     * Returns a string representation of the vertices of the graph. Whatever that may be.
     * 
     * @return the String representation of the vertices of the graph.
     */
    public String printVertices();
    /**
     * Returns a string representation of the edges in the graph. 
     * 
     * @return string representation of the edges in the graph.
     */
    public String printEdges();
    /**
     * Returns true if the graph is directed, false otherwise.
     * 
     * @return true if the graph is directed, false otherwise.
     */
    public boolean isDirected();
    /**
     * Makes a copy of the graph and returns it. The copy is to
     * be COMPLETELY separate from the original, all GRAPH data is independent.
     * (although it cannot be ensured that the data WITHIN the graph will not be
     * connected).
     * 
     * ex. vertex or edge changes are independent, but changes to the data in a vertex is NOT.
     * 
     * @return the copy of the graph.
     */
    public Graph<T> makeCopy();
}