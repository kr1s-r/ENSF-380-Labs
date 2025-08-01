package edu.ucalgary.oop;

import java.util.List;

/* Interface for defining operations of a ToDoList */
public interface IToDoList {
  void addTask(Task newTask);
  void deleteTask(String id);
  void completeTask(String id);
  void editTask(String id, String newTitle, boolean isCompleted);
  void undo(); // undo last operation (add/delete/edit/complete)
  List<Task> listTasks(); // returns all the tasks
}
