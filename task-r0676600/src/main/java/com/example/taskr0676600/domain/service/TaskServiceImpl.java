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
        List<Task> tasks = repository.getTasks();
        int x = -1;
        for (Task t: tasks
             ) {if(t.getId()>x)x=t.getId();

        }
        Task t = new Task(x+1,taskDTO.getTitle(),taskDTO.getDueDate(),taskDTO.getDetail());
        repository.addTask(t);

    }

    @Override
    public Task getTask(int id) {
        return repository.getTask(id);
    }

    @Override
    public void removeTask(int id) {
        repository.removeTask(id);

    }

    @Override
    public void editTask(int id, TaskDTO t) {
        repository.editTask(new Task(id,t.getTitle(),t.getDueDate(),t.getDetail()));

    }

    @Override
    public Subtask getSubTask(int id, int subId) {
        return repository.getTask(id).getSubtask(subId);
    }

    @Override
    public void addSubTask(int id, SubtaskDTO subtask) {
        repository.addSubtask(id,new Subtask(subtask.getId(),subtask.getTitle(),subtask.getDescription()));

    }

    @Override
    public void editSubTask(int id, SubtaskDTO subTask) {
        repository.editSubtask(id,new Subtask(subTask.getId(),subTask.getTitle(),subTask.getDescription()));

    }

    @Override
    public void removeSubTask(int id, int subId) {
        repository.removeSubtask(id,subId);

    }

    @Override
    public List<Subtask> getSubtasks(int taskId) {
        return repository.getTask(taskId).getSubtasks();
    }
}
