import java.awt.Dimension;

import javax.swing.JLayeredPane;

public class Computer extends User {
    private String position;

    Computer(Deck deck, String position) {
        super(deck);
        this.position = position;
        this.getLatestPanel();
    }

    public void getLatestPanel() {
        int xPosition = 20;
        int yPosition = 20; // padding 20 pixels

        if (position == "NORTH") {
            xPosition = (MyFrame.WIDTH - (Card.WIDTH + (size() - 1) * GAP_CARD_HORIZONTAL)) / 2;
        } else {
            panel.setPreferredSize(new Dimension(Card.WIDTH + GAP_CARD_VERTICAL, Card.HEIGHT));
            yPosition = (MyFrame.HEIGHT - (Card.HEIGHT + (size() - 1) * GAP_CARD_VERTICAL)) / 2
                    - (Card.HEIGHT + 2 * GAP_CARD_VERTICAL);
        }

        if (position == "EAST") {
            xPosition = 0;
        }

        for (Card card : cards) {
            Card backCard = new Card();
            backCard.setBounds(xPosition, yPosition, Card.WIDTH, Card.HEIGHT);

            if (position == "NORTH") {
                xPosition += GAP_CARD_HORIZONTAL;
            } else {
                yPosition += GAP_CARD_VERTICAL;
            }

            panel.add(backCard);
            panel.moveToFront(backCard);
        }
    }
}
