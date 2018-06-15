package by.matrosov.recursion;

public class Bottle {
    private int maxCapacity;
    private int curCapacity;

    public Bottle(int maxCapacity, int curCapacity) {
        this.maxCapacity = maxCapacity;
        this.curCapacity = curCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }


    public int getCurCapacity() {
        return curCapacity;
    }

    public void setCurCapacity(int curCapacity) {
        this.curCapacity = curCapacity;
    }
}
