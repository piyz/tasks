package by.matrosov.tasks.true_restaurant.task;

import by.matrosov.tasks.true_restaurant.Queue;

public class ClientTableLefter implements Runnable {

    private Queue queue;

    public ClientTableLefter(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().setName(":: client table-lefter");
                Thread.sleep(20000);
                queue.left();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
