/**
 * A deck of playing cards.
 */
public class Deck1 extends CardCollection {

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck1(String label) {
        super(label);

        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                addCard(new Card(rank, suit));
            }
        }
    }

}
