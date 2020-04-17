package com.example.taskr0676600.repository;

import com.example.taskr0676600.domain.model.Task;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> list;


    public TaskRepository() {
        list = new ArrayList<>();
        list.add(new Task(1,"Task 1", LocalDateTime.of(2021, Month.MARCH,10,17,30), "no detail"));
        list.add(new Task(2,"Task 2", LocalDateTime.of(2022, Month.MARCH,30,18,30),"blub"));
        list.add(new Task(3,"Task 3", LocalDateTime.of(2023, Month.MARCH,20,16,30),"bobob"));

    }

    public List<Task> getTasks() {
        return list;
    }

    public Task getTask(int id){
        Task out = null;
        for (Task t: list
             ) {
            if(t.getId() == id){
                out = t;

            }

        }
        return out;
    }


    public void addTask(Task task) {
        this.list.add(task);
    }

    public void editTask(Task task){
        for (Task t:list
             ) {
            if(t.getId() == task.getId()){
                t.setTitle(task.getTitle());
                t.setDueDate(task.getDueDate());
                t.setDetail(task.getDetail());
            }

        }
    }



}
