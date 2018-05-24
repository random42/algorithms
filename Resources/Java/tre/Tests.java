package tre;

import java.util.*;

class Tests {
  public static void main(String[] args) {
    heapTest();
  }

  public static void heapTest() {
    System.out.println("\n\nHeap Test\n");
    Heap<Integer> a = new Heap<Integer>();
    a.insert(12);
    a.insert(3);
    a.insert(222);
    a.insert(23);
    a.insert(42);
    System.out.println(a.isHeap());
    a.extractMaximum();
    System.out.println(a.isHeap());
    a.extractMaximum();
    System.out.println(a.isHeap());
    a.extractMaximum();
    System.out.println(a.isHeap());
  }
}
