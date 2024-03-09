import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.Dimension;

public class Computer extends User {
    private String position;

    Computer(Deck deck, String position) {
        super(deck);

        this.position = position;
    }

    public JLayeredPane printCards() {
        int yPosition = 20; // padding 20 pixels
        int xPosition = 20;

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        System.out.println(position);
        if (position == "NORTH") {
            layeredPane.setPreferredSize(new Dimension(Card.WIDTH, Card.HEIGHT + GAP_CARD_VERTICAL));
            xPosition = (MyFrame.WIDTH - (Card.WIDTH + (size() - 1) * GAP_CARD_HORIZONTAL)) / 2;
        } else {
            layeredPane.setPreferredSize(new Dimension(Card.WIDTH + GAP_CARD_VERTICAL, Card.HEIGHT));
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

            layeredPane.add(backCard);
            layeredPane.moveToFront(backCard);
        }

        return layeredPane;
    }
}
