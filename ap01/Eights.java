import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulates a game of Crazy Eights.  See
 * https://en.wikipedia.org/wiki/Crazy_Eights
 * for basic play and scoring rules.
 */
public class Eights {

    private Genius one;
    private Player two;
    private ArrayList<Player> players = new ArrayList<>();
    private Hand drawPile;
    private Hand discardPile;
    private Scanner in;

    /**
     * Initializes the state of the game.
     */
    public Eights() {
        Deck1 deck = new Deck1("Deck");
        deck.shuffle();

        // deal cards to each player
        int handSize = 5;
        one = new Genius("Genius");
        deck.deal(one.getHand(), handSize);

        two = new Player("Chris");
        deck.deal(two.getHand(), handSize);

        // turn one card face up
        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        // put the rest of the deck face down
        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);

        // create the scanner we'll use to wait for the user
        in = new Scanner(System.in);
    }

    /**
     * Initializes the state of the game with a
     * non-previously specified number of players.
     */
    public Eights(ArrayList<Player> players){
        Deck1 deck = new Deck1("Deck");
        deck.shuffle();

        // start with the provided players list or receive it from input
        int handSize = 5;
        this.players = new ArrayList<>();

        // create the scanner we'll use to type in from the user
        in = new Scanner(System.in);

        if (players != null && !players.isEmpty()) {
            this.players = players;
            for (Player p : this.players) {
                deck.deal(p.getHand(), handSize);
            }
        } else {
            while(true){
                System.out.println("Type in the name of the player (or 'done' if all the players are ready):");
                String name = in.nextLine().trim();
                if (name.equals("done")) {
                    break;
                }
                Player p = new Player(name);
                this.players.add(p);
                deck.deal(p.getHand(), handSize);
            }

            // if no players were added, use the two default players
            if (this.players.isEmpty()) {
                one = new Genius("Genius");
                deck.deal(one.getHand(), handSize);
                two = new Player("Chris");
                deck.deal(two.getHand(), handSize);
                this.players.add(one);
                this.players.add(two);
            }
        }

        // turn one card face up
        discardPile = new Hand("Discards");
        deck.deal(discardPile, 1);

        // put the rest of the deck face down
        drawPile = new Hand("Draw pile");
        deck.dealAll(drawPile);

    }

    /**
     * Returns true if either hand is empty.
     */
    public boolean isDone() {
        for (Player player : players){
            if(player.getHand().empty())
                return true;
        }
        return false;
    }

    /**
     * Moves cards from the discard pile to the draw pile and shuffles.
     */
    public void reshuffle() {
        // save the top card
        Card prev = discardPile.popCard();

        // move the rest of the cards
        discardPile.dealAll(drawPile);

        // put the top card back
        discardPile.addCard(prev);

        // shuffle the draw pile
        drawPile.shuffle();
    }

    /**
     * Returns a card from the draw pile.
     */
    public Card draw() {
        if (drawPile.empty()) {
            reshuffle();
        }
        return drawPile.popCard();
    }

    /**
     * Switches players.
     */
    public Player nextPlayer(Player current) {
        int index = players.indexOf(current);
        if (index == players.size() - 1) {
            return players.getFirst();
        }
        return players.get(players.indexOf(current) + 1);
    }

    public void displayState() {
        for(Player player: players){
            player.display();
        }
        discardPile.display();
        System.out.print("Draw pile: ");
        System.out.println(drawPile.size() + " cards");
    }

    /**
     * Waits for the user to press enter.
     */
    public void waitForUser() {
        in.nextLine();
    }

    /**
     * One player takes a turn.
     */
    public void takeTurn(Player player) {
        Card prev = discardPile.last();
        Card next = player.play(this, prev);
        discardPile.addCard(next);

        System.out.println(player.getName() + " plays " + next);
        System.out.println();
    }

    /**
     * Plays the game.
     */
    public void playGame() {
        if(players.isEmpty()){
            players.add(one);
            players.add(two);
        }
        Player player = players.getFirst();

        // keep playing until there's a winner
        while (!isDone()) {
            displayState();
            waitForUser();
            takeTurn(player);
            player = nextPlayer(player);
        }

        // display the final score
        for(Player p : players){
            player.displayScore();
        }
    }


    /**
     * Creates a loop that plays the game 100 times.
     */
    private static int[] play100Times() {
        int[] wins = new int[2];
        for(int i=0; i < 100; i++) {
            Eights game = new Eights();
            Player player = game.one;

            // keep playing until there's a winner
            while (!game.isDone()) {
                //displayState();
                //waitForUser();
                game.takeTurn(player);
                player = game.nextPlayer(player);
            }

            if (player == game.two)
                wins[0]++;
            else
                wins[1]++;
        }

        return wins;
    }

    /**
     * Creates the game and runs it.
     */
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        Eights games = new Eights(players);
        games.playGame();
        Eights game = new Eights();
        //game.playGame();
        int[] wins = game.play100Times();
        System.out.printf("%s has won %d times!", game.one.getName(), wins[0]);
        System.out.println();
        System.out.printf("%s has won %d times!", game.two.getName(), wins[1]);
    }

}
