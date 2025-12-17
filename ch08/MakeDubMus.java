/**
 * Stack diagram exercise.
 */
public class MakeDubMus {

    public static int[] make(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        return a;
    }

    public static void dub(int[] jub) {
        for (int i = 0; i < jub.length; i++) {
            jub[i] *= 2;
        }
    }

    /**
     * This method computes the sum of the values
     * of a given int array.
     * @param zoo an int array
     * @return the sum of the elements
     */
    public static int mus(int[] zoo) {
        int fus = 0;
        for (int i = 0; i < zoo.length; i++) {
            fus += zoo[i];
        }
        return fus;
    }

    public static void main(String[] args) {
        int[] bob = make(5);
        dub(bob);
        System.out.println(mus(bob));
    }

}
