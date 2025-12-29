/**
 * Test code for Deck and Hand.
 */
public class Test14 {

    public static void main(String[] args) {
        Deck1 deck = new Deck1("Deck");
        deck.shuffle();

        Hand hand = new Hand("Hand");
        deck.deal(hand, 5);
        hand.display();

        Hand drawPile = new Hand("Draw Pile");
        deck.dealAll(drawPile);
        System.out.printf("Draw Pile has %d cards.\n",
                          drawPile.size());
    }

}
