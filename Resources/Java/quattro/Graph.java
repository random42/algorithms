package quattro;

import java.util.*;

/*
  This class is implemented with adjacent lists.
  Vertices should be unique by their T elem field using Object.equals().
*/
public class Graph<T> {

  private final boolean oriented;
  private final boolean weighted;
  protected ArrayList<Vertex<T>> vertices;
  private int _edges;

  /*
    by default the graph is oriented and weighted
  */
  public Graph() {
    this.oriented = true;
    this.weighted = true;
    _edges = 0;
    vertices = new ArrayList<Vertex<T>>();
  }

  public Graph(boolean oriented, boolean weighted) {
    this.oriented = oriented;
    this.weighted = weighted;
    _edges = 0;
    vertices = new ArrayList<Vertex<T>>();
  }

  public int getNumberOfVertices() {
    return vertices.size();
  }

  public int getNumberOfEdges() {
    return _edges;
  }

  public boolean isOriented() {return oriented;}

  public boolean isWeighted() {return weighted;}

  public double getWeight() {
    if (!weighted) throw new Error("Graph is not weighted!");
    double weight = 0;
    Iterator<Vertex<T>> i = vertices.iterator();
    while (i.hasNext()) {
      Vertex<T> u = i.next();
      Iterator<Edge<T>> j = u.adj.iterator();
      while (j.hasNext()) {
        weight += j.next().weight;
      }
    }
    return oriented ? weight : weight/2;
  }

  public Vertex<T> addVertex(T elem) {
    Vertex<T> n = new Vertex<T>(elem);
    vertices.add(n);
    return n;
  }

  /*
    remove the vertex and calls cleanEdgesToVertex()
    to remove edges to the removed vertex
  */
  public void removeVertex(T elem) {
    int index = indexOfVertex(elem);
    if (index < 0) return;
    Vertex<T> v = vertices.remove(index);
    this.cleanEdgesToVertex(v);
  }

  // for non weighted graph
  public void addEdge(T u, T v) {
    if (weighted) throw new Error("Need a weight to add edge!");
    Vertex<T> a = findVertex(u);
    Vertex<T> b = findVertex(v);
    if (a == null)
      a = this.addVertex(u);
    if (b == null)
      b = this.addVertex(v);
    this.addEdge(a,b,1);
  }

  // for weighted graph
  public void addEdge(T u, T v, double weight) {
    if (!weighted) throw new Error("Cannot specify a weight to add edge!");
    Vertex<T> a = findVertex(u);
    Vertex<T> b = findVertex(v);
    if (a == null)
      a = this.addVertex(u);
    if (b == null)
      b = this.addVertex(v);
    this.addEdge(a,b,weight);
  }

  private void addEdge(Vertex<T> u, Vertex<T> v, double weight) {
    u.addEdge(v, weight);
    if (!oriented) {
      v.addEdge(u, weight);
    }
    _edges++;
  }

  public void removeEdge(T u, T v) {
    Vertex<T> a = findVertex(u);
    Vertex<T> b = findVertex(v);
    if (a == null || b == null) return;
    Edge<T> r = a.removeEdge(b);
    if (!oriented) {
      b.removeEdge(a);
    }
    if (r != null) {
      _edges--;
    }
    return;
  }

  public Iterator<Vertex<T>> iterator() {
    return vertices.iterator();
  }

  /*
    removes edges to a deleted vertex
    takes O(E)
  */
  private void cleanEdgesToVertex(Vertex<T> v) {
    Iterator<Vertex<T>> i = vertices.iterator();
    while (i.hasNext()) {
      if (i.next().removeEdge(v) != null)
        _edges--;
    }
  }

  private int indexOfVertex(T elem) {
    Iterator<Vertex<T>> i = vertices.iterator();
    boolean exists = false;
    int j = -1;
    while (i.hasNext() && !exists) {
      exists = i.next().elem.equals(elem);
      j++;
    }
    return exists ? j : -1;
  }

  private Vertex<T> findVertex(T elem) {
    int index = indexOfVertex(elem);
    if (index >= 0) {
      return vertices.get(index);
    } else {
      return null;
    }
  }

  public String toString() {
    String r = "";
    Iterator<Vertex<T>> i = vertices.iterator();
    while (i.hasNext()) {
      r += i.next().toString() + "\n";
    }
    return r;
  }
}
