package quattro;

import java.util.*;
import tre.Heap;

public class Algorithms {

  public static <T> ArrayList<Edge<T>> MstPrim(Graph<T> g) {
    return MstPrim(g,g.vertices.get(0));
  }

  public static <T> ArrayList<Edge<T>> MstPrim(Graph<T> g, Vertex<T> source) {
    if (g.isOriented() || !g.isWeighted())
      throw new Error("Graph must be weighted and not oriented!");
    int vSize = g.getNumberOfVertices();
    ArrayList<Edge<T>> path = new ArrayList<Edge<T>>(vSize);
    HashMap<Vertex<T>,Edge<T>> pi = new HashMap<Vertex<T>,Edge<T>>(vSize);
    Heap<Double,Vertex<T>> queue = new Heap<Double,Vertex<T>>(false, vSize);
    for (int i = 0;i < vSize;i++) {
      queue.insert(Double.POSITIVE_INFINITY, g.vertices.get(i));
    }
    queue.changeKey(source, 0.0);
    while (queue.size() > 0) {
      Vertex<T> u = queue.extract();
      Edge<T> from = pi.get(u);
      if (from != null)
        path.add(from);
      Iterator<Edge<T>> i = u.iterator();
      while (i.hasNext()) {
        Edge<T> e = i.next();
        Vertex<T> v = e.to;
        if (queue.contains(v) && e.weight < queue.getKey(v)) {
          queue.changeKey(v, e.weight);
          pi.put(v,e);
        }
      }
    }
    return path;
  }

}
