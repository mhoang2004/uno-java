import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class choseColorFrame extends JFrame {
    private JButton buttonBLUE;   
    private JButton buttonYELLOW;   
    private JButton buttonGREEN;   
    private JButton buttonRED;  
    private String noti;
    User player;
    public choseColorFrame()
    {
        buttonBLUE = new JButton("BLUE");
        buttonGREEN = new JButton("GREEN");
        buttonRED = new JButton("RED");
        buttonYELLOW = new JButton("YELLOW");
        this.init();
        this.setVisible(true);
    }
    public choseColorFrame(String noti)
    {
        this.noti = noti;
        this.init("THÔNG BÁO");
    }
    void init(String title)
    {
        this.setTitle(title); // set title
        this.setSize(500, 100); // x-dimension and y-dimension
        this.setResizable(false);
        JTextField text = new JTextField(noti);
        this.add(text);
        this.setLocationRelativeTo(null);

    }
    void init()
    {
        this.setTitle("Chose Color"); // set title
        this.setSize(500, 100); // x-dimension and y-dimension
        ActionListener ac = new choseColor(this);
        buttonRED.addActionListener(ac);
        buttonGREEN.addActionListener(ac);
        buttonBLUE.addActionListener(ac);
        buttonYELLOW.addActionListener(ac);
        this.setResizable(false);
        this.setLayout(new GridLayout());
        this.add(buttonBLUE);
        this.add(buttonRED);
        this.add(buttonGREEN);
        this.add(buttonYELLOW);
        this.setLocationRelativeTo(null);
    }
    public void setColor(String color)
    {
        player.setColorPrevCard(color);
    }
    
}
