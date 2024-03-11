import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public class Player extends User {
    private int selectedCardIndex;
    private ArrayList<Card> suggestedCards;

    Player(Deck deck) {
        super(deck);

        selectedCardIndex = -1;

        for (Card card : cards) {
            card.addMouseListener(card);
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    public JLayeredPane printCards() {
        // JLayeredPane = Swing container that provides a third dimension for
        // positioning components. Ex: depth, z-index
        JLayeredPane layeredPane = new JLayeredPane();

        // using setPreferredSize() no guarantee that the layout manager will honor the
        // preferred size exactly.
        layeredPane.setPreferredSize(new Dimension(Card.WIDTH, Card.HEIGHT + GAP_CARD_VERTICAL));

        int x = (MyFrame.WIDTH - (Card.WIDTH + (size() - 1) * GAP_CARD_HORIZONTAL)) / 2;

        for (Card card : cards) {
            card.setBounds(x, 50, Card.WIDTH, Card.HEIGHT);

            x += GAP_CARD_HORIZONTAL;

            layeredPane.add(card);
            layeredPane.moveToFront(card);

            // suggestion effect
            // if(previousCard.getColor() == card.getColor() || previousCard.getRank() ==
            // card.getRank()) {
            // card.suggestedEffect();
            // }
        }

        return layeredPane;
    }
}
