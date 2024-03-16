import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public class Player extends User {
    private ArrayList<Card> suggestedCards;

    Player(Deck deck) {
        super(deck);
        this.getLatestPanel();

        for (Card card : cards) {
            card.addMouseListener(card);
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        // suggestedCards();
    }

    public void playerHitCard(Card card) {
        // animation
        // card.setLocation(card.getX(), card.getY());

        hitCard(card);
    }

    public void getLatestPanel() {
        int xPosition = (MyFrame.WIDTH - (Card.WIDTH + (size() - 1) * GAP_CARD_HORIZONTAL)) / 2;
        int yPosition = 50;
        int layer = 0;

        for (Card card : cards) {
            card.setBounds(xPosition, yPosition, Card.WIDTH, Card.HEIGHT);
            xPosition += GAP_CARD_HORIZONTAL;
            panel.add(card, Integer.valueOf(layer++));

            // panel.moveToFront(card);

            // suggestion effect
            // if(previousCard.getColor() == card.getColor() || previousCard.getRank() ==
            // card.getRank()) {
            // card.suggestedEffect();
            // }
        }
        panel.repaint();
    }

}
