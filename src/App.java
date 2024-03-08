import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
//import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        MyFrame frame = new MyFrame();

        Deck deck = new Deck();
        User player = new User(deck);
        ButtonUno playerButton = new ButtonUno("player", MyFrame.WIDTH-100, MyFrame.HEIGHT-100);

        // Add the JLabel to the frame
        Card card = new Card("Y", "5");
        JLayeredPane playerCards = player.getCards(card);
        // JLayeredPane comCards = com1.getCards();

        // JPanel jPanelPlayer = new JPanel();
        // jPanelPlayer.setLayout(null);
        // jPanelPlayer.add(playerCards);
        // jPanelPlayer.add(playerButton);
        frame.add(playerCards, BorderLayout.SOUTH);
        // frame.add(comCards, BorderLayout.NORTH);
        //frame.add(jPanelPlayer, BorderLayout.SOUTH);
        //frame.add(playerButton, BorderLayout.CENTER);
        playerButton.addActionListener(e -> {
            // Xử lý sự kiện khi nút được nhấn
            System.out.println("Button clicked!");
        });

       

        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}