package zadaca2;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final List<Double> listOfNumbers = Arrays.asList(23.5, 12345.67, 98.7, 43.456, 12.34, 987.56);

    public double add() {
        double base = 0;
        for (double value : listOfNumbers) {
            base = base + value;
        }
        return base;
    }

    public double sub() {
        double base = 0;
        for (double value : listOfNumbers) {
            base = base - value;
        }
        return base;
    }

}
