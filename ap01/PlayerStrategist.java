public class PlayerStrategist extends Player{

    public PlayerStrategist(String name){
        super(name);
    }

    @Override
    public Card play(Eights eights, Card prev) {
        for(int i = 0; i < hand.size(); i++){
            if(hand.getCard(i).getRank() == 8)
                return hand.popCard(i);
        }

        int index = hand.size() - 1;
        int rank = 0;
        Card cardHigh = null;
        for(int i = 0; i < hand.size(); i++) {
            if (cardMatches(hand.getCard(i), prev) && hand.getCard(i).getRank() > rank){
                rank = hand.getCard(i).getRank();
                cardHigh = hand.getCard(i);
                index = i;
            }
        }

        if (cardHigh == null) {
            cardHigh = drawForMatch(eights, prev);
            return cardHigh;
        }
        return hand.popCard(index);
    }
}
