public class Exercise6 {

    public static void main(String[] args) {
        boolean flag1 = isHoopy(202);
        boolean flag2 = isFrabjuous(202);
        System.out.println(flag1);
        System.out.println(flag2);
        if (flag1 && flag2) {
            System.out.println("ping!");
        }
        if (flag1 || flag2) {
            System.out.println("pong!");
        }
        System.out.println(isDivisible(4,0));
        System.out.println(isTriangle(2,3,8));
        System.out.println(oddSum(9));
        System.out.println(ack(3, 3));
        System.out.println(power(6, 3));
    }

    public static boolean isHoopy(int x) {
        boolean hoopyFlag;
        if (x % 2 == 0) {
            hoopyFlag = true;
        } else {
            hoopyFlag = false;
        }
        return hoopyFlag;
    }

    public static boolean isFrabjuous(int x) {
        boolean frabjuousFlag;
        if (x > 0) {
            frabjuousFlag = true;
        } else {
            frabjuousFlag = false;
        }
        return frabjuousFlag;
    }

    public static boolean isDivisible(int n, int m){
        if(m != 0)
            return n % m == 0;
        else {
            System.err.println("divisor must not be null!");
            return false;
        }
    }

    public static boolean isTriangle(int x, int y, int z){
        return !((x > y + z) || (y > x + z) || (z > x + y));
    }

    public static int oddSum(int n){
        if((n%2==0)||(n<=0)){
            System.out.println("Integer n must be odd and positive");
            return 0;
        } else if(n==1){ //base case
            System.out.println(n);
            return n;
        } else{
            System.out.println(n);
            int progressiveSum = n + oddSum(n-2);
            return progressiveSum;
        }
    }

    /**
     * This method calculates the value of the
     * Ackermann function given two non-negative integers
     * @param m the first non-negative integer
     * @param n the second non-negative integer
     * @return the integer result of the Ackermann function
     */
    public static int ack(int m, int n){
        if((n<0)||(m<0)){
            System.out.println("Integers must be non-negative!");
            return 0;
        } else if(m==0){ //base case
            return n + 1;
        } else if(n==0){
            return ack(m -1, 1);
        } else{
            return ack(m - 1, ack(m,n - 1));
        }
    }

    /**
     * This recursive method calculates
     * the value of the power x^n.
     * @param x the base of the power
     * @param n the exponent of the power
     * @return the result of the power
     */
    public static double power(double x, int n){
        if(n<0) {
            System.out.println("Exponent must be non-negative!");
            return 0.0;
        } else if(n==0){ //base case
                return 1;
        } else if(n%2==0){ //escape case if the exponent n is even
            return Math.pow(power(x, n/2), 2);
        } else{ //recursive case
            return x * power(x, n-1);
        }
    }
}



