package com.example.taskr0676600.dto;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void setDetail(String detail){
        this.detail = detail;
    }



    public void setDueDate(String dateString) {
        dateString = dateString.replace('T',' ');
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dueDate = LocalDateTime.parse(dateString, formatter);
        this.dueDate = dueDate;
    }

}
