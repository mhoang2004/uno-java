import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class User {
    static int INIT_CARD = 7;
    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;

    User(Deck deck) {
        this.cards = new ArrayList<Card>();
        this.selectedCards = new ArrayList<Card>();

        Card card;
        for (int i = 0; i < INIT_CARD; i++) {
            card = deck.getOneCard();
            cards.add(card);
        }
    }

    public JPanel getCards() {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBackground(new Color(3, 104, 63));

        int x = 0;
        int y = 50;

        for (Card card : cards) {
            x += 90;
            card.setBounds(x, y, 80, 120);
            // card.setLocation(new Point(x, y));
            cardPanel.add(card);
        }

        return cardPanel;
    }
}
