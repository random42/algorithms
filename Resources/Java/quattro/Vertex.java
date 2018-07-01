package quattro;

import java.util.*;

public class Vertex<T> {
  T elem; // unique object linked to the vertex
  protected ArrayList<Edge<T>> adj; // edges from the vertex

  public Vertex(T e) {
    elem = e;
    adj = new ArrayList<Edge<T>>();
  }

  public Edge<T> addEdge(Vertex<T> v, double weight) {
    Edge<T> e = new Edge<T>(weight, this, v);
    adj.add(e);
    return e;
  }

  public Edge<T> removeEdge(Vertex<T> v) {
    Iterator<Edge<T>> i = adj.iterator();
    boolean found = false;
    Edge<T> e = null;
    while (i.hasNext() && !found) {
      e = i.next();
      found = e.to.equals(v);
    }
    if (found) {
      i.remove();
      return e;
    } else {
      return null;
    }
  }

  public boolean isAdjacent(Vertex<T> x) {
    Iterator<Edge<T>> i = adj.iterator();
    boolean found = false;
    while (i.hasNext() && !found) {
      Edge<T> e = i.next();
      found = e.to.equals(x);
    }
    return found;
  }

  public Iterator<Edge<T>> iterator() {
    return adj.iterator();
  }

  public String toString() {
    String a = elem.toString();
    a += " -> ";
    Iterator<Edge<T>> i = adj.iterator();
    while (i.hasNext()) {
      Edge<T> n = i.next();
      a += "{" + n.to.elem.toString() + ", " + n.weight + "}";
    }
    return a;
  }
}
