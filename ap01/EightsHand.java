import java.util.ArrayList;

public class EightsHand extends Hand{



    public EightsHand(String label) {
        super(label);
    }

    public int scoreHand(){
        int score = 0;
        for(int i=0; i < this.size(); i++){
            EightsCard card = this.getCard(i);
            score += card.scoreCard();
        }
        return score;
    }

    @Override
    public EightsCard getCard(int i) {
        Card c = cards.get(i);
        return new EightsCard(c.getRank(),c.getSuit());
    }
}
