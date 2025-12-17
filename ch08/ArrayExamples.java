import java.util.Arrays;

/**
 * Demonstrates uses of arrays.
 */
public class ArrayExamples {

    /**
     * Example code from Chapter 8.
     */
    public static void main(String[] args) {
        int size = 10;
        int[] counts = new int[4];
        double[] values = new double[size];

        counts[0] = 7;
        counts[1] = counts[0] * 2;
        counts[2]++;
        counts[3] -= 60;

        // traversal with a while loop
        int j = 0;
        while (j < 4) {
            System.out.println(counts[j]);
            j++;
        }

        // traversal with a for loop
        for (int i = 0; i < 4; i++) {
            System.out.println(counts[i]);
        }

        int[] array = {1, 2, 3, 4};
        printArray(array);

        // printing an array as an object
        System.out.println(array);

        // printing with Arrays class
        System.out.println(Arrays.toString(array));

        // copying an array
        double[] a = {1.0, 2.0, 3.0};
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        // copying with Arrays class
        double[] c = Arrays.copyOf(a, a.length);

        // traversal
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.pow(a[i], 2.0);
        }

        // search
        int index = search(a, 2.0);
        System.out.println("index = " + index);

        // reduce
        double total = sum(a);
        System.out.println("total = " + total);

        double[] d = powArray(a,3);
        for(int i=0; i < a.length; i++){
            System.out.println(a[i]);
        }

        int[] histogram = histogram(array, 10);
        for(int counter : histogram){
            System.out.println(counter);
        }

        System.out.println(indexOfMax(array));
        System.out.println(sieve(5));
        System.out.println(areFactors(24,array));
        System.out.println(arePrimeFactors(24,array));
    }

    /**
     * Prints the elements of an array.
     */
    public static void printArray(int[] array) {
        System.out.print("{" + array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println("}");
    }

    /**
     * Returns the index of the target in the array, or -1 if not found.
     */
    public static int search(double[] a, double target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the total of the elements in an array.
     */
    public static double sum(double[] a) {
        double total = 0.0;
        for (int i = 0; i < a.length; i++) {
            total += a[i];
        }
        return total;
    }

    /**
     * This method raises the elements of a double
     * array to a given power.
     * @param a the double array
     * @param n the exponent of the power
     * @return a new double array containing the powers
     * of the elements of the initial array
     */
    public static double[] powArray(double[] a, int n){
        for(int i =0; i<a.length; i++){
            a[i] = Math.pow(a[i],n);
        }
        return a;
    }

    /**
     * This method takes an int array of scores
     * and returns a histogram of counters.
     * @param scores the int array containing the
     *               scores to be analyzed
     * @param counters the number of counters to
     *                 return in the histogram
     * @return a new in array ith the counters of
     * the histogram
     */
    public static int[] histogram(int[] scores, int counters){
        int[] counts = new int[counters];
        for (int score : scores){
            counts[score] ++;
        }
        return counts;
    }

    /**
     * This method finds the index of the
     * largest element of a given int array.
     * @param a an int array
     * @return the index of the largest element
     */
    public static int indexOfMax(int[] a){
        int indexOfMax = 0, max = 0;
        for(int i=0; i < a.length; i++){
            if(i==0) {
                max = a[0];
            }
            else{
                if(a[i] > max){
                    max = a[i];
                    indexOfMax = i;
                }
            }
        }
        return indexOfMax;
    }

    /**
     * This method uses the Sieve of Eratosthenes'
     * algorithm to find whether a given positive
     * number is prime.
     * @param n a positive number
     * @return true if the number is prime,
     * false otherwise
     */
    public static boolean sieve(int n){
        boolean isPrime = true;
        int[] numbers = new int[n];
        for(int p = 0; p < numbers.length; p++){
            numbers[p] = p;
        }
        for(int i=2; i <= n/2; i++){
            if(numbers[i]==0)
                continue;
            else if(n%i==0){
                isPrime = false;
            }
            else if(numbers[i]!=0){
                for(int j=i; j <= n/2; j++){
                    if(numbers[j]%i==0)
                        numbers[j] = 0;
                }
            }
        }
        return isPrime;
    }

    /**
     * This method determines whether
     * all the elements of an int array
     * are factors of an integer given.
     * @param n an integer
     * @param a an int array
     * @return true if all the elements
     * are factors of n, false otherwise
     */
    public static boolean areFactors(int n, int[] a){
        boolean areFactors = true;
        for(int number : a){
            if(n%number!=0) {
                areFactors = false;
                break;
            }
        }
        return areFactors;
    }

    public static boolean arePrimeFactors(int n, int[] a){
        boolean arePrimeFactors = true;
        for(int number : a){
            if(!sieve(number)) {
                arePrimeFactors = false;
                break;
            }
        }
        if(!areFactors(n,a))
            arePrimeFactors = false;
        return arePrimeFactors;
    }

}
