package edu.ucalgary.oop;

/**
@author Kris Ranganathan <a href="mailto:kris.ranganathan@ucalgary.ca">
kris.ranganathan@ucalgary.ca</a>
@version 1.2
@since 1.0
*/
/*
Hello is a simple program which prints all primitive data types, explicit, and implicit casting
*/

public class Hello {
  public static void main(String[] args) {
    /**
      This prints all primitive data types in java
      @param args Optional command-line argument
    */
    boolean flag = true;
    char character = 's';
    byte var1 = 5;
    short var2 = 30000;
    int var3 = -2000;
    long var4 = 12345678912345L;
    float var5 = 2.00e16f;
    double var6 = 4.93e8;

    System.out.println("boolean: " + flag);
    System.out.println("character: " + character);
    System.out.println("var1: " + var1);
    System.out.println("var2: " + var2);
    System.out.println("var3: " + var3);
    System.out.println("var4: " + var4);
    System.out.println("var5: " + var5);
    System.out.println("var6: " + var6);

    // automatic cast
    double doubVar3 = var3;
    System.out.println("automatic cast: " + doubVar3);

    // explicit cast
    int intVar6 = (int) var6;
    System.out.println("explicit cast: " + intVar6);
  }
} // End of class declaration
