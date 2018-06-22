package quattro;

public class Edge<T> {
  double weight;
  Vertex<T> from;
  Vertex<T> to;

  public Edge(double w, Vertex<T> f, Vertex<T> t) {
    weight = w;
    from = f;
    to = t;
  }

  public String toString() {
    return this.from.toString() + " -> "
      + this.to.toString() + " :: weight " + weight;
  }
}
