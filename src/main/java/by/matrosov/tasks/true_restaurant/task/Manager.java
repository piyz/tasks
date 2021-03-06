package by.matrosov.tasks.true_restaurant.task;

import by.matrosov.tasks.true_restaurant.Queue;

public class Manager implements Runnable {

    private Queue queue;

    public Manager(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
                Thread.currentThread().setName(":: client manager");
                queue.get();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
