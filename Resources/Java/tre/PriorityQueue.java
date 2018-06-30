package tre;

import java.util.*;

public class PriorityQueue<K extends Comparable<K>,V> {
  static class Element {
    K key;
    V value;

    public Element(K k, V v) {
      key = k;
      value = v;
    }
  }
  final boolean max;
  private Heap<QueueElement<T>> heap;

  public PriorityQueue(boolean max) {
    heap = new Heap<QueueElement<T>>();
    this.max = max;
    indexes = new HashMap<V,Integer>();
  }

  public PriorityQueue(boolean max, int size) {
    heap = new Heap<QueueElement<T>>(size);
    this.max = max;
    indexes = new HashMap<V,Integer>(size);
  }

  public void insert(QueueElement<T> e) {
    heap.insert(e);
  }

  public void insert(T elem, double priority) {
    if (!max) priority = -priority;
    QueueElement<T> q = new QueueElement<T>(elem, priority);
    heap.insert(q);
  }

  public boolean contains(T e) {

  }

  public void changePriority(int index, double priority) {

  }

  public T extract() {
    return heap.extractMax().elem;
  }

  public T maximum() {
    return heap.heapSize > 0 ? heap.h.get(0).elem : null;
  }

  public int length() {
    return heap.heapSize;
  }

  public String toString() {
    return heap.toString();
  }
}
