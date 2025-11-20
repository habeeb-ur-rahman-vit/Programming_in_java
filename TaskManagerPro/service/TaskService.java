package com.taskmanager.service;

import com.taskmanager.storage.Storage;
import com.taskmanager.model.Task;
import java.util.*;

public class TaskService {
    private List<Task> tasks;
    private Storage storage;
    private int nextId = 1;

    public TaskService(Storage s) {
        storage = s;
        tasks = s.loadTasks();
        for (Task t: tasks) nextId = Math.max(nextId, t.getId() + 1);
    }

    public Task createTask(String owner, String title, int priority) {
        Task t = new Task(nextId++, owner, title, "todo", priority);
        tasks.add(t);
        storage.saveTasks(tasks);
        return t;
    }

    public List<Task> listTasksFor(String owner) {
        List<Task> out = new ArrayList<>();
        for (Task t: tasks) if (t.getOwner().equals(owner)) out.add(t);
        return out;
    }

    public boolean deleteTask(int id, String owner) {
        Iterator<Task> it = tasks.iterator();
        while (it.hasNext()) {
            Task t = it.next();
            if (t.getId() == id && t.getOwner().equals(owner)) { it.remove(); storage.saveTasks(tasks); return true; }
        }
        return false;
    }

    public boolean updateStatus(int id, String owner, String status) {
        for (Task t: tasks) if (t.getId()==id && t.getOwner().equals(owner)) { t.setStatus(status); storage.saveTasks(tasks); return true; }
        return false;
    }

    public List<Task> listAll() { return new ArrayList<>(tasks); }
}
