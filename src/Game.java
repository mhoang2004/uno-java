import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.Timer;

class Game {
    static Card prevCard;
    static int turn;
    static Deck deck;
    static ButtonUno playerButton;
    static ArrayList<Computer> com;
    public static MyFrame frame;

    JPanel mainPanel;

    final int COMPUTER_NUM = 3; // 0 < x < 4

    static Player player;

    static boolean reverse;
    
    Game() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBounds(0, 0, MyFrame.WIDTH, MyFrame.HEIGHT);
        mainPanel.setBackground(new Color(3, 104, 63));

        frame = new MyFrame();
        frame.add(mainPanel);

       
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
        while (prevCard.getColor()==null)
        {
            prevCard = deck.getOneCard(); 
        }
        // testGame();
        reverse = true; // chieu kim dong ho
    }
    // @SuppressWarnings("unused")
    static public void  testGame()
    {
        while (true)
        {
            for (Card card : player.getCards()) {
                if(card.getColor() ==prevCard.getColor())
                {
                    prevCard = deck.getOneCard(); 
                }
            }
            
        } 
    }
    public void render() {

        

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2, 10, 10));
        center.setBackground(new Color(3, 104, 63));

        // deck
        // Card backCard = new Card();
        center.add(deck);
        center.add(prevCard);
        deck.addMouseListener(deck);
        // button
        center.add(playerButton);
        playerButton.addMouseListener(playerButton);

        mainPanel.add(player.getPanel(), BorderLayout.SOUTH);
        mainPanel.add(com.get(0).getPanel(), BorderLayout.WEST);
        mainPanel.add(com.get(1).getPanel(), BorderLayout.NORTH);
        mainPanel.add(com.get(2).getPanel(), BorderLayout.EAST);
        mainPanel.add(center, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
    public static void checkSkipAndDraw(Computer next)
    {
        if(player.checkCard() == false)
        {
            player.drawCard();
            player.nextUser.setTurn(false);
            
            if(next.getPos() == "EAST")
            {
                com.get(2).setTurn(true);
                computer2Played();
            }else{
                com.get(0).setTurn(true);
                computerPlayed();
            }

        }
    }
    public void checkUno() {
        if (playerButton.getUnoClicked() == true) {
            System.out.println("check uno");
            if (player.getCards().size() != 1) {
                player.drawCard();
            }
            playerButton.setUnoClicked();
        }
    }

    public boolean gameEnd() {
        if (player.getCards().size() == 0 || com.get(0).getCards().size() == 0 || com.get(1).getCards().size() == 0
                || com.get(2).getCards().size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkSkip() {
        if (Game.prevCard.getRank() == "SKIP") {
            return true;
        }
        else if(Game.prevCard.getRank() == "DRAWTWO") {
            return true;
        }
        else if(Game.prevCard.getRank() == "DRAWFOUR") {
            return true;
        }
        return false;
    }
    
    public static boolean checkWild() {
        if (Game.prevCard.getRank() == "WILD") {
            return true;
        }
        else return false;
    }

    public static void computerPlayed() {
        System.out.println("com0 " + com.get(0).getTurn());
        if(Player.choosingColor == true)
        {
            if (com.get(0).getTurn() == true) {
                if (checkWild()) {
                    com.get(0).wild();
                }
                System.out.println("--------Com0 card-------");
                com.get(0).computerHitCard();
                System.out.println("selectedCard = " + Computer.selectedCard);
                System.out.println("prevCard = " + Game.prevCard);
                System.out.println("count = " + com.get(0).getCount() + "  " + com.get(0).getCards().size());
            }
            // REVERSE
            if ((Game.prevCard.getRank() == "REVERSE") && (Computer.selectedCard != false)) {
                Game.reverse();
            }
            com.get(0).nextUser.setTurn(true);
            com.get(0).setTurn(false);
            if (Computer.selectedCard == false) {
                com.get(0).drawCard();
                com.get(0).computerHitCard();
                System.out.println("selectedCard = " + Computer.selectedCard);
                System.out.println("prevCard = " + Game.prevCard);
                System.out.println("count = " + com.get(0).getCount() + "  " + com.get(0).getCards().size());
            }
            // SKIP
            if ((checkSkip()) && (Computer.selectedCard != false)) {
                com.get(0).skip();
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        computer2Played();
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer.start();
                return;
            }
    
            if (Game.reverse == true) {
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        computer1Played();
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer.start();
            }else {
                checkSkipAndDraw(com.get(2));
            }
        }
        
    }

    public static void computer1Played() {
        System.out.println("com1 " + com.get(1).getTurn());
        if(Player.choosingColor)
        {
            if ((com.get(1).getTurn() == true)) {
            if (checkWild()) {
                com.get(1).wild();
            }
            System.out.println("--------Com1 card-------");
            com.get(1).computerHitCard();
            System.out.println("selectedCard = " + Computer.selectedCard);
            System.out.println("prevCard = " + Game.prevCard);
            System.out.println("count = " + com.get(1).getCount() + "  " + com.get(1).getCards().size());
        }
        //REVERSE
        if ((Game.prevCard.getRank() == "REVERSE") && (Computer.selectedCard != false)) {
            Game.reverse();
        }
        com.get(1).nextUser.setTurn(true);
        com.get(1).setTurn(false);
            if (Computer.selectedCard == false) {
                com.get(1).drawCard();
                com.get(1).computerHitCard();
                System.out.println("selectedCard = " + Computer.selectedCard);
                System.out.println("prevCard = " + Game.prevCard);
                System.out.println("count = " + com.get(1).getCount() + "  " + com.get(1).getCards().size());
            }
        // SKIP
        if ((checkSkip()) && (Computer.selectedCard != false)) {
            com.get(1).skip();
            if (Game.reverse == true ) {
                checkSkipAndDraw(com.get(0));
            }
            else {
                checkSkipAndDraw(com.get(2));
            }
            return;
        }
        
        if (Game.reverse == true) {
            Timer timer = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    computer2Played();
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();
        } else if (Game.reverse == false) {
            Timer timer = new Timer(2000, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    computerPlayed();
                    ((Timer) e.getSource()).stop();
                }
            });
            timer.start();
        }
        }
    }

    public static void computer2Played() {
        System.out.println("com2 " + com.get(2).getTurn());
        if(Player.choosingColor)
        {
            if ((com.get(2).getTurn() == true)) {
                if (checkWild()) {
                    com.get(2).wild();
                }
                System.out.println("--------Com2 card-------");
                com.get(2).computerHitCard();
                System.out.println("selectedCard = " + Computer.selectedCard);
                System.out.println("prevCard = " + Game.prevCard);
                System.out.println("count = " + com.get(2).getCount() + "  " + com.get(2).getCards().size());
            }
            // REVERSE
            if ((Game.prevCard.getRank() == "REVERSE") && (Computer.selectedCard != false)) {
                Game.reverse();
            }
            com.get(2).nextUser.setTurn(true);
            com.get(2).setTurn(false);
                if (Computer.selectedCard == false) {
                    com.get(2).drawCard();
                    com.get(2).computerHitCard();
                    System.out.println("selectedCard = " + Computer.selectedCard);
                    System.out.println("prevCard = " + Game.prevCard);
                    System.out.println("count = " + com.get(2).getCount() + "  " + com.get(2).getCards().size());
                }
            // SKIP
            if ((checkSkip()) && (Computer.selectedCard != false)) {
                com.get(2).skip();
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        computerPlayed();
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer.start();
                return;
            }
            
            if (Game.reverse == false) {
                Timer timer = new Timer(2000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        computer1Played();
                        ((Timer) e.getSource()).stop();
                    }
                });
                timer.start();
            }else
            {
                checkSkipAndDraw(com.get(0));
            }
        }
       
    }

    // SKIP
    
    // REVERSE
    public static void reverse() {
        if (reverse == true) {
            player.setNextUser(com.get(2));
            com.get(2).setNextUser(com.get(1));
            com.get(1).setNextUser(com.get(0));
            com.get(0).setNextUser(player);
            reverse = false; // nguoc chieu kim dong ho
        } else {
            com.get(0).setNextUser(com.get(1));
            com.get(1).setNextUser(com.get(2));
            com.get(2).setNextUser(player);
            player.setNextUser(com.get(0));
            reverse = true; // dung chieu kim dong ho
        }
    }

    public void update() {
        checkUno();
        System.out.println("runn");
        System.out.println("--------Player card-------");
        for (int i = 0; i < player.getCards().size(); i++) {
            System.out.println(player.getCards().get(i));
        }
        player.setTurn(true);
        System.out.println("prevCard = " + prevCard);
    }
}