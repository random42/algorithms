package quattro;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class Tests {
  @Test
  public void basicMethods() {
    Graph<String> g = new Graph<String>(false, true);
    g.addVertex("ciao");
    g.addVertex("mamma");
    g.addVertex("dio");
    g.addEdge("ciao", "mamma", 123);
    g.addEdge("mamma", "mamma", 1);
    g.addEdge("dio", "ciao", 3);
    assertEquals(g.getNumberOfEdges(),3);
    assertEquals(g.getNumberOfVertices(),3);
    g.removeVertex("ciao");
    assertEquals(g.getNumberOfEdges(),1);
    assertEquals(g.getNumberOfVertices(),2);
  }

}
