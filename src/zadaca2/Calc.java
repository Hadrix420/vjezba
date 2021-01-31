package zadaca2;

import java.util.Arrays;
import java.util.List;

public class Calc {
    private final static List<Double> listOfNumbers = Arrays.asList(23.5, 12345.67, 98.7, 43.456, 12.34, 987.56);

    private static double add() {
        double base = 0;
        for (double value : listOfNumbers) {
            base = base + value;
        }
        return base;
    }

    private static double sub() {
        double base = 0;
        for (double value : listOfNumbers) {
            base = base - value;
        }
        return base;
    }

    private static double div(){
        double base = listOfNumbers.get(0);
        for(double value: listOfNumbers){
            if(!(base==value)){
                base = base/value;
            }
        }
        return base;
    }
    private static double mul(){
        double base = listOfNumbers.get(0);
        for(double value: listOfNumbers){
            if(!(base==value)){
                base = base * value;
            }
        }
        return base;
    }

    public static void printAdd(){
        System.out.println("Result of addition is: " + add());

    }
    public static void printSub(){
        System.out.println("Result of substitution is: " + sub());
    }
    public static void printDiv(){
        System.out.println("Result of division is: " +div());
    }
    public static void printMul(){
        System.out.println("Result of multiplication is: " +mul());
    }

}
