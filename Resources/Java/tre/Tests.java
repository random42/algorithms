package tre;

import java.util.*;

class Tests {
  public static void main(String[] args) {
    priorityQueueTest();
  }

  public static void priorityQueueTest() {
    // true per coda di massimo
    PriorityQueue<String> a = new PriorityQueue<String>(false);
    a.insert("ciao", 12);
    a.insert("io",13);
    a.insert("tu",0);
    a.insert("egli",20);
    a.insert("mai",9);
    //System.out.println(a);
    System.out.println(a.heap.isHeap());
    System.out.println(a.extractMaximum().equals("tu"));
    System.out.println(a.heap.isHeap());
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
