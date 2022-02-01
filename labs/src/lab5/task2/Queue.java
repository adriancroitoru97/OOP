package lab5.task2;

import lab5.task1.Task;

import java.util.ArrayList;

public class Queue extends CommonOperations implements Container {
    @Override
    public Task pop() {
        return super.getTasks().remove(0);
    }
}
