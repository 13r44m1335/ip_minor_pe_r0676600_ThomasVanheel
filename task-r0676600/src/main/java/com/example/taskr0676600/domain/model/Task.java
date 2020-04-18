package com.example.taskr0676600.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Task {
    private int id;
    private String title;
    private LocalDateTime dueDate;
    private String detail;
    private List<Subtask> subtasks;


    public Task(int id, String title, LocalDateTime dueDate, String detail) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.detail = detail;
        this.subtasks = new ArrayList<>();

    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getDetail(){return detail;}

    public void setDetail(String detail){ this.detail = detail;}

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDetail(), getDueDate());
    }

    @Override
    public String toString() {
        return title + ": due to " + dueDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a"));
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public Subtask getSubtask(int id)
    {
        for (Subtask s:subtasks) {
            if(s.getId()==id)
            {
                return s;
            }
        }
        return null;
    }

    public void addSubtask(Subtask subtask) {
        int x = -1;
        for (Subtask s:subtasks
             ) {if(x<s.getId()){
                 x = s.getId();
        }

        }
        if(subtasks.size()!=0)
        {
            subtask.setId(subtasks.get(subtasks.size() - 1).getId() + 1);
        }
        else
        {
            subtask.setId(x+1);
        }
        subtasks.add(subtask);
    }

    public void editSubtask(Subtask subtask) {
        for (Subtask s:subtasks
             ) {if (s.getId() == subtask.getId()) {
            s.setDescription(subtask.getDescription());
            s.setTitle(subtask.getTitle());}

        }

    }

    public void removeSubTask(int id) {
        for (Subtask s:subtasks
             ) {if(s.getId() == id){
                 subtasks.remove(s);
            }
        }
    }

}