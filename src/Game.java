import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

class Game {
    private MyFrame frame;
    final int COMPUTER_NUM = 3; // 0 < x < 4

    private Deck deck;

    private Player player;
    static Card prevCard;

    private Computer com1;
    private Computer com2;
    private Computer com3;

    private ButtonUno playerButton;

    Game() {
        this.frame = new MyFrame();
        this.deck = new Deck();

        this.player = new Player(deck);
        this.com1 = new Computer(deck, "NORTH");
        this.com2 = new Computer(deck, "WEST");
        this.com3 = new Computer(deck, "EAST");

        this.playerButton = new ButtonUno("player");
        prevCard = deck.getOneCard();
    }

    /*
     * đầu tiên trong hàm nghe click của Card -> sẽ gán prevCard = card,
     * sau đó, sẽ xoá card ra khỏi bộ bài của Player (nó sẽ tự động xong mọi thứ)
     * việc đầu tiên là gán lại preCard = card
     * 
     */

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