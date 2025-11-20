package com.taskmanager.model;

public class User {
    private String username;
    private String fullName;

    public User(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }

    public String getUsername() { return username; }
    public String getFullName() { return fullName; }

    public String toCSV() { return username + "," + fullName; }

    public static User fromCSV(String line) {
        String[] p = line.split(",", 2);
        if (p.length < 2) return null;
        return new User(p[0], p[1]);
    }
}
