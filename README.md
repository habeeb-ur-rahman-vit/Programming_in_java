# Programming_in_java
Task Manager Pro

A simple Java console application to manage users and tasks.

Overview

Task Manager Pro allows users to register, login, create, view, update, and delete tasks. Users can also generate simple task reports and export them as text files. The project uses a file-based storage system, making it lightweight and easy to run without database setup.

Features

User registration and login

Task creation, viewing, status update, deletion

Reporting: summary of tasks per user

Export reports to text files

Clear input/output console interface

Technologies/Tools Used

Java (version 8+)

File I/O for data persistence

ArrayList for data management

Modular structure with packages for model, service, utils, storage, and UI

Steps to Install & Run

Ensure Java 8+ is installed.

Open terminal in the project root folder.

Compile the project:

javac -d out src/com/taskmanager/*.java src/com/taskmanager/model/*.java src/com/taskmanager/service/*.java src/com/taskmanager/storage/*.java src/com/taskmanager/ui/*.java src/com/taskmanager/utils/*.java src/com/taskmanager/tests/*.java

Run the main program:

java -cp out com.taskmanager.Main
Instructions for Testing

A simple test class is included at src/com/taskmanager/tests/TestTaskService.java.

Run the test:

java -cp out com.taskmanager.tests.TestTaskService

Manual testing can also be done via the console menus.
