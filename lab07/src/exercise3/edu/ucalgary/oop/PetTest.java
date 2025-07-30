package exercise3.edu.ucalgary.oop;

import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.TimeZone;

public class PetTest {
  ZoneId timeZone;
  LocalDate currentDate;

  int currentYear;
  int currentMonth;
  int currentDay;
  int[] currentBirthday;

  @Before
  public void setUp() {
    timeZone = TimeZone.getTimeZone("GMT-7").toZoneId();
    currentDate = LocalDate.now(timeZone);
    currentYear = currentDate.getYear();
    currentMonth = currentDate.getMonthValue();
    currentDay = currentDate.getDayOfMonth();
    currentBirthday = new int[] {currentYear, currentMonth, currentDay};
  }
  
  @Test
  public void testCalculateAgeBirthdayPast() {
    int pastYear = currentYear - 3;

    int[] birthDate = new int[]{pastYear, 1, 1};
    Pet petDog = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
    int expResult = currentYear - birthDate[0];
    int result = petDog.calculateAge();
    assertEquals("Calculated age was incorrect: ", expResult, result);
  }

  @Test
  public void testCalculateAgeBirthdayFuture() {
    LocalDate futureBirthday = currentDate.plusDays(8);

    int[] birthDate = new int[]{currentYear, futureBirthday.getMonthValue(), futureBirthday.getDayOfMonth()};
    Pet petDog = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
    int expResult = currentYear - birthDate[0] - 1; // -1 since birthday hasn't occured yet
    int result = petDog.calculateAge();
    assertEquals("Calculated age was incorrect: ", expResult, result);
  }

  @Test
  public void testCalculateAgeLeapYearBirthday() {
    int leapYear = currentYear - 3;

    // check for leap year
    while (!((leapYear % 4 == 0 && leapYear % 100 != 0) || (leapYear % 400 == 0))) {
      leapYear--;
    }

    int[] birthDate = new int[] {leapYear, 2, 29}; // Feb 29 is a leap year
    Pet petDog = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);

    int expResult = currentYear - leapYear;
    int result = petDog.calculateAge();
    assertEquals("Age should be correctly calculated for leap-year birthdays.", expResult, result);
  }

  @Test
  public void testCalculateAgeBirthdayToday() {
    int[] birthDate = new int[]{currentYear, currentMonth, currentDay};
    Pet petDog = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
    int expResult = currentYear - birthDate[0];
    int result = petDog.calculateAge();
    assertEquals("Calculated age was incorrect: ", expResult, result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCalculatedAgeBirthdayException() {
    int[] birthDate = new int[]{currentYear + 2, 7, 1};
    new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
  }

  @Test
  public void testGetName() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    String name = petDog.getName();
    assertEquals("Incorrect name", "Kanellos", name);
  }

  @Test
  public void testSetName() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    petDog.setName("Achilles");
    assertEquals("Name not updated correctly", "Achilles", petDog.getName());
  }

  @Test
  public void testGetSpecies() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    String species = petDog.getSpecies();
    assertEquals("Incorrect species", "Dog", species);
  }

  @Test
  public void testSetSpecies() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    petDog.setSpecies("Cat");
    assertEquals("Species not updated correctly", "Cat", petDog.getSpecies());
  }

  @Test
  public void testGetBreed() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    String breed = petDog.getBreed();
    assertEquals("Incorrect breed", "Golden Retriever", breed);
  }

  @Test
  public void testSetBreed() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    petDog.setBreed("German Shepherd");
    assertEquals("Breed not updated correctly", "German Shepherd", petDog.getBreed());
  }

  @Test
  public void testGetNumOfLegs() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    int numOfLegs = petDog.getNumLegs();
    assertEquals("Incorrect number of legs", 4, numOfLegs);
  }

  @Test
  public void testSetNumOfLegs() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    petDog.setNumLegs(3);
    assertEquals("Number of legs not updated incorrectly", 3, petDog.getNumLegs());
  }

  @Test
  public void testGetColour() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    String colour = petDog.getColour();
    assertEquals("Incorrect colour", "Golden", colour);
  }

  @Test
  public void testSetColour() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    petDog.setColour("Brown");
    assertEquals("Color not updated correctly", "Brown", petDog.getColour());
  }

  @Test
  public void testGetCoveringType() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    String coveringType = petDog.getCoveringType();
    assertEquals("Incorrect covering type", "Fur", coveringType);
  }

  @Test
  public void testSetCoveringType() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    petDog.setCoveringType("Wool");
    assertEquals("Covering type not updated correctly", "Wool", petDog.getCoveringType());
  }

  @Test
  public void testGetBirthYear() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    int year = petDog.getBirthYear();
    assertEquals("Incorrect birth year", currentYear, year);
  }

  @Test
  public void testGetBirthMonth() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    int month = petDog.getBirthMonth();
    assertEquals("Incorrect birth month", currentMonth, month);
  }

  @Test
  public void testGetBirthDay() {
    Pet petDog = new Pet("Kanellos", "Dog", "Golden Retriever", 4, "Golden", "Fur", currentBirthday);
    int day = petDog.getBirthDay();
    assertEquals("Incorrect birth day", currentDay, day);
  }
}