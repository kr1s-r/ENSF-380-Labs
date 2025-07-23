/**
 * ENSF 380 – Object Copying with Copy Constructors
 *
 * This example demonstrates how to create a deep copy of a `CompetitionHorse` object
 * using a **copy constructor** instead of `clone()`. This approach gives full control over how 
 * objects and their nested references are duplicated.
 *
 * Instructions:
 * 1. Write a copy constructor for both the `CompetitionHorse` and `Rider` classes.
 * 2. Use the copy constructor to create a new horse (horse2) based on horse1.
 * 3. Give horse2 a different name, skills, and rider.
 * 4. Print both horses and verify that they are independent copies.
 *
 * Expected Result:
 * horse1 and horse2 should be independent — changing one does not affect the other.
 */

package edu.ucalgary.oop;

import java.util.Arrays;

public class ObjectCopying {

  public static void main(String[] args){
    // horse1
    CompetitionHorse horse1 = new CompetitionHorse("Horse","Equidae","Chordata","Blaze");
    String[] horse1Skills = new String[]{"Jumping", "Dressage"};
    horse1.setCompetitionHorseSkills(horse1Skills);
    horse1.setRider("Alex", 4321, 30);
    
    System.out.println("Original Horse1");
    System.out.println("Name: " + horse1.getCompetitionHorseName());
    System.out.println("Skills: " + Arrays.toString(horse1.skills));
    System.out.println("Rider: " + horse1.getRider().getRiderName());

    // horse2 is a deep copy of horse1 using copy constructors
    CompetitionHorse horse2 = new CompetitionHorse(horse1);
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

// CompetitionHorse represents the horse during the competition
class CompetitionHorse {
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

  // copy constructor for deep-copying CompetitionHorse object
  public CompetitionHorse(CompetitionHorse origCompetitionHorse) {
    this.animalSpecies = origCompetitionHorse.animalSpecies;
    this.animalFamily = origCompetitionHorse.animalFamily;
    this.animalPhylum = origCompetitionHorse.animalPhylum;
    this.animalName = origCompetitionHorse.animalName;

    this.skills = origCompetitionHorse.skills;
    this.animalRider = new Rider(origCompetitionHorse.animalRider);
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
class Rider {
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

  // copy constructor for deep-copying Rider object
  public Rider(Rider origRider) {
    this.riderName = origRider.riderName;
    this.riderRegNumber = origRider.riderRegNumber;
    this.age = origRider.age;
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