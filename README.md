# Programming_in_java
#Task Manager Pro

A simple Java console application to manage users and tasks.

#Overview

Task Manager Pro allows users to register, login, create, view, update, and delete tasks. Users can also generate simple task reports and export them as text files. The project uses a file-based storage system, making it lightweight and easy to run without database setup.

#Features

1.User registration and login

2.Task creation, viewing, status update, deletion

3.Reporting: summary of tasks per user

4.Export reports to text files

5.Clear input/output console interface

#Technologies/Tools Used

1.Java (version 8+)

2.File I/O for data persistence

3.ArrayList for data management

4.Modular structure with packages for model, service, utils, storage, and UI

#Steps to Install & Run

1.Ensure Java 8+ is installed.

2.Open terminal in the project root folder.

3.Compile the project:

javac -d out src/com/taskmanager/*.java src/com/taskmanager/model/*.java src/com/taskmanager/service/*.java src/com/taskmanager/storage/*.java src/com/taskmanager/ui/*.java src/com/taskmanager/utils/*.java src/com/taskmanager/tests/*.java

4.Run the main program:

java -cp out com.taskmanager.Main

#Instructions for Testing

1.A simple test class is included at 
src/com/taskmanager/tests/TestTaskService.java.

2.Run the test:

java -cp out com.taskmanager.tests.TestTaskService

3.Manual testing can also be done via the console menus.
