package edu.ucalgary.oop;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class JavaStringsPattern {

  // regex pattern
  private final static Pattern SECRET_CODE_REGEX = Pattern.compile("(?i)[aeiou]", Pattern.CASE_INSENSITIVE);

  // getter method
  public static Pattern getSecretCodeRegex() {
    return SECRET_CODE_REGEX;
  }

  // trim whitespace and return length of concatenated strings
  public int addTogether(String a, String b) {
    String newStr = a.trim() + b.trim();
    return newStr.length();
  }

  // generate unique id
  public String idProcessing(String firstName, String lastName, String petName, int year) {
    // id = first letter of each string and concatenate the year
    return firstName.substring(0, 1) 
    + lastName.substring(0, 1)
    + petName.substring(0, 1)
    + String.valueOf(year);
  }

  // secret code replaces vowels with "z" and returns first 3 characters
  public String secretCode(String ingredient) {
    Matcher matcher = getSecretCodeRegex().matcher(ingredient);
    String secret = matcher.replaceAll("z");
    return secret.substring(0, 3);
  }

  // main method for testing
  public static void main(String args[]) {
    JavaStringsPattern myObject = new JavaStringsPattern();

    // Print out examples from addTogether.
    String oneExample = "12 4 6789";
    String twoExample = "abcdef gh";
    int theLength = myObject.addTogether(oneExample,twoExample);
    System.out.println(theLength);

    // Length is unchanged by adding whitespace to front and back
    oneExample = "   " + oneExample + "\n";
    twoExample = "\t" + twoExample;
    theLength = myObject.addTogether(oneExample,twoExample);
    System.out.println(theLength);

    // Print out example of idProcessing
    String personFirst = "Dorothy";
    String personLast = "Gale";
    String petName = "Toto";
    int petBirth = 1899;
    String theID = myObject.idProcessing(personFirst,personLast, petName,petBirth);
    System.out.println(theID);

    // Print out examples from secretCode
    String ingredientOne = "tomato";
    String ingredientTwo = "WATER";
    String theCode = myObject.secretCode(ingredientOne);
    System.out.println(theCode);
    theCode = myObject.secretCode(ingredientTwo);
    System.out.println(theCode);
  }
}
