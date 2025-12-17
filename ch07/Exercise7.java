import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {

        loop(10);
        System.out.println(squareRoot(9.0));
        System.out.println(power(2.0,8));
        System.out.println(factorial(8));
        System.out.println(myexp(8.0,100));
        check(1);
        for(double i=0.1; i<=100.0; i*=10){
            check(i);
        }
        System.out.println("The values of exponential e^x for x=-0.1,-1.0,-10.0,-100.0 are:");
        for(double i=-0.1; i>=-100.0; i*=10){
            System.out.println(myexp(i,100));
        }
        System.out.println(gauss(2.0,100));
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
     * This method calculates an approximation
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
     * This method calculates
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

    /**
     * This method computes the factorial function
     * of a given integer n.
     * @param n the argument of the factorial function
     * @return the value of the factorial function
     */
    public static int factorial(int n){
        int result = 1;
        for(int i=n;i > 1; i--){
            result *= i;
        }
        return result;
    }

    /**
     * This method calculates e^x
     * using an infinite series expansion,
     * whose i^th term is: x^i/i!.
     * @param x the exponent of the exponential
     * @param n the number of terms of the series
     *          we want to add
     * @return the value of the exponential
     */
    public static double myexp(double x, int n){
        double result = 1;
        double temp = 1;
        for(int i=1; i <= n; i++){
            temp *= x/i;
            result += temp;
        }
        return result;
    }

    /**
     * This method compares the values of the exponential e^x
     * computed ith this class' method 'myexp' and
     * the ones computed with Math.exp(), showing them
     * in different columns.
     * @param x the exponent of the function to calculates
     */
    public static void check(double x){
        System.out.print(x);
        System.out.print("\t");
        System.out.print(myexp(x,100));
        System.out.print("\t");
        System.out.print(Math.exp(x));
        System.out.println();
    }

    /**
     * This method calculates exp(-x^2),
     * given an integer x, using an
     * infinite series expansion of Gauss.
     * @param x the argument of the exponential
     * @param n the number of terms of the series
     * @return the value of the exponential
     */
    public static double gauss(double x, int n){
        double result = 1;
        double temp = 1;
        for(int i=1; i<=n; i++){
            temp *= -x*x/i;
            result += temp;
        }
        return result;
    }

}
