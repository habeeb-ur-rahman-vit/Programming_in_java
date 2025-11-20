package com.taskmanager.utils;

import com.taskmanager.service.TaskService;
import com.taskmanager.model.Task;
import java.util.*;
import java.io.*;

public class ReportGenerator {
    public static String summary(TaskService ts, String owner) {
        List<Task> list = ts.listTasksFor(owner);
        int todo=0, doing=0, done=0;
        for (Task t: list) {
            if (t.getStatus().equalsIgnoreCase("todo")) todo++;
            else if (t.getStatus().equalsIgnoreCase("doing")) doing++;
            else if (t.getStatus().equalsIgnoreCase("done")) done++;
        }
        return "Summary for " + owner + ": total=" + list.size() + ", todo=" + todo + ", doing=" + doing + ", done=" + done;
    }

    public static
