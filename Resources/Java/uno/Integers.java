package uno;

import java.io.*;
import java.util.*;

public class Integers {
  public static void main(String[] args) {
    String path = "/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/integers.csv";
    ArrayList<Long> array = readIntegers(path);
    System.out.println("Array size: " + array.size());
    System.out.println("Sorting array");
    long startTime = System.currentTimeMillis();
    Sort.mergeSortIterative(array);
    long endTime = System.currentTimeMillis();
    double seconds = (double)(endTime - startTime) / 60;
    System.out.println("Sorting took " + seconds + " seconds");
    String outputPath = "/Users/random/code/uni/laboratorio-algoritmi-2017-18/datasets/sorted_integers.csv";
    writeIntegers(outputPath, array);
  }

  public static void writeIntegers(String filePath, ArrayList<Long> array) {
    try {
      FileWriter output = new FileWriter(filePath);
      Iterator<Long> iterator = array.iterator();
      while (iterator.hasNext()) {
        output.write(iterator.next().toString() + "\n");
      }
      output.close();
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public static ArrayList<Long> readIntegers(String filePath) {
    try {
      System.out.println("Loading integers file");
      File integers = new File(filePath);
      Scanner input = new Scanner(integers);
      ArrayList<Long> array = new ArrayList<Long>();
      // setting delimiter between every integer
      input.useDelimiter("\n");
      // creating array
      System.out.println("Creating array");
      while (input.hasNextLong()) {
        array.add(input.nextLong());
      }
      // closing input read
      input.close();
      return array;
    } catch(Exception e) {
      System.out.println(e);
      return null;
    }
  }
}
