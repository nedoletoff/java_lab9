package dop;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskQueue {
    LinkedList<MyTask> tasks;
    LinkedList<Integer> results;

    public TaskQueue() {
        tasks = new LinkedList<>();
        results = new LinkedList<>();
    }

    public LinkedList<Integer> getResults() {
        return results;
    }

    public MyTask pop() {
        return tasks.pop();
    }

    public void push(MyTask task) {
        tasks.push(task);
    }

    public void showResults() {
        synchronized (results) {
            for (Integer element : results) {
                if (element == 0) {
                    System.out.println();
                } else
                    System.out.print(element + " ");
            }
        }
    }
}
