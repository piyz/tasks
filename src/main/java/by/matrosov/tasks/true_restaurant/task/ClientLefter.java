package by.matrosov.tasks.true_restaurant.task;

import by.matrosov.tasks.true_restaurant.Tunnel;

public class ClientLefter implements Runnable{

    private Tunnel tunnel;

    public ClientLefter(Tunnel tunnel) {
        this.tunnel = tunnel;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(30000);
                Thread.currentThread().setName(":: client lefter");
                tunnel.remove();
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
