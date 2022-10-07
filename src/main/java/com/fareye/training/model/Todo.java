package com.fareye.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter @Getter @NoArgsConstructor @ToString
public class Todo {

    private LocalDate dueDate;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String taskBody;
    private String taskTitle;
    private Boolean taskStatus;
    private User user;

 /*   public LocalDate getDueDate() {
        return this.dueDate;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public LocalDate getModifiedDate() {
        return this.modifiedDate;
    }

    public String getTaskBody() {
        return this.taskBody;
    }

    public String getTaskTitle() {
        return this.taskTitle;
    }

    public Boolean getTaskStatus() {
        return this.taskStatus;
    }

    public User getUser() {
        return this.user;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setTaskBody(String taskBody) {
        this.taskBody = taskBody;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void setTaskStatus(Boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
