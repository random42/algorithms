package quattro;

public class Edge<T> {
  protected double weight;
  protected Vertex<T> from;
  protected Vertex<T> to;

  public Edge(double w, Vertex<T> f, Vertex<T> t) {
    weight = w;
    from = f;
    to = t;
  }

  public String toString() {
    return this.from.toString() + " => { "
      + this.to.toString() + ", weight " + weight + " }";
  }
}
