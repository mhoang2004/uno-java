import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("Uno Game"); // set title
        this.setSize(1280, 720); // x-dimension and y-dimension
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false); //
        this.setVisible(true); // make frame visible
        this.setLayout(null);

        // change the logo
        ImageIcon image = new ImageIcon("../resources/images/logo.png");
        this.setIconImage(image.getImage());

        // change color of background
        this.getContentPane().setBackground(new Color(3, 104, 63));
    }
}
