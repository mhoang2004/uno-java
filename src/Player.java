import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;

public class Player extends User {
    private ArrayList<Card> suggestedCards;

    Player(Deck deck) {
        super(deck);
        this.getLatestPanel();

        for (Card card : cards) {
            card.addMouseListener(card);
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        System.out.println("HELLOOOO");

    }

    public void getLatestPanel() {
        int xPosition = (MyFrame.WIDTH - (Card.WIDTH + (size() - 1) * GAP_CARD_HORIZONTAL)) / 2;
        int yPosition = 50;

        for (Card card : cards) {
            card.setBounds(xPosition, yPosition, Card.WIDTH, Card.HEIGHT);

            xPosition += GAP_CARD_HORIZONTAL;

            panel.add(card);
            panel.moveToFront(card);

            // suggestion effect
            // if(previousCard.getColor() == card.getColor() || previousCard.getRank() ==
            // card.getRank()) {
            // card.suggestedEffect();
            // }
        }
    }
}
