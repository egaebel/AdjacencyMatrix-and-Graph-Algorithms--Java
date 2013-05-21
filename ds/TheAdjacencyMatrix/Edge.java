package ds.TheAdjacencyMatrix;

/**
 * An abstract Edge class which has methods
 * getWeight()
 * and
 * setWeight(int weight).
 * Used for a Graph data structure to abstract
 * out the edges.
 * 
 * @author Ethan Gaebel (egaebel)
 *
 */
public abstract class Edge implements Comparable<Edge> {

    /**
     * Sets the weight of the edge to the passed in weight.
     * 
     * @param weight the weight of the edge.
     */
    public abstract void setWeight(int weight);
    
    /**
     * Gets the weight of the edge.
     * 
     * @return the edge weight.
     */
    public abstract int getWeight();
}