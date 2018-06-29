package tre;

public class QueueElement<T> implements Comparable<QueueElement<T>>{
  T elem;
  double priority;

  public QueueElement(T e, double p) {
    elem = e;
    priority = p;
  }

  public int compareTo(QueueElement<T> o) {
    if (priority > o.priority) return 1;
    else if (priority == o.priority) return 0;
    else return -1;
  }

  public String toString() {
    String r = "{";
    r = r.concat(elem.toString() + ", ");
    r = r.concat(Double.toString(priority) + "}");
    return r;
  }
}
