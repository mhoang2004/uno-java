
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        // MyFrame frame = new MyFrame();

        JFrame frame = new JFrame("UNO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250, 720);

        Deck deck = new Deck();

        User player = new User(deck);

        // System.out.println(player.getCards().get(0).toString());
        // frame.add(player.getCards().get(0));

        // Add the JLabel to the frame
        frame.add(player.getCards());

        frame.setVisible(true);
    }
}