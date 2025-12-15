import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.abs;

/**
 * "Guess My Number" exercise.
 */
public class GuessStarter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("(including both). Can you guess what it is?");

        //prompt the user and get the value
        System.out.print("Type a number: ");
        int guess = in.nextInt();
        System.out.printf("Your guess is: %d\n", guess);

        // pick a random number
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        System.out.print("The number I was thinking of is: ");
        System.out.println(number);

        //compute and display the difference between the user's guess and the number that was generated
        System.out.printf("You were off by: %d", abs(number - guess));


    }

}
