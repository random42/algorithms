package uno;

import java.io.*;
import java.util.*;

public class SortIntegers {
  public static void main(String[] args) {
    String path = "/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/integers.csv";
    ArrayList<Long> array = readIntegers(path);
    System.out.println("Array size: " + array.size());
    measureSort(array, "insertionSort");
    //measureSort(array, "mergeSortIterative");
    //ArrayList<Long> sorted = measureSort(array, "mergeSortRecursive");
    String outputPath = "/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/sorted_integers.csv";
    //writeIntegers(outputPath, sorted);
  }

  public static ArrayList<Long> measureSort(ArrayList<Long> array, String method) {
    ArrayList<Long> copy = new ArrayList<Long>(array);
    long startTime = System.currentTimeMillis();
    switch(method) {
      case "mergeSortIterative": {
        Utils.mergeSortIterative(copy);
        break;
      }
      case "mergeSortRecursive": {
        Utils.mergeSortRecursive(copy);
        break;
      }
      case "insertionSort": {
        Utils.insertionSort(copy);
        break;
      }
    }
    Utils.mergeSortIterative(copy);
    long endTime = System.currentTimeMillis();
    double seconds = (double)(endTime - startTime) / 60;
    System.out.println(method + " took " + seconds + " seconds");
    return copy;
  }

  public static void writeIntegers(String filePath, ArrayList<Long> array) {
    try {
      FileWriter output = new FileWriter(filePath);
      Iterator<Long> iterator = array.iterator();
      while (iterator.hasNext()) {
        output.write(iterator.next().toString() + "\n");
      }
      output.close();
    } catch(IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static ArrayList<Long> readIntegers(String filePath) {
    try {
      File integers = new File(filePath);
      Scanner input = new Scanner(integers);
      ArrayList<Long> array = new ArrayList<Long>();
      // setting delimiter between every integer
      input.useDelimiter("\n");
      // creating array
      //int i = 0;
      //int max = 10000;
      while (input.hasNextLong()) {
        array.add(input.nextLong());
        //i++;
      }
      // closing input read
      input.close();
      return array;
    } catch(IOException e) {
      System.out.println(e.getMessage());
      return null;
    }
  }
}
