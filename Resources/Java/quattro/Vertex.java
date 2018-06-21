import java.util.*;

public class Vertex<T> {
  T elem; // info object linked to the vertex
  ArrayList<Edge> adj; // edges from the vertex

  public Vertex(T e) {
    elem = e;
    adj = new ArrayList<Edge>();
  }

  public Edge addEdge(Vertex<T> v, double weight) {
    Edge e = new Edge(weight, this, v);
    adj.add(e);
    return e;
  }

  public boolean isAdjacent(Vertex x) {
    Iterator<Edge> i = adj.iterator();
    boolean found = false;
    while (i.hasNext() && !found) {
      Edge e = i.next();
      found = e.to == x;
    }
    return found;
  }

  public String toString() {
    return elem.toString();
  }
}
