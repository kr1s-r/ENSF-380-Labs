/**
 * ENSF 380 – Object Copying with the clone() Method
 *
 * This example demonstrates creating a deep copy of a `CompetitionHorse` object
 * using the `clone()` method. Unlike simple reference assignment, cloning creates
 * a new object in memory with the same values, so changes to the clone do not
 * affect the original.
 *
 * Instructions:
 * 1. Clone horse1 into horse2 using the clone method.
 * 2. Give horse2 a different name, skills, and rider.
 * 3. Print both horses and verify that changes to horse2 do not affect horse1.
 *
 * Expected Result:
 * horse1 and horse2 should now be independent — modifying one does not modify the other.
 *
 */

package exercise3.edu.ucalgary.oop;

import java.util.Arrays;

public class ObjectCopying {

  public static void main(String[] args) throws CloneNotSupportedException {
    // horse1
    CompetitionHorse horse1 = new CompetitionHorse("Horse","Equidae","Chordata","Blaze");
    String[] horse1Skills = new String[]{"Jumping", "Dressage"};
    horse1.setCompetitionHorseSkills(horse1Skills);
    horse1.setRider("Alex", 4321, 30);

    System.out.println("Original Horse1");
    System.out.println("Name: " + horse1.getCompetitionHorseName());
    System.out.println("Skills: " + Arrays.toString(horse1.skills));
    System.out.println("Rider: " + horse1.getRider().getRiderName());

    // clone horse1 to create an independent object in memory (horse2)
    CompetitionHorse horse2 = (CompetitionHorse)horse1.clone();
    horse2.setCompetitionHorseName("Thunder");
    horse2.setRider("Taylor", 1234, 25);
    String [] horse2Skills = new String[]{"Racing"};
    horse2.setCompetitionHorseSkills(horse2Skills);
    
    // output horse1 and horse2 details
    System.out.println();
    System.out.println("Horse1");
    System.out.println("Name: " + horse1.getCompetitionHorseName());
    System.out.println("Skills: " + Arrays.toString(horse1.skills));
    System.out.println("Rider: " + horse1.getRider().getRiderName());
    System.out.println("Horse2");
    System.out.println("Name: " + horse2.getCompetitionHorseName());
    System.out.println("Skills: " + Arrays.toString(horse2.skills));
    System.out.println("Rider: " + horse2.getRider().getRiderName());
  }   
}

// CompetitionHorse implements deep cloning by overriding clone() method
class CompetitionHorse implements Cloneable {
  private String animalSpecies;
  private String animalFamily;        
  private String animalPhylum;
  private String animalName;
  private Rider animalRider = new Rider();
  public String[] skills = new String[10];

  // default constructor
  public CompetitionHorse(){
  }
  
  // constructor with params
  public CompetitionHorse(String animalSpecies, String animalFamily, String animalPhylum, String animalName) {
    this.animalSpecies = animalSpecies;
    this.animalFamily = animalFamily;
    this.animalPhylum = animalPhylum;
    this.animalName = animalName;
  }

  // deep clone of CompetitionHorse object
  public Object clone() throws CloneNotSupportedException {
    CompetitionHorse copy = (CompetitionHorse)super.clone();
    copy.animalRider = (Rider)animalRider.clone();
    return copy;
  }

  // setters
  public void setCompetitionHorsePhylum(String animalPhylum) {
    this.animalPhylum = animalPhylum;
  }

  public void setCompetitionHorseFamily(String animalFamily) {
    this.animalFamily = animalFamily;
  }

  public void setCompetitionHorseSpecies(String animalSpecies) {
    this.animalSpecies = animalSpecies;
  }

  public void setCompetitionHorseName(String animalName) {
    this.animalName = animalName;
  }
        
  public void setRider(String name, int regNumber, int age) {
    this.animalRider.setRiderName(name);
    this.animalRider.setRiderRegNumber(regNumber);
    this.animalRider.setAge(age);  
  }

  public void setCompetitionHorseSkills(String[] skills) {
    this.skills = skills;
  }

  // getters
  public String getCompetitionHorsePhylum() {
    return animalPhylum;
  }

  public String getCompetitionHorseFamily() {
    return animalFamily;
  }

  public String getCompetitionHorseSpecies() {
    return animalSpecies;
  }

  public String getCompetitionHorseName() {
    return animalName;
  }
  
  public Rider getRider(){
    return animalRider;
  }
        
}

// Rider implements deep cloning by overriding clone() method
class Rider implements Cloneable {
  private String riderName;
  private int riderRegNumber;
  private int age;
  
  // default constructor
  public Rider(){
  }
  
  // constructor with params
  public Rider(String riderName, int riderRegNumber, int age) {
    this.riderName = riderName;
    this.riderRegNumber = riderRegNumber;
    this.age = age;
  }

  // deep clone of Rider object
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  // setters
  public void setRiderName(String riderName) {
    this.riderName = riderName;
  }
  
  public void setRiderRegNumber(int riderRegNumber) {
    this.riderRegNumber = riderRegNumber;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  // getters
  public String getRiderName() {
    return riderName;
  }

  public int getRiderRegNumber() {
    return riderRegNumber;
  }

  public int getAge() {
    return age;
  }  
}