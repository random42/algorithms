package tre;


public class PriorityQueue<T> {
  final boolean max;
  private Heap<QueueElement<T>> heap;

  public PriorityQueue(boolean max) {
    heap = new Heap<QueueElement<T>>();
    this.max = max;
  }

  public void insert(QueueElement<T> e) {
    heap.insert(e);
  }

  public void insert(T elem, double priority) {
    if (!max) priority = -priority;
    QueueElement<T> q = new QueueElement<T>(elem, priority);
    heap.insert(q);
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
