package edu.ucalgary.oop;

/* Demonstrates functionality of the ToDoList application */
public class Main {
  public static void main(String[] args) {
    ToDoList toDoList = new ToDoList(); // create a new instance of ToDoList

    // add 3 tasks the the list
    System.out.println("---- Adding Tasks ----");
    toDoList.addTask(new Task("1", "Learn Java"));
    toDoList.addTask(new Task("2", "Write Unit Tests"));
    toDoList.addTask(new Task("3", "Review Code"));
    printTasks(toDoList);

    // mark the 2nd tasks as completed
    System.out.println("\n---- Completing Task ID 2 ----");
    toDoList.completeTask("2");
    printTasks(toDoList);

    // edit the 3rd task
    System.out.println("\n---- Editing Task ID 3 ----");
    toDoList.editTask("3", "Review Design Patterns", false);
    printTasks(toDoList);

    // delete the 1st task
    System.out.println("\n---- Deleting Task ID 1 ----");
    toDoList.deleteTask("1");
    printTasks(toDoList);

    // undo the deletion of the 1st task
    System.out.println("\n---- Undo Delete ----");
    toDoList.undo();
    printTasks(toDoList);

    // undo the edit operation of the 3rd task
    System.out.println("\n---- Undo Edit ----");
    toDoList.undo();
    printTasks(toDoList);

    // undo the operation of making the 2nd task as completed
    System.out.println("\n---- Undo Complete ----");
    toDoList.undo();
    printTasks(toDoList);
  }

  // Helper function to print all tasks in provided ToDoList
  public static void printTasks(ToDoList toDoList) {
    for (Task t : toDoList.listTasks()) {
      System.out.println("ID: " + t.getId() + ", Title: " + t.getTitle() + ", Completed: " + t.isCompleted());
    }
  }
}
