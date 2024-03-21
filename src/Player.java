import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public class Player extends User {
    public static boolean choosingColor;
    Player(Deck deck) {
        super(deck);
        this.getLatestPanel();
        ID = "Player";
        choosingColor = true;
         for (Card card : cards) {
            card.addMouseListener(card);
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        for (Card card : suggestedCards) {
            card.suggestedEffect();
        }
        // if(cards.get(0).getColor() != null)
        // {
        //     cards.set(0, new Card(null, "WILD"));
        // }
        // for (Card card : cards) {
        //     if(checkValid(card))
        //     {
        //         card.suggestedEffect();
        //     }
        // }
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
