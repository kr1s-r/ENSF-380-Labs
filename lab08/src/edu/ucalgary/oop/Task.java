package edu.ucalgary.oop;

import java.util.Objects;

/* Represents a single task in the ToDoList */
public class Task {

  private String id;
  private String title;
  private boolean isCompleted;

  public Task(String id, String title) {
    this.id = id;
    this.title = title;
  }

  // copy constructor
  public Task(Task originalTask) {
    this.id = originalTask.id;
    this.title = originalTask.title;
    this.isCompleted = originalTask.isCompleted;
  }

  /* Setters and Getters */
  public void setCompleted(boolean isCompleted) {
    this.isCompleted = isCompleted;
  }

  public boolean isCompleted() {
    return this.isCompleted;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  // returns deep copy of the current Task object
  public Task copy() {
    return new Task(this);
  }
    
  // overrides equals method to compare Tasks attributes
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Task task = (Task) obj;
    return Objects.equals(id, task.id) && Objects.equals(title, task.title) && isCompleted == task.isCompleted; 
  }

  // overrides hashCode method
  @Override
  public int hashCode() {
    return Objects.hash(id, title, isCompleted);
  }
}
