package tre;


public class PriorityQueue<T> {
  Heap<QueueElement<T>> heap;

  public PriorityQueue() {
    heap = new Heap<QueueElement<T>>();
  }

  public void insert(QueueElement<T> e) {
    heap.insert(e);
  }

  public void insert(T elem, int priority) {
    QueueElement<T> q = new QueueElement<T>(elem, priority);
    heap.insert(q);
  }

  public QueueElement<T> extractMaximum() {
    return heap.extractMaximum();
  }

  public QueueElement<T> maximum() {
    return heap.heapSize > 0 ? heap.h.get(0) : null;
  }

  public String toString() {
    return heap.toString();
  }
}
