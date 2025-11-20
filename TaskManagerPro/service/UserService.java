package com.taskmanager.service;

import com.taskmanager.storage.Storage;
import com.taskmanager.model.User;
import java.util.*;

public class UserService {
    private List<User> users;
    private Storage storage;

    public UserService(Storage s) {
        storage = s;
        users = s.loadUsers();
    }

    public boolean register(String username, String fullname) {
        for (User u: users) if (u.getUsername().equals(username)) return false;
        User nu = new User(username, fullname);
        users.add(nu);
        storage.saveUsers(users);
        return true;
    }

    public User login(String username) {
        for (User u: users) if (u.getUsername().equals(username)) return u;
        return null;
    }

    public List<User> listUsers() { return new ArrayList<>(users); }
}
