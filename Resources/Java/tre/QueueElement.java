package tre;

public class QueueElement<T> implements Comparable<QueueElement<T>>{
  T elem;
  int priority;

  public QueueElement(T e, int p) {
    elem = e;
    priority = p;
  }

  public int compareTo(QueueElement<T> o) {
    return this.priority - o.priority;
  }

  public String toString() {
    String r = "{";
    r = r.concat(elem.toString() + ", ");
    r = r.concat(Integer.toString(priority) + "}");
    return r;
  }
}
