package edu.ucalgary.oop;

public class JavaStrings {
  public static void main(String[] args) {
    String myString = "ENSF Principles of Software Development";

    // count 'E' and 'e' using regex
    int eCount = myString.replaceAll("[^Ee]", "").length();
    System.out.println("Number of E's and e's: " + eCount);

    // split the string and print each token
    String[] tokens = myString.split(" ");
    System.out.println("\nTokens:");
    for (String token : tokens) {
      System.out.println(token);
    }
    System.out.println("Total tokens: " + tokens.length);

    // use StringBuilder to insert colon after "ENSF"
    StringBuilder updatedString = new StringBuilder(myString);
    int insertPosition = myString.indexOf("ENSF") + "ENSF".length();
    updatedString.insert(insertPosition, ":");
    System.out.println("\nUpdated string: " + updatedString);
  }
}
