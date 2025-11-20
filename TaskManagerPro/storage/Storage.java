package com.taskmanager.storage;

import java.io.*;
import java.util.*;
import com.taskmanager.model.User;
import com.taskmanager.model.Task;

public class Storage {
    private File usersFile = new File("data/users.txt");
    private File tasksFile = new File("data/tasks.txt");

    public Storage() {
        usersFile.getParentFile().mkdirs();
        try { usersFile.createNewFile(); tasksFile.createNewFile(); } catch (Exception e) {}
    }

    public List<User> loadUsers() {
        List<User> out = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = r.readLine()) != null) {
                User u = User.fromCSV(line.trim());
                if (u != null) out.add(u);
            }
        } catch (Exception e) {}
        return out;
    }

    public void saveUsers(List<User> users) {
        try (PrintWriter w = new PrintWriter(new FileWriter(usersFile, false))) {
            for (User u: users) w.println(u.toCSV());
        } catch (Exception e) {}
    }

    public List<Task> loadTasks() {
        List<Task> out = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(tasksFile))) {
            String line;
            while ((line = r.readLine()) != null) {
                Task t = Task.fromCSV(line.trim());
                if (t != null) out.add(t);
            }
        } catch (Exception e) {}
        return out;
    }

    public void saveTasks(List<Task> tasks) {
        try (PrintWriter w = new PrintWriter(new FileWriter(tasksFile, false))) {
            for (Task t: tasks) w.println(t.toCSV());
        } catch (Exception e) {}
    }
}
