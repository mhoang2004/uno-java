import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    MyFrame() {
        this.setTitle("Uno Game"); // set title
        this.setSize(WIDTH, HEIGHT); // x-dimension and y-dimension
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false);
        this.setLayout(null);

        // change the logo
        ImageIcon image = new ImageIcon("../resources/images/logo.png");
        this.setIconImage(image.getImage());

        // change color of background
        
        
        this.getContentPane().setBackground(new Color(3, 104, 63));
    }
}

// JFrame frame = new JFrame();
// this.setSize(700, 700);
// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
