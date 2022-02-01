package lab5.task2;

import lab5.task1.Task;

import java.util.ArrayList;

public abstract class CommonOperations implements Container {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void push(Task task) {
        tasks.add(tasks.size(), task);
    }

    public int size() {
        return tasks.size();
    }

    public boolean isEmpty() {
        return tasks.size() == 0;
    }

    public void transferFrom(Container container) {
        this.tasks.addAll(((CommonOperations)container).tasks);
        ((CommonOperations)container).tasks.clear();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
