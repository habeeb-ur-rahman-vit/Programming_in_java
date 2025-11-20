package com.taskmanager.ui;

import com.taskmanager.storage.Storage;
import com.taskmanager.service.UserService;
import com.taskmanager.service.TaskService;
import com.taskmanager.utils.ReportGenerator;
import com.taskmanager.utils.Validator;
import com.taskmanager.model.User;
import java.util.*;

public class ConsoleUI {
    private Scanner sc = new Scanner(System.in);
    private Storage storage = new Storage();
    private UserService us = new UserService(storage);
    private TaskService ts = new TaskService(storage);
    private User current = null;

    public void start() {
        while (true) {
            System.out.println("
Welcome to Task Manager Pro");
            System.out.println("1. Register
2. Login
3. Exit");
            System.out.print("Choice: ");
            int c = readInt();
            if (c==1) doRegister();
            else if (c==2) { if (doLogin()) userMenu(); }
            else break;
        }
    }

    private void doRegister() {
        System.out.print("username: ");
        String u = sc.nextLine().trim();
        System.out.print("full name: ");
        String f = sc.nextLine().trim();
        if (us.register(u, f)) System.out.println("Registered."); else System.out.println("Username taken.");
    }

    private boolean doLogin() {
        System.out.print("username: ");
        String u = sc.nextLine().trim();
        User uu = us.login(u);
        if (uu == null) { System.out.println("No such user."); return false; }
        current = uu; System.out.println("Login success. Hello " + current.getFullName()); return true;
    }

    private void userMenu() {
        while (true) {
            System.out.println("
User menu for " + current.getUsername());
            System.out.println("1. Create Task
2. List My Tasks
3. Delete Task
4. Update Status
5. Report
6. Logout");
            System.out.print("Choice: ");
            int c = readInt();
            if (c==1) createTask();
            else if (c==2) listMyTasks();
            else if (c==3) deleteTask();
            else if (c==4) updateStatus();
            else if (c==5) doReport();
            else break;
        }
        current = null;
    }

    private void createTask() {
        System.out.print("title: "); String t = sc.nextLine().trim();
        System.out.print("priority (1-5): "); int p = readInt();
        if (!Validator.validPriority(p)) { System.out.println("Invalid priority."); return; }
        ts.createTask(current.getUsername(), t, p);
        System.out.println("Task added.");
    }

    private void listMyTasks() {
        for (var t: ts.listTasksFor(current.getUsername())) System.out.println(t.getId() + " | " + t.getTitle() + " | " + t.getStatus() + " | " + t.getPriority());
    }

    private void deleteTask() {
        System.out.print("task id: "); int id = readInt();
        if (ts.deleteTask(id, current.getUsername())) System.out.println("Deleted."); else System.out.println("Not found or not your task.");
    }

    private void updateStatus() {
        System.out.print("task id: "); int id = readInt();
        System.out.print("new status (todo/doing/done): "); String s = sc.nextLine().trim();
        if (ts.updateStatus(id, current.getUsername(), s)) System.out.println("Updated."); else System.out.println("Failed.");
    }

    private void doReport() {
        System.out.println(ReportGenerator.summary(ts, current.getUsername()));
        System.out.print("Export to file? (y/n): "); String r = sc.nextLine().trim();
        if (r.equalsIgnoreCase("y")) { System.out.print("filename: "); String f = sc.nextLine(); if (ReportGenerator.exportTextReport(ts, current.getUsername(), f)) System.out.println("Saved."); else System.out.println("Failed."); }
    }

    private int readInt() { try { String s = sc.nextLine(); return Integer.parseInt(s.trim()); } catch (Exception e) { return -1; } }
}
