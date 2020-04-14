package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    public List<Task> getTasks();
    void addTask(TaskDTO taskDTO);
}
