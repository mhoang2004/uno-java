import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

public abstract class User {
    static final int INIT_CARD = 7;
    static final int GAP_CARD_HORIZONTAL = 50; // 50px gap each card
    static final int GAP_CARD_VERTICAL = 20;

    protected ArrayList<Card> cards;
    protected JLayeredPane panel;
    protected User nextUser;
    protected boolean turn;

    User(Deck deck) {
        cards = new ArrayList<Card>();
        // JLayeredPane = Swing container that provides a third dimension for
        // positioning components. Ex: depth, z-index
        panel = new JLayeredPane();
        // turn
        turn = false;
        // using setPreferredSize() no guarantee that the layout manager will honor the
        // preferred size exactly.
        panel.setPreferredSize(new Dimension(Card.WIDTH, Card.HEIGHT + GAP_CARD_VERTICAL));
        panel.setLayout(null);

        for (int i = 0; i < INIT_CARD; i++) {
            Card card = deck.getOneCard();
            card.setUser(this); // set user
            cards.add(card);
        }

        // System.out.println("-------------------------TRƯỚC KHI
        // SORT----------------");
        // for (Card card : cards) {
        // System.out.println(card.toString());
        // }
        // sortCard();
        // System.out.println("-------------------------SAU KHI SORT----------------");
        // for (Card card : cards) {
        // System.out.println(card.toString());
        // }
    }

    public void hitCard(Card card) {
        Game.prevCard.assignCard(card);

        // TODO animation
        // card.setLocation(0, 0);

        cards.remove(card);
        panel.removeAll();

        // panel.revalidate();

        panel.repaint(); // clear all card

        getLatestPanel(); // repaint
    }

    public void sortCard() {
        Card firstCard = new Card(cards.get(0));
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

        // ? Hoang's sort, but fail :(
        // int n = cards.size();
        // for (int i = 0; i < n - 1; i++) {
        // for (int j = i + 1; j < n; j++) {

        // String a = cards.get(i).getColor();
        // String b = cards.get(j).getColor();

        // if (a == null) {
        // Card cardTemp = cards.get(i);
        // cards.set(i, cards.get(j));
        // cards.set(j, cardTemp);
        // continue;
        // }

        // if (b == null)
        // continue;

        // // int c = Integer.parseInt(cards.get(i).getRank());
        // // int d = Integer.parseInt(cards.get(i).getRank());

        // if (a.compareTo(b) < 0) {
        // Card cardTemp = cards.get(i);
        // cards.set(i, cards.get(j));
        // cards.set(j, cardTemp);
        // continue;
        // }

        // // if (c > d) {
        // // Card cardTemp = cards.get(i);
        // // cards.set(i, cards.get(j));
        // // cards.set(j, cardTemp);
        // // }
        // }
        // }
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

    public void drawCard(Deck deck) {
        Card card = deck.getOneCard();
        cards.add(card);

        panel.removeAll();
        panel.repaint(); // clear all card
        getLatestPanel();
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setNextUser(User nextUser) {
        this.nextUser = nextUser;
    }

    public User getNextUser() {
        return nextUser;
    }

    public boolean checkValid(Card card) {
        Card prevCard = Game.prevCard;
        System.out.println(prevCard.toString());
        System.out.println(card.toString());

        if (card.getColor() == prevCard.getColor()) {
            return true;
        }
        if (card.getRank() == prevCard.getRank()) {
            return true;
        }
        if (card.getColor() == null) {
            return true;
        }
        return false;
    }
    // public void suggestedCards()
    // {
    // for (Card card : cards) {
    // if(checkValid(card)==true)
    // {
    // card.suggestedEffect();
    // }
    // }
    // }

}
