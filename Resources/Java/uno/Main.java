package uno;

import java.util.*;
import java.io.*;

/*


*/

public class Main {

  public static void main(String[] args) {
    sortIntegers();
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
      // setting delimiter char between every integer
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

  public static void findSums(ArrayList<Long> integers) {
    ArrayList<Long> sums = readIntegers("/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/sums.txt");
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

  public static void sortIntegers() {
    System.out.println("Reading integers...");
    String path = "/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/integers.csv";
    ArrayList<Long> array = readIntegers(path);
    System.out.println("Array length: " + array.size());
    System.out.println("\nSorting array...\n");
    measureSort(array, "insertionSort");
    measureSort(array, "mergeSortIterative");
    ArrayList<Long> sorted = measureSort(array, "mergeSortRecursive");
    System.out.println("\nWriting sorted integers to file \"sorted_integers.csv\"");
    String outputPath = "/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/sorted_integers.csv";
    writeIntegers(outputPath, sorted);
    System.out.println("\nFinding sums...\n");
    findSums(array);
  }
}
