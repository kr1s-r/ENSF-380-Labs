# ENSF 380 Labs

This repository contains my ENSF 380 labs from the Summer 2025 semester in Java:

---

## 📚 Lab Index

- [Lab 01](./lab01): Intro to Java and Javadoc
- [Lab 02](./lab02): OOP basics & Using testing in main()
- [Lab 03](./lab03): Java Arrays
- [Lab 04](./lab04): No Lab - Quiz
- [Lab 05](./lab05): Java String and Regex
- [Lab 06](./lab06): Copying Objects in Java
- [Lab 07](./lab07): Testing using JUnit
- [Lab 08](./lab08): Java Interfaces
- [Lab 09](./lab09/): Databases and JDBC using PostgreSQL

---

## 📁 Folder Structure

Your code is organized as the following:

```
Lab Code/
├── src/edu/ucalgary/oop/    # Java source, test files and compiled .class files
└── README.md
```

---

## 🛠️ Compiling, Testing, and Running Java Files

### Compiling

To compile all Java files in the `src` folder:

```cmd
javac src/edu/ucalgary/oop/*.java
```

### Running

To run a Java class (e.g., `Main`):

```cmd
java edu.ucalgary.oop.Main
```

### Testing

If you have JUnit tests, follow these steps:

1. **Compile your source and test files (Windows example):**

```cmd
javac -cp .;C\<Folder with jar files>\* edu/ucalgary/oop/*.java
```

2. **Run a specific JUnit test class:**

```cmd
java -cp .;C\<Folder with jar files>\* org.junit.runner.JUnitCore edu.ucalgary.oop.ApplicationNameTest
```

- Replace `ApplicationNameTest` with the name of your test class.
- Replace `<Folder with jar files>` with the path of where your .jar files are located.

**Tips:**

- If you see errors about missing classes, check your classpath and folder structure.
- Test results will be printed in the terminal; failures and errors will be shown with stack traces.

---

## 🗄️ Databases

For code involving databases:

- Use PostgreSQL and ensure it is installed and added to your PATH.
- Example reset command:
  ```cmd
  psql -U <username> -d postgres -f competition.sql
  ```
- Use pgAdmin or the psql shell to inspect or query your database manually.
- Helpful Resources can be found on D2L or online (i.e. YouTube)
