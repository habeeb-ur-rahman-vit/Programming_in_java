package com.taskmanager.model;

public class Task {
    private int id;
    private String owner; // username
    private String title;
    private String status; // todo, doing, done
    private int priority; // 1 high - 5 low

    public Task(int id, String owner, String title, String status, int priority) {
        this.id = id;
        this.owner = owner;
        this.title = title;
        this.status = status;
        this.priority = priority;
    }

    public int getId() { return id; }
    public String getOwner() { return owner; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public int getPriority() { return priority; }

    public void setStatus(String s) { this.status = s; }
    public void setTitle(String t) { this.title = t; }
    public void setPriority(int p) { this.priority = p; }

    public String toCSV() {
        return id + "," + owner + "," + title.replace(",", " ") + "," + status + "," + priority;
    }

    public static Task fromCSV(String line) {
        String[] p = line.split(",", 5);
        if (p.length < 5) return null;
        try {
            int id = Integer.parseInt(p[0]);
            String owner = p[1];
            String title = p[2];
            String status = p[3];
            int pr = Integer.parseInt(p[4]);
            return new Task(id, owner, title, status, pr);
        } catch (Exception e) {
            return null;
        }
    }
}
