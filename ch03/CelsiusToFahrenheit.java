import java.util.Scanner;

/**
 * Converts Celsius to Fahrenheit.
 */

public class CelsiusToFahrenheit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        //prompt the user and get the value
        System.out.print("What is the temperature in Celsius? ");
        double celsius = in.nextDouble();
        final double COEFFICIENT = 9.0 / 5.0;
        final int VALUE_TO_ADD = 32;

        //convert and output the result
        double fahrenheit = celsius * COEFFICIENT + VALUE_TO_ADD;
        System.out.printf("%.1f C = %.1f F", celsius, fahrenheit);
    }

}
