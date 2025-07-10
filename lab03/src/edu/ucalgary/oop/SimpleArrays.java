package edu.ucalgary.oop;

import java.util.Arrays;

public class SimpleArrays {
  private String[] arr = new String[4]; 

  // constructor with string argument
  public SimpleArrays(String name) {
    Arrays.fill(this.arr, name); // fill array with string name given
  }

  // constructor with no argument
  public SimpleArrays() {
    Arrays.fill(this.arr, "Hello, world"); // fill array with "Hello, world"
  }

  // default index to 0 if no index is provided
  public String arrayConcat() {
    return this.arrayConcat(0);
  }

  // concat arrays from a starting index
  public String arrayConcat(int index) {
    if (index < 0 || index > (this.arr.length - 1)) {
      throw new IndexOutOfBoundsException("index is out of bounds");
    }

    // concat values from array from a starting index, separated by #
    String result = "";
    for (int i = index; i < this.arr.length; i++) {
      result += this.arr[i];
      if (i < this.arr.length - 1) {
        result += "#";
      }
    }

    return result;
  }

  // crop an array if between two indices
  public String arrayCrop(int start, int end) {
    
    // if end < start, swap vars 
    if (end < start) {
      int temp = start;
      start = end;
      end = temp;
    }
    
    if (start == end) {
      return "Match";
    }

    if (start < 0 || end >= this.arr.length) {
      return "Fail";
    }

    // concat values from array between the two indices, separated by #
    String result = "";
    for (int i = start; i <= end; i++) {
      result += this.arr[i];
      if (i < this.arr.length - 1) {
        result += "#";
      }
    }

    return result;
  }

  // Testing
  public static void main(String[] args){
    SimpleArrays myArray1 = new SimpleArrays();
    String foundResult1 = myArray1.arrayConcat();
    System.out.println(foundResult1);

    SimpleArrays myArray2 = new SimpleArrays();
    String foundResult2 = myArray2.arrayConcat(2);
    System.out.println(foundResult2);

    SimpleArrays myArray3 = new SimpleArrays("Hi you");
    String foundResult3 = myArray3.arrayConcat();
    System.out.println(foundResult3);

    SimpleArrays myArray4 = new SimpleArrays("Hi you");
    String foundResult4 = myArray4.arrayConcat(2);
    System.out.println(foundResult4);

    SimpleArrays myArray5 = new SimpleArrays("Hi you");
    String foundResult5 = myArray5.arrayCrop(0, 2);
    System.out.println(foundResult5);

    SimpleArrays myArray6 = new SimpleArrays("Hi you");
    String foundResult6 = myArray6.arrayCrop(3, 2);
    System.out.println(foundResult6);

    SimpleArrays myArray7 = new SimpleArrays("Hi you");
    String foundResult7 = myArray7.arrayCrop(0, 6);
    System.out.println(foundResult7);

    SimpleArrays myArray8 = new SimpleArrays("Hi you");
    String foundResult8 = myArray8.arrayCrop(3, 3);
    System.out.println(foundResult8);
  }
}
