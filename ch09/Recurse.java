/**
 * Recursion exercise.
 */
public class Recurse {

    /**
     * Returns the first character of the given String.
     */
    public static char first(String s) {
        return s.charAt(0);
    }

    /**
     * Returns all but the first letter of the given String.
     */
    public static String rest(String s) {
        return s.substring(1);
    }

    /**
     * Returns all but the first and last letter of the String.
     */
    public static String middle(String s) {
        return s.substring(1, s.length() - 1);
    }

    /**
     * Returns the length of the given String.
     */
    public static int length(String s) {
        return s.length();
    }

    /**
     * Returns the letters of a string, one on each line.
     */
    public static void printString(String s){
        if(length(s) == 1){ //base case
            System.out.println(first(s));
        } else{ //recursive case
            System.out.println(first(s));
            printString(rest(s));
        }
    }

    /**
     * Returns the letters of a string backward,
     * one on each line.
     */
    public static void printBackward(String s){
        if(length(s) == 1){ //base case
            System.out.println(first(s));
        } else{ //recursive case
            printString(rest(s));
            System.out.println(first(s));
        }
    }

    /**
     * Returns a string with letters in reverse order,
     * given an initial string.
     */
    public static String reverseString(String s){
        if(length(s) == 1){ //base case
            String r = "";
            r += first(s);
            return r;
        } else{ //recursive case
            return reverseString(rest(s)) + first(s);
        }
    }

    /**
     * Returns true whether a string is a palindrome,
     * false otherwise.
     */
    public static boolean isPalindrome(String s){
        if(length(s) == 1){
            return true;
        } else if(length(s) == 2) {
            return first(s) == first(rest(s));
        } else {
            boolean isTruePalindrome = isPalindrome(middle(s));
            if(first(s) == first(reverseString(s))){
                return isTruePalindrome;
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args){
        System.out.println(first("banana"));
        System.out.println(rest("banana"));
        System.out.println(middle("banana"));
        System.out.println(length("banana"));
        printString("banana");
        printBackward("banana");
        String backwards = reverseString("coffee");
        System.out.println(backwards);
        System.out.println(isPalindrome("palindromeemordnilap"));
        System.out.println(isPalindrome("otto"));
    }

}
