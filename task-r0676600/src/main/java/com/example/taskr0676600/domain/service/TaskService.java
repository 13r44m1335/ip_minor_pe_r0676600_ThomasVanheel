package com.example.taskr0676600.domain.service;

import com.example.taskr0676600.domain.model.Subtask;
import com.example.taskr0676600.domain.model.Task;
import com.example.taskr0676600.dto.SubtaskDTO;
import com.example.taskr0676600.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(TaskDTO taskDTO);

    Task getTask(int id);

    void removeTask(int id);

    void editTask(int id, TaskDTO t);


    Subtask getSubTask(int id, int subId);

    void addSubTask(int id, SubtaskDTO subTask);

    void editSubTask(int id, SubtaskDTO subTask);

    void removeSubTask(int id, int subId);


    List<Subtask> getSubtasks(int taskId);



}
