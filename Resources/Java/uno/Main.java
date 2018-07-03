package uno;

import java.util.*;
import java.io.*;

/*


*/

public class Main {

  public static void main(String[] args) {
    String path = "../../datasets/integers.csv";
    System.out.println("Reading integers from \"" + path + "\"");
    ArrayList<Long> array = readIntegers(path);
    System.out.println("Array length: " + array.size());
    System.out.println("\nSorting array...\n");
    // insertionSort takes too much time, I'll let your CPU live one more day
    // measureSort(array, "insertionSort");
    measureSort(array, "mergeSortIterative");
    ArrayList<Long> sorted = measureSort(array, "mergeSortRecursive");
    String outputPath = "../../datasets/sorted_integers.csv";
    System.out.println("\nWriting sorted integers to \"" + outputPath + "\"");
    writeIntegers(outputPath, sorted);
    findSums(array);
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
    double seconds = (double)(endTime - startTime) / 1000;
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
    }
    catch(IOException e) {
      throw new Error("File not found!\nPath: " + filePath);
    }
  }

  public static void findSums(ArrayList<Long> integers) {
    System.out.println("\nFinding sums...\n");
    ArrayList<Long> sums = readIntegers("../../datasets/sums.txt");
    Iterator<Long> iterator = sums.iterator();
    long startTime = System.currentTimeMillis();
    int i = 0;
    while (iterator.hasNext()) {
      i++;
      long value = iterator.next();
      System.out.print(value + " => ");
      System.out.println(Utils.containsSum(integers, value));
    }
    long endTime = System.currentTimeMillis();
    double seconds = (double)(endTime - startTime) / 1000;
    System.out.println("Finding sums took " + seconds + " seconds");
    System.out.println("On average took " + seconds/(double)i + " seconds per number");
  }
}
