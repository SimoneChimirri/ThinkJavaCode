public class Time2 {

    public static void main(String[] args) {
        int hour = 12;
        int minute = 8;
        int second = 57;
        int secondsSinceMidnight = hour * 3600 + minute * 60 + second;
        System.out.print("Number of seconds since midnight: ");
        System.out.println(secondsSinceMidnight);
        int dailySeconds = 24 * 3600;
        int secondsTillMidnight = dailySeconds - secondsSinceMidnight;
        System.out.print("Number of seconds remaining in the day: ");
        System.out.println(secondsTillMidnight);
        double percentage = secondsSinceMidnight * 1.0 / dailySeconds * 1.0 * 100;
        System.out.print("Percent of the day that has passed: ");
        System.out.println(percentage);
        minute = 24;
        second = 36;
        int secondsSinceMidnightEnd = hour * 3600 + minute * 60 + second;
        int elapsedTimeInSeconds = secondsSinceMidnightEnd - secondsSinceMidnight;
        System.out.print("Elapsed time since you started working on this exercise: ");
        System.out.println(elapsedTimeInSeconds + " seconds");
    }
}
