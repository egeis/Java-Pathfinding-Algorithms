package algorithms.graphs;

/**
 *
 * @author Richard Coan
 */
public class Edge {
    public static int RECIEVER  = 1;
    public static int SENDER    = 2;
    public static int OMNI      = 3;
    
    public final double angle;
    public final double distance;
        
    protected int direction;

    public Edge(double angle, double distance, int direction) {
        this.angle = angle;
        this.distance = distance;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }   
}
