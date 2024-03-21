import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class choseColorFrame extends JFrame {
    private JButton buttonBLUE;   
    private JButton buttonYELLOW;   
    private JButton buttonGREEN;   
    private JButton buttonRED;  
    private String noti;
    public User user;
    public Card thisCard;
    public String src;
    public choseColorFrame(User user , Card thisCard)
    {
        src = null;
        this.user = user;
        this.thisCard = thisCard;
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
        JLabel buts = new JLabel();
        buts.setLayout(new GridLayout());
        ActionListener ac = new choseColor(this);
        buttonRED.addActionListener(ac);
        buttonGREEN.addActionListener(ac);
        buttonBLUE.addActionListener(ac);
        buttonYELLOW.addActionListener(ac);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        buts.add(buttonBLUE);
        buts.add(buttonRED);
        buts.add(buttonGREEN);
        buts.add(buttonYELLOW);
        JTextField text = new JTextField("Hello ");
        this.add(text, BorderLayout.NORTH);
        this.add(buts, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
}
