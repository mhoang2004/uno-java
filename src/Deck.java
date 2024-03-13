import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // 10: skip, 11: reverse, 12: drawtwo
    static final String[] ranks = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "DRAWTWO", "REVERSE", "SKIP" };
    static final String[] colors = { "B", "G", "Y", "R" };

    private ArrayList<Card> deck;

    Deck() {
        if (deck != null)
            deck.clear();
        this.createDeck();
        this.shuffleDeck();
    }

    private void createDeck() {
        deck = new ArrayList<Card>();
        Card tempCard;

        for (String color : colors) {
            for (String rank : ranks) {
                tempCard = new Card(color, rank);
                deck.add(tempCard);

                if (rank != "0") // except "0" any else will have 2 cards
                    deck.add(new Card(tempCard));
            }
        }

        for (int i = 0; i < 4; i++) {
            tempCard = new Card(null, "WILD"); // 4 wild card
            deck.add(tempCard);
        }

        for (int i = 0; i < 4; i++) {
            tempCard = new Card(null, "DRAWFOUR"); // 4 +4 card
            deck.add(tempCard);
        }
    }

    private void shuffleDeck() {
        int size = deck.size();
        Random random = new Random();
        int j;
        for (int i = 0; i < size; i++) {
            j = random.nextInt(size);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int size() {
        return deck.size();
    }

    public Card getOneCard() {
        return deck.remove(0);
    }
}
