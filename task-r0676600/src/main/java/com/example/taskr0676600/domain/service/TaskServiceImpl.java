package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.dto.TaskDTO;
import com.example.taskr0676600.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getTasks() {
        return repository.getTasks();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task t = new Task(taskDTO.getTitle(),taskDTO.getDueDate());
        repository.addTask(t);

    }
}
