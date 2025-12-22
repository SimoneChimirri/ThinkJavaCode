import java.math.BigInteger;

/**
 * BigInteger exercise.
 */
public class Pow {

    /**
     * Integer exponentiation.
     */
    public static int pow(int x, int n) {
        if (n == 0) return 1;

        // find x to the n/2 recursively
        int t = pow(x, n / 2);

        // if n is even, the result is t squared
        // if n is odd, the result is t squared times x
        if (n % 2 == 0) {
            return t * t;
        } else {
            return t * t * x;
        }
    }

    /**
     * BigInteger exponentiation.
     */
    public static BigInteger powBig(int x, int n) {
        if (n == 0) return BigInteger.ONE;

        // find x to the n/2 recursively
        BigInteger t = powBig(x, n / 2);

        // if n is even, the result is t squared
        // if n is odd, the result is t squared times x
        if (n % 2 == 0) {
            return t.multiply(t);
        } else {
            return t.multiply(t).multiply(BigInteger.valueOf(x));
        }
    }

    public static void main(String[] args){
        System.out.println(pow(4,5));
        System.out.println(powBig(4,5));
        System.out.println(powBig(4,123));
    }

}
