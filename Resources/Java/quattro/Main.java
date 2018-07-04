package quattro;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    System.out.println("Reading csv file...");
    Graph<String> g = readCsv("../../datasets/italian_dist_graph.csv");
    System.out.println(
      "\nGraph stats\n" +
      "\nVertices: " + g.getNumberOfVertices() +
      "\nEdges: " + g.getNumberOfEdges() +
      "\nWeight: " + g.getWeight() +
      "\n\nMinimum spanning forest\n"
    );
    ArrayList<ArrayList<Edge<String>>> msf = Algorithms.msfPrim(g);
    int edges = 0; double weight = 0;
    for (int i = 0; i < msf.size(); i++) {
      ArrayList<Edge<String>> mst = msf.get(i);
      edges += mst.size();
      weight += mstWeight(mst);
      printMstStats(msf.get(i));
    }
    System.out.println("\nForest:\nEdges: " + edges + "\nWeight: " + weight);
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
    catch(IOException e) {
      throw new Error("File not found!\nPath: " + path);
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

  public static <T> void printMstStats(ArrayList<Edge<T>> mst) {
    System.out.println(
      "\nMinimum spanning tree" +
      "\nEdges: " + mst.size() +
      "\nWeight: " + mstWeight(mst)
    );
  }
}
