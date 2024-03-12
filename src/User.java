import java.util.ArrayList;

import javax.swing.JLayeredPane;

public abstract class User {
    static final int INIT_CARD = 7;
    static final int GAP_CARD_HORIZONTAL = 50; // 50px gap each card
    static final int GAP_CARD_VERTICAL = 20;

    protected ArrayList<Card> cards;

    User(Deck deck) {
        this.cards = new ArrayList<Card>();

        for (int i = 0; i < INIT_CARD; i++) {
            Card card = deck.getOneCard();

            // set index to do event handler
            card.index = i;

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
    public void sortCard()
    {
        Card firstCard = new Card(cards.get(0));
        boolean tmp = false;
        for (int i=1; i< cards.size() ; i++)
        {
            if(firstCard.getColor() != cards.get(i).getColor())
            {
                for(int j = i +1; j< cards.size() ; j++)
                {
                    if(firstCard.getColor() == cards.get(j).getColor())
                    {
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
    public void onCardClick(Card card) {
        // Handle card click in the User class
        System.out.println("Card clicked: " + card.getColor() + "-" + card.getRank());
    }

    // number of cards user have...
    public int size() {
        return cards.size();
    }

    public void hitTheCard() {

    }

    public abstract JLayeredPane printCards();

    public ArrayList<Card> getCards() {
        return cards;
    }

    // public void drawCard(Deck deck) {
    //     Card card = deck.getOneCard();
    //     cards.add(card);
    // }
}
