public class Big {

    /**
     * Computes the factorial function
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
}
