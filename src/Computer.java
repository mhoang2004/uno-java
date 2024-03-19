import java.awt.Dimension;

import javax.swing.JLayeredPane;

public class Computer extends User {
    private String position;
    static boolean selectedCard = false;
    public String getPos()
    {
        return position;
    }
    Computer(Deck deck, String position) {
        super(deck);
        this.position = position;
        this.count = 7;
        this.getLatestPanel();
    }

    public void getLatestPanel() {
        int xPosition = 20;
        int yPosition = 20; // padding 20 pixels
        int layer = 0;

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

            panel.add(backCard, Integer.valueOf(layer++));
        }

    } 

    public void computerHitCard() {
        // Test reverse
        // for(Card card : cards) {
        //         if (card.getRank() == "REVERSE")
        //             return card;
        // }

        //Test skip
        // for(Card card : cards) {
        //         if (card.getRank() == "SKIP")
        //             return card;
        // }
        Computer.selectedCard = false;
        for(Card card : cards) {
            if(card.getColor() == Game.prevCard.getColor()) {
                if (card.getRank().length() == 1){
                    this.hitCard(card);
                    Computer.selectedCard = true;
                    this.count--;
                    return;
                }
            }
        }            
        for(Card card : cards) {
            if (card.getRank() == Game.prevCard.getRank()) {
                this.hitCard(card);
                Computer.selectedCard = true;
                this.count--;
                return;
            }
        }
        for(Card card : cards) {
            if (card.getColor() == Game.prevCard.getColor()) {
                this.hitCard(card);
                Computer.selectedCard = true;
                this.count--;
                return;
            }
        }
        for(Card card : cards) {
            if (card.getRank() == "WILD") {
                this.hitCard(card);
                Computer.selectedCard = true;
                this.count--;
                return;
            }
        }
        for(Card card : cards) {
            if (card.getRank() == "DRAWFOUR") {
                this.hitCard(card);
                Computer.selectedCard = true;
                this.count--;
                return;
            }
        }
    }

    // public void ComputerHitCard() {
    //     // if (this.checkDrawTwo()) {
    //     //     if (selectedCard().getRank() != "DRAWTWO") {
    //     //         this.checkDrawTwo();
    //     //         return;
    //     //     }
    //     // }
    //     // if (this.checkDrawFour()) {
    //     //     if (selectedCard().getRank() != "DRAWFOUR") {
    //     //         this.checkDrawTwo();
    //     //         return;
    //     //     }
    //     // }
        
    //     if (Computer.selectedCard != null) {
    //         // Game.prevCard = selectedCard;
    //         this.selectedCard();
            
    //     }
        
        // this.nextUser.setTurn(true);
        // this.setTurn(false);
}
    
