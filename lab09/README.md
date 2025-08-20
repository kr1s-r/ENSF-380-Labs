## Lab 09: Database Setup and Running Instructions

### PostgreSQL Setup

1. **Install PostgreSQL**

   - Download and install PostgreSQL from [https://www.postgresql.org/download/](https://www.postgresql.org/download/).
   - During installation, note your username and password (default: user `postgres`, password you set).
   - Add PostgreSQL's `bin` directory (e.g., `C:\Program Files\PostgreSQL\17\bin`) to your system PATH.

2. **Reset the Database Before Each Test Run**

   - Open a new command prompt (cmd.exe).
   - Navigate to the folder containing `competition.sql`.
   - Run the following command:

     ```cmd
     psql -U oop -d postgres -f competition.sql
     ```

   - Replace `oop` with your database username if different.
   - Enter your password when prompted.

3. **Verify psql Installation**
   - Run `psql --version` in the command prompt to check if psql is available.
   - If not, ensure your PATH is set correctly and open a new command prompt.

### Running the Java Program

1. **Compile the Java Files**

   - In VS Code or command prompt, compile the Java files in the `src` folder.

2. **Run the Program**

   - Execute the `Registration` class. Example:

     ```cmd
     java -cp bin;lib\* edu.ucalgary.oop.Registration
     ```

   - Make sure the PostgreSQL JDBC driver (`.jar` file) is in your `lib` folder.

   **Folder Structure**

   The workspace contains two folders by default, where:

   - `src`: the folder to maintain sources
   - `lib`: the folder to maintain dependencies

   Meanwhile, the compiled output files will be generated in the `bin` folder by default.

   > If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

### Notes

- Always reset the database before running your tests to avoid duplicate key errors.
- You can use pgAdmin or the psql shell to inspect the database manually if needed.
