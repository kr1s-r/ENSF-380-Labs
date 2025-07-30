package exercise2.edu.ucalgary.oop;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.LocalDate;

public class StringProcessorTest {

  @Test
  public void testGetStoredString() {
    StringProcessor sp = new StringProcessor("testing");
    assertEquals("testing", sp.getStoredString());
  }

  @Test
  public void testAddTogetherMirror() {
    StringProcessor sp = new StringProcessor(" Hello ");
    String result = sp.addTogetherMirror(" World ");
    assertEquals("dlrowolleh", result);
  }

  @Test
  public void testValidIdProcessing() {
    String id = StringProcessor.idProcessing("Emma", "Doe", "Matthew", 2010);
    assertEquals("EDM2010", id);
  }

  /* Test boundary cases for number of letters */
  @Test
  public void testIdProcessingInvalidNameTooShort() {
    try {
      StringProcessor.idProcessing("E", "Doe", "Max", 2010);
      fail("Expected IllegalArgumentException for name too short.");
    } catch (IllegalArgumentException e) {
      assertEquals("Names must start with a capital letter and be 2-26 letters long.", e.getMessage());
    }
  }

  @Test
  public void testIdProcessingNameExactlyTwoLetters() {
    String id = StringProcessor.idProcessing("Em", "Doe", "Matthew", 2010);
    assertEquals("EDM2010", id);
  }

  @Test
  public void testIdProcessingNameExactly26Letters() {
    String name = "A".repeat(26);
    String id = StringProcessor.idProcessing("Emma", "Doe", name, 2016);
    assertEquals("EDA2016", id);
  }

  @Test
  public void testIdProcessingInvalidNameTooLong() {
    String name = "A".repeat(27);
    try {
      StringProcessor.idProcessing("Emma", name, "Matthew", 2015);
      fail("Expected IllegalArgumentException for name too short.");
    } catch (IllegalArgumentException e) {
      assertEquals("Names must start with a capital letter and be 2-26 letters long.", e.getMessage());
    }
  }

  @Test
  public void testIdProcessingInvalidNameNoCapital() {
    try {
      StringProcessor.idProcessing("emily", "Doe", "Max", 2010);
      fail("Expected IllegalArgumentException for name not starting with a capital letter.");
    } catch (IllegalArgumentException e) {
      assertEquals("Names must start with a capital letter and be 2-26 letters long.", e.getMessage());
    }
  }

  /* Test for boundary conditions so that year is not in the future or after December 2021*/
  @Test
  public void testIdProcessingInvalidFutureYear() {
    int year = LocalDate.now().getYear() + 1;
    
    try {
      StringProcessor.idProcessing("Emily", "Doe", "Max", year);
      fail("Expected IllegalArgumentException for year in the future.");
    } catch (IllegalArgumentException e) {
      assertEquals("Pet year of birth cannot be in the future.", e.getMessage());
    }
  }
  
  @Test
  public void testIdProcessYearAfter2021() {
    try {
      StringProcessor.idProcessing("Emily", "Doe", "Max", 2022);
      fail("Expected IllegalArgumentException for year after 2021.");
    } catch (IllegalArgumentException e) {
      assertEquals("Pet year of birth cannot be after December 2021.", e.getMessage());
    }
  }

  /* Test for certain offset in secret code */
  @Test
  public void testSecretCodePositiveOffset() {
    StringProcessor sp = new StringProcessor("AbcZz");
    String result = sp.secretCode(2); // shift to the right by 2
    assertEquals("CdeBb", result);
  }

  @Test
  public void testSecretCodeNegativeOffset() {
    StringProcessor sp = new StringProcessor("Abc");
    String result = sp.secretCode(-1); // shift to the left by 1
    assertEquals("Zab", result);
  }

  @Test
  public void testSecretCodeNonAlphabetCharacters() {
    StringProcessor sp = new StringProcessor("A!b C.");
    String result = sp.secretCode(1); // shift to the right by 1
    assertEquals("B!c D.", result);
  } 
}
