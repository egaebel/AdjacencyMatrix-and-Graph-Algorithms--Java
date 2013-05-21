package ds.TheAdjacencyMatrix;

/**
 * An Edge object which represents an edge with 0 weight.
 * The setWeight method does nothing for this edge. 
 * 
 * @author Ethan Gaebel (egaebel)
 *
 */
public class EmptyEdge extends Edge {

    //~Methods-------------------------------------------------
    @Override
    public int compareTo(Edge edge) {

        if (edge.getWeight() < 0) {
            return 1;
        }
        else if (edge.getWeight() > 0) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public void setWeight(int weight) {}

    @Override
    public int getWeight() {
        return 0;
    }
    
    @Override
    public String toString() {
        
        return "0";
    }
}
