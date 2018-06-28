package tre;


public class PriorityQueue<T> {
  boolean max;
  Heap<QueueElement<T>> heap;

  public PriorityQueue(boolean max) {
    heap = new Heap<QueueElement<T>>();
    this.max = max;
  }

  public void insert(QueueElement<T> e) {
    heap.insert(e);
  }

  public void insert(T elem, int priority) {
    if (!max) priority = -priority;
    QueueElement<T> q = new QueueElement<T>(elem, priority);
    heap.insert(q);
  }

  public T extractMaximum() {
    return heap.extractMaximum().elem;
  }

  public T maximum() {
    return heap.heapSize > 0 ? heap.h.get(0).elem : null;
  }

  public String toString() {
    return heap.toString();
  }
}
