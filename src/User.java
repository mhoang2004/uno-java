import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class User {
    static int INIT_CARD = 7;
    static int GAP_CARD = 50; // 50px gap each card

    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;
    private ArrayList<Card> suggestedCards;
    
    User(Deck deck) {
        this.cards = new ArrayList<Card>();
        this.selectedCards = new ArrayList<Card>();

        for (int i = 0; i < INIT_CARD; i++) {
            Card card = deck.getOneCard();
            cards.add(card);
        }
    }

    // number of cards user have...
    public int size() {
        return cards.size();
    }

    public JLayeredPane getCards(Card previousCard) {
        // JLayeredPane = Swing container that provieds a third dimension for
        // positioning components. Ex: depth, z-index
        JLayeredPane layeredPane = new JLayeredPane();

        // using setPreferredSize() no guarantee that the layout manager will honor the
        // preferred size exactly.
        layeredPane.setPreferredSize(new Dimension(Card.WIDTH, Card.HEIGHT));

        int x = (MyFrame.WIDTH - (Card.WIDTH + size() * GAP_CARD)) / 2;
        int test = 0;

        for (Card card : cards) {
            test++;
            if (test == 3) {
                card.setY();
            }
        
            card.setBounds(x, card.getY(), Card.WIDTH, Card.HEIGHT);
            x = x + GAP_CARD;

            layeredPane.add(card);
            layeredPane.moveToFront(card);

            // suggestion effect
            if(previousCard.getColor() == card.getColor() || previousCard.getRank() == card.getRank()) {
                card.suggestedEffect();
            }
        }

        return layeredPane;
    }
}
