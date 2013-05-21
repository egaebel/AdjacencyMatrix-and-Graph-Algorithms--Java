package ds.TheAdjacencyMatrix;

import ds.Graph.Graph;

/**
 * Interface for an AdjacencyMatrix Graph data structure which can be either directed or un-directed. 
 * That choice should be made in the constructor.
 * 
 * @author Ethan Gaebel (egaebel)
 *
 * @param <T>
 */
public interface AdjacencyMatrixInterface<T, E> extends Graph<T> {

    //~Methods-------------------------------------------------
    @Override
    public int addVertex(T element);
    @Override
    public boolean removeVertex(T element);
    /**
     * Takes an element and finds it's index in the array of elements.
     * 
     * @param element the element to find in the array.
     * @return the index if the element is present, -1 otherwise.
     */
    public int findVertex(T element);
    /**
     * Takes a vertex number and gets the element stored there.
     * Returns null if the number is invalid, or an element of that number doesn't exist.
     * 
     * @param number the number of the vertex to get.
     * @return the element corresponding to the passed vertex number.
     */
    public T getVertex(int number);
    /**
     * Removes the vertex with the specified number from the graph.
     * Returns true if the number has a vertex, false otherwise.
     * 
     * @param number the number of the vertex in the adjacency matrix to
     *          remove from the graph.
     * @return true if the number maps to a vertex, false otherwise.
     */
    public boolean removeVertex(int index);
    @Override
    public T popVertex(T element);
    /**
     * Removes the vertex mapping to the passed number from the graph and returns
     * the element contained in the vertex, or null if the number didn't map to a vertex.
     * 
     * @param number the number mapping to the vertex in the graph to be removed.
     * @return the element which was removed from the graph, or null if it wasn't present.
     */
    public T popVertex(int index);
    @Override
    public int size();
    @Override
    public boolean addEdge(T element1, T element2);
    /**
     * Adds an edge between the two passed in vertex numbers of weight 1.
     * If it's directed, adds the edge from index1 to index 2.
     * 
     * @param index1 the first vertex number.
     * @param index2 the second vertex number.
     * @return true if indices are valid, and if the edge does not already exist.
     */
    public boolean addEdge(int index1, int index2);
    /**
     * Adds an edge between element1 and element2 of weight weight.
     * If it's directed, adds the edge from element1 to element2. 
     * Returns true if the edge doesn't exist, (the new edge was created) and false otherwise.
     * 
     * @param element1 the first element (or starting element) to put the edge at.
     * @param element2 the second element, that the edge goes to.
     * @param weight the weight of the edge.
     * @return true if an edge doesn't ALREADY exist, false otherwise.
     */
    public boolean addEdge(T element1, T element2, int weight);
    /**
     * Adds an edge between index1 and index2 of weight weight.
     * If it's directed, adds the edge from index1 to index 2. 
     * Returns true if the edge doesn't exist, (the new edge was created) and false otherwise.
     * 
     * @param index1 the number of the first vertex (the from vertex)
     * @param index2 the number of the second vertex (the to vertex)
     * @return true if an edge doesn't exist, false otherwise.
     */
    public boolean addEdge(int index1, int index2, int weight);
    /**
     * Adds an the Edge, edge, between element1 and element2.
     * 
     * @param element1 the element the edge goes from.
     * @param element2 the element the edge goes to.
     * @param edge the Edge object between the elements.
     * @return true if element1 and element2 are successful and edge != null, 
     *          false otherwise.
     */
    public boolean addEdge(T element1, T element2, E edge);
    /**
     * Adds the Edge edge to the adjacency matrix at index1, index2.
     * 
     * @param index1 the index of the from vertex.
     * @param index2 the index of the to vertex.
     * @param edge the Edge object to add to the matrix.
     * @return true if successful, false if index1 or index2 is out of bounds
     *          or if edge == null
     */
    public boolean addEdge(int index1, int index2, E edge);
    @Override
    public boolean removeEdge(T element1, T element2);
    /**
     * Takes two vertex numbers and removes the edge.
     * If it's directed, removes the edge from index1 to index 2.
     * Returns true if the edge exists, false otherwise.
     * 
     * @param index1 the first vertex number.
     * @param index2 the second vertex number.
     * @return true if the edge exists, false otherwise.
     */
    public boolean removeEdge(int index1, int index2);
    /**
     * Takes two elements and if an edge exists, removes it and returns the weight.
     * If it doesn't exist, returns -1.
     * 
     * @param element1 the first element with a vertex.
     * @param element2 the second element with a vertex.
     * @return the weight of the edge being popped.
     */
    public int popEdge(T element1, T element2);
    /**
     * Takes two vertex numbers and removes the edge between them, returns the weight of the edge 
     * (returning 0 if no edge).
     * If it's a directed graph, then returns the weight of the edge from index1 to index2
     * Returns -1 if the vertex numbers are invalid.
     * 
     * @param index1 the number of vertex1.
     * @param index2 the number of vertex2.
     * @return the weight of the edge that got removed.
     */
    public int popEdge(int index1, int index2);
    @Override
    public AdjacencyMatrixInterface<T, E> makeCopy();
    @Override
    public boolean isDirected();
    @Override
    public String printEdges();
    @Override
    public String printVertices();
}