import java.awt.BorderLayout;
import javax.swing.JLayeredPane;

public class App {
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();

        Deck deck = new Deck();
        User player = new User(deck);

        // Add the JLabel to the frame
        JLayeredPane playerCards = player.getCards();
        // JLayeredPane comCards = com1.getCards();

        frame.add(playerCards, BorderLayout.SOUTH);
        // frame.add(comCards, BorderLayout.NORTH);

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}