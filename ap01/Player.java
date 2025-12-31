/**
 * A player in a game of crazy eights.
 */
public class Player {

    protected String name;
    protected EightsHand hand;

    /**
     * Constructs a player with an empty hand.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new EightsHand(name);
    }

    /**
     * Gets the player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's hand.
     */
    public EightsHand getHand() {
        return hand;
    }

    /**
     * Removes and returns a legal card from the player's hand.
     */
    public Card play(Eights eights, Card prev) {
        for(int i = 0; i < hand.size(); i++){
            if(hand.getCard(i).getRank() == 8)
                return hand.popCard(i);
        }
        EightsCard card = searchForMatch(prev);
        if (card == null) {
            card = drawForMatch(eights, prev);
        }
        return card;
    }

    /**
     * Searches the player's hand for a matching card.
     */
    public EightsCard searchForMatch(Card prev) {
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.getCard(i);
            EightsCard eightsCard = new EightsCard(card.getRank(), card.getSuit());
            if (eightsCard.match(prev)) {
                Card pop = hand.popCard(i);
                return new EightsCard(pop.getRank(), pop.getSuit());
            }
        }
        return null;
    }

    /**
     * Draws cards until a match is found.
     */
    public EightsCard drawForMatch(Eights eights, Card prev) {
        while (true) {
            Card card = eights.draw();
            EightsCard eightsCard = new EightsCard(card.getRank(), card.getSuit());
            System.out.println(name + " draws " + card);
            if (eightsCard.match(prev)) {
                return eightsCard;
            }
            hand.addCard(card);
        }
    }

    /**
     * Checks whether two cards match.
     */
    public static boolean cardMatches(Card card1, Card card2) {
        if (card1.getSuit() == card2.getSuit()) {
            return true;
        }
        if (card1.getRank() == card2.getRank()) {
            return true;
        }
        if (card1.getRank() == 8) {
            return true;
        }
        return false;
    }

    /**
     * Calculates the player's score (penalty points).
     */
    public int score() {
        return hand.scoreHand();
    }

    /**
     * Displays the player's hand.
     */
    public void display() {
        hand.display();
    }

    /**
     * Displays the player's name and score.
     */
    public void displayScore() {
        System.out.println(name + " has " + score() + " points");
    }

}
