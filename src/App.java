import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//import javax.swing.*;
public class App {

    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();
        final int COMPUTER_NUM = 3; // 0 < x < 4

        Deck deck = new Deck();

        // Button test section
        // ButtonUno playerButton = new ButtonUno("player", MyFrame.WIDTH - 100,
        // MyFrame.HEIGHT - 100);

        // User test section
        Player player = new Player(deck);

        // TODO implement this!! ;
        ArrayList<Computer> computers;

        Computer com1 = new Computer(deck, "NORTH");
        Computer com2 = new Computer(deck, "WEST");
        Computer com3 = new Computer(deck, "EAST");

        JLayeredPane playerCards = player.printCards();
        JLayeredPane com1Cards = com1.printCards();
        JLayeredPane com2Cards = com2.printCards();
        JLayeredPane com3Cards = com3.printCards();

        // JPanel black = new JPanel();
        // black.setBackground(Color.BLACK);
        // black.setPreferredSize(new Dimension(100, 100));

        /* DEMO (COULD DELETE) */
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1, 2, 10, 10));
        center.setBackground(new Color(3, 104, 63));

        Card backCard = new Card();
        Card firstCard = deck.getOneCard();
        center.add(backCard);
        center.add(firstCard);
        /* END DEMO */

        frame.add(playerCards, BorderLayout.SOUTH);
        frame.add(com1Cards, BorderLayout.NORTH);
        frame.add(com2Cards, BorderLayout.WEST);
        frame.add(com3Cards, BorderLayout.EAST);
        frame.add(center, BorderLayout.CENTER);

        // TODO game loop here...

        // frame.add(playerButton, BorderLayout.CENTER);
        // playerButton.addActionListener(e -> {
        // System.out.println("Button clicked!");
        // });

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

}