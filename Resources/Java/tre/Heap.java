package tre;

import java.util.*;

/*
  This class implements a Heap object with these properties:
  - max/min choice
  - Key type must be implements Comparable
  - contains, getKey and size methods run in O(1)
  - insert, extract and changeKey run in O(logN)
*/

public class Heap<K extends Comparable<K>,V> {
  /*
    E class is only used privately
    public methods will interact through V and K types
  */
  private class E implements Comparable<E>{
    K key;
    V value;

    public E(V v, K k) {
      key = k;
      value = v;
    }

    public int compareTo(E obj) {
      int a = key.compareTo(obj.key);
      return max ? a : -a;
    }

    public String toString() {
      String r = "{ " + key.toString() + " : " + value.toString() + " }";
      return r;
    }
  }

  private final boolean max;
  protected ArrayList<E> h;
  /*
    this HashMap is needed to change keys in O(logN)
    and retrieve keys in O(1)
  */
  protected HashMap<V,Integer> indexes;

  public Heap(boolean m) {
    max = m;
    h = new ArrayList<E>();
    indexes = new HashMap<V,Integer>();
  }

  public Heap(boolean m, int size) {
    max = m;
    h = new ArrayList<E>(size);
    indexes = new HashMap<V,Integer>(size);
  }

  public boolean isMaxHeap() {
    return max;
  }

  public boolean contains(V value) {
    return indexes.containsKey(value);
  }

  public K getKey(V value) {
    return h.get(indexes.get(value)).key;
  }

  public void changeKey(V value, K newKey) {
    int i = indexes.get(value);
    h.set(i, new E(value, newKey));
    heapifyUp(i);
    heapifyDown(i);
  }

  // checks property H[i] >= H[left(i)], H[right(i)]
  protected boolean isHeap() {
    if (h.size() == 0)
      return true;
    return isHeap(0);
  }

  public void insert(K key, V value) {
    int i = h.size();
    h.add(new E(value, key));
    indexes.put(value,i);
    heapifyUp(i);
  }

  public V extract() {
    if (h.size() == 0)
      return null;
    E first = h.get(0);
    E last = h.get(h.size()-1);
    exchange(0,h.size()-1);
    h.remove(h.size()-1);
    indexes.remove(first.value);
    heapifyDown(0);
    return first.value;
  }

  public int size() {
    return h.size();
  }

  private void heapifyDown(int i) {
    int largest = i;
    if (h.get(largest).compareTo(h.get(left(i))) < 0) largest = left(i);
    if (h.get(largest).compareTo(h.get(right(i))) < 0) largest = right(i);
    if (largest != i) {
      exchange(largest, i);
      heapifyDown(largest);
    }
  }

  private void heapifyUp(int i) {
    while (i > 0 && h.get(parent(i)).compareTo(h.get(i)) < 0) {
      exchange(i, parent(i));
      i = parent(i);
    }
  }

  private int parent(int i) {
    return ((i+1) >> 1)-1;
  }

  private int left(int i) {
    int r = ((i+1) << 1)-1;
    return r < h.size() ? r : i;
  }

  private int right(int i) {
    int r = ((i+1) << 1);
    return r < h.size() ? r : i;
  }

  private void exchange(int i, int j) {
    E temp = h.get(i);
    indexes.put(temp.value, j);
    indexes.put(h.get(j).value, i);
    h.set(i, h.get(j));
    h.set(j, temp);
  }

  public String toString() {
    if (h.size() == 0)
      return "[]";
    String r = "[";
    int i = 0;
    while (i < h.size()-1) {
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
