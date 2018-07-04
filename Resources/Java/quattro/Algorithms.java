package quattro;

import java.util.*;
import tre.Heap;

public class Algorithms {

  public static <T> ArrayList<ArrayList<Edge<T>>> msfPrim(Graph<T> g) {
    ArrayList<Vertex<T>> visited = new ArrayList<Vertex<T>>(g.vertices);
    ArrayList<ArrayList<Edge<T>>> forest = new ArrayList<ArrayList<Edge<T>>>();
    while (visited.size() > 0) {
      ArrayList<Edge<T>> path = mstPrim(g, visited.get(0));
      forest.add(path);
      Iterator<Edge<T>> i = path.iterator();
      while (i.hasNext()) {
        Edge<T> e = i.next();
        visited.remove(e.from);
        visited.remove(e.to);
      }
    }
    return forest;
  }

  public static <T> ArrayList<Edge<T>> mstPrim(Graph<T> g, Vertex<T> source) {
    if (g.isOriented() || !g.isWeighted())
      throw new Error("Graph must be weighted and not oriented!");
    int vSize = g.getNumberOfVertices();
    // list of tree edges
    ArrayList<Edge<T>> mst = new ArrayList<Edge<T>>(vSize);
    // retrieves u.pi property as an Edge(u.pi, u)
    HashMap<Vertex<T>,Edge<T>> pi = new HashMap<Vertex<T>,Edge<T>>(vSize);
    Heap<Double,Vertex<T>> queue = new Heap<Double,Vertex<T>>(false, vSize);
    for (int i = 0;i < vSize;i++) {
      queue.insert(Double.POSITIVE_INFINITY, g.vertices.get(i));
    }
    queue.changeKey(source, 0.0);
    while (queue.size() > 0) {
      Double key = queue.getFirstKey();
      Vertex<T> u = queue.extract();
      Edge<T> from = pi.get(u);
      if (key == Double.POSITIVE_INFINITY) {
        continue;
      }
      if (from != null)
        mst.add(from);
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
    return mst;
  }

}
