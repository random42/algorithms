import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class EsercizioUnoTest {
  @Test
  public void testInsertionSort() {
    List<Integer> array = Arrays.asList(1,5,7,2,4,800,35,12,3);
    List<Integer> sorted = Arrays.asList(1,2,3,4,5,7,12,35,800);
    ArrayList<Integer> list = new ArrayList<Integer>(9);
    list.addAll(array);
    EsercizioUno.insertionSort(list);
    assertEquals(sorted, list);
  }
}
