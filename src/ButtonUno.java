import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonUno extends JButton {
    static final int WIDTH = 80;
    static final int HEIGHT = 73;

    private String button; //determines whether the button is a player or an npc
    private int x;
    private int y;

    ButtonUno(String button, int x, int y){
        super();
        this.button = button;
        this.x = x;
        this.y = y;

        // get button
        this.setIcon(new ImageIcon("../resources/button-uno/button-uno.png"));
        this.setHorizontalAlignment(JButton.CENTER); // Center the image horizontally
        this.setVerticalAlignment(JButton.CENTER); // Center the image vertically
        this.setContentAreaFilled(false);
        this.setBounds(this.x, this.y, WIDTH, HEIGHT);

        // handled when the button is pressed
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public String getButton(){
        return this.button;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    
}