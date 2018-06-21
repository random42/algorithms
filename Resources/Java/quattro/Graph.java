import java.util.*;

public class Graph<T> {

  boolean oriented;
  boolean weighted;
  ArrayList<Vertex<T>> vertices;

  public Graph(boolean o, boolean w) {
    this.oriented = o;
    this.weighted = w;
    vertices = new ArrayList<Vertex<T>>();
  }

  // checks if elem already exists before adding the vertex
  public Vertex<T> addVertex(T elem) {
    return null;
  }

  public void removeVertex(Vertex u) {

  }

  // for non weighted graph
  public Edge addEdge(Vertex<T> u, Vertex<T> v) {
    if (weighted) return null;
  }

  // for weighted graph
  public Edge addEdge(Vertex<T> u, Vertex<T> v, double weight) {
    if (!weighted) return null;
    return null;
  }

  public void removeEdge() {

  }
}
