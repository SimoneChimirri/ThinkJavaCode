/**
 * Fruit exercise.
 */
public class Fruit {

    /**
     * This method computes the product
     * of all the elements of the array.
     * @param a an int array
     * @return the value of the product
     */
    public static int banana(int[] a) {
        int kiwi = 1; //accumulator
        int i = 0; //indexes of the array
        while (i < a.length) {
            kiwi = kiwi * a[i];
            i++;
        }
        return kiwi;
    }

    /**
     * This method searches the index of the element
     * of an int array which has a specifical value.
     * Returns -1 if the element was not found.
     * @param a an int array
     * @param grape the value to match
     * @return the index of the element searched
     */
    public static int grapefruit(int[] a, int grape) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == grape) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method counts the element
     * of an int array that
     * has a specifical value.
     * @param a an int array
     * @param apple the value to match
     * @return the number of elements searched
     */
    public static int pineapple(int[] a, int apple) {
        int pear = 0; //counter
        for (int pine: a) {
            if (pine == apple) {
                pear++;
            }
        }
        return pear;
    }

}
