import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {

        loop(10);
        System.out.println(squareRoot(9.0));
        System.out.println(power(2.0,8));
    }

    public static void loop(int n) {
        int i = n;
        while (i > 1) {
            System.out.println(i);
            if (i % 2 == 0) {
                i = i / 2;
            } else {
                i = i + 1;
            }
        }
    }

    /**
     * This method calculate an approximation
     * of the square root of a number
     * @param a the number whose root will be found
     * @return the approximated result of the square root
     */
    public static double squareRoot(double a){
        Scanner in = new Scanner(System.in);
        boolean ok;
        System.out.println("Type a number: ");
        do{ //number input check
            ok = true;
            if(!in.hasNextDouble()){
                ok = false;
                String word = in.next();
                System.err.println(word + " is not a number!");
            }
        }while(!ok);
        double x;
        while(true){ //positive input check
            x = in.nextDouble();
            if(x<=0){
                System.out.println("number is non-positive");
                continue;
            } else{break;}
        };
        double x1 = x;
        do{ //compute and return the result of the square
            x = x1;
            x1 = (x + a/x) / 2;
        }while(Math.abs(x-x1)>0.0001);
        return x1;
    }

    /**
     * This method calculate
     * the value of the power x^n.
     * @param x the base of the power
     * @param n the exponent of the power
     * @return the result of the power
     */
    public static double power(double x, int n) {
        while (n < 0) {
            System.err.println("Exponent must be non-negative!");
            break;
        }
        double power = x;
        while (n > 0) {
            if (n % 2 == 0) {
                power *= Math.pow(x, n / 2);
                n = n/2;
            } else {
                power *= Math.pow(x, n - 1);
                n--;
            }
        }
        return power;
    }

}
