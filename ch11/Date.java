public class Date {

    private int year;
    private int month;
    private int day;

    public Date() {
        this.year = 2025;
        this.month = 12;
        this.day = 23;
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static void main(String[] args){
        Date birthDate = new Date(2004, 2, 1);
    }
}
