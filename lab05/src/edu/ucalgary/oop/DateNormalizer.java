package edu.ucalgary.oop;

import java.util.regex.*;

public class DateNormalizer {
  
  /**
   * Normalizes a date-like string to the format yyyy-mm-dd.
   * Accepts inputs in formats like yyyy-mm-dd, yyyy.mm.dd, dd-mm-yyyy, or dd.mm.yyyy.
   * If input doesn't match any supported format, returns an empty string.
  */
  public static String normalizeDate(String initialDate) {
    String dateRegex = "^(\\d{4})[-.](\\d{2})[-.](\\d{2})$"; // for dates in correct format
    String reversedDateRegex = "^(\\d{2})[-.](\\d{2})[-.](\\d{4})$"; // for dates in reversed format
    String normalizedDate = "$1-$2-$3"; // pattern to normalize
    String reversedNormalizedDate = "$3-$2-$1"; // pattern to normalize reversed formats

    if (Pattern.matches(dateRegex, initialDate)) {
      return initialDate.replaceAll(dateRegex, normalizedDate);
    } 
    
    else if (Pattern.matches(reversedDateRegex, initialDate)) {
      return initialDate.replaceAll(reversedDateRegex, reversedNormalizedDate);
    }

    else {
      return "";
    }
  }

  // main method for testing
  public static void main(String[] args) {
    System.out.println("Example input 1: 2021-12-16");
    System.out.println("Expected output: 2021-12-16");
    System.out.println("Output: " + normalizeDate("2021-12-16") + "\n");

    System.out.println("Example input 1: 2022.01.15");
    System.out.println("Expected output: 2022-01-15");
    System.out.println("Output: " + normalizeDate("2022.01.15") + "\n");

    System.out.println("Example input 1: 15-01-2022");
    System.out.println("Expected output: 2022-01-15");
    System.out.println("Output: " + normalizeDate("15-01-2022") + "\n");

    System.out.println("Example input 1: 16.12.2021");
    System.out.println("Expected output: 2021-12-16");
    System.out.println("Output: " + normalizeDate("16.12.2021") + "\n");

    System.out.println("Example input 1: 14.32.2021");
    System.out.println("Expected output: 2021-32-14");
    System.out.println("Output: " + normalizeDate("14.32.2021") + "\n");

    System.out.println("Example input 1: 3 Jan 2022");
    System.out.println("Expected output: ");
    System.out.println("Output: " + normalizeDate("3 Jan 2022"));
  }
}
