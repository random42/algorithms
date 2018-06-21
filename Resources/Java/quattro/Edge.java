

public class Edge {
  double weight;
  Vertex from;
  Vertex to;

  public Edge(double w, Vertex f, Vertex t) {
    weight = w;
    from = f;
    to = t;
  }

  public String toString() {
    return this.from.toString() + " -> "
      + this.to.toString() + " :: weight " + weight;
  }
}
