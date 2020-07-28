package com.solvd.automation.lab.carina.demo.bo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AzureActivity {
    private int id;
    private String title;
    private String dueDate;
    private boolean completed;

    public AzureActivity(String title, String dueDate, boolean completed) {
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public AzureActivity() {
    }

    @JsonCreator
    public AzureActivity(
            @JsonProperty("ID") int id,
            @JsonProperty("Title") String title,
            @JsonProperty("DueDate") String dueDate,
            @JsonProperty("Completed") boolean completed
    ) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}