package dop;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int n = 10;
        int start = 2;
        int gap = 100;
        int stop = 100;
        TaskQueue queue = new TaskQueue();
        MyTask[] tasks = new MyTask[n];
        Worker[] workers = new Worker[n];


        for (int i = 0; i < n; i++) {
            tasks[i] = new MyTask(start, stop);
            start = stop + 1;
            stop = gap * (i + 2);
        }

        for (MyTask task : tasks)
            queue.push(task);

        for (Worker worker : workers) {
            worker = new Worker(queue.getResults(), queue.pop());
            worker.start();
            TimeUnit.MILLISECONDS.sleep(100);
            queue.showResults();
            System.out.println();
        }

        queue.showResults();


        //task1.run();
        //System.out.println(task1.getAnswers().toString());

    }
}

