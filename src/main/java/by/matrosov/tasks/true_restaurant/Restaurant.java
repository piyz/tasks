package by.matrosov.tasks.true_restaurant;

import by.matrosov.tasks.true_restaurant.task.ClientGenerator;
import by.matrosov.tasks.true_restaurant.task.ClientQueueLefter;
import by.matrosov.tasks.true_restaurant.task.ClientTableLefter;
import by.matrosov.tasks.true_restaurant.task.Manager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {
    public static void main(String[] args) {
        Queue queue = new Queue();

        ClientGenerator generator = new ClientGenerator(queue);
        ClientQueueLefter queueLefter = new ClientQueueLefter(queue);
        ClientTableLefter tableLefter = new ClientTableLefter(queue);
        Manager manager = new Manager(queue);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(generator);
        service.execute(queueLefter);
        service.execute(tableLefter);
        service.execute(manager);
    }
}
