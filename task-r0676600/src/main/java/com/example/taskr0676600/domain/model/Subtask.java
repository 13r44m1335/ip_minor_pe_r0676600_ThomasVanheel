package com.example.taskr0676600.domain.model;


public class Subtask {
    private int id;
    private String title;
    private String description;

    public Subtask(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Subtask(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
