import java.util.*;

public class EsercizioUno {

  public static <T extends Comparable<T>> void insertionSort(ArrayList<T> array) {
    if (array == null || array.size() <= 1) {
      return;
    }
    else {
      for (int i = 1; i < array.size(); i++) {
        T value = array.get(i);
        int j = i - 1;
        while (j >= 0 && array.get(j).compareTo(value) > 0) {
          array.set(j+1, array.get(j));
          j--;
        }
        array.set(j+1, value);
      }
    }
  }
}
