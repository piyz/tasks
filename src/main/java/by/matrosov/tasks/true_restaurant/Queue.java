package by.matrosov.tasks.true_restaurant;

import by.matrosov.tasks.true_restaurant.model.Client;
import by.matrosov.tasks.true_restaurant.model.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Queue {
    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 5;

    private List<Client> queueClients;
    private List<Table> tables;

    private int n;

    public Queue() {
        this.queueClients = Collections.synchronizedList(new ArrayList<>());
        this.tables = Collections.synchronizedList(new ArrayList<>());
        initTables();
    }

    private void initTables(){
        for (int i = 2; i < 7; i++) {
            tables.add(new Table(i));
        }
    }

    public synchronized void add(Client client){
        try {
            if (queueClients.size() < MAX_SIZE){
                notifyAll();
                queueClients.add(client);
                System.out.printf("coming client %d :: %s %s \n", client.getSize(), queueClients, Thread.currentThread().getName());
            }else {
                System.out.printf("no place in queue %s \n", Thread.currentThread().getName());
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void remove(){
        try {
            if (!queueClients.isEmpty()){
                notifyAll();
                queueClients.remove(new Random().nextInt(queueClients.size()));
                System.out.printf("left client :: %s %s \n", queueClients, Thread.currentThread().getName());
            }else {
                System.out.printf("queue is empty %s \n", Thread.currentThread().getName());
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void get(){
        try{
            if (!queueClients.isEmpty()){
                notifyAll();

                int count = 0;
                for (int i = 0; i < queueClients.size(); i++) {
                    if (checkTables(queueClients.get(i))){
                        move2table(queueClients.get(i));
                        i--;
                    }else {
                        count++;
                        System.out.printf("no tables for client %d :: %s %s \n", queueClients.get(i).getSize(), queueClients, Thread.currentThread().getName());
                    }
                }
                if (count == queueClients.size()){
                    wait();
                }

            }else {
                System.out.printf("queue is empty %s \n", Thread.currentThread().getName());
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public synchronized void left(){
        try {
            Table table = getTables().get(new Random().nextInt(5));
            if (!table.getClientList().isEmpty()){
                notifyAll();
                table.getClientList().remove(new Random().nextInt(table.getClientList().size()));
                System.out.printf("client left from table %d :: %s :: %s %s \n", table.getSize(), queueClients, getTables(), Thread.currentThread().getName());
            }else {
                wait();
                System.out.printf("no one left :: %s %s \n", queueClients, Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean checkTables(Client client){
        for (Table table : getTables()) {
            if (table.getSize() == client.getSize() && table.getClientList().isEmpty()){
                n = table.getSize() - 2;
                return true;
            }
        }

        for (Table table : getTables()) {
            if (table.getClientList().isEmpty() && table.getSize() > client.getSize()){
                n = table.getSize() - 2;
                return true;
            }
        }

        for (Table table : getTables()) {
            if (!table.getClientList().isEmpty()){
                int takenPlaces = 0;
                for (int i = 0; i < table.getClientList().size(); i++) {
                    takenPlaces += table.getClientList().get(i).getSize();
                }
                if (table.getSize() - takenPlaces >= client.getSize()){
                    n = table.getSize() - 2;
                    return true;
                }
            }
        }
        return false;
    }

    private void move2table(Client client){
        getTables().get(n).getClientList().add(client);
        queueClients.remove(client);
        System.out.printf("client move to table %d :: %s :: %s %s \n", n + 2, queueClients, getTables(), Thread.currentThread().getName());
    }

    public List<Table> getTables() {
        return tables;
    }
}
