package ds.TheAdjacencyMatrix;


/**
 * Standard edge holding only an int.
 * 
 * @author Ethan Gaebel (egaebel)
 *
 */
public class IntEdge extends Edge {

    //~Data Fields--------------------------------------------
    /**
     * The weight of the edge.
     */
    private int weight;

    //~Constructors--------------------------------------------
    /**
     * Constructor taking the integer weight to set the weight to.
     * 
     */
    public IntEdge(int theWeight) {
        
        weight = theWeight;
    }
    
    /**
     * Default constructor, sets weight to 0.
     */
    public IntEdge() {
        
        weight = 0;
    }

    //~Methods-------------------------------------------------
    @Override
    public void setWeight(int weight) {

        this.weight = weight;
        
    }

    @Override
    public int getWeight() {

        return weight;
    }

    @Override
    public int compareTo(Edge edge) {

        if (edge.getWeight() == weight) {
        
            return 0;
        }
        else if (edge.getWeight() < weight) {
            
            return 1;
        }
        else {
            
            return -1;
        }
    }
    
    @Override
    public String toString() {
        
        return String.valueOf(weight);
    }
}