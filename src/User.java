import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JLayeredPane;

public abstract class User  {
    static final int INIT_CARD = 7;
    static final int GAP_CARD_HORIZONTAL = 50; // 50px gap each card
    static final int GAP_CARD_VERTICAL = 20;

    protected ArrayList<Card> cards;
    protected JLayeredPane panel;
    protected User nextUser;
    protected boolean turn;
    protected int count;
    public Object view;
    protected String ID;
    protected ArrayList<Card> suggestedCards;

    User(Deck deck) {
        cards = new ArrayList<Card>();
        suggestedCards = new ArrayList<Card>();
        // JLayeredPane = Swing container that provides a third dimension for
        // positioning components. Ex: depth, z-index
        panel = new JLayeredPane();
        // turn
        turn = false;

        // using setPreferredSize() no guarantee that the layout manager will honor the
        // preferred size exactly.
        panel.setPreferredSize(new Dimension(Card.WIDTH, Card.HEIGHT + GAP_CARD_VERTICAL));
        panel.setLayout(null);
        //test
        // for (Card card : deck.getDeck()) {
        //     if(card.isSpecial())
        //     {
        //         cards.set(0, card);
        //     }
        // }

        for (int i = 0; i < INIT_CARD; i++) {
            Card card = deck.getOneCard();
            
            card.setUser(this); // set user
            cards.add(card);
        }
        // for (Card card : cards) {
        //     if(checkValid(card))
        //     {
        //         suggestedCards.add(card);
        //     }
        // }
           
        
        
        // TEST SKIP
        // for (int i = 0; i < INIT_CARD; i++) {
        //     Card card = new Card("B", "SKIP");
        //     card.setUser(this); // set user
        //     cards.add(card);
        // }
        // TEST +2, +4
        // for (int i = 0; i <= 3; i++) {
        //     Card card = new Card("B", "SKIP");
        //     card.setUser(this); // set user
        //     cards.add(card);
        // }
        // for (int i = 4; i < INIT_CARD; i++) {
        //     Card card = new Card("B", "3");
        //     card.setUser(this); // set user
        //     cards.add(card);
        // }
            // checkCard();
        sortCard();
    }

    public void hitCard(Card card) {
        if(card.getColor() == null)
        {

        }
        else{
            Game.prevCard.assignCard(card);

        }
       

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
    public boolean checkCard ()
    {
        sortCard();
        for (Card card : cards) {
            if(checkValid(card))
            {
                card.suggestedEffect();
            }else{
                card.setCard();
            }
        }
        for (Card card : cards) {
            if(checkValid(card)== true){

                return true;
            }
        }
        System.out.println("false");
        return false;
    }
    public abstract void getLatestPanel();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public JLayeredPane getPanel() {
        return panel;
    }

    public Card drawCard() {
        if (Game.deck.getDeck().size() == 0) {
            System.out.println("Het bai roi cuu");
        }
        Card card = Game.deck.getOneCard();
        card.addMouseListener(card);
        cards.add(card);
        card.setUser(this);
        panel.removeAll();
        sortCard();

        panel.repaint(); // clear all card
        getLatestPanel();
        this.count++;
        System.out.println("Draw card " + card);
        return card;
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

    public void setCount(int x) {
        count = count + x;
    }

    public int getCount() {
        return count;
    }

    public boolean checkValid(Card card) {
        Card prevCard = Game.prevCard;
        // for (Card card2 : cards) {
        //     System.out.println(card2.toString());
        // }
        
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
    //fail
    public void setColorPrevCard(String color,Card card)
    {
        
        Game.prevCard.setColor(color);
        Game.prevCard.setRank(card.getRank());
    }
    
    // choose color
    // public Card chooseColor() {
    //     if(ID == "Player")
    //     {
    //         Game.prevCard.setRank(null);
    //         choseColorFrame myFrame = new choseColorFrame(this, );

    //         myFrame.addWindowListener(new WindowAdapter() {
    //             public void windowClosing(WindowEvent e) {
    //                 // Khi frame mới đóng, hiển thị lại frame cũ
    //                 Game.frame.setVisible(true);
    //                 myFrame.dispose();
    //             }
    //         });
    //     }   
    //     return Game.prevCard ;
    // }

    public void passTurn() {
        this.getNextUser().setTurn(false);
        this.setTurn(false);
        this.getNextUser().getNextUser().setTurn(true);
    }

    // public void prevDrawCard() {
    //     this.getNextUser().getNextUser().getNextUser().drawCard();
    // }

    public void skip() {
        if (Game.prevCard.getRank() == "SKIP") {
            this.passTurn();
        }
        else if(Game.prevCard.getRank() == "DRAWTWO") {
            this.getNextUser().drawCard(); 
            this.getNextUser().drawCard(); 
            this.passTurn();
        }
        else if(Game.prevCard.getRank() == "DRAWFOUR") {
            this.getNextUser().drawCard(); 
            this.getNextUser().drawCard(); 
            this.getNextUser().drawCard(); 
            this.getNextUser().drawCard(); 
            this.passTurn();
            // Game.prevCard.setColor(chooseColor().getColor());
        }
    }
    public void wild() {
        if (Game.prevCard.getRank() == "WILD") {
            // Game.prevCard.setColor(chooseColor().getColor());
            Game.prevCard.setRank(null);
        }
    }
    // public boolean checkDrawTwo() {
    //     boolean flag = false;
    //     if(Game.prevCard.getRank() == "DRAWTWO") {
    //         this.drawCard(); 
    //         this.drawCard(); 
    //         flag = true;
    //     }
    //     return flag;
    // }
    // public boolean checkDrawFour() {
    //     boolean flag = false;
    //     if(Game.prevCard.getRank() == "DRAWFOUR") {
    //         chooseColor();
    //         this.drawCard(); 
    //         this.drawCard(); 
    //         this.drawCard(); 
    //         this.drawCard(); 
    //         flag = true;
    //         Game.prevCard.setColor(chooseColor());
    //     }
    //     return flag;
    // }
}
