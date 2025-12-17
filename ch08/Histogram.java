import java.util.Random;

/**
 * Example code related to histograms.
 */
public class Histogram {

    /**
     * Returns an array of random integers.
     */
    public static int[] randomArray(int size) {
        Random random = new Random();
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(100);
        }
        return a;
    }

    /**
     * Computes the number of array elements in [low, high).
     */
    public static int inRange(int[] a, int low, int high) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= low && a[i] < high) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method finds the maximum value
     * in an int array, but
     * only considering the elements
     * between lowIndex and highIndex,
     * two given integers, including both.
     * @param array an int array
     * @param lowIndex the minimum value considered
     * @param highIndex the maximum value considered
     * @return the maximum element in the range if found,
     * an error message and a fake number otherwise
     */
    public static int maxInRange(int[] array, int lowIndex, int highIndex){
        int max, max1, max2;
        if(lowIndex==highIndex){ //base case
            max = array[lowIndex];
            }
        else {
            int count = 0;
            if(highIndex-lowIndex==1){
                max1=maxInRange(array,lowIndex,lowIndex);
                max2=maxInRange(array,highIndex,highIndex);
                if(max1>=max2)
                    max = max1;
                else
                    max = max2;
            }else {
                int halfInterval = highIndex - (highIndex - lowIndex) / 2;
                max1 = array[lowIndex];
                for (int i = lowIndex; i < halfInterval; i++) {
                    if (array[i] > max1) {
                        max1 = array[i];
                    }
                }
                max2 = array[halfInterval];
                for (int i = halfInterval; i < highIndex; i++) {
                    if (array[i] > max2) {
                        max2 = array[i];
                    }
                }
                if (max1 > max2)
                    max = maxInRange(array, lowIndex, halfInterval);
                else if (max2 > max1)
                    max = maxInRange(array, halfInterval, highIndex);
                else
                    max = max1;
            }
        }
        return max;
    }

    public static double max(int[] a){
        return maxInRange(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int numValues = 8;
        int[] array = randomArray(numValues);
        ArrayExamples.printArray(array);

        int[] scores = randomArray(30);
        int a = inRange(scores, 90, 100);
        int b = inRange(scores, 80, 90);
        int c = inRange(scores, 70, 80);
        int d = inRange(scores, 60, 70);
        int f = inRange(scores, 0, 60);

        // making a histogram
        int[] counts = new int[100];
        for (int i = 0; i < scores.length; i++) {
            int index = scores[i];
            counts[index]++;
        }

        // histogram with enhanced for loop
        counts = new int[100];
        for (int score : scores) {
            counts[score]++;
        }

        System.out.println(maxInRange(array,2,5));
    }

}
