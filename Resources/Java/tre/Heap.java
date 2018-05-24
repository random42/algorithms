package tre;

import java.util.*;

public class Heap<T extends Comparable<T>> {
  public ArrayList<T> h;
  public int heapSize;

  public static <T extends Comparable<T>> void exchange(ArrayList<T> arr, int i, int j) {
    T temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }

  public static void buildHeap() {

  }

  public Heap() {
    h = new ArrayList<T>();
    heapSize = 0;
  }

  public Heap(int size) {
    h = new ArrayList<T>(size);
    heapSize = 0;
  }

  // checks property H[i] >= H[left(i)], H[right(i)]
  // and checks tree depth
  protected boolean isHeap() {
    if (heapSize == 0)
      return true;
    return isHeap(0);
  }

  public void insert(T e) {
    int i = heapSize++;
    h.add(i, e);
    while (i > 0 && h.get(parent(i)).compareTo(h.get(i)) < 0) {
      exchange(h, i, parent(i));
      i = parent(i);
    }
  }

  public T extractMaximum() {
    if (heapSize == 0)
      return null;
    T r = h.get(0);
    h.set(0, h.get(--heapSize));
    heapify(0);
    return r;
  }

  private void heapify(int i) {
    int largest = i;
    if (h.get(largest).compareTo(h.get(left(i))) < 0) largest = left(i);
    if (h.get(largest).compareTo(h.get(right(i))) < 0) largest = right(i);
    if (largest != i) {
      exchange(h, largest, i);
      heapify(largest);
    }
  }

  private int parent(int i) {
    return ((i+1) >> 1)-1;
  }

  private int left(int i) {
    int r = ((i+1) << 1)-1;
    return r < heapSize ? r : i;
  }

  private int right(int i) {
    int r = ((i+1) << 1);
    return r < heapSize ? r : i;
  }

  public String toString() {
    if (heapSize == 0)
      return "[]";
    String r = "[";
    int i = 0;
    while (i < heapSize-1) {
      r = r.concat(h.get(i).toString() + ",");
      i++;
    }
    r = r.concat(h.get(i).toString() + "]");
    return r;
  }

  private boolean isHeap(int i) {
    boolean order =
      h.get(i).compareTo(h.get(left(i))) >= 0 &&
      h.get(i).compareTo(h.get(right(i))) >= 0;
    if (left(i) != i) {
      order = order && isHeap(left(i));
    }
    if (right(i) != i) {
      order = order && isHeap(right(i));
    }
    return order;
  }
}
