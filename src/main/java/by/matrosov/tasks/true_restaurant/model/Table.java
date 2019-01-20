package by.matrosov.tasks.true_restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int size;
    private List<Client> clientList;

    public Table(int size) {
        this.size = size;
        this.clientList = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    @Override
    public String toString() {
        return "{" +
                "size=" + size +
                ", clientList=" + clientList +
                '}';
    }
}
