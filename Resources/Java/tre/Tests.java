package tre;

import java.util.*;

class Tests {
  public static void main(String[] args) {
    priorityQueueTest();
    heapTest();
  }

  public static void priorityQueueTest() {
    // System.out.println("PriorityQueue Test");
    // // true per coda di massimo
    // PriorityQueue<String> a = new PriorityQueue<String>(false);
    // a.insert("ciao", 12);
    // a.insert("io",13);
    // a.insert("tu",0);
    // a.insert("egli",20);
    // a.insert("mai",9);
    // // System.out.println(a);
    // System.out.println(a.heap.isHeap());
    // System.out.println(a.extract().equals("tu"));
    // System.out.println(a.heap.isHeap());
  }

  public static void heapTest() {
    System.out.println("\n\nHeap Test\n");
    Heap<Integer,String> a = new Heap<Integer,String>(false,5);
    a.insert(12,"a");
    a.insert(3,"b");
    a.insert(222,"c");
    a.insert(23,"d");
    a.insert(42,"e");
    a.insert(1000,"f");
    a.insert(-1234,"g");
    a.insert(-23,"h");
    System.out.println(a.isHeap());
    a.extract();
    System.out.println(a.isHeap());
    a.extract();
    System.out.println(!a.contains("h") && a.contains("c"));
    a.changeKey("f",-1000); // should be in first position now
    System.out.println(a.isHeap());
    a.extract();
    System.out.println(a.isHeap());
    a.changeKey("a",-9000);
    System.out.println(a.isHeap());
  }
}
