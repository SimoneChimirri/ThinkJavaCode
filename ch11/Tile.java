import java.util.Objects;

public class Tile {

    private char letter;
    private int value;

    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public static void printTile(Tile tile){
        System.out.print("Tile's letter: ");
        System.out.println(tile.letter);
        System.out.println("Tile's value: ");
        System.out.println(tile.value);
    }

    public static void testTile(){
        Tile tile = new Tile('Z',10);
        printTile(tile);
    }

    @Override
    public String toString() {
        return "Tile{" +
                "letter=" + letter +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tile tile)) return false;
        return letter == tile.letter && value == tile.value;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
