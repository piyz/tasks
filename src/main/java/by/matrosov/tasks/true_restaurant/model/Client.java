package by.matrosov.tasks.true_restaurant.model;

public class Client {
    private final int size;

    public Client(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
