package ds.TheAdjacencyMatrix;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import ds.Graph.Graph;

/**
 * An Adjacency Matrix style graph which can be used to either represent a directed graph
 * or an undirected graph. Undirected by default. (default constructor)  
 * 
 * If the graph is Directed, the rows are the FROM vertices, and the columns are the TO vertices.
 * 
 * @author Ethan Gaebel (egaebel)
 *
 * @param <T>
 * @param <E extends Edge>
 */
public class AdjacencyMatrix<T, E extends Edge> 
        implements AdjacencyMatrixInterface<T, E>, Graph<T> {

    //~Constants----------------------------------------------
    private static final int DEFAULT_SIZE = 10;

    //~Data Fields--------------------------------------------
    /**
     * Int matrix that holds edge weights in weighted graphs. 
     * A 1 in a directed graph indicates an edge, a 0 indicates no edge.
     */
    private Object[][] matrix;

    /**
     * One object that represents all of the empty (0 weight) edges in the graph.
     */
    private EmptyEdge empty;
    
    /**
     * Array of elements contained in the graph.
     * Elements correspond to the same indices as they do in the adjacency matrix of edges.
     * 
     * i.e. matrix[4][5] is an edge from 4 to 5, 
     *  elements[4] is the element at 4, elements[5] is the element at 5
     */
    private T[] elements;
    
    /**
     * The maximum number of vertices in the adjacency matrix.
     */
    private int size;
    
    /**
     * The current number of vertices in the graph.
     */
    private int numVertices;
    
    /**
     * Indicates whether the graph is directed or not. True if directed, false otherwise.
     */
    private boolean directed;

    //~Constructors--------------------------------------------
    /**
     * Initializes the adjacency matrix to a size of 10.
     * Which means there are 10 vertices in the graph.
     */
    public AdjacencyMatrix() {
       
        this(DEFAULT_SIZE);
    }
    
    /**
     * Initializes the adjacency matrix to a size of 10. There will be 10 vertices in the graph.
     * 
     * @param directed true if the graph is to be a directed graph, false otherwise.
     */
    public AdjacencyMatrix(boolean directed) {
        
        this();
        this.directed = directed;
    }
    
    /**
     * Initializes the adjacency matrix to a size of size.
     * There will be a maximum size of *size* vertices in the graph
     * 
     * @param size the size of the adjacency matrix.
     */
    @SuppressWarnings("unchecked")
    public AdjacencyMatrix(int size) {
        
        elements = (T[]) new Object[size];
        matrix = new Object[size][size];
        
        this.size = size;
        numVertices = 0;
        directed = false;
        
        empty = new EmptyEdge();
        
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                matrix[i][j] = empty;
            }
        }
    }
    
    /**
     * Initializes the adjacency matrix to a size of size.
     * There will be a maximum size of *size* vertices in the graph.
     * 
     * @param directed indicates whether the graph should be directed or not.
     * @param size the size of the adjacency matrix.
     */
    public AdjacencyMatrix(boolean directed, int size) {
        
        this(size);
        this.directed = directed;
    }

    //~Methods-------------------------------------------------
    /**
     * Totally randomizes the graph
     */
    public void makeGraphRandom() {
        
        Random rand = new Random();
        int weight;
        
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                weight = rand.nextInt();
                if (weight < 0) {
                    weight = 0;
                }
                
                ((Edge) matrix[i][j]).setWeight(weight);
                
                if (!directed) {
                    
                    ((Edge) matrix[j][i]).setWeight(weight);
                }
            }
        }
    }
    
    @Override
    public AdjacencyMatrixInterface<T, E> makeCopy() {
        
        AdjacencyMatrix<T, E> copy = new AdjacencyMatrix<T, E>(directed);
        
        //copy vertices
        for(int i = 0; i < size; i++) {
            
            copy.addVertex(elements[i]);
        }
        
        //copy edges
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                
                copy.addEdge(i, j, (E) matrix[i][j]);
            }
        }
        
        return copy;
    }
    
    @Override
    public int addVertex(T element) {

        if (numVertices == size) {
            
            resize();
        }
        
        for (int i = 0; i < size; i++) {
            
            if (elements[i] == null) {
                
                elements[i] = element;
                numVertices++;
                return i;
            }
        }
        
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        
        size *= 2;
        T[] temp = (T[]) new Object[size];
        Object[][] matrixTemp = new Object[size][size];
        
        for (int i = 0; i < elements.length; i++) {
        
            temp[i] = elements[i];
            
            for (int j = 0; i < elements.length; j++) {
             
                matrixTemp[i][j] = (Edge) matrix[i][j];
            }
        }
        
        elements = temp;
        matrix = matrixTemp;
    }

    @Override
    public boolean removeVertex(T element) {

        int index = findVertex(element);
        
        if (index != -1) {
            
            return removeVertex(index);
        }
        
        return false;
    }
    
    /**
     * Takes an element and finds it's index in the array of elements.
     * 
     * @param element the element to find in the array.
     * @return the index if the element is present, -1 otherwise.
     */
    public int findVertex(T element) {
        
        if (element != null) {
         
            for (int i = 0; i < elements.length; i++) {
                
                if (element.equals(elements[i])) {
                    
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Takes a vertex number and gets the element stored there.
     * Returns null if the number is invalid, or an element of that number doesn't exist.
     * 
     * @param number the number of the vertex to get.
     * @return the element corresponding to the passed vertex number.
     */
    public T getVertex(int number) {
        
        if (number < size && number > -1 && elements[number] != null) {
            
            return elements[number];
        }
        
        return null;
    }

    /**
     * Removes the vertex with the specified number from the graph.
     * Returns true if the number has a vertex, false otherwise.
     * 
     * @param number the number of the vertex in the adjacency matrix to
     *          remove from the graph.
     * @return true if the number maps to a vertex, false otherwise.
     */
    public boolean removeVertex(int index) {

        if (index > -1 && index < size && elements[index] != null) {
            
            elements[index] = null;
            
            //set rows and columns of index to 0
            for (int i = 0; i < size; i++) {
                
                matrix[index][i] = empty;
                matrix[i][index] = empty;
            }
            
            numVertices--;
            
            return true;
        }

        return false;
    }

    @Override
    public T popVertex(T element) {

        int index = findVertex(element);
        
        if (index != -1) {
            
            return popVertex(index);
        }
        
        return null;
    }

    /**
     * Removes the vertex mapping to the passed number from the graph and returns
     * the element contained in the vertex, or null if the number didn't map to a vertex.
     * 
     * @param number the number mapping to the vertex in the graph to be removed.
     * @return the element which was removed from the graph, or null if it wasn't present.
     */
    public T popVertex(int index) {

        if (index > -1 && index < size) {
            
            T element = elements[index];
            
            elements[index] = null;
            
            //set rows and columns of index to 0
            for (int i = 0; i < size; i++) {
                
                matrix[index][i] = empty;
                matrix[i][index] = empty;
            }
            
            numVertices--;
            
            return element;
        }
        
        return null;
    }
    
    @Override
    public List<T> getVertices() {
        
        List<T> list = new LinkedList<T>();
        
        for (int i = 0; i < size; i++) {
            
            T el = elements[i];
            if (el != null) {
                list.add(el);
            }
        }
        
        return list;
    }

    @Override
    public int size() {

        return numVertices;
    }

    @Override
    public boolean addEdge(T element1, T element2) {
        
        int index1 = findVertex(element1);
        int index2 = findVertex(element2);
        
        if (index1 != -1 && index2 != -1) {
            
            return addEdge(index1, index2);
        }
        
        return false;
    }
    
    /**
     * Adds an edge between the two passed in vertex numbers of weight 1.
     * If it's directed, adds the edge from index1 to index 2.
     * 
     * @param index1 the first vertex number.
     * @param index2 the second vertex number.
     * @return true if indices are valid, and if the edge does not already exist.
     */
    public boolean addEdge(int index1, int index2) {

        return addEdge(index1, index2, 1);
    }
    
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
    public boolean addEdge(T element1, T element2, int weight) {
        
        int index1 = findVertex(element1);
        int index2 = findVertex(element2);
        
        if (index1 != -1 && index2 != -1) {
            
            return addEdge(index1, index2, weight);
        }
        
        return false;
    }
    
    /**
     * Adds an edge between index1 and index2 of weight weight.
     * If it's directed, adds the edge from index1 to index 2. 
     * Returns true if the edge doesn't exist, (the new edge was created) and false otherwise.
     * 
     * @param index1 the number of the first vertex (the from vertex)
     * @param index2 the number of the second vertex (the to vertex)
     * @return true if an edge doesn't exist, false otherwise.
     */
    public boolean addEdge(int index1, int index2, int weight) {
        
        if (index1 > -1 && index2 > -1 
                && index1 < size && index2 < size
                && ((Edge) matrix[index1][index2]).getWeight() == 0) {

            Edge newEdge = new IntEdge(weight);
            matrix[index1][index2] = newEdge;
            
            if (!directed) {
                matrix[index2][index1] = newEdge;    
            }
            
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean addEdge(T element1, T element2, E edge) {
        
        int index1 = findVertex(element1);
        int index2 = findVertex(element2);
        
        if (index1 != -1 && index2 != -1 && edge != null) {
        
            return addEdge(index1, index2, edge);
        }
        
        return false;
    }
    
    @Override
    public boolean addEdge(int index1, int index2, E edge) {
        
        if (index1 > -1 && index1 < size 
                && index2 > -1 && index2 < size && edge != null) {
            
            matrix[index1][index2] = edge;
            
            if (!directed) {
                matrix[index2][index1] = edge;
            }
            
            return true;
        }
        
        return false;
    }

    /**
     * Gets the edge weight of the edge going from the vertex
     * numbered by fromVertex, to the vertex numbered by toVertex.
     * 
     * @param fromVertex the vertex number that the edge goes from.
     * @param toVertex the vertex number that the edge goes to.
     * @return the weight of the edge. -1 if invalid parameters are passed,
     *          however edge weights COULD also be -1.....
     */
    public int getEdge(int fromVertex, int toVertex) {
        
        if (fromVertex > -1 && toVertex > -1 
                && fromVertex < size && toVertex < size) {
            
            return ((Edge) matrix[fromVertex][toVertex]).getWeight();
        }
        
        return -1;
    }
    
    @Override
    public List<T> getEdgesTo(T element) {

        int index = findVertex(element);
        
        List<T> edges = new LinkedList<T>();
        
        //if the passed element exists
        if (index != -1) {
            
            //Loop over all possible edges and if there isn't a 0
                //adds them to the edges List
            for (int i = 0; i < size; i++) {
                
                //if the edge HAS a weight
                if (((Edge) matrix[index][i]).getWeight() != 0) { 
                 
                    edges.add(elements[i]);
                }
            }
        }
        
        return edges;
    }
    
    @Override
    public List<T> getEdgesFrom(T element) {

        int index = findVertex(element);
        
        List<T> edges = new LinkedList<T>();
        
        //if the passed element exists
        if (index != -1) {
            //Loop over all possible edges and if there isn't a 0
                //adds them to the edges List
            for (int i = 0; i < size; i++) {
                
                //if the edge HAS a weight
                if (((Edge) matrix[i][index]).getWeight() != 0) { 
                 
                    edges.add(elements[i]);
                }
            }
        }
        
        return edges;
    }

    @Override
    public boolean removeEdge(T element1, T element2) {

        int index1 = findVertex(element1);
        int index2 = findVertex(element2);
        
        if (index1 != -1 && index2 != -1) {
            
            return removeEdge(index1, index2);
        }
        
        return false;
    }
    
    /**
     * Takes two vertex numbers and removes the edge.
     * If it's directed, removes the edge from index1 to index 2.
     * Returns true if the edge exists, false otherwise.
     * 
     * @param index1 the first vertex number.
     * @param index2 the second vertex number.
     * @return true if the edge exists, false otherwise.
     */
    public boolean removeEdge(int index1, int index2) {
        
        if (((Edge) matrix[index1][index2]).getWeight() != 0 
                && index1 > -1 && index1 < size && index2 > -1 
                && index2 < size) {
            
            matrix[index1][index2] = empty; 
            
            if (!directed) {
                matrix[index2][index1] = empty;
            }
                    
            return true;
        }
        
        return false;
    }
    
    /**
     * Takes two elements and if an edge exists, removes it and returns the weight.
     * If it doesn't exist, returns -1.
     * 
     * @param element1 the first element with a vertex.
     * @param element2 the second element with a vertex.
     * @return the weight of the edge being popped.
     */
    public int popEdge(T element1, T element2) {
        
        int index1 = findVertex(element1);
        int index2 = findVertex(element2);
        
        if (index1 != -1 && index2 != -1) {
            
            return popEdge(index1, index2);
        }
        
        return -1;
    }
    
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
    public int popEdge(int index1, int index2) {
        
        
        if ((index1 > -1 && index1 < size) && (index2 > -1 && index2 < size)) {

            int weight = ((Edge) matrix[index1][index2]).getWeight();
            
            matrix[index1][index2] = empty;
            
            if (!directed) {
                matrix[index2][index1] = empty;
            }
                    
            return weight;
        }
        
        return -1;
    }
    
    /**
     * True if the graph is directed, false otherwise.
     * 
     * @return directed True if the graph is directed, false otherwise.
     */
    public boolean isDirected() {
        
        return directed;
    }
    
    public String printEdges() {
        
        StringBuilder build = new StringBuilder();
        
        build.append("-");
        for (int i = 0; i < size; i++) {
            
            build.append("|").append(i);
        }
        build.append("|").append("\n");
        
        for (int i = 0; i < size; i++) {
            
            build.append("-|");
        }
        build.append("-|").append("\n");
        
        for (int i = 0; i < size; i++) {
                
            build.append(i);
            
            for (int j = 0; j < size; j++) {

                build.append("|").append(matrix[i][j]);
            }
            build.append("|").append("\n");
        }
        
        for (int i = 0; i < size; i++) {
            
            build.append("-|");
        }
        build.append("-|").append("\n");
        
        return build.toString();
    }
    
    public String printVertices() {
 
        StringBuilder build = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
            
            build.append("|").append(elements[i]);
        }
        
        return build.toString();
    }
}