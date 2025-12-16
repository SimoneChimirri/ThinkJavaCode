public class Exercise5 {

    public static void zoop(String fred, int bob) {
        System.out.println(fred);
        if (bob == 5) {
            ping("not ");
        } else {
            System.out.println("!");
        }
    }

    public static void main(String[] args) {
        int bizz = 5;
        int buzz = 2;
        int bezz = 3;
        int n = 4;
        zoop("just for", bizz);
        clink(2 * buzz);
        checkFermat(5,3,4,2);
        checkFermat(2,3,4,5);
    }

    public static void clink(int fork) {
        System.out.print("It's ");
        zoop("breakfast ", fork);
    }

    public static void ping(String strangStrung) {
        System.out.println("any " + strangStrung + "more ");
    }

    public static void checkFermat(int a, int b, int c, int n){
        if(n > 2){
            if(Math.pow(a, n)+Math.pow(b, n) == Math.pow(c, n)){
                System.out.println("Holy smokes, Fermat was wrong!");
            } else {
                System.out.println("No, that doesn't work.");
            }
        } else{
            System.err.println("n must be greater than 2!");
        }
    }
}
