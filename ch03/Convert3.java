import java.util.Scanner;

/**
 * This program converts a total number of seconds
 * to hours, minutes, and seconds.
 */

public class Convert3 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        final int SECONDS_PER_MINUTE = 60;
        final int MINUTES_PER_HOUR = 60;
        int hour = 0, minute = 0;
        int second;

        //prompt the user and get the value
        System.out.print("Exactly how many seconds? ");
        int secondInput = in.nextInt();

        //convert and output the result
        minute += secondInput / SECONDS_PER_MINUTE;
        second = secondInput % SECONDS_PER_MINUTE;
        hour += minute / MINUTES_PER_HOUR;
        minute = minute % MINUTES_PER_HOUR;
        System.out.printf("%d seconds = %d hours, %d minutes and %d seconds", secondInput, hour, minute, second);
    }
}
