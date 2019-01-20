package by.matrosov.tasks.true_restaurant.task;

import by.matrosov.tasks.true_restaurant.Tunnel;
import by.matrosov.tasks.true_restaurant.model.Client;

import java.util.Random;

public class ClientGenerator implements Runnable{

    private Tunnel tunnel;

    public ClientGenerator(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.currentThread().setName(":: client generator");
                Client client = new Client(getRandomSize());
                tunnel.add(client);
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
