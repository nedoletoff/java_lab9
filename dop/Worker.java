package dop;

import java.util.LinkedList;

public class Worker extends Thread{
    LinkedList<Integer> results;
    MyTask task;

    public Worker(LinkedList<Integer> results, MyTask task) {
        this.results = results;
        this.task = task;
    }

    @Override
    public void run() {
        task.run();
        synchronized (results) {
           results.addAll(task.getAnswers());
        }
    }
}
