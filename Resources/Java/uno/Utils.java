package uno;

import java.util.*;
public class Utils {
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
    }
  }

  protected static <T extends Comparable<T>> void merge(ArrayList<T> array, int left, int right, int center) {
    ArrayList<T> temp = new ArrayList<T>(array.subList(left,right));
    center -= left;
    int length = right - left;
    int firstHalf = 0;
    int secHalf = center;
    int i = left;
    while (firstHalf < center && secHalf < length) {
      if (temp.get(secHalf).compareTo(temp.get(firstHalf)) > 0) {
        array.set(i++, temp.get(firstHalf++));
      } else {
        array.set(i++, temp.get(secHalf++));
      }
    }
    while (firstHalf < center) {
      array.set(i++, temp.get(firstHalf++));
    }
    while (secHalf < length) {
      array.set(i++, temp.get(secHalf++));
    }
  }

  public static boolean containsSum(ArrayList<Long> array, long sum) {
    if (array == null || array.size() < 2) {
      return false;
    }
    // sort array first
    array = new ArrayList<Long>(array);
    mergeSortRecursive(array);
    int length = array.size();
    int i = 0;
    int j = length - 1;
    long left = array.get(i);
    long right = array.get(j);
    boolean found = left + right == sum;
    while (!found && i < j) {
      if (left + right > sum) {
        right = array.get(--j);
      }
      else if (left + right < sum) {
        left = array.get(++i);
      }
      else {
        found = true;
      }
    }
    return found;
  }
}
