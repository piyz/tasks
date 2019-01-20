package by.matrosov.tasks.true_restaurant.task;

import by.matrosov.tasks.true_restaurant.Tunnel;

public class Manager implements Runnable {

    private Tunnel tunnel;

    public Manager(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5000);
                Thread.currentThread().setName(":: client manager");
                tunnel.get();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
