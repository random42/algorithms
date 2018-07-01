package quattro;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Reading csv file...");
    Graph<String> g = readCsv("/Users/random/Code/uni/laboratorio-algoritmi-2017-18/datasets/italian_dist_graph.csv");
    System.out.println(
      "Graph stats" +
      "\nVertices: " + g.getNumberOfVertices() +
      "\nEdges: " + g.getNumberOfEdges() +
      "\nWeight: " + g.getWeight()
    );
    ArrayList<Edge<String>> mst = Algorithms.MstPrim(g);
    System.out.println(
      "\nMinimum spanning tree" +
      "\nEdges: " + mst.size() +
      "\nWeight: " + mstWeight(mst)
    );
  }

  public static Graph<String> readCsv(String path) {
    try {
      Graph<String> graph = new Graph<String>(false, true);
      Scanner input = new Scanner(new File(path));
      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[] record = line.split(",");
        graph.addEdge(record[0],record[1], Double.parseDouble(record[2]));
      }
      return graph;
    }
    catch(Exception e) {
      return null;
    }
  }

  public static <T> double mstWeight(ArrayList<Edge<T>> mst) {
    double w = 0.0;
    Iterator<Edge<T>> i = mst.iterator();
    while (i.hasNext()) {
      w += i.next().getWeight();
    }
    return w;
  }
}
