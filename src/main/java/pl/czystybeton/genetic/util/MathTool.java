package pl.czystybeton.genetic.util;

public class MathTool {

    public final static int FLOOR = 0x01;
    public final static int CEIL = 0x02;
    public final static int ROUND = 0x03;
    public final static int NOOP = 0x04;

    public static double random(double max) {
        return random(max, 0.0);
    }

    public static int random(int max) {
        return (int)random(max, 0.0);
    }

    public static double random(double max, double min) {
        return random(max, min, FLOOR);
    }

    public static double random(double max, double min, int operator) {
        double value = Math.random() * (max - min) + min;

        switch (operator) {
            case FLOOR:
                return Math.floor(value);
            case CEIL:
                return Math.ceil(value);
            case ROUND:
                return Math.round(value);
            default:
                return value;
        }
    }

}
