package by.matrosov.tasks.true_restaurant.task;

import by.matrosov.tasks.true_restaurant.Queue;
import by.matrosov.tasks.true_restaurant.model.Client;

import java.util.Random;

public class ClientGenerator implements Runnable{

    private Queue queue;

    public ClientGenerator(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().setName(":: client generator");
                Client client = new Client(getRandomSize());
                queue.add(client);
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getRandomSize(){
        return new Random().nextInt(6) + 1;
    }
}
