package by.matrosov.interview;

public class ClocksAngle {
    public static void main(String[] args) {
        double hours = 12;
        double minutes = 25;

        calculateAngle(hours, minutes);
    }

    private static void calculateAngle(double h, double m){
        //1 hour = 30 grad
        //1 min = 6 grad

        double hoursAngle = h * 30;
        double minutesAngle = m * 6;

        double result1;
        double result2;
        if (hoursAngle < minutesAngle){
            result1 = minutesAngle - hoursAngle;
            result2 = 360 - result1;
        }else if (hoursAngle > minutesAngle){
            result1 = hoursAngle - minutesAngle;
            result2 = 360 - result1;
        }else {
            result1 = result2 = 0;
        }

        System.out.println(result1 + " and " + result2);
    }
}
