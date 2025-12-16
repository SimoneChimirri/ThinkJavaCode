public class Recursive {

    public static void main(String[] args) {
        System.out.println(prodNoTempVar(1, 4));
    }

    public static int prod(int m, int n) {
        if (m == n) {
            return n;
        } else {
            int recurse = prod(m, n - 1);
            int result = n * recurse;
            return result;
        }
    }

    public static int prodNoTempVar(int m, int n){
        if (m == n) {
            return n;
        } else {
            return n * prod(m, n - 1);
        }
    }

}
