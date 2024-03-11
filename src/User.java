import java.util.ArrayList;

import javax.swing.JLayeredPane;

public abstract class User {
    static final int INIT_CARD = 7;
    static final int GAP_CARD_HORIZONTAL = 50; // 50px gap each card
    static final int GAP_CARD_VERTICAL = 20;

    protected ArrayList<Card> cards;

    User(Deck deck) {
        this.cards = new ArrayList<Card>();

        for (int i = 0; i < INIT_CARD; i++) {
            Card card = deck.getOneCard();

            // set index to do event handler
            card.index = i;

            cards.add(card);
        }
    }

    public void onCardClick(Card card) {
        // Handle card click in the User class
        System.out.println("Card clicked: " + card.getColor() + "-" + card.getRank());
    }

    // number of cards user have...
    public int size() {
        return cards.size();
    }

    public void hitTheCard() {

    }

    public abstract JLayeredPane printCards();

    public ArrayList<Card> getCards() {
        return cards;
    }

    // public void drawCard(Deck deck) {
    //     Card card = deck.getOneCard();
    //     cards.add(card);
    // }
}
