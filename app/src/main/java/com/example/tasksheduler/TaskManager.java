package com.example.tasksheduler;

import android.util.Log;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TaskManager {
    private PriorityQueue<TaskModule> taskModuleQueue;

    public TaskManager() {
        taskModuleQueue = new PriorityQueue<>(Comparator.comparingInt(TaskModule::getPriority));
    }

    public void addTask(TaskModule taskModule) {
        taskModuleQueue.offer(taskModule);
        Log.d("TaskManager", "Task added: " + taskModule.getTitle());
    }

    public TaskModule getNextTask() {
        return taskModuleQueue.poll();
    }

    public boolean isEmpty() {
        return taskModuleQueue.isEmpty();
    }
    public List<TaskModule> getAllTasks() {
        return new ArrayList<>(taskModuleQueue);
    }

}
