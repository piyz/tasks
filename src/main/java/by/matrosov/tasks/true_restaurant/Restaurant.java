package by.matrosov.tasks.true_restaurant;

import by.matrosov.tasks.true_restaurant.task.ClientGenerator;
import by.matrosov.tasks.true_restaurant.task.ClientLefter;
import by.matrosov.tasks.true_restaurant.task.Manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    public static void main(String[] args) {
        Tunnel tunnel = new Tunnel();

        ClientGenerator generator = new ClientGenerator(tunnel);
        ClientLefter lefter = new ClientLefter(tunnel);
        Manager manager = new Manager(tunnel);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(generator);
        service.execute(lefter);
        service.execute(manager);
    }
}
