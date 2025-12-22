/**
 * Exercise on encapsulation and generalization.
 */
public class Exercise9 {

    public static void main(String[] args) {
        System.out.println(encapsuleGeneralize("((3 + 7) * 2)"));
        System.out.println(encapsuleGeneralize("(3 * 5) +6]"));
        System.out.println(encapsuleGeneralize("Henry[the first one"));
        System.out.println(encapsuleGeneralize("I didn't know what to say{it was disgusting}"));
        System.out.println(isAbecedarian("abdest"));
        System.out.println(isAbecedarian("abbey"));
        System.out.println(isAbecedarian("cat"));
        System.out.println(isDoubloon("Emmett"));
        System.out.println(isDoubloon("catR"));
        System.out.println(isAnagram("stop","pots"));
        System.out.println(isAnagram("allen downey","well annoyed"));
        System.out.println(isAnagram("crime","micro"));
        System.out.println(canSpell("quijibo","jib"));
        System.out.println(canSpell("Annabel","Annabelle"));
    }

    public static int encapsuleGeneralize(String s){
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                count++;
            } else if (c == ')' || c == ']' || c == '}') {
                count--;
            }
        }

        return count;
    }

    /**
     * This method determines whether a word is abecedarian,
     * so if the letters in the word appear in alphabetical order.
     * @param s the word given
     * @return true if the word is abecedarian,
     * false otherwise
     */
    public static boolean isAbecedarian(String s){
        boolean isAbecedarian = true;
        s = s.toLowerCase();
        for(int i=1; i < s.length(); i++){
            if(s.charAt(i-1) > s.charAt(i)){
                isAbecedarian = false;
                break;
            }
        }
        return isAbecedarian;
    }

    /**
     * This method checks whether a word is a "doubloon",
     * so if every letter in the word appears exactly twice.
     * @param s the word given
     * @return true if the word is a doubloon,
     * false otherwise
     */
    public static boolean isDoubloon(String s){
        boolean isDoubloon = false;
        s = s.toLowerCase();
        for(int i=0; i < s.length(); i++){
            int count = 0;
            for(int j=0;j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) {
                    count++;
                    if (count == 2) {
                        isDoubloon = true;
                    }
                    else if (count > 2) {
                        isDoubloon = false;
                        break;
                    }
                }
            }
        }
        return isDoubloon;
    }

    /**
     * This method checks whether two words are anagrams
     * of each other, so if they contain the same letters
     * and the same number of each letter.
     * @param s1 the first word given
     * @param s2 the second word given
     * @return true if the two words are anagrams of each other,
     * false otherwise
     */
    public static boolean isAnagram(String s1, String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if(s1.length() != s2.length()){
            return false;
        }
        boolean isAnagram = true;
        for(int i=0; i < s1.length(); i++){
            char c = s1.charAt(i);
            int count = 0;
            for(int k=0; k < s1.length(); k++){
                if(s1.charAt(i)==s1.charAt(k))
                    count++;
            }
            for(int j = 0;j  < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    count --;
                }
            }
            if(count != 0)
                return !isAnagram;
        }
        return isAnagram;
    }

    /**
     * This method checks whether the set of tiles
     * with letters on them can spell the word given,
     * like in the game 'Scrabble'.
     * @param s the tiles with letters on them
     * @param t the word to spell
     * @return true if the tiles can spell the word,
     * false otherwise
     */
    public static boolean canSpell(String s,String t){
        s = s.toLowerCase();
        t = t.toLowerCase();
        if(s.length() < t.length()){
            return false;
        }
        boolean canSpell = true;
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            int count = 0;
            for(int k=0; k < s.length(); k++){
                if(s.charAt(i)==s.charAt(k))
                    count++;
            }
            for(int j = 0;j  < t.length(); j++){
                if(s.charAt(i) == t.charAt(j)){
                    count --;
                }
            }
            if(count < 0)
                return !canSpell;
        }
        return canSpell;
    }

}
