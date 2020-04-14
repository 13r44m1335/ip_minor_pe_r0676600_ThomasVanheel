package com.example.taskr0676600.repository;

import com.example.taskr0676600.domain.model.Task;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRepository {
    private List<Task> list;


    public TaskRepository() {
        list = new ArrayList<>();
        list.add(new Task("Task 1", new Date()));
        list.add(new Task("Task 2", new Date()));
        list.add(new Task("Task 3", new Date()));

    }

    public List<Task> getTasks() {
        return list;
    }


    public void addTask(Task task) {
        list.add(task);
    }
}
