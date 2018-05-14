package uno;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class Tests {
  @Test
  public void insertionSort() {
    List<Integer> list = Arrays.asList(1,5,7,2,4,800,35,12,3);
    List<Integer> sorted = Arrays.asList(1,2,3,4,5,7,12,35,800);
    ArrayList<Integer> array = new ArrayList<Integer>(list);
    Utils.insertionSort(array);
    assertEquals(sorted, array);
  }

  @Test
  public void mergeSortIterative() {
    List<Integer> list = Arrays.asList(13,12,20,100,1,-30,23,11,9,30);
    List<Integer> sorted = Arrays.asList(-30,1,9,11,12,13,20,23,30,100);
    ArrayList<Integer> array = new ArrayList<Integer>(list);
    Utils.mergeSortIterative(array);
    assertEquals(sorted, array);
  }

  @Test
  public void mergeSortRecursive() {
    List<Integer> list = Arrays.asList(13,12,20,100,1,-30,23,11,9,30);
    List<Integer> sorted = Arrays.asList(-30,1,9,11,12,13,20,23,30,100);
    ArrayList<Integer> array = new ArrayList<Integer>(list);
    Utils.mergeSortRecursive(array);
    assertEquals(sorted, array);
  }

  @Test
  public void mergeTest() {
    ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(2,10,12,1,15,20,32,50,51));
    List<Integer> sorted = Arrays.asList(1,2,10,12,15,20,32,50,51);
    Utils.merge(a,0,9,3);
    //System.out.println(a);
    assertEquals(a,sorted);
  }
  
  @Test
  public void findSumsTest() {
    ArrayList<Long> array = new ArrayList<Long>(Arrays.asList(0l,2l,5l,6l,10l,12l,31l,90l,411l));
    assertEquals(Utils.containsSum(array, 411), true);
    assertEquals(Utils.containsSum(array, 412), false);
    assertEquals(Utils.containsSum(array, 15), true);
    assertEquals(Utils.containsSum(array, 90+31), true);
    assertEquals(Utils.containsSum(array, 12+11), false);
  }
}
