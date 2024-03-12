import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public abstract class User {
    static final int INIT_CARD = 7;
    static final int GAP_CARD_HORIZONTAL = 50; // 50px gap each card
    static final int GAP_CARD_VERTICAL = 20;

    protected ArrayList<Card> cards;
    protected JLayeredPane panel;

    User(Deck deck) {
        this.cards = new ArrayList<Card>();
        // JLayeredPane = Swing container that provides a third dimension for
        // positioning components. Ex: depth, z-index
        panel = new JLayeredPane();

        // using setPreferredSize() no guarantee that the layout manager will honor the
        // preferred size exactly.
        panel.setPreferredSize(new Dimension(Card.WIDTH, Card.HEIGHT + GAP_CARD_VERTICAL));
        panel.setLayout(null);

        for (int i = 0; i < INIT_CARD; i++) {
            Card card = deck.getOneCard();
            cards.add(card);
        }
        System.out.println("HELLO------");
        System.out.println("-------------------------TRƯỚC KHI SORT----------------");
        for (Card card : cards) {
            System.out.println(card.toString());
        }
        sortCard();
        System.out.println("-------------------------SAU KHI SORT----------------");
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public void sortCard() {
        Card firstCard = new Card(cards.get(0));
        boolean tmp = false;
        for (int i = 1; i < cards.size(); i++) {
            if (firstCard.getColor() != cards.get(i).getColor()) {
                for (int j = i + 1; j < cards.size(); j++) {
                    if (firstCard.getColor() == cards.get(j).getColor()) {
                        Card cardTMP = cards.get(i);
                        cards.set(i, cards.get(j));
                        cards.set(j, cardTMP);

                        break;
                    }
                }

            }
            firstCard = cards.get(i);
        }
    }

    // number of cards user have...
    public int size() {
        return cards.size();
    }

    public abstract void getLatestPanel();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public JLayeredPane getPanel() {
        return panel;
    }

    // public void drawCard(Deck deck) {
    // Card card = deck.getOneCard();
    // cards.add(card);
    // }
}
