package by.matrosov.tasks.true_restaurant.task;

import by.matrosov.tasks.true_restaurant.Queue;

public class ClientQueueLefter implements Runnable{

    private Queue queue;

    public ClientQueueLefter(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(30000);
                Thread.currentThread().setName(":: client queue-lefter");
                queue.remove();
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
