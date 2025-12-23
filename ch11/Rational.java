public class Rational {
    private int numerator;
    private int denominator;

    public Rational() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void printRational(){
        System.out.printf("%d / %d",this.numerator,this.denominator);
        System.out.println();
    }

    public void negate(){
        this.numerator = -this.numerator;
    }

    public void invert(){
        int temp = this.numerator;
        this.numerator= this.denominator;
        this.denominator = temp;
    }

    public double toDouble(){
        return (double) this.numerator / (double) this.denominator;
    }

    public Rational reduce(){
        Rational reduced = new Rational(this.numerator,this.denominator);
        int remainder = 1;
        while(remainder != 0){
            remainder = reduced.numerator % reduced.denominator;
            reduced.numerator = reduced.denominator;
            reduced.denominator = remainder;
        }
        int gdc = reduced.numerator;
        reduced.denominator = this.denominator / gdc;
        reduced.numerator = this.numerator / gdc;
        return reduced;
    }

    public Rational add(Rational rational){
        Rational r = new Rational();
        r.denominator = rational.denominator * this.denominator;
        r.numerator = rational.numerator * this.denominator + this.numerator * rational.denominator;
        r = r.reduce();
        return r;
    }

    @Override
    public String toString() {
        return "Rational{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    public static void main(String[] args){
        Rational rational = new Rational();
        rational.numerator = 7;
        rational.denominator = 3;
        rational.printRational();
        System.out.println(rational);
        rational.negate();
        System.out.println(rational);
        rational.invert();
        System.out.println(rational);
        System.out.println(rational.toDouble());
        Rational r1 = new Rational(48,18);
        System.out.println(r1.reduce());
        Rational r2 = r1.reduce();
        System.out.println(r2.add(rational));
    }
}
