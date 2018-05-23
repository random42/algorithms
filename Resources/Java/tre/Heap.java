package tre;

public class Heap<T extends Comparable<T>> {
  public T[] h;
  public int heapSize;

  public static void exchange(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void buildHeap() {

  }

  public Heap() {
    h = new int[10];
    heapSize = 0;
  }

  public Heap(int size) {
    h = new int[size];
    heapSize = 0;
  }

  public boolean isHeap() {
    int depth = heapSize
  }

  public void insert(int e) {
    if (heapSize == h.length) return;
    int i = heapSize++;
    h[i] = e;
    while (i > 0 && h[parent(i)] < h[i]) {
      exchange(h, i, parent(i));
      i = parent(i);
    }
  }

  public int extractMaximum() {
    if (heapSize == 0)
      return 0;
    int r = h[0];
    h[0] = h[--heapSize];
    heapify(0);
    return r;
  }

  private void heapify(int i) {
    int largest = i;
    if (h[largest] < h[left(i)]) largest = left(i);
    if (h[largest] < h[right(i)]) largest = right(i);
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
    if (heapSize == 0) {
      return "[]";
    }
    String a = "[";
    int i = 0;
    for (; i < heapSize -1;i++) {
      a = a.concat(h[i] + ",");
    }
    a = a.concat(h[i] + "]");
    return a;
  }

  private static int logCeil(int base, int arg) {
    int i = 0;
    while (Math.pow(base, i) <=)
  }
}
