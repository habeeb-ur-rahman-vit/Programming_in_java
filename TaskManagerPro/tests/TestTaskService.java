package com.taskmanager.tests;

import com.taskmanager.storage.Storage;
import com.taskmanager.service.TaskService;

public class TestTaskService {
    public static void main(String[] args) {
        Storage s = new Storage();
        TaskService ts = new TaskService(s);
        ts.createTask("alice", "test1", 3);
        ts.createTask("alice", "test2", 2);
        if (ts.listTasksFor("alice").size() >= 2) System.out.println("OK");
        else System.out.println("FAIL");
    }
}
