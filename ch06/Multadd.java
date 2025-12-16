public class Multadd {
    public static void main(String[] args){
        System.out.println(multadd(1.0,2.0,3.0));
        System.out.println(multadd(Math.cos(Math.PI/4),0.5,Math.sin(Math.PI/4)));
        System.out.println(multadd(Math.log(10), 1.0,Math.log(20)));
        System.out.println(expSum(0.0));
    }

    public static double multadd(double a, double b, double c){
        return a * b + c;
    }

    public static double expSum(double x){
        return multadd(x, Math.exp(-x), Math.sqrt(1.0 - Math.exp(-x)));
    }
}
