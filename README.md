# Programming_in_java
# Task Manager Pro
A simple Java console application to manage users and tasks.

## Features
- Register and login users
- Create, list, update status, delete tasks
- Per-user report and export

## Technologies
- Java 8+ (no external libraries)

## Run
1. Open terminal at project root
2. Compile:
   javac -d out src/com/taskmanager/*.java src/com/taskmanager/model/*.java src/com/taskmanager/service/*.java src/com/taskmanager/storage/*.java src/com/taskmanager/ui/*.java src/com/taskmanager/utils/*.java src/com/taskmanager/tests/*.java
3. Run:
   java -cp out com.taskmanager.Main

## Testing
Run the test main:
  java -cp out com.taskmanager.tests.TestTaskService

## Git
Initialize Git and push to GitHub. Make repository public. Add README.md and statement.md.
