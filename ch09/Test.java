public class Test {

    public static void main(String[] args){
        String s = "Samuel"+'B'; //String + char permitted, concatenation
        System.out.println(s.toUpperCase());
        System.out.println('B'+"Samuel"); //char + String permitted, concatenation
        boolean vero = true;
        System.out.println("ZeroB"+vero); //String + boolean permitted, concatenation
        System.out.println(vero+"ZeroB"); //boolean + String permitted, concatenation
        int x = 9;
        System.out.println("Zero"+x); //String + int permitted, concatenation
        System.out.println(x+"Zero"); //int + String permitted, concatenation
        double c = 3.9;
        System.out.println("Zero"+c); //String + double permitted, concatenation
        System.out.println(c+"Zero"); //double + String permitted, concatenation
        System.out.println(x+c); //double + int and int + double permitted, double sum
        System.out.println('c'+x); //char + int permitted, sum of int
        System.out.println(x+'c'); //int + char permitted, sum of int
        System.out.println('c'+c); //char + double permitted, sum of double
        System.out.println(c+'c'); //double + char permitted, sum of double
        //System.out.println('c'+vero); char + boolean not legal
        //System.out.println(vero+'c'); boolean + char not legal
        //System.out.println(vero+c); boolean + double not legal
        //System.out.println(vero+x); boolean + int not legal
        //System.out.println(c+vero); int/double + bool not legal
        char t = 'b';
        //t = t + 1; Incompatible types. Found: 'int', required: 'char'
        System.out.println(""+5);// 5
        int[] histogram = letterHist("alpha");
        for(int occurrence: histogram){
            System.out.println(occurrence);
        }
    }

    public static int[] letterHist(String s){
        String lows = s.toLowerCase();
        int[] histogram = new int[26];
        for(int i=0; i < lows.length(); i++){
            if((int)lows.charAt(i)-97<26&&(int)lows.charAt(i)-97>=0)
                histogram[(int)lows.charAt(i)-97]++;
        }
        return histogram;
    }
}
