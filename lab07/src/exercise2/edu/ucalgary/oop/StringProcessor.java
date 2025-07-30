package exercise2.edu.ucalgary.oop;

import java.time.LocalDate;

public class StringProcessor{
    
  private final String storedString;
    
  public StringProcessor(String input){
    this.storedString = new String(input);
  }

  public String getStoredString(){
    return this.storedString;
  }
  
  public String addTogetherMirror(String inputString) {
    String combined = storedString.strip() + inputString.strip();
    combined = combined.toLowerCase();
    
    String reversed = "";
    for (int i = combined.length() - 1; i >= 0; i--) {
      reversed += combined.charAt(i);
    }
    return reversed;
  }

  public static String idProcessing(String firstName, String lastName, String petName, int year) {
    int currentYear = LocalDate.now().getYear();

    if (year > currentYear) {
      throw new IllegalArgumentException("Pet year of birth cannot be in the future.");
    }

    if (year > 2021) {
      throw new IllegalArgumentException("Pet year of birth cannot be after December 2021.");
    }

    String namePattern = "^[A-Z][a-zA-Z'’`\\-\\. ]{1,25}$";

    if (!firstName.matches(namePattern) || !lastName.matches(namePattern) || !petName.matches(namePattern)) {
      throw new IllegalArgumentException("Names must start with a capital letter and be 2-26 letters long.");
    }

    String petID = new String(
      String.valueOf(firstName.charAt(0)) + 
      String.valueOf(lastName.charAt(0)) + 
      String.valueOf(petName.charAt(0)) + 
      String.valueOf(year)
    );
    return petID;
  }

  public String secretCode(int offset) {
    String encodedString = "";
    
    for (int i = 0; i < storedString.length(); i++) {
      char c = storedString.charAt(i);
      char shiftedChar = c;

      if (c >= 'A' && c <= 'Z') {
        int shiftedIndex = (c - 'A' + offset) % 26;
        if (shiftedIndex < 0) shiftedIndex += 26;
        shiftedChar = (char)('A' + shiftedIndex);
      }

      else if (c >= 'a' && c <= 'z') {
        int shiftedIndex = (c - 'a' + offset) % 26;
        if (shiftedIndex < 0) shiftedIndex += 26;
        shiftedChar = (char)('a' + shiftedIndex);
      }

      encodedString += shiftedChar;
    }
    
    return encodedString;
  }
}