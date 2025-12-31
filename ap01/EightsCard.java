public class EightsCard extends Card{

    public EightsCard(int rank, int suit) {
        super(rank,suit);
    }

    /**
     * Checks whether two cards match.
     */
    public boolean match(Card card2) {
        if (this.getSuit() == card2.getSuit()) {
            return true;
        }
        if (this.getRank() == card2.getRank()) {
            return true;
        }
        return this.getRank() == 8;
    }

    public int scoreCard(){
        int score;
        int rank = this.getRank();
        if (rank == 8) {
            score = -20;
        } else if (rank > 10) {
            score = -10;
        } else {
            score = -rank;
        }
        return score;
    }


}
