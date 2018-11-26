package by.matrosov.algorithms.hashcode;


import java.util.List;

public class Entity {

    private boolean aBoolean;
    private byte aByte;
    private char aChar;
    private short aShort;
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private Object object;
    private List<Integer> list;

    @Override
    public int hashCode() {
        int result = 17;

        result = result * 37 + (aBoolean ? 0 : 1);
        result = result * 37 + (int)aByte;
        result = result * 37 + (int)aChar;
        result = result * 37 + (int)aShort;
        result = result * 37 + anInt;
        result = result * 37 + (int)(aLong ^ (aLong >>> 32));
        result = result * 37 + Float.floatToIntBits(aFloat);
        result = result * 37 + (int)(Double.doubleToLongBits(aDouble) ^ (Double.doubleToLongBits(aDouble) >>> 32));
        result = result * 37 + (object == null ? 0 : object.hashCode());

        return result;
    }
}