import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import javax.swing.Timer;
import java.awt.event.ActionListener;
class Game {
    static Card prevCard;
    static int turn;
    static Deck deck;
    static ButtonUno playerButton;
    static ArrayList<Computer> com;
    private MyFrame frame;

    final int COMPUTER_NUM = 3; // 0 < x < 4

    static Player player;
    
    Game() {
        frame = new MyFrame();
        deck = new Deck();

        player = new Player(deck);

        com = new ArrayList<>();
        Computer com1 = new Computer(deck, "WEST");
        Computer com2 = new Computer(deck, "NORTH"); 
        Computer com3 = new Computer(deck, "EAST");
        com.add(com1);
        com.add(com2);
        com.add(com3);
        // set next user
        com.get(0).setNextUser(com2);  
        com2.setNextUser(com3);  
        com3.setNextUser(player);  
        player.setNextUser(com.get(0));

        playerButton = new ButtonUno("player");
        prevCard = deck.getOneCard();
    }

    public void render() {
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

        frame.add(player.getPanel(), BorderLayout.SOUTH);
        frame.add(com.get(0).getPanel(), BorderLayout.WEST);
        frame.add(com.get(1).getPanel(), BorderLayout.NORTH);
        frame.add(com.get(2).getPanel(), BorderLayout.EAST);
        frame.add(center, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public void checkUno() {
        if (playerButton.getUnoClicked() == true) {
            System.out.println("check uno");
            if (player.getCards().size() != 1) {
                player.drawCard(deck);
            }
            playerButton.setUnoClicked();
        }
    }
    public boolean gameEnd() {
        if (player.getCards().size() == 0 || com.get(0).getCards().size() == 0 || com.get(1).getCards().size() == 0 || com.get(2).getCards().size() == 0) {
            return true;
        }
        return false;
    }

    public static void computerPlayed() {
        System.out.println(com.get(0).getTurn());
        if (com.get(0).getTurn() == true) {
            com.get(0).ComputerHitCard(deck);
            System.out.println("--------Com1 card-------");
            for (int i=0; i < com.get(0).getCards().size(); i++) {
                System.out.println(com.get(0).getCards().get(i));
            }
        }
      
        
        computer1Played();
    }

    public static void computer1Played() {
        System.out.println(com.get(1).getTurn());
        if (com.get(1).getTurn() == true) {
            com.get(1).ComputerHitCard(deck);
            System.out.println("--------Com2 card-------");
            for (int i=0; i < com.get(1).getCards().size(); i++) {
                System.out.println(com.get(1).getCards().get(i));
            }
        }
    }

    public static void computer2Played() {
        System.out.println(com.get(2).getTurn());
        if (com.get(2).getTurn() == true) {
            com.get(2).ComputerHitCard(deck);
            System.out.println("--------Com3 card-------");
            for (int i=0; i < com.get(2).getCards().size(); i++) {
                System.out.println(com.get(2).getCards().get(i));
            }
        }
    }
    public void update() {
            checkUno();
            System.out.println("runnnnnnn");
            System.out.println("--------Com1 card-------");
            for(int i=0; i<com.get(0).getCards().size(); i++) {
                System.out.println(com.get(0).getCards().get(i));
            }
            player.setTurn(true);
            System.out.println("prevCard = " + prevCard);
    }
}