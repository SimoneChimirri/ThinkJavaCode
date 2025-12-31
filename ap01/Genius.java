public class Genius extends Player{

    public Genius(String name){
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
        EightsCard cardHigh = null;
        for(int i = 0; i < hand.size(); i++) {
            if (hand.getCard(i).match(prev) && hand.getCard(i).getRank() > rank){
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
