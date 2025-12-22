import java.math.BigInteger;

public class Big {

    /**
     * Computes the factorial function
     * of a given BigInteger n.
     * @param n the argument of the factorial function
     * @return the value of the factorial function
     */
    public static BigInteger factorial(BigInteger n){
        BigInteger result = BigInteger.valueOf(1);
        for(BigInteger i = n; i.compareTo(BigInteger.ONE) > 0; i = i.subtract(BigInteger.ONE)){
            result = result.multiply(i);
        }
        return result;
    }

    public static void main(String[] args){
        int x = 17;
        BigInteger big = BigInteger.valueOf(x);
        BigInteger small = BigInteger.valueOf(17);
        BigInteger bigger = BigInteger.valueOf(1700000000);
        BigInteger total = small.add(bigger);
        BigInteger power = small.pow(x);
        BigInteger product = small.multiply(big);
        System.out.println(big);
        System.out.println(small);
        System.out.println(bigger);
        System.out.println(total);
        System.out.println(power);
        System.out.println(product);

        for(BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf(31)) < 0; i = i.add(BigInteger.ONE)){
            System.out.print(i + "\t");
            System.out.print(factorial(i));
            System.out.println();
        }
    }
}




