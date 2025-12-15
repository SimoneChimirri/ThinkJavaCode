public class Exercise {

    public static void zoop() {
        baffle();
        System.out.print("You wugga ");
        baffle();
    }

    public static void main(String[] args) {
        System.out.print("No, I ");
        zoop();
        System.out.print("I ");
        baffle();
        zool(11, "Marisol", "Torino");
        printAmerican("Saturday", 22, "July", 2015);
        printEuropean("Saturday", 22, "July", 2015);
    }

    public static void baffle() {
        System.out.print("wug");
        ping();
    }

    public static void ping() {
        System.out.println(".");
    }

    public static void zool(int number, String str1, String str2){
    }

    public static void printAmerican(String day, int date, String month, int year){
        System.out.println(day + ", "+ month + " " + date + ", " + year);
    }

    public static void printEuropean(String day, int date, String month, int year){
        System.out.println(day + " "+ date + " " + month + " " + year);
    }
}
