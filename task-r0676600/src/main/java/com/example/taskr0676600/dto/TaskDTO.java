package com.example.taskr0676600.dto;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TaskDTO {
    private int id;
    private String title;
    private LocalDateTime dueDate;
    private String detail;


    public int getId(){
        return id;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public void setTitle(String title) {
        this.title = title;
    }

    @FutureOrPresent
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public String getDetail(){
        return detail;
    }



    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

}
