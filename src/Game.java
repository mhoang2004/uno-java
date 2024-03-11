import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
class Game {
    private MyFrame frame;
    final int COMPUTER_NUM = 3; // 0 < x < 4

    private Deck deck;

    private Player player;

    // TODO implement this!! ;
    private Computer com1;
    private Computer com2;
    private Computer com3;

    private ButtonUno playerButton;

    private Card prevCard;
    Game() {
        this.frame = new MyFrame();
        this.deck = new Deck();
        this.player = new Player(deck);
        
        this.com1 = new Computer(deck, "NORTH");
        this.com2 = new Computer(deck, "WEST");
        this.com3 = new Computer(deck, "EAST");

        this.playerButton = new ButtonUno("player");
        this.prevCard = deck.getOneCard();
    }

    void render() {
        JLayeredPane playerCards = player.printCards();
        JLayeredPane com1Cards = com1.printCards();
        JLayeredPane com2Cards = com2.printCards();
        JLayeredPane com3Cards = com3.printCards();

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2, 10, 10));
        center.setBackground(new Color(3, 104, 63));

        // deck
        Card backCard = new Card();
        center.add(backCard);

        center.add(prevCard);
        
        // button
        center.add(playerButton);
        playerButton.addMouseListener(playerButton);
        
        /* END DEMO */

        frame.add(playerCards, BorderLayout.SOUTH);
        frame.add(com1Cards, BorderLayout.NORTH);
        frame.add(com2Cards, BorderLayout.WEST);
        frame.add(com3Cards, BorderLayout.EAST);
        frame.add(center, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    // public void checkUno() {
    //     if (ButtonUno.unoClicked == true) {
    //         if (player.getCards().size() != 1) {
    //             player.drawCard(deck);
    //         }
    //         ButtonUno.unoClicked = false;
    //     }
    // }

    void update() {
        // boolean gameEnd = false;
        // while(!gameEnd) {
        //     // check game end
        // 	// if (player.getCards().size() == 0 || com1.getCards().size() == 0 || com2.getCards().size() == 0 || com3.getCards().size() == 0) {
        // 	// 	gameEnd = true;
        // 	// }
        // 	// //suggestedEffect
        // 	// for (Card card : player.cards) {
    	// 	// 	if(prevCard.getColor() == card.getColor() || prevCard.getRank() == card.getRank()) {
    	// 	// 		card.suggestedEffect();
    	// 	// 	}
    	// 	// }
        //    System.out.println("run");
        // }
        // for (Card card : player.cards) {
        //     if(prevCard.getColor() == card.getColor() || prevCard.getRank() == card.getRank()) {
        //         card.suggestedEffect();
        //     }
        // }
        // checkUno();
    }
}