package exercise1.edu.ucalgary.oop;

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
 
  @Before
  public void setUp() {
    timeZone = TimeZone.getTimeZone("GMT-7").toZoneId();
    currentDate = LocalDate.now(timeZone);
    currentYear = currentDate.getYear();
    currentMonth = currentDate.getMonthValue();
    currentDay = currentDate.getDayOfMonth();
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
    Pet petDog = new Pet("Pongo", "Dog", "Dalmatian", 4, "Spotted", "Fur", birthDate);
  }
}

