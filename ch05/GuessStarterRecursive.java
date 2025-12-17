import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.abs;

/**
 * "Guess My Number" exercise,
 * implemented with a recursive method.
 */
public class GuessStarterRecursive {

    public static void main(String[] args) {
        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("(including both). Can you guess what it is?");

        // pick a random number
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        userGuess(number);


        System.out.print("The number I was thinking of is: ");
        System.out.println(number);


    }

    /**
     * This method prompts the user for his guess,
     * gets the value and tells him if it was too high or too low.
     * @param random the random generated number to guess
     */
    public static void userGuess(int random){

        Scanner in = new Scanner(System.in);

        //prompt the user and get the value
        System.out.print("Type a number: ");
        int guess = in.nextInt();
        System.out.printf("Your guess is: %d\n", guess);


        //tell the user whether the guess is correct, too high or too low
        if(guess == random){ //base case
            System.out.println("Correct!");
        }
        else{
            if(guess > random){
                System.out.println("The value was too high!");
            }
            else{
                System.out.println("The value was too low!");
            }
            System.out.println("Try again!");
            userGuess(random);
        }
    }

}
