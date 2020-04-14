package com.example.tasks.service;

import com.example.tasks.domain.Task;
import com.example.tasks.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    public List<Task> getTasks();
    void addTask(TaskDTO taskDTO);
}
