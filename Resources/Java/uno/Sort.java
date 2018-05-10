package uno;

import java.util.*;

public class Sort {

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

  public static <T extends Comparable<T>> void mergeSortIterative(ArrayList<T> array) {
    if (array == null || array.size() == 0) {
      return;
    }
    else {
      int length = array.size();
      int subLength = 2;
      int left = length - 2;
      int right = length;
      boolean end = false;
      while (!end) {
        end = subLength >= length;
        while (right > 0) {
          if (left < 0) left = 0;
          if (right - left > subLength / 2) {
            int center = right - subLength/2;
            merge(array,left,right,center);
          }
          left -= subLength;
          right -= subLength;
        }
        subLength = subLength << 1;
        right = length;
        left = right - subLength;
      }
    }
  }

  public static <T extends Comparable<T>> void mergeSortRecursive(ArrayList<T> array) {
    if (array == null) {
      return;
    } else {
      mergeSortRecursive(array,0,array.size());
    }
  }

  protected static <T extends Comparable<T>> void mergeSortRecursive(ArrayList<T> array, int left, int right) {
    if (left + 1 < right) {
      int center = (right + left) / 2;
      mergeSortRecursive(array,left,center);
      mergeSortRecursive(array,center,right);
      merge(array,left,right,center);
      //System.out.println(array);
    }
  }

  protected static <T extends Comparable<T>> void merge(ArrayList<T> array, int left, int right, int center) {
    ArrayList<T> temp = new ArrayList<T>(array.subList(left,right));
    center -= left;
    int length = right - left;
    int firstCursor = 0;
    int secCursor = center;
    for (int i = left; i < right;i++) {
      // if cursors are valid compare
      if (firstCursor < center && secCursor < length) {
        if (temp.get(secCursor).compareTo(temp.get(firstCursor)) > 0) {
          array.set(i, temp.get(firstCursor++));
        } else {
          array.set(i, temp.get(secCursor++));
        }
      }
      // else use valid cursor
      else {
        if (firstCursor == center) {
          array.set(i, temp.get(secCursor++));
        } else {
          array.set(i, temp.get(firstCursor++));
        }
      }
    }
  }
}
