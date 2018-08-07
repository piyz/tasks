package by.matrosov.datastructure;

public class MyList<T>{
    private T[] data;
    private int capacity;
    private int size; //current size
    private static final int DEFAULT_CAPACITY = 15;

    public MyList() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T element){
        if (size == capacity){
            T[] newArr = (T[]) new Object[1 + size];
            for (int i = 0; i < size; i++) {
                newArr[i] = data[i];
            }
            //System.arraycopy(data,0, newArr,0, size);
            data = newArr;
            capacity = capacity + 1;
        }
        data[size] = element;
        size++;
    }

    public T get(int index){
        if (index < 0 || index >= size){
            throw new RuntimeException("index out of bounds");
        }
        return data[index];
    }

    public void deleteLastElement(){
        if (size == 0){
            throw new RuntimeException("list is empty: cannot delete");
        }
        size--;
        data[size] = null;
    }

    public void deleteFirstElement(){
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        //System.arraycopy(data,1, data,0,size - 1);
        data[size - 1] = null;
        size--;
    }

    public void delete(int index){
        for (int i = index + 1; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void delete(T value){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)){
                delete(i);
            }
        }
    }

    public int countWords(int L, int i, char c){
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (data[j].toString().length() == L){
                if (data[j].toString().charAt(i) == c){
                    count++;
                }
            }
        }
        return count;
    }
}
