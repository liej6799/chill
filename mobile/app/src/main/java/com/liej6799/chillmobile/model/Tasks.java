package com.liej6799.chillmobile.model;

public class Tasks {

    private String taskName;
    private boolean isActive;
    private TaskType taskTypes;

    public Tasks(String taskName, boolean isActive, TaskType taskTypes) {
        this.taskName = taskName;
        this.isActive = isActive;
        this.taskTypes = taskTypes;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public TaskType getTaskTypes() {
        return taskTypes;
    }

    public void setTaskTypes(TaskType taskTypes) {
        this.taskTypes = taskTypes;
    }
}

