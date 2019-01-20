package by.matrosov.tasks.true_restaurant;

import by.matrosov.tasks.true_restaurant.model.Client;
import by.matrosov.tasks.true_restaurant.model.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tunnel {
    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 5;

    private List<Client> queueClients;
    private List<Table> tables;

    private int n;

    public Tunnel() {
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
                System.out.println("coming client " + client.getSize() + " :: " + queueClients + " " + Thread.currentThread().getName());
            }else {
                System.out.println("no place in queue " + Thread.currentThread().getName());
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
                System.out.println("left client" + " :: " + queueClients + " " + Thread.currentThread().getName());
            }else {
                System.out.println("queue is empty " + Thread.currentThread().getName());
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
                        System.out.println("no tables for client " + queueClients.get(i).getSize()+ " :: " + queueClients + Thread.currentThread().getName());
                        count++;
                    }
                }
                if (queueClients.size() == count){
                    wait();
                }

            }else {
                System.out.println("queue is empty " + Thread.currentThread().getName());
                wait();
            }
        }catch (InterruptedException e){
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
        System.out.println("client move to table " + (n + 2) + " :: " + queueClients + " :: " + getTables() + " " + Thread.currentThread().getName());
    }

    public List<Table> getTables() {
        return tables;
    }
}
