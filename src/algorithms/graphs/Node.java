package algorithms.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javafx.geometry.Point3D;

/**
 *
 * @author Richard Coan
 */
public class Node {
    protected final Point3D coords;
    protected Map<Node, Edge> adjacent;
    
    /**
     * Constructor
     * @param coords 
     */
    public Node(Point3D coords) {
        this.coords = coords;
        this.adjacent = new HashMap();
    }

    /**
     * @return Node Coordinates.
     */
    public Point3D getCoords() {
        return coords;
    }

    /**
     * @return Map<Node, Edge> of adjacent nodes.
     */
    public Map<Node, Edge> getAdjacent() {
        return adjacent;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.coords);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.coords, other.coords)) {
            return false;
        }
        return true;
    }
      
    /**
     * Adds a node to the adjacency list with an undirected edge.
     * @param node
     * @return Edge created by the adjacency, or null if node already exists.
     */
    public Edge AddAdjacent(Node node)
    {
        return AddAdjacent(node, Edge.OMNI);
    }
    
    /**
     * Adds a node to the adjacency list with a directed edge.
     * @param node
     * @param direction
     * @return Edge created by the adjacency, or null if node already exists.
     */
    public Edge AddAdjacent(Node node, int direction)
    {
        Edge e = null;
        
        if(!adjacent.containsKey(node))
        {
            e = new Edge(this.coords.angle(node.coords), this.coords.distance(node.coords), direction); 
            adjacent.put(node, e);
        }
       
        return e;
    }
    
}
