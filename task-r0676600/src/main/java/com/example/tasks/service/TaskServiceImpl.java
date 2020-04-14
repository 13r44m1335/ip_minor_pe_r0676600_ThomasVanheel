package com.example.tasks.service;

import com.example.tasks.domain.Task;
import com.example.tasks.dto.TaskDTO;
import com.example.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository repository;
    @Autowired
    public TaskServiceImpl(TaskRepository repository){
        this.repository=repository;
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
