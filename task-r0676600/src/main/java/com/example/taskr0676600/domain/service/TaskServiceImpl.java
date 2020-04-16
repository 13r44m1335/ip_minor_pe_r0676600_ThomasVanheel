package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.dto.SubtaskDTO;
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
        Task t = new Task(taskDTO.getId(),taskDTO.getTitle(),taskDTO.getDueDate(),taskDTO.getDetail());
        repository.addTask(t);

    }

    @Override
    public Task getTask(int id) {
        return repository.getTask(id);
    }

    @Override
    public void removeTask(int id) {

    }

    @Override
    public void editTask(int id, TaskDTO t) {

    }

    @Override
    public Subtask getSubTask(int subId) {
        return null;
    }

    @Override
    public void addSubTask(int id, SubtaskDTO subTask) {

    }

    @Override
    public void editSubTask(int id, int subId, SubtaskDTO subTask) {

    }

    @Override
    public void removeSubTask(int id, int subId) {

    }

    @Override
    public List<Subtask> getSubtasks(int taskId) {
        return null;
    }
}
