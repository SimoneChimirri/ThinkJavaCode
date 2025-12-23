import java.util.Arrays;
import java.util.Random;

/**
 * A deck of playing cards (of fixed size).
 */
public class Deck {

    private Card[] cards;

    /**
     * Constructs a standard deck of 52 cards.
     */
    public Deck() {
        this.cards = new Card[52];
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                this.cards[index] = new Card(rank, suit);
                index++;
            }
        }
    }

    /**
     * Constructs a deck of n cards (null).
     */
    public Deck(int n) {
        this.cards = new Card[n];
    }

    /**
     * Gets the internal cards array.
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Displays each of the cards in the deck.
     */
    public void print() {
        for (int i = 0; i < this.cards.length; i++) {
            System.out.println(this.cards[i]);
        }
    }

    /**
     * Returns a string representation of the deck.
     */
    public String toString() {
        return Arrays.toString(this.cards);
    }

    /**
     * Chooses a random number between low and high, including both.
     */
    public int randomInt(int low, int high) {
        return low + (int) (Math.random() * (high - low + 1));
    }

    /**
     * Swaps the cards at indexes i and j.
     */
    public void swapCards(int i, int j) {
        Card temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
    }

    /**
     * Randomly permutes the array of cards.
     */
    public void shuffle() {
        int i = randomInt(0,51);
        int j = randomInt(0,51);
        swapCards(i, j);
    }

    /**
     * Finds the index of the lowest card
     * between low and high inclusive.
     */
    public int indexLowest(int low, int high) {
        int index = low;
        Card lowestCard = cards[low];
        for(int i=low; i < high; i++){
            if(cards[i].compareTo(lowestCard) == -1){
                index = i;
                lowestCard = cards[i];
            }
        }
        return index;
    }

    /**
     * Sorts the cards (in place) using selection sort.
     */
    public void selectionSort() {
        for(int i = 0; i < cards.length; i ++){
            int index = indexLowest(i, cards.length);
            swapCards(i, index);
        }
    }

    /**
     * Returns a subset of the cards in the deck.
     */
    public Deck subdeck(int low, int high) {
        Deck sub = new Deck(high - low + 1);
        for (int i = 0; i < sub.cards.length; i++) {
            sub.cards[i] = this.cards[low + i];
        }
        return sub;
    }

    /**
     * Combines two previously sorted subdecks.
     */
    public static Deck merge(Deck d1, Deck d2) {
        int i = 0;
        int j = 0;
        int resultLength = d1.cards.length + d2.cards.length;
        Deck mergeDeck = new Deck(resultLength);
        for(int k = 0; k < resultLength; k++){
            if(i >= d1.cards.length) {
                mergeDeck.cards[k] = d2.cards[j];
                j++;
            }else if(j >= d2.cards.length) {
                mergeDeck.cards[k] = d1.cards[i];
                i++;
            }else if(d1.cards[i].compareTo(d2.cards[j]) < 0){
                mergeDeck.cards[k] = d1.cards[i];
                i ++;
            } else{
                mergeDeck.cards[k] = d2.cards[j];
                j ++;
            }
        }
        return mergeDeck;
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     */
    public Deck mergeSort() {
        int mid = (cards.length - 1) / 2 + 1;
        Deck d1 = subdeck(0, mid - 1);
        Deck d2 = subdeck(mid, cards.length -1);
        d1.selectionSort();
        d2.selectionSort();
        return merge(d1, d2);
    }

    /**
     * Returns a sorted copy of the deck using merge sort.
     * (recursive version)
     */
    public Deck mergeSortRecursive() {
        if(cards.length == 0 || cards.length == 1){ //base case
            return this;
        }
        int mid = (cards.length - 1) / 2 + 1;
        Deck d1 = subdeck(0, mid - 1);
        Deck d2 = subdeck(mid, cards.length -1);
        d1 = d1.mergeSortRecursive();
        d2 = d2.mergeSortRecursive();
        return merge(d1, d2);
    }

    /**
     * Reorders the cards (in place) using insertion sort.
     */
    public void insertionSort() {
        for (int i = 1; i < cards.length; i++) {
            for (int k = i; k > 0 && cards[k].compareTo(cards[k - 1]) < 0; k--) {
                swapCards(k, k - 1);
            }
        }

    }

}
