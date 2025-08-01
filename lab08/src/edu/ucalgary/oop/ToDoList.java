package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implementation of the IToDoList interface.
 * Manages tasks and supports undo functionality.
 */
public class ToDoList implements IToDoList {
  protected List<Task> tasks = new ArrayList<>(); // current task list (ArrayList)
  protected Stack<List<Task>> history = new Stack<>(); // history of task list (Stack)

  // saves a copy of the current task list in the history stack
  // call this function before modifying anything
  public void pushAction() {
    List<Task> action = new ArrayList<>();

    for (Task t : tasks) {
      action.add(t.copy()); // deep copy of each task and store into an ArrayList
    }

    history.push(action);
  }

  // add task
  @Override
  public void addTask(Task newTask) {
    pushAction();
    tasks.add(newTask);
  }

  // delete task
  @Override
  public void deleteTask(String id) {
    pushAction();
    for (int i = 0; i < tasks.size(); i++) {
      Task t = tasks.get(i);
      if (t.getId().equals(id)) {
        // removes the task by an index
        tasks.remove(i);
        break;
      }
    }
  }

  // marks the task as completed
  @Override
  public void completeTask(String id) {
    pushAction();
    for (int i = 0; i < tasks.size(); i++) {
      Task t = tasks.get(i);
      if (t.getId().equals(id)) {
        // set task as completed
        t.setCompleted(true);
        break;
      }
    }
  }

  // edits the task
  @Override
  public void editTask(String id, String newTitle, boolean isCompleted) {
    pushAction();
    for (int i = 0; i < tasks.size(); i++) {
      Task t = tasks.get(i); // get task at specific index
      if (t.getId().equals(id)) {
        // create a new task and update it
        Task modifiedTask = new Task(t.getId(), newTitle);
        modifiedTask.setCompleted(isCompleted);
        tasks.set(i, modifiedTask); // replaces the task in the ArrayList
        break;
      }
    }
  }

  // undo the last action
  @Override
  public void undo() {
    if (!history.empty()) {
      tasks = history.pop(); // restores the last saved state
    }
  }

  // lists tasks
  @Override
  public List<Task> listTasks() {
    return tasks;
  }
}
