package com.example.taskr0676600.domain.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Objects;

public class Task {
    private int id;
    private String title;
    private LocalDateTime dueDate;
    private String detail;


    public Task(int id, String title, LocalDateTime dueDate, String detail) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.detail = detail;

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

}