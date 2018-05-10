import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class EsercizioUnoTest {
  @Test
  public void insertionSortInteger() {
    List<Integer> list = Arrays.asList(1,5,7,2,4,800,35,12,3);
    List<Integer> sorted = Arrays.asList(1,2,3,4,5,7,12,35,800);
    ArrayList<Integer> array = new ArrayList<Integer>(list);
    EsercizioUno.insertionSort(array);
    assertEquals(sorted, array);
  }

  @Test
  public void insertionSortString() {
    List<String> list = Arrays.asList("bacco","dodici","a","aaaa","zeta");
    List<String> sorted = Arrays.asList("a","aaaa","bacco","dodici","zeta");
    ArrayList<String> array = new ArrayList<String>(list);
    EsercizioUno.insertionSort(array);
    assertEquals(sorted, array);
  }

  @Test
  public void mergeSortInteger() {
    List<Integer> list = Arrays.asList(13,12,20,100,1,-30,23,11,9,30);
    List<Integer> sorted = Arrays.asList(-30,1,9,11,12,13,20,23,30,100);
    ArrayList<Integer> array = new ArrayList<Integer>(list);
    EsercizioUno.mergeSort(array);
    assertEquals(sorted, array);
  }

  @Test
  public void mergeSortString() {
    List<String> list = Arrays.asList("bacco","dodici","a","aaaa","zeta");
    List<String> sorted = Arrays.asList("a","aaaa","bacco","dodici","zeta");
    ArrayList<String> array = new ArrayList<String>(list);
    EsercizioUno.mergeSort(array);
    assertEquals(sorted, array);
  }

  @Test
  public void mergeTest() {
    ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(2,10,12,1,15,20));
    List<Integer> sorted = Arrays.asList(1,2,10,12,15,20);
    EsercizioUno.merge(a,0,6,3);
    assertEquals(a,sorted);
  }
}
