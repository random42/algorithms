package quattro;

import java.util.Scanner;
import java.io.*;

public class Main {
  public static void main(String[] args) {
    try {
      System.out.println("Reading csv file...");
      Graph<String> g = readCsv("/Users/random/Code/uni/laboratorio-algoritmi-2017-18/datasets/italian_dist_graph.csv");
      System.out.println(
        "Vertices: " + g.getNumberOfVertices() +
        "\nEdges: " + g.getNumberOfEdges() +
        "\nWeight: " + g.getWeight()
      );
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static Graph<String> readCsv(String path) throws FileNotFoundException {
    Graph<String> graph = new Graph<String>(false, true);
    Scanner input = new Scanner(new File(path));
    while (input.hasNextLine()) {
      String line = input.nextLine();
      String[] record = line.split(",");
      graph.addEdge(record[0],record[1], Double.parseDouble(record[2]));
    }
    return graph;
  }
}
