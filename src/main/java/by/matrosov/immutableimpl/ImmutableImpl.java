package by.matrosov.immutableimpl;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableImpl {
    private final int i;
    private final String s;
    private HashMap<String, String> map;

    private ImmutableImpl(int i, String s, HashMap<String, String> map) {
        this.i = i;
        this.s = s;
        this.map = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            this.map.put(entry.getKey(), entry.getValue());
        }
    }

    public int getI() {
        return i;
    }

    public String getS() {
        return s;
    }

    @SuppressWarnings("unchecked")
    private HashMap<String, String> getMap() {
        return (HashMap<String, String>) map.clone();
    }

    public static void main(String[] args) {
        int i = 25;
        String s = "ssssssss";
        HashMap<String, String> map = new HashMap<>();

        map.put("1", "dfsdfd");
        map.put("2", "sdasda");

        ImmutableImpl immutable = new ImmutableImpl(i, s, map);
        System.out.println("Original values : " + immutable.getI() +
                " :: " + immutable.getS() + " :: " + immutable.getMap());

        map.put("test", "test");
        System.out.println("After local changes : " + immutable.getI() +
                " :: " + immutable.getS() + " :: " + immutable.getMap());

        HashMap<String, String> test = immutable.getMap();
        test.put("test", "test");
        System.out.println("After ancestral changes : " + immutable.getI()
                + " :: " + immutable.getS() + " :: " + immutable.getMap());
    }
}