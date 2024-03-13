import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

class Game {
    static Card prevCard;
    private MyFrame frame;

    final int COMPUTER_NUM = 3; // 0 < x < 4

    private Deck deck;

    private Player player;
    private Computer com1;
    private Computer com2;
    private Computer com3;

    private ButtonUno playerButton;

    Game() {
        frame = new MyFrame();
        deck = new Deck();

        player = new Player(deck);
        com1 = new Computer(deck, "NORTH");
        com2 = new Computer(deck, "WEST");
        com3 = new Computer(deck, "EAST");

        playerButton = new ButtonUno("player");
        prevCard = deck.getOneCard();
    }

    void render() {
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
        frame.add(com1.getPanel(), BorderLayout.NORTH);
        frame.add(com2.getPanel(), BorderLayout.WEST);
        frame.add(com3.getPanel(), BorderLayout.EAST);
        frame.add(center, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    // public void checkUno() {
    // if (ButtonUno.unoClicked == true) {
    // if (player.getCards().size() != 1) {
    // player.drawCard(deck);
    // }
    // ButtonUno.unoClicked = false;
    // }
    // }

    void update() {
        // boolean gameEnd = false;
        // while(!gameEnd) {
        // // check game end
        // // if (player.getCards().size() == 0 || com1.getCards().size() == 0 ||
        // com2.getCards().size() == 0 || com3.getCards().size() == 0) {
        // // gameEnd = true;
        // // }
        // // //suggestedEffect
        // // for (Card card : player.cards) {
        // // if(prevCard.getColor() == card.getColor() || prevCard.getRank() ==
        // card.getRank()) {
        // // card.suggestedEffect();
        // // }
        // // }
        // System.out.println("run");
        // }
        // for (Card card : player.cards) {
        // if(prevCard.getColor() == card.getColor() || prevCard.getRank() ==
        // card.getRank()) {
        // card.suggestedEffect();
        // }
        // }
        // checkUno();
    }
}