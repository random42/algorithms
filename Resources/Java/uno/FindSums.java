package uno;

import java.util.*;

/*
  

*/

public class FindSums {
  public static void main(String[] args) {
    ArrayList<Long> integers = SortIntegers.readIntegers("/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/integers.csv");
    ArrayList<Long> sums = SortIntegers.readIntegers("/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/sums.txt");
    Iterator<Long> iterator = sums.iterator();
    long startTime = System.currentTimeMillis();
    while (iterator.hasNext()) {
      long value = iterator.next();
      System.out.print(value + " => ");
      System.out.println(Utils.containsSum(integers, value));
    }
    long endTime = System.currentTimeMillis();
    double seconds = (double)(endTime - startTime) / 60;
    System.out.println("Finding sums took " + seconds + " seconds");
  }
}
