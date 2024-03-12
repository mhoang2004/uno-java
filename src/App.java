import javax.swing.SwingUtilities;

//import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Game game = new Game();

                game.render();
                // game.update();
            }
        });

    }
}