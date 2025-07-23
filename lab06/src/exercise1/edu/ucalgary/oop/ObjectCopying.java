/**
 * ENSF 380 - Creating Multiple Objects
 *
 * Demonstrates creating multiple instances of a CompetitionHorse class with separate
 * rider and skills assignments. Used to show how different objects are referenced in memory in Java.
 * 
 * Instructions:
 * 1. Create a second horse and assign it a few skills and a rider
 * 
 * */

package exercise1.edu.ucalgary.oop;

import java.util.Arrays;

public class ObjectCopying {

  public static void main(String[] args){
    // initialize first horse
    CompetitionHorse horse1 = new CompetitionHorse("Horse","Equidae","Chordata","Blaze");
    String[] horse1Skills = new String[]{"Jumping", "Dressage"};
    horse1.setCompetitionHorseSkills(horse1Skills);
    horse1.setRider("Alex", 4321, 30);

    // initialize second horse
    CompetitionHorse horse2 = new CompetitionHorse("Horse","Equidae","Chordata","Simba");
    String[] horse2Skills = new String[]{"laughing", "kicking"};
    horse2.setCompetitionHorseSkills(horse2Skills);
    horse2.setRider("Gurender", 9696 , 23);
    
    // Print details
    System.out.println("Horse1");
    System.out.println("Name: " + horse1.getCompetitionHorseName());
    System.out.println("Skills: " + Arrays.toString(horse1.skills));
    System.out.println("Rider: " + horse1.getRider().getRiderName());
    System.out.println("Rider: " + horse1.getRider().getRiderRegNumber());
    System.out.println("Rider: " + horse1.getRider().getAge());

    System.out.println("\nHorse2");
    System.out.println("Name: " + horse2.getCompetitionHorseName());
    System.out.println("Skills: " + Arrays.toString(horse2.skills));
    System.out.println("Rider: " + horse2.getRider().getRiderName());
    System.out.println("Rider: " + horse2.getRider().getRiderRegNumber());
    System.out.println("Rider: " + horse2.getRider().getAge());
  }   
}

// CompetitionHorse represents the horse during the competition
class CompetitionHorse {
  private String animalSpecies;
  private String animalFamily;        
  private String animalPhylum;
  private String animalName;
  private Rider animalRider = new Rider();
  public String[] skills = new String[10];

  // default constructor
  public CompetitionHorse() { 
  }
  
  // constructor with params
  public CompetitionHorse(String animalSpecies, String animalFamily, String animalPhylum, String animalName) {
    this.animalSpecies = animalSpecies;
    this.animalFamily = animalFamily;
    this.animalPhylum = animalPhylum;
    this.animalName = animalName;
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

// Rider class represents the rider on the horse
class Rider{
  private String riderName;
  private int riderRegNumber;
  private int age;
  
  // default constructor
  public Rider() { 
  }
  
  // constructor with params
  public Rider(String riderName, int riderRegNumber, int age) {
    this.riderName = riderName;
    this.riderRegNumber = riderRegNumber;
    this.age = age;
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